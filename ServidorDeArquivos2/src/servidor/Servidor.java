/**
 * Classe que modela o Servidor Escravo
 * @author: Jorge Augusto C. dos Reis
 * @data..: 19/03/2013 às 06:22
 * @Descrição:
 * Esta classe modela o Servidor Principal do Sistema.
 */

package servidor;

import base.InfoServidor;
import java.util.ArrayList;

public class Servidor {
    public  static final String ARQ_CONFIG_PORTAS = "ConfigPortasServidor.ser";
    /**
     * Este ArrayList tem uma lista de InfoServido, contento as portas, nas quais
     * o servidor vai escutar as conexões do clientes e dos servidores escravos
     */
    private ArrayList<InfoServidor> infoPortas = new ArrayList<InfoServidor>();
    private JanelaServidor          janelaServidor;


    public Servidor() { }

    public ArrayList<InfoServidor> getInfoPortas() {
        return infoPortas;
    }

    public void setInfoPortas(ArrayList<InfoServidor> infoPortas) {
        this.infoPortas = infoPortas;
    }


}
