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

public class InfoServidoresEscravos implements Serializable{
    private String  nome;
    private String  ip;
    private int     porta;

    public InfoServidoresEscravos(String nome, String ip, int porta) {
        this.nome   = nome;
        this.ip     = ip;
        this.porta  = porta;
    }

    // Sobre-escreve o método toString para fornecer os atributos da classe
    // Este método é somente para testes.
    @Override
    public String toString() {
        return "[" + nome + ", " + ip + ", " + porta + "]";
    }

    public String getNome() {
        return nome;
    }
}
