/**
 * Classe que implementa Runnable para várias conexões
 * @author Jorge Augusto C. dos Reis
 */

package servidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConexaoServidor implements Runnable {
    private Socket                  socketCliente;
    private ObjectInputStream       entradaCliente;
    private ObjectOutputStream      saidaCliente;

    public ConexaoServidor(Socket socketCliente) throws Exception {
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