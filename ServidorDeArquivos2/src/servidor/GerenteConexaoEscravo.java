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
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GerenteConexaoEscravo implements Runnable {
    private ServerSocket                socketServidor;
    private Servidor                    servidor;         // referência a janela do programa
    private JanelaServidor              janelaServidor;
    private ArrayList<ConexaoEscravo>   listaConexoes;

    // Construtor
    public GerenteConexaoEscravo(Servidor servidor) {
        try {
            this.servidor   = servidor;
            socketServidor  = new ServerSocket(servidor.getPortaEscravos());
            janelaServidor  = servidor.getJanelaServidor();
            listaConexoes   = new ArrayList<ConexaoEscravo>();


            janelaServidor.adicionarHistorico("Criando SocketServ para Escravos, na porta: " +
            Integer.toString(servidor.getPortaEscravos()), "OK");
        }
        catch(Exception ex) {
            janelaServidor.adicionarHistorico("Criando SocketServ para Escravos, na porta: " +
            Integer.toString(servidor.getPortaEscravos()), "ERRO");
        }
    }

    @Override
    public void run() {
        janelaServidor.adicionarHistorico("Iniciou Thread do Gerente de Conexões com Escravos", "OK");

        for(;;) {
            try {
                ConexaoEscravo  conexao = new ConexaoEscravo(socketServidor.accept());
                Thread          thread  = new Thread(conexao);
                thread.start();

                listaConexoes.add(conexao);     // salava conexão com escravo na lista!
                janelaServidor.adicionarHistorico("Aceitou conexão de escravo: Escravo #1, na porta 2002", "OK");
            }
            catch(Exception ex) {
                janelaServidor.adicionarHistorico("Aceitando conexão de Escravo", "ERRO");
            }
        }
    }
}
