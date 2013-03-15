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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Conexao implements Runnable {
    private Socket                  socketControleCliente;
    private ObjectInputStream       entradaControleSolicitacao;
    private ObjectOutputStream      saidaControleResposta;
    private Janela                  janela;         // referência a janela do programa
    private TipoSolicitacao         solicitacao;

    public Conexao(Socket socketCliente, Janela janela) throws Exception {
        janela.escreveNaBarraStatus("Entrou no construtor da Conexão");

        this.janela         = janela;
        this.socketControleCliente  = socketCliente;
        entradaControleSolicitacao  = new ObjectInputStream(this.socketControleCliente.getInputStream());
        saidaControleResposta       = new ObjectOutputStream(this.socketControleCliente.getOutputStream());
    }

    @Override
    public void run() {
        for(;;) {
            try {
                solicitacao = (TipoSolicitacao) entradaControleSolicitacao.readObject();

                switch(solicitacao) {
                    case LISTAGEM_ARQUIVOS:
                        enviaListaDeArquivos();
                    break;

                    case UPLOAD:

                    break;

                    case DOWNLOAD:

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
            saidaControleResposta.writeObject(janela.getListaDeArquivos());
            saidaControleResposta.flush();
        }
        catch(Exception ex) {
            System.err.println("Erro ao enviar o resultado...");
        }
    }
}