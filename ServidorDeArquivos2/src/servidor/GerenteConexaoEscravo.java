/**
 * Classe que modela o Gerente de Conexão com os Escravos
 * @author: Jorge Augusto C. dos Reis
 * @data..: 19/03/2013 às 07:45
 * @Descrição:
 * Esta classe modela o Gerente de Conexão do Servidor Principal com os
 * Servidores Escravos, foi implementado deste modo para que este gerente
 * rode em Thread seperada, para não ter problemas com a GUI.
 */

package servidor;

import java.net.ServerSocket;
import javax.swing.JOptionPane;

public class GerenteConexaoEscravo implements Runnable {
    private ServerSocket        socketServidor;
    private Servidor            servidor;         // referência a janela do programa
    private JanelaServidor      janelaServidor;

    // Construtor
    public GerenteConexaoEscravo(Servidor servidor) {
        try {
            this.servidor   = servidor;
            socketServidor  = new ServerSocket(servidor.getPortaEscravos());
            janelaServidor  = servidor.getJanelaServidor();
        }
        catch(Exception ex) {
            janelaServidor.adicionarHistorico("Criando SocketServ para Escravos, na porta: " +
            Integer.toString(servidor.getPortaEscravos()), "ERRO");
        }
    }

    @Override
    public void run() {
        janelaServidor.adicionarHistorico("Iniciou Gerente de Conexões com Escravos", "OK");

        // Loop infinito, aceita as conexões vindas dos clientes
        // e cria uma nova Conexao (GerenteConexao) para responder pela
        // mesma
        for(;;) {
            try {
                /**
                 * new Thread(new Conexao(socketServidor.accept(), janela)).start();
                 * Thread  thread  = new Thread(conexao);
                 * thread.start();
                 */
                ConexaoEscravo  conexao = new ConexaoEscravo();
                Thread          thread  = new Thread(conexao);
                thread.start();

            }
            catch(Exception ex) {
                JOptionPane.showConfirmDialog(null, ex.getMessage(),
                        "Erro ao aceitar a conexão do cliente e criar a nova Conexão",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
