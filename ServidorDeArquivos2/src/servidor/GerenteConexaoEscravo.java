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

import base.EstadoSistema;
import java.net.ServerSocket;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GerenteConexaoEscravo implements Runnable {
    private ServerSocket                socketServidor;
    private Servidor                    servidor;         // referência a janela do programa
    private JanelaServidor              janelaServidor;
    private ArrayList<ConexaoEscravo>   listaEscravos;

    // Construtor
    public GerenteConexaoEscravo(Servidor servidor) {
        try {
            this.servidor   = servidor;
            socketServidor  = new ServerSocket(servidor.getPortaEscravos());
            janelaServidor  = servidor.getJanelaServidor();
            listaEscravos   = new ArrayList<ConexaoEscravo>();

            janelaServidor.adicionarHistorico("Criando SocketServ para Escravos, na porta: " +
            Integer.toString(servidor.getPortaEscravos()), EstadoSistema.OK);
        }
        catch(Exception ex) {
            janelaServidor.adicionarHistorico("Criando SocketServ para Escravos, na porta: " +
            Integer.toString(servidor.getPortaEscravos()), EstadoSistema.ERRO);
        }
    }

    @Override
    public void run() {
        janelaServidor.adicionarHistorico("Iniciou Thread do Gerente de Conexões com Escravos", EstadoSistema.OK);

        for(;;) {
            try {
                ConexaoEscravo  conexao = new ConexaoEscravo(socketServidor.accept(), servidor);
                Thread          thread  = new Thread(conexao);
                thread.start();

                listaEscravos.add(conexao);     // salva conexão com escravo na lista!

                janelaServidor.adicionarHistorico("Aceitou conexão de escravo: " + conexao.getInfoConexo(), EstadoSistema.OK);
                janelaServidor.atualizarTabelaEscravos();
            }
            catch(Exception ex) {
                janelaServidor.adicionarHistorico("Aceitando conexão de Escravo", EstadoSistema.ERRO);
            }
        }
    }

    /**
     * Este método vai atualizar a lista de servidores escravos
     */
    public ArrayList<ConexaoEscravo> getListaEscravos() {
        return listaEscravos;
    }

    /**
     * Este método atualiza a lista de arquivos no servidor...
     */
    public synchronized void processaListaArquivos() {
        servidor.getListaArquivo().clear();
        try{
            for(ConexaoEscravo conEscravo : listaEscravos) {
                // Se esta desconectado passa para o próximo
                if(conEscravo.getEstado() == ConexaoEscravo.EstadoEscravo.DESCONECTADO) continue;

                servidor.getListaArquivo().addAll(conEscravo.getListaArquivo());
            }

            janelaServidor.atualizaTabelaArquivos();
        }
        catch(Exception ex) {
            janelaServidor.adicionarHistorico("Processando listas de arquivos dos Servidores Escravos", EstadoSistema.ERRO);
        }
    }


    /**
     * Returna o número total de servidores escravos conectados
     * isso é para ajudar o método de método enviaE
     */
    public boolean temEscravoConectado() {
        for(ConexaoEscravo conexao : listaEscravos) {
            if(conexao.getEstado() == ConexaoEscravo.EstadoEscravo.CONECTADO)
                return true;
        }

        return false;
    }
}
