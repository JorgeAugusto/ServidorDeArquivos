/**
 * Classe que implementa Runnable para várias conexões
 * @author Jorge Augusto C. dos Reis
 * Descrição:
 */

package servidor;

public class InfoCliente {
    private int         idCliente;
    private Conexao     conexao;
    private Thread      thread;
    private String      estado;
    private String      arquivo;
    private int         percentual;

    public InfoCliente(int idCliente, Conexao conexao, Thread thread, String estado, String arquivo, int percentual) {
        this.idCliente  = idCliente;
        this.conexao    = conexao;
        this.thread     = thread;
        this.estado     = estado;
        this.arquivo    = arquivo;
        this.percentual = percentual;
    }

    // Este método retorna o array para ser usado no Model da JTable
    public String[] getArray() {
        return new String[]{"#" + Integer.toString(idCliente), estado, arquivo, Integer.toString(percentual) + "%"};
    }
}
