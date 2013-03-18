/**
 * Classe que modela o Servidor Escravo
 * @author: Jorge Augusto C. dos Reis
 * @data..: 18/03/2013 às 05:22
 * @Descrição:
 * Esta classe modela o Servidor Escravo do sistema.
 */

package escravo;

import base.InfoServidor;

public class Escravo {
    public  static final String ARQ_CONFIG_CON_SERVIDOR = "ConfigConServidor.ser";

    private InfoServidor infoConexaoServidor;


    public Escravo() { }

    public Escravo(InfoServidor infoConexaoServidor) {
        this.infoConexaoServidor = infoConexaoServidor;
    }

    public InfoServidor getInfoServidor() {
        return infoConexaoServidor;
    }

    public void setInfoServidor(InfoServidor infoConexaoServidor) {
        this.infoConexaoServidor = infoConexaoServidor;
    }
}
