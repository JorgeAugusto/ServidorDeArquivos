/**
 * Classe que modela a informação de um servidor (principal ou escravo)
 * @author: Jorge Augusto C. dos Reis
 * @data..: 17/03/2013 às 23:14
 * @Descrição:
 * Esta classe modela as informações de conexão de um host servidor
 * que pode ser tando o servidor principal como um dos vários servidores
 * escravos
 */

package base;

import java.io.*;
import java.util.ArrayList;

public class InfoServidor implements Serializable {
    private String  nome;
    private String  ip;
    private int     portaControle;
    private int     portaDados;

    public InfoServidor() {

    }

    public InfoServidor(String nome, String ip, int portaControle, int portaDados) {
        this.nome   = nome;
        this.ip     = ip;
        this.portaControle = portaControle;
        this.portaDados    = portaDados;
    }

    // Somente para Teste
    @Override
    public String toString() {
        return "[" + nome + ", " + ip + ", " + Integer.toString(portaControle) +
                ", " + Integer.toString(portaDados) + "]";
    }

    public String getNome() {
        return nome;
    }

    public String getIp() {
        return ip;
    }

    public int getPortaControle() {
        return portaControle;
    }

    public int getPortaDados() {
        return portaDados;
    }

    /**
     * Este método salva um objeto desta classe em um arquivo informado.
     * @return true se salvo com sucesse e false em caso de erro.
     */
    public static boolean salvaEmArquivo(InfoServidor info, String nomeArquivo) {
        try {
            FileOutputStream    arquivo     = new FileOutputStream(nomeArquivo);
            ObjectOutputStream  escritor    = new ObjectOutputStream(arquivo);
            escritor.writeObject(info);
            escritor.flush();

            arquivo.close();
        }
        catch(Exception ex) {
            return false;
        }

        return true;
    }

    /**
     * Este método carrega um objeto desta classe de um arquivo informado.
     * @return true se carregado com sucesse e false em caso de erro.
     */
    public static InfoServidor carregaDeArquivo(InfoServidor info, String nomeArquivo) {
        try {
            FileInputStream     arquivo     = new FileInputStream(nomeArquivo);
            ObjectInputStream   leitor      = new ObjectInputStream(arquivo);
            info = (InfoServidor) leitor.readObject();

            arquivo.close();
        }
        catch(Exception ex) {
            return null;
        }

        return info;
    }

    /**
     * Este método salva um ArrayList de objetos desta classe em um arquivo informado.
     * @return true se salvo com sucesse e false em caso de erro.
     */
    public static boolean salvaEmArquivo(ArrayList<InfoServidor> listaInfo, String nomeArquivo) {
        try {
            FileOutputStream    arquivo     = new FileOutputStream(nomeArquivo);
            ObjectOutputStream  escritor    = new ObjectOutputStream(arquivo);
            escritor.writeObject(listaInfo);
        }
        catch(Exception ex) {
            return false;
        }

        return true;
    }

    /**
     * Este método carrega um objeto desta classe de um arquivo informado.
     * @return true se carregado com sucesse e false em caso de erro.
     */
    public static ArrayList<InfoServidor> carregaDeArquivo(ArrayList<InfoServidor> listaInfo, String nomeArquivo) {
        try {
            FileInputStream     arquivo     = new FileInputStream(nomeArquivo);
            ObjectInputStream   leitor      = new ObjectInputStream(arquivo);
            listaInfo = (ArrayList<InfoServidor>) leitor.readObject();
        }
        catch(Exception ex) {
            return null;
        }

        return listaInfo;
    }
}
