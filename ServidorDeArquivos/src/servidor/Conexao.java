/**
 * Classe que implementa Runnable para várias conexões
 * @author Jorge Augusto C. dos Reis
 * Descrição:
 * Esta classe modela uma conexão com o servidor principal, ela vai ser utilizada
 * pela classe ServidorPrincipal para criar uma nova Thread com gerenciará uma
 * conexão com o cliente.
 */

package servidor;

import base.InfoDeArquivo;
import cliente.TipoSolicitacao;
import java.io.*;
import java.net.Socket;

public class Conexao implements Runnable {
    private static final String     pastaBaseArquivos = "ArquivosDistribuidos";

    private Socket                  socketCliente;
    private ObjectInputStream       entrada;
    private ObjectOutputStream      saida;
    private JanelaPrincipal         janela;         // referência a janela do programa
    private TipoSolicitacao         solicitacao;
    private InfoDeArquivo           infoDeArquivo;

    public Conexao(Socket socketCliente, JanelaPrincipal janela) throws Exception {
        janela.escreveNaBarraStatus("Entrou no construtor da Conexão");

        this.janela         = janela;
        this.socketCliente  = socketCliente;
        entrada     = new ObjectInputStream(this.socketCliente.getInputStream());
        saida       = new ObjectOutputStream(this.socketCliente.getOutputStream());
    }

    @Override
    public void run() {
        for(;;) {
            // Se o socke esta fechado então terminar Thread.
            if(socketCliente.isClosed()) return;

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
            /**
             * Lê a informação enviada pelo cliente sobre qual arquivo ele
             * quer baixar
             */
            infoDeArquivo = (InfoDeArquivo) entrada.readObject();

            File                arquivo         = new File(pastaBaseArquivos + "\\" + infoDeArquivo.getNome());
            FileInputStream     entradaArquivo  = new FileInputStream(arquivo);
            FileOutputStream    saidaCliente    = (FileOutputStream) socketCliente.getOutputStream();

            byte[] b = {0};

            while (entradaArquivo.read(b) != -1) {
                saidaCliente.write(b);
            }
            saidaCliente.flush();       // força despejo de algum dado restante
            saidaCliente.close();       // fecha stream de saída
            entradaArquivo.close();     // fecha arquivo de entrada
            socketCliente.close();      // fecha o socket
        }
        catch (Exception ex) {
            janela.escreveNaBarraStatus("Erro enviar o arquivo para o cliente...: " + ex);
        }
    }
}