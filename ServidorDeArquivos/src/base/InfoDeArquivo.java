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
    private String                  nome;
    private InfoServidorEscravo     local;
    private long                    tamanho; // em bytes;


    // Construtor
    public InfoDeArquivo(String nome, InfoServidorEscravo local, long tamanho) {
        this.nome       = nome;
        this.local      = local;
        this.tamanho    = tamanho;
    }

    /**
     * Este método returna um array de Objects ele vai ser usado pelo Model da
     * JTable
     * @REFATORAR: É necessário escrever um método que transforme o total de dados
     * em um forma mais inteligente, tipo... KB, MB, GB e coisas do tipo
     * mas isso fica pra faze final
     */
    public Object[] getArray() {
        Object[] array = new Object[3];
        array[0] = (String) nome;
        array[1] = (InfoServidorEscravo) local;
        array[2] = (String) Long.toString(tamanho) + " bytes";

        return array;
    }

    public String getNome() {
        return nome;
    }

    public InfoServidorEscravo getInfoServidorEscravo() {
        return local;
    }

    public long getTamanho() {
        return tamanho;
    }
}
