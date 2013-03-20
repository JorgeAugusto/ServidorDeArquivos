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
    private Socket                  socket;
    private ObjectInputStream       entrada;
    private ObjectOutputStream      saida;
    private Servidor                servidor;

    @Override
    public void run() {
        servidor.getJanelaServidor().adicionarHistorico("Executou run em ConexaoEscravo", "OK");
    }

}
