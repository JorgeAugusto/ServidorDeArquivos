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
    private JanelaServidor          janelaServidor;     // só para facilidar o acesso!
    private Socket                  socket;
    private ObjectInputStream       entrada;
    private ObjectOutputStream      saida;
    private Servidor                servidor;

    public ConexaoEscravo(Socket socket, Servidor servidor) {
        this.socket     = socket;
        this.servidor   = servidor;
        janelaServidor  = servidor.getJanelaServidor();
    }

    @Override
    public void run() {
        // janelaServidor.adicionarHistorico("Processando Requisições do Escravo #1", "AGUARDANDO...");
    }
}
