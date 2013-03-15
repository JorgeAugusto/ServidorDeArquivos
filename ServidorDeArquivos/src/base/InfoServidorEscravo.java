/**
 * Enum com as configurações de conexão
 * @author Jorge Augusto C. dos Reis
 * Descrição:
 * Esta classe modela uma informação de conexão com um servidor escravo
 * Ela é usando em um ArrayList, para que dessa se possa trabalhar com esses
 * dados como objetos.
 */

package base;

import java.io.Serializable;

public class InfoServidorEscravo implements Serializable{
    private String  nome;
    private String  ip;
    private int     porta;

    public InfoServidorEscravo(String nome, String ip, int porta) {
        this.nome   = nome;
        this.ip     = ip;
        this.porta  = porta;
    }

    /**
     * Sobrescreve o método toString por que dessa forma eu posso
     * armazenar na JTable na coluna Local um objeto da classe InfoDeAquivo.
     @REFATORAR: Este método deve ser apagado na versão final
     */
    @Override
    public String toString() {
        return nome;
    }

    // Retorna o nome do servidor escravo, usando pelo método: solicitarListagemDeArquivos
    // da classe Janela, para colocar o nome do escravo na JTable.
    public String getNome() {
        return nome;
    }
}
