/**
 * Classe que modela a Conexão de um Escravo
 * @author: Jorge Augusto C. dos Reis
 * @data..: 19/03/2013 às 07:45
 * @Descrição:
 * Esta classe modela a Conexão do Servidor com um Escravo.
 */

package escravo;

import base.Mensagem;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

public class ConexaoControle implements Runnable {
    private JanelaEscravo           janelaEscravo;     // só para facilidar o acesso!
    private Socket                  socket;
    private ObjectInputStream       entrada;
    private ObjectOutputStream      saida;
    private Escravo                 escravo;
    // private EstadoEscravo           estado;
    private Mensagem                mensagemRecebida;
    private Mensagem                mensagemEnviada;

    /**
     * a própria conexão de controle que cria o socket...
     * mudar isso em breve!
     */
    public ConexaoControle(Escravo escravo) /*throws Exception*/ {
        this.escravo    = escravo;
        janelaEscravo   = escravo.getJanelaEscravo();

        try {
            socket      = new Socket(escravo.getInfoConServidor().getIp(), escravo.getInfoConServidor().getPorta());
            saida       = new ObjectOutputStream(socket.getOutputStream());
            saida.flush();
            entrada     = new ObjectInputStream(socket.getInputStream());

            /**
             * Não precisa mais disso, por que é o servidor principal que requisa
             * a lista de arquivos
             */
            // enviarListaDeArquivos();
        }
        catch(Exception ex) {
            janelaEscravo.escreverNaBarraStatus(
                    String.format("ERRO ao conectar em: [%s] no IP: [%s] na Porta: [%d]",
                        escravo.getInfoConServidor().getNome(),
                        escravo.getInfoConServidor().getIp(),
                        escravo.getInfoConServidor().getPorta())
                    );
            return;
        }

        janelaEscravo.escreverNaBarraStatus(
                String.format("Conectado com SUCESSO em: [%s] no IP: [%s] na Porta: [%d]",
                    escravo.getInfoConServidor().getNome(),
                    escravo.getInfoConServidor().getIp(),
                    escravo.getInfoConServidor().getPorta())
                );

        JOptionPane.showMessageDialog(janelaEscravo, "Saio no construtor de ConexaoControle");
    }

    /**
     * Este método vai rodar em uma nova Thread
     * e ele é responsável por responder as mensagem para o servidor principal
     */
    @Override
    public void run() {
        for(;;) {
            // Se o socke esta fechado então terminar Thread.
            if(socket.isClosed()) return;

            try {
                mensagemRecebida = (Mensagem) entrada.readObject();

                switch(mensagemRecebida.getTipoMensagem()) {
                    case LISTA_ARQUIVOS:
                        enviarListaDeArquivos();
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

    public String getIP() {
        return  socket.getInetAddress().toString();
    }

    public int getPorta() {
        return socket.getPort();
    }

//    public EstadoEscravo getEstado() {
//        return estado;
//    }

//    public void setEstado(EstadoEscravo estado) {
//        this.estado = estado;
//    }

//    public String getNome() {
//        return "Escravo #" + Integer.toString(id);
//    }

    /**
     * Este método retorna as informações da conexão como uma string
     * é um método auxiliar para facilitar o acesso as essas informações
     */
//    public String getInfoConexo() {
//        return String.format("%s no IP: [%s] na Porta: [%d]", getNome(), getIP(), getPorta());
//    }

    // Métodos privados
    /**
     * Este método envia ao servidor escravo uma solicitação para que mesmo
     * envie uma lista contento os nomes dos arquivos que estão disponíveis
     */
//    private void solicitarListaArquivos() {
//        try {
//            Mensagem requiscao = new Mensagem(Mensagem.TipoMensagem.LISTA_ARQUIVOS, null);
//
//        }
//        catch(Exception ex) {
//
//        }
//    }

    /**
     * Este método processa a mensagem de recebimento de uma lista de arquivos
     */
//    private synchronized void processarListaArquivo() {
//        janelaServidor.adicionarHistorico("Processecando lista de arquivos de : " + getNome() + "...", EstadoSistema.PROCESSANDO);
//
//        ArrayList<InfoArquivo> listaArquivosServidor = servidor.getListaArquivo();
//        listaArquivosServidor.clear();
//
//        // Pega a lista de arquivos enviado pelo servidor escravo através da mensagem
//        ArrayList<InfoArquivo> listaArquivosEscravo = (ArrayList<InfoArquivo>) mensagem.getInfoMensagem();
//
//        for(InfoArquivo arquivo : listaArquivosEscravo) {
//            listaArquivosServidor.add(
//            new InfoArquivo(arquivo.getNome(), new InfoServidor(getNome(), getIP(), arquivo.getServEscravo().getPorta()), arquivo.getTamanho() ));
//        }
//
//        // Salva de volta no servidor.
//        servidor.setListaArquivo(listaArquivosServidor);
//        janelaServidor.atualizaTabelaArquivos();
//        janelaServidor.adicionarHistorico("Processecando lista de arquivos de : " + getNome(), EstadoSistema.OK);
//    }


    /**
     * Desconecta servidor escravo do servidor principal
     */
    private void desconectarServidorEscravo() {

        janelaEscravo.escreverNaBarraStatus("Ouve algum erro na hora de processar mensagem!!!...");
//        /**
//        * @NOTA
//        * Este código deve ser movido para um novo método...
//        */
//
//        janelaServidor.adicionarHistorico("Processsando Mensagem de " + getInfoConexo() , EstadoSistema.ERRO);
//        janelaServidor.adicionarHistorico("Desconectando do Servidor Escravo... " + getNome() , EstadoSistema.PROCESSANDO);
//
//        try {
//            entrada.close();
//            saida.close();
//            socket.close();
//
//            /**
//                * @NOTA 1
//                * Código muito prolixo!!!
//                * Considerar mudar a listaEscravos para dentro da classe servidor e
//                * não em GerenteConexaoEscravo como está atualmente.
//                * @NOTA 2
//                * Também considerar usar HashTable ao invéz de ArrayList
//                * para não depender o índice gerado por id
//                */
//            servidor.getGerenteConexaoEscravos().getListaEscravos().get(id - 1).setEstado(EstadoEscravo.DESCONECTADO);
//            janelaServidor.atualizarTabelaEscravos();
//
//            // Removo arquivos deste servidor escravo
//
//
//
//            // Atualiza lista de arquivos...
//        }
//        catch(Exception ex1) {
//            janelaServidor.adicionarHistorico("Desconectando Servidor Escravo: " + getNome() + "...", EstadoSistema.ERRO);
//        }
//
//        janelaServidor.adicionarHistorico("Desconectando Servidor Escravo: " + getNome(), EstadoSistema.OK);
    }


    // Este método responde a solicitção de listagem de arquivos...
    private void enviarListaDeArquivos() {
        try {
            janelaEscravo.escreverNaBarraStatus("Enviando lista de arquivos para:" + escravo.getInfoConServidor().getNome());

            escravo.atualizarListaArquivos();
            mensagemEnviada = new Mensagem(Mensagem.TipoMensagem.LISTA_ARQUIVOS, escravo.getListaArquivos());

            // envia listagem de arquivos...
            // saida = new ObjectOutputStream(socket.getOutputStream());
            saida.writeObject(mensagemEnviada);
            saida.flush();
        }
        catch(Exception ex) {
            janelaEscravo.escreverNaBarraStatus("Erro ao enivar lista de arquivos para: " + escravo.getInfoConServidor().getNome());
        }
    }
    
}
