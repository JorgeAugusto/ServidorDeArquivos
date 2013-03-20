/**
 * Classe que modela o Servidor Principal do Sistema
 * @author: Jorge Augusto C. dos Reis
 * @data..: 19/03/2013 às 06:22
 * @Descrição:
 * Esta classe modela o Servidor Principal do Sistema.
 */

package servidor;

import base.InfoServidor;
import java.io.File;
import java.util.ArrayList;

public class Servidor {
    public  static final String ARQ_CONFIG_PORTAS = "ConfigPortasServidor.ser";
    /**
     * Este ArrayList tem uma lista de InfoServido, contento as portas, nas quais
     * o servidor vai escutar as conexões do clientes e dos servidores escravos
     */
    private ArrayList<InfoServidor> infoPortas;
    private JanelaServidor          janelaServidor;     // só para facilidar o acesso!
    private GerenteConexaoEscravo   gerenteConexaoEscravos;

    public Servidor(JanelaServidor janelaServidor) {
        this.janelaServidor = janelaServidor;
        infoPortas          = new ArrayList<InfoServidor>();

        carregarConfigPortas();             // carrega portas
        iniciarGerenteConexaoEscravos();    // iniciar gerente de escravos
    }


    /**
     * Este método inicia a Thread de gerenciamento de conexães do escravos
     */
    public final void iniciarGerenteConexaoEscravos() {
        gerenteConexaoEscravos = new GerenteConexaoEscravo(this);
        new Thread(gerenteConexaoEscravos).start();
    }

    public ArrayList<InfoServidor> getInfoPortas() {
        return infoPortas;
    }

    public void setInfoPortas(ArrayList<InfoServidor> infoPortas) {
        this.infoPortas = infoPortas;
    }

    public JanelaServidor getJanelaServidor() {
        return janelaServidor;
    }

    public int getPortaClientes() {
        if(infoPortas.size() >= 2) {
            return infoPortas.get(0).getPorta();
        }
        return -1;
    }

    public int getPortaEscravos() {
        if(infoPortas.size() >= 2) {
            return infoPortas.get(1).getPorta();
        }
        return -1;
    }
    
    /**
     * Este método carrega as informações de conexão do
     */
    public final void carregarConfigPortas() {
        try {
            File arq = new File(Servidor.ARQ_CONFIG_PORTAS);

            ArrayList<InfoServidor> listaPortas = new ArrayList<InfoServidor>();

            listaPortas.add(new InfoServidor("Clientes", "-", 2000));
            listaPortas.add(new InfoServidor("Escravos", "-", 2001));

            if(!arq.exists() || !arq.isFile()) {
                InfoServidor.salvarEmArquivo(listaPortas, Servidor.ARQ_CONFIG_PORTAS);
            }

            setInfoPortas(InfoServidor.carregarDeArquivo(listaPortas, Servidor.ARQ_CONFIG_PORTAS));
        }
        catch(Exception ex) {
            janelaServidor.adicionarHistorico("Corregando configurações de portas", "ERRO");
            return;
        }

        janelaServidor.adicionarHistorico("Corregando configurações de portas", "OK");
    }
}
