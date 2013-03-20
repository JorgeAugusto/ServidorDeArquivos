/**
 * Classe que modela o Servidor Escravo
 * @author: Jorge Augusto C. dos Reis
 * @data..: 18/03/2013 às 05:22
 * @Descrição:
 * Esta classe modela o Servidor Escravo do sistema.
 */

package escravo;

import base.InfoServidor;
import java.io.File;
import java.net.Socket;

public class Escravo {
    public  static final String ARQ_CONFIG_CON_SERVIDOR = "ConfigConServidor.ser";

    private InfoServidor    infoConexaoServidor;
    private JanelaEscravo   janelaEscravo;
    private Socket          socket;


    public Escravo(JanelaEscravo janelaEscravo) throws Exception {
        this.janelaEscravo = janelaEscravo;
        carregarConfigConServidor();
        socket = new Socket("localhost", 2001);
    }

    public InfoServidor getInfoServidor() {
        return infoConexaoServidor;
    }

    public void setInfoServidor(InfoServidor infoConexaoServidor) {
        this.infoConexaoServidor = infoConexaoServidor;
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

            setInfoServidor(InfoServidor.carregarDeArquivo(infoServidor, Escravo.ARQ_CONFIG_CON_SERVIDOR));
        }
        catch(Exception ex) {
            janelaEscravo.escreverNaBarraStatus("Erro ao carregar configurações da conexão com o Servidor.");
            return;
        }

        janelaEscravo.escreverNaBarraStatus("Configurações da conexão com o Servidor, carregadas com sucesso.");
    }
}
