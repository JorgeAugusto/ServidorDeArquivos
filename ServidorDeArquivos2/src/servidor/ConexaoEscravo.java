/**
 * Classe que modela a Conexão de um Escravo
 * @author: Jorge Augusto C. dos Reis
 * @data..: 19/03/2013 às 07:45
 * @Descrição:
 * Esta classe modela a Conexão do Servidor com um Escravo.
 */

package servidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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

    public ConexaoEscravo(Socket socket, Servidor servidor, int id) {
        this.socket     = socket;
        this.servidor   = servidor;
        this.id         = id;
        janelaServidor  = servidor.getJanelaServidor();
        estado          = EstadoEscravo.CONECTADO;
    }

    @Override
    public void run() {
        janelaServidor.adicionarHistorico(String.format("Processando Requisições do Escravo #%d", id) , "OK");
    }

    public int getEscravoId() {
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


    // Métodos privados

    /**
     * Este método envia ao servidor escravo uma solicitação para que mesmo
     * envie uma lista contento os nomes dos arquivos que estão disponíveis
     */
    private void solicitarListaArquivos() {
        try {

        }
        catch(Exception ex) {

        }
    }
}
