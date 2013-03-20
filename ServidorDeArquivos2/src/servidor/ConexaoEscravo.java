/**
 * Classe que modela a Conexão de um Escravo
 * @author: Jorge Augusto C. dos Reis
 * @data..: 19/03/2013 às 07:45
 * @Descrição:
 * Esta classe modela a Conexão do Servidor com um Escravo.
 */

package servidor;

import base.InfoArquivo;
import base.InfoServidor;
import base.Mensagem;
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
    private Mensagem                mensagem;

    public ConexaoEscravo(Socket socket, Servidor servidor, int id) throws Exception {
        this.socket     = socket;
        this.servidor   = servidor;
        this.id         = id;
        janelaServidor  = servidor.getJanelaServidor();
        estado          = EstadoEscravo.CONECTADO;

        // Se o escravo mandar logo algo...
        entrada     = new ObjectInputStream(socket.getInputStream());
        saida       = new ObjectOutputStream(socket.getOutputStream());

        solicitarListaArquivos();
    }

    @Override
    public void run() {
        janelaServidor.adicionarHistorico("Iniciando Thread de Escravo: " + getInfoConexo(), "OK");

        for(;;) {
            // Se o socke esta fechado então terminar Thread.
            if(socket.isClosed()) return;

            try {
                // entrada  = new ObjectInputStream(socket.getInputStream());
                mensagem = (Mensagem) entrada.readObject();

                switch(mensagem.getTipoMensagem()) {
                    case LISTA_ARQUIVOS:
                        recebendoListaArquivo();
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
                janelaServidor.adicionarHistorico("Processsando Mensagem de " + getInfoConexo() , "ERRO");
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
    private void solicitarListaArquivos() {
        try {
            Mensagem requiscao = new Mensagem(Mensagem.TipoMensagem.LISTA_ARQUIVOS, null);

        }
        catch(Exception ex) {

        }
    }

    /**
     * Este método processa a mensagem de recebimento de uma lista de arquivos
     */
    private synchronized void recebendoListaArquivo() {
        janelaServidor.adicionarHistorico("Recenbendo Lista de Arquivos", "OK");

        ArrayList<InfoArquivo> listaArquivosServidor = servidor.getListaArquivo();
        listaArquivosServidor.clear();

        // Pega a lista de arquivos enviado pelo servidor escravo através da mensagem
        ArrayList<InfoArquivo> listaArquivosEscravo = (ArrayList<InfoArquivo>) mensagem.getInfoRequisicao();

        for(InfoArquivo arquivo : listaArquivosEscravo) {
            listaArquivosServidor.add(
            new InfoArquivo(arquivo.getNome(), new InfoServidor(getNome(), getIP(), arquivo.getServEscravo().getPorta()), arquivo.getTamanho() ));
        }

        // Salva de volta no servidor.
        servidor.setListaArquivo(listaArquivosServidor);
        janelaServidor.atualizaTabelaArquivos();
    }
}
