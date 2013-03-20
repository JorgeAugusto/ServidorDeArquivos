/**
 * Classe que modela a informação de um arquivo
 * @author: Jorge Augusto C. dos Reis
 * @data..: 18/03/2013 às 03:22
 * @Descrição:
 * Esta classe modela as informações de uma arquivo, como nome, servEscravo que
 * é o local (Servidor Escravo) onde o arquivo se encontra e o seu tamanho
 */

package base;

import java.io.Serializable;

public class InfoArquivo implements Serializable {
    private String          nome;
    private InfoServidor    servEscravo;
    private long            tamanho;

    public InfoArquivo() { }

    public InfoArquivo(String nome, InfoServidor servEscravo, long tamanho) {
        this.nome           = nome;
        this.servEscravo    = servEscravo;
        this.tamanho        = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public InfoServidor getServEscravo() {
        return servEscravo;
    }

    public long getTamanho() {
        return tamanho;
    }

    /**
     * Este método retorna os dados como um array de String, ele é usado
     * pelo DefaultModel da JTable.
     * @NOTA: Ele deve se movido daqui para a classe que tem a JTable
     */
    public String[] getArray() {
        String[] array = new String[3];
        array[0] = nome;
        array[1] = servEscravo.getNome();
        array[2] = Long.toString(tamanho) + " bytes";

        return array;
    }
    
}
