/**
 * Enum com as configurações de conexão
 * @author Jorge Augusto C. dos Reis
 */

package base;

public enum InfoServidorPrincipal {
    SERVIDOR_PRINCIPAL("localhost",   2000);

    InfoServidorPrincipal(String ip, int porta) {
        this.ip     = ip;
        this.porta  = porta;
    }

    public String   ip;
    public int      porta;
}

