/**
 * Enum com as configurações de conexão
 * @author Jorge Augusto C. dos Reis
 */

package base;

import java.io.Serializable;

public class InfoServidoresEscravos implements Serializable{
    private String nome;
    private String ip;

    public InfoServidoresEscravos(String nome, String ip) {
        this.nome   = nome;
        this.ip     = ip;
    }
}
