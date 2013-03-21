/**
 * Classe que modela o Servidor Escravo
 * @author: Jorge Augusto C. dos Reis
 * @data..: 18/03/2013 às 05:22
 * @Descrição:
 * Esta classe modela o Servidor Escravo do sistema.
 */

package escravo;

import base.InfoArquivo;
import base.InfoServidor;
import base.Mensagem;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Escravo {
    public static final String  ARQ_CONFIG_CON_SERVIDOR = "ConfigConServidor.ser";
    public static final String  PASTA_COMPARTILHADOS    = "Compartilhados";
    public static final String  PASTA_DOWNLOADS         = "Downloads";


    private ObjectInputStream       entrada;
    private ObjectOutputStream      saida;
    private InfoServidor            infoConServidor;
    private JanelaEscravo           janelaEscravo;
    private Socket                  socket;
    private ArrayList<InfoArquivo>  listaArquivos;
    private ConexaoControle         conexaoControle;

    public Escravo(JanelaEscravo janelaEscravo) throws Exception {
        this.janelaEscravo  = janelaEscravo;
        listaArquivos       = new ArrayList<InfoArquivo>();

        carregarConfigConServidor();
        criarConexaoControle();
    }

    // Este método cria o socket de comunicação com o servidor principal.
    public final void criarConexaoControle() {
        try {
        conexaoControle = new ConexaoControle(this);
        Thread  thread  = new Thread(conexaoControle);
        thread.start();
        }
        catch(Exception ex) {
            janelaEscravo.escreverNaBarraStatus("Erro na criação da conexão de controle com o servidor.");
        }
    }

    /**
     * Retorna informações de conexão com o servidor
     */
    public InfoServidor getInfoConServidor() {
        return infoConServidor;
    }

    /**
     * Set informações de conexão com o servidor
     */
    public void setInfoConServidor(InfoServidor infoConexaoServidor) {
        this.infoConServidor = infoConexaoServidor;
    }

    /**
     * Retorna a lista dos arquivos
     */
    public ArrayList<InfoArquivo> getListaArquivos() {
        return listaArquivos;
    }

    /**
     * Este método carrega as informações de conexão do
     */
    public final void carregarConfigConServidor() {
        try {
            File arq = new File(Escravo.ARQ_CONFIG_CON_SERVIDOR);

            InfoServidor infoServidor = new InfoServidor("Servidor", "localhost", 2000);

            if(!arq.exists() || !arq.isFile()) {
                InfoServidor.salvarEmArquivo(infoServidor, Escravo.ARQ_CONFIG_CON_SERVIDOR);
            }

            setInfoConServidor(InfoServidor.carregarDeArquivo(infoServidor, Escravo.ARQ_CONFIG_CON_SERVIDOR));
        }
        catch(Exception ex) {
            janelaEscravo.escreverNaBarraStatus("Erro ao carregar configurações da conexão com o Servidor.");
            return;
        }

        janelaEscravo.escreverNaBarraStatus("Configurações da conexão com o Servidor, carregadas com sucesso.");
    }

    /**
     * Este método cria a lista de arquivos a ser enviada para o servidor e
     * a ser mostrada na tabela de arquivos na JanelaEscravo
     */
    public void atualizarListaArquivos() {
        try {
            InfoServidor    esteEscravo = new InfoServidor("Máquina Local", "-", infoConServidor.getPorta());

            File    pasta       = new File(PASTA_COMPARTILHADOS);

            listaArquivos.clear();
            for(File arquivo : pasta.listFiles()) {
                if(arquivo.isFile()) {
                    InfoArquivo infoArquivo = new InfoArquivo(arquivo.getName(), esteEscravo, arquivo.length());
                    listaArquivos.add(infoArquivo);
                }
            }
        }
        catch(Exception ex) {
            janelaEscravo.escreverNaBarraStatus("Erro ao montar listagem de arquivos: " + ex.getMessage());
        }
    }
}
