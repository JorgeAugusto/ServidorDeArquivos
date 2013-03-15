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
import base.InfoDeArquivo;
import java.net.ServerSocket;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GerenteConexao implements Runnable{
    private ServerSocket    socketServidor;
    private Janela          janela;         // referência a janela do programa

    // Construtor
    public GerenteConexao(Janela janela) {
        try {
            this.janela = janela;
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
        janela.escreveNaBarraStatus("Iniciou execução da Thread do Servidor!!!");

        // Loop infinito, aceita as conexões vindas dos clientes
        // e cria uma nova Conexao (GerenteConexao) para responder pela
        // mesma
        for(;;) {
            try {
                new Thread(new Conexao(socketServidor.accept(), janela)).start();
            }
            catch(Exception ex) {
                JOptionPane.showConfirmDialog(null, ex.getMessage(),
                        "Erro ao aceitar a conexão do cliente e criar a nova Conexão",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
