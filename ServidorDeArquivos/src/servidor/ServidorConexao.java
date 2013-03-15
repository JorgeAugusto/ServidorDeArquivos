/**
 * Classe que implementa Runnable para várias conexões
 * @author Jorge Augusto C. dos Reis
 * Descrição:
 * Esta classe modela uma conexão com o servidor principal, ela vai ser utilizada
 * pela classe ServidorPrincipal para criar uma nova Thread com gerenciará uma
 * conexão com o cliente.
 */

package servidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServidorConexao implements Runnable {
    private Socket                  socketCliente;
    private ObjectInputStream       entradaCliente;
    private ObjectOutputStream      saidaCliente;

    public ServidorConexao(Socket socketCliente) throws Exception {
        this.socketCliente = socketCliente;
        entradaCliente = new ObjectInputStream(this.socketCliente.getInputStream());
        saidaCliente   = new ObjectOutputStream(this.socketCliente.getOutputStream());
    }

    @Override
    public void run() {
        for(;;) {

        }
    }
}