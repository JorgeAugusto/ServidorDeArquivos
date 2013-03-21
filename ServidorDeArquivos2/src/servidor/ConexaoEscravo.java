/**
 * Classe que modela a Conexão de um Escravo
 * @author: Jorge Augusto C. dos Reis
 * @data..: 19/03/2013 às 07:45
 * @Descrição:
 * Esta classe modela a Conexão do Servidor com um Escravo.
 */

package servidor;

import base.EstadoSistema;
import base.InfoArquivo;
import base.InfoServidor;
import base.Mensagem;
import escravo.Escravo;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ConexaoEscravo implements Runnable {

    // Enum interna
    public enum EstadoEscravo {
        CONECTADO, DESCONECTADO, DOWNLOAD, UPLOAD, OCUPADO;
    }

    private JanelaServidor          janelaServidor;     // só para facilidar o acesso!
    private Socket                  socket;
    private ObjectInputStream       entrada;
    private ObjectOutputStream      saida;
    private Servidor                servidor;
    private int                     id;                 // identificador da conexão com o escravo.
    private EstadoEscravo           estado;
    private Mensagem                mensagemRecebida;
    private Mensagem                mensagemEnviada;
    private ArrayList<InfoArquivo>  listaArquivos;

    public ConexaoEscravo(Socket socket, Servidor servidor) throws Exception {
        this.socket     = socket;
        this.servidor   = servidor;
        this.id         = servidor.getNovoIdEscravo();
        janelaServidor  = servidor.getJanelaServidor();
        estado          = EstadoEscravo.CONECTADO;
        listaArquivos   = new ArrayList<InfoArquivo>();

        // Se o escravo mandar logo algo...
        saida       = new ObjectOutputStream(socket.getOutputStream());
        saida.flush();

        entrada     = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        solicitarListaArquivos();

        for(;;) {
            // Se o socke esta fechado então terminar Thread.
            if(socket.isClosed()) return;

            try {
                mensagemRecebida = (Mensagem) entrada.readObject();

                switch(mensagemRecebida.getTipoMensagem()) {
                    case LISTA_ARQUIVOS:
                        janelaServidor.adicionarHistorico("Recebeu lista de arquivos de : " + getNome() , EstadoSistema.OK);
                        processarListaArquivo();
                    break;

                    case UPLOAD:

                    break;

                    case DOWNLOAD:

                    break;

                    case DELETAR:

                    break;
                }
            }
            catch(Exception ex) {
                // Caso hava um erro desconecta o servidor escravo...
                desconectarServidorEscravo();
            }
        }
    }

    public int getId() {
        return id;
    }

    public String getIP() {
        return  socket.getInetAddress().toString();
    }

    public int getPorta() {
        return socket.getPort();
    }

    public EstadoEscravo getEstado() {
        return estado;
    }

    public void setEstado(EstadoEscravo estado) {
        this.estado = estado;
    }

    public String getNome() {
        return "Escravo #" + Integer.toString(id);
    }

    /**
     * Este método retorna as informações da conexão como uma string
     * é um método auxiliar para facilitar o acesso as essas informações
     */
    public String getInfoConexo() {
        return String.format("%s no IP: [%s] na Porta: [%d]", getNome(), getIP(), getPorta());
    }

    // Métodos privados
    /**
     * Este método envia ao servidor escravo uma solicitação para que mesmo
     * envie uma lista contento os nomes dos arquivos que estão disponíveis
     */
    private synchronized void solicitarListaArquivos() {
        try {
            mensagemEnviada = new Mensagem(Mensagem.TipoMensagem.LISTA_ARQUIVOS, null);

            saida.writeObject(mensagemEnviada);
            saida.flush();
        }
        catch(Exception ex) {
            janelaServidor.adicionarHistorico("Enviando requisição de lista de arquivo para " + getNome(), EstadoSistema.ERRO);
        }

        janelaServidor.adicionarHistorico("Enviando requisição de lista de arquivo para " + getNome(), EstadoSistema.OK);
    }

    /**
     * Este método processa a mensagemRecebida de recebimento de uma lista de arquivos
     */
    private synchronized void processarListaArquivo() {
        ArrayList<InfoArquivo> listaArquivosEscravo = (ArrayList<InfoArquivo>) mensagemRecebida.getInfoMensagem();
        ArrayList<InfoArquivo> listaArquivosTemp = new ArrayList<InfoArquivo>();

        for(InfoArquivo arquivo : listaArquivosEscravo) {
            listaArquivosTemp.add(
            new InfoArquivo(arquivo.getNome(), new InfoServidor(getNome(), getIP(), arquivo.getServEscravo().getPorta()), arquivo.getTamanho() ));
        }

        listaArquivos = listaArquivosTemp;
        servidor.getGerenteConexaoEscravos().processaListaArquivos();
        janelaServidor.adicionarHistorico("Processsando lista de arquivos de " + getNome() , EstadoSistema.OK);
    }

    /**
     * Desconecta servidor escravo do servidor principal
     */
    private void desconectarServidorEscravo() {
        /**
        * @NOTA
        * Este código deve ser movido para um novo método...
        */
        janelaServidor.adicionarHistorico("Processsando Mensagem de " + getInfoConexo() , EstadoSistema.ERRO);
        janelaServidor.adicionarHistorico("Desconectando do Servidor Escravo... " + getNome() , EstadoSistema.PROCESSANDO);

        try {
            entrada.close();
            saida.close();
            socket.close();

            /**
            * @NOTA 1
            * Código muito prolixo!!!
            * Considerar mudar a listaEscravos para dentro da classe servidor e
            * não em GerenteConexaoEscravo como está atualmente.
            * @NOTA 2
            * Também considerar usar HashTable ao invéz de ArrayList
            * para não depender o índice gerado por id
            */

            // Muda estado da conexão
            servidor.getGerenteConexaoEscravos().getListaEscravos().get(id - 1).setEstado(EstadoEscravo.DESCONECTADO);
            janelaServidor.adicionarHistorico("Desconectando Servidor Escravo: " + getNome(), EstadoSistema.OK);

            // Atualiza lista de arquivos...
            if(!enviarBroadCast()) {
                servidor.getGerenteConexaoEscravos().processaListaArquivos();
            }

            janelaServidor.atualizarTabelaEscravos();
        }
        catch(Exception ex1) {
            janelaServidor.adicionarHistorico("Desconectando Servidor Escravo: " + getNome() + "...", EstadoSistema.ERRO);
        }
    }


    /**
     * Este método envia uma mensagem em Broadcast, ou seja, para todos os
     * Servidores Escravos conectados
     */
    private synchronized boolean enviarBroadCast() {
        janelaServidor.adicionarHistorico("Enviando Broadcas...", EstadoSistema.PROCESSANDO);
        if(!servidor.getGerenteConexaoEscravos().temEscravoConectado()) {
            janelaServidor.adicionarHistorico("Enviando Broadcas... Falou não há Servidores Escravos conectados", EstadoSistema.ERRO);

            return false;
        }

        try{
            ArrayList<ConexaoEscravo> listaEscravos = servidor.getGerenteConexaoEscravos().getListaEscravos();

            for(ConexaoEscravo conEscravo : listaEscravos) {
                // Se esta desconectado passa para o próximo
                if(conEscravo.getEstado() == EstadoEscravo.DESCONECTADO) continue;

                conEscravo.solicitarListaArquivos();
            }
        }
        catch(Exception ex) {
            janelaServidor.adicionarHistorico("Enviando Broadcas: " + getNome(), EstadoSistema.ERRO);
        }

        janelaServidor.adicionarHistorico("Enviando Broadcas", EstadoSistema.OK);

        return true;
    }

    /**
     * Retorna lista de arquivos deste escravo...
     */
    public ArrayList<InfoArquivo> getListaArquivo() {
        return listaArquivos;
    }
}
