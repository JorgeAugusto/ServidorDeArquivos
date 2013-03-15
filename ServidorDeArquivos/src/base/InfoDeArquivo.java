/**
 * Enum com as configurações de conexão
 * @author Jorge Augusto C. dos Reis
 * Descrição:
 * Esta classe modela uma listagem de arquivos, ela implementa a interface
 * Serializable, para que possa se usar as classes:
 * ObjectInputStream e ObjectOutputStream
 */

package base;

import java.io.Serializable;

public class InfoDeArquivo implements Serializable {
    private String  nome;
    private String  local;
    private int     tamanho; // em bytes;


    // Construtor
    public InfoDeArquivo(String nome, String local, int tamanho) {
        this.nome       = nome;
        this.local      = local;
        this.tamanho    = tamanho;
    }

    /**
     * Este método returna um array de string's ele vai ser usado pelo Model da
     * JTable
     * @Todo: É necessário escrever um método que transforme o total de dados
     * em um forma mais inteligente, tipo... KB, MB, GB e coisas do tipo...
     * mas isso fica pra faze final
     */
    public String[] getArray() {
        String[] array = new String[3];
        array[0] = nome;
        array[1] = local;
        array[2] = Integer.toString(tamanho) + " bytes";

        return array;
    }

    public String getNome() {
        return nome;
    }

    public String getLocal() {
        return local;
    }

    public int getTamanho() {
        return tamanho;
    }
}
