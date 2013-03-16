/**
 * Classe que implementa Runnable para várias conexões
 * @author Jorge Augusto C. dos Reis
 * Descrição:
 * Esta classe modela uma conexão com o servidor principal, ela vai ser utilizada
 * pela classe ServidorPrincipal para criar uma nova Thread com gerenciará uma
 * conexão com o cliente.
 */

package servidor;

import cliente.TipoSolicitacao;
import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao implements Runnable {
    private Socket                  socketCliente;
    private ObjectInputStream       entrada;
    private ObjectOutputStream      saida;
    private JanelaPrincipal         janela;         // referência a janela do programa
    private TipoSolicitacao         solicitacao;

    public Conexao(Socket socketCliente, JanelaPrincipal janela) throws Exception {
        janela.escreveNaBarraStatus("Entrou no construtor da Conexão");

        this.janela                 = janela;
        this.socketCliente  = socketCliente;
        entrada  = new ObjectInputStream(this.socketCliente.getInputStream());
        saida       = new ObjectOutputStream(this.socketCliente.getOutputStream());
    }

    @Override
    public void run() {
        for(;;) {
            try {
                solicitacao = (TipoSolicitacao) entrada.readObject();

                switch(solicitacao) {
                    case LISTAGEM_ARQUIVOS:
                        enviaListaDeArquivos();
                    break;

                    case UPLOAD:

                    break;

                    case DOWNLOAD:
                        enviaArquivo();
                    break;

                    case DELETAR:

                    break;
                }
            }
            catch(Exception ex) {
                janela.escreveNaBarraStatus("Erro ao ler solicitação: " + ex);
            }
        }
    }

    // Este método responde a solicitção de listagem de arquivos...
    private void enviaListaDeArquivos() {
        try {
            // envia listagem de arquivos...
            saida.writeObject(janela.getListaDeArquivos());
            saida.flush();
        }
        catch(Exception ex) {
            System.err.println("Erro ao enviar o resultado...");
        }
    }

    // Este método envia o arquivo selecionado...
    private void enviaArquivo() {
        try {
            File                arquivo = new File("enviar.txt");
            FileInputStream     in      = new FileInputStream(arquivo);

            OutputStream        out     = socketCliente.getOutputStream();

            byte[] b = {0};

            while (in.read(b) != -1) {
                out.write(b);
            }
        }
        catch (Exception ex) {
            janela.escreveNaBarraStatus("Erro enviar o arquivo: " + ex);
        }
    }
}