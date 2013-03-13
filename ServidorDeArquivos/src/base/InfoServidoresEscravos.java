/**
 * Enum com as configurações de conexão
 * @author Jorge Augusto C. dos Reis
 */

package base;

import java.io.Serializable;

public class InfoServidoresEscravos implements Serializable{
    private String  nome;
    private String  ip;
    private int     porta;

    public InfoServidoresEscravos(String nome, String ip, int porta) {
        this.nome   = nome;
        this.ip     = ip;
        this.porta  = porta;
    }
}
