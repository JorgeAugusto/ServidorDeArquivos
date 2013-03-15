/**
 * Enum com as configurações de conexão
 * @author Jorge Augusto C. dos Reis
 * Descrição:
 * Esta classe modela a GerenteConexao do servidor responsavel por aceitar as conexões
 * isto por que o método accept é bloqueante e não pode ficar em um método da
 * interface gráfica senão, ele trava a mesma, desta forma é necessário se criar
 * uma nova GerenteConexao para realizar o processo de aceitar as novas conexões.
 */

package servidor;

import base.InfoServidorPrincipal;
import java.net.ServerSocket;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GerenteConexao implements Runnable{
    private ServerSocket    socketServidor;
    private JLabel          barraStatus;


    // Construtor
    public GerenteConexao(JLabel barraStatus) {
        try {
            this.barraStatus = barraStatus;
            socketServidor = new ServerSocket(InfoServidorPrincipal.SERVIDOR_PRINCIPAL.porta);
        }
        catch(Exception ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage(),
                                "Erro ao criar Socket do Servidor",
                                JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void run() {
        barraStatus.setText("Iniciou Execução da Thread do Servidor!!!");

        // Loop infinito, aceita as conexões vindas dos clientes
        // e cria uma nova Conexao (GerenteConexao) para responder pela
        // mesma
        for(;;) {
            try {
                new Thread(new Conexao(socketServidor.accept())).start();
            }
            catch(Exception ex) {
                JOptionPane.showConfirmDialog(null, ex.getMessage(),
                        "Erro ao aceitar a conexão do cliente e criar a nova Conexão",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
