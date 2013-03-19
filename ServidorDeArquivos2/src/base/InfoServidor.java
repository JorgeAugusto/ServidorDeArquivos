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
    private int     porta;

    public InfoServidor() { }

    public InfoServidor(String nome, String ip, int porta) {
        this.nome   = nome;
        this.ip     = ip;
        this.porta = porta;
    }

    //<editor-fold defaultstate="collapsed" desc="SOMENTE PARA TESTES - DEVE SER RETIRADO MAIS TARDE">
    // Somente para Teste
    @Override
    public String toString() {
        return "[" + nome + ", " + ip + ", " + Integer.toString(porta) + "]";
    }
    //</editor-fold>

    public String getNome() {
        return nome;
    }

    public String getIp() {
        return ip;
    }

    public int getPorta() {
        return porta;
    }

    /**
     * Este método salva um objeto desta classe em um arquivo informado.
     */
    public static void salvaEmArquivo(InfoServidor info, String nomeArquivo) throws Exception {
        FileOutputStream    arquivo     = new FileOutputStream(nomeArquivo);
        ObjectOutputStream  escritor    = new ObjectOutputStream(arquivo);

        escritor.writeObject(info);
        escritor.flush();
        arquivo.close();
    }

    /**
     * Este método carrega um objeto desta classe de um arquivo informado.
     */
    public static InfoServidor carregaDeArquivo(InfoServidor info, String nomeArquivo) throws Exception {
        FileInputStream     arquivo     = new FileInputStream(nomeArquivo);
        ObjectInputStream   leitor      = new ObjectInputStream(arquivo);

        info = (InfoServidor) leitor.readObject();
        arquivo.close();

        return info;
    }

    /**
     * Este método salva um ArrayList de objetos desta classe em um arquivo informado.
     */
    public static void salvaEmArquivo(ArrayList<InfoServidor> listaInfo, String nomeArquivo) throws Exception {
        FileOutputStream    arquivo     = new FileOutputStream(nomeArquivo);
        ObjectOutputStream  escritor    = new ObjectOutputStream(arquivo);

        escritor.writeObject(listaInfo);
        escritor.flush();
        arquivo.close();
    }

    /**
     * Este método carrega um objeto desta classe de um arquivo informado.
     */
    public static ArrayList<InfoServidor> carregaDeArquivo(ArrayList<InfoServidor> listaInfo, String nomeArquivo) throws Exception {
        FileInputStream     arquivo     = new FileInputStream(nomeArquivo);
        ObjectInputStream   leitor      = new ObjectInputStream(arquivo);

        listaInfo = (ArrayList<InfoServidor>) leitor.readObject();
        arquivo.close();

        return listaInfo;
    }
}
