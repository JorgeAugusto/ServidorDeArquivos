/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import base.InfoDeArquivo;
import base.InfoServidorPrincipal;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge Augusto
 */
public class JanelaDownload extends javax.swing.JDialog {

    /**
     * Creates new form JanelaDownload
     */
    public JanelaDownload(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        // Coloa janela no centro da tela
        setLocationRelativeTo(null);
        janelaPai = (JanelaPrincipal) parent;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelArquivo = new javax.swing.JLabel();
        jLabelServidor = new javax.swing.JLabel();
        jPanelBarraStatus = new javax.swing.JPanel();
        jSeparator = new javax.swing.JSeparator();
        jLabelBarraStatus = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jProgressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Baixando arquivo, aguarde...");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                windowOpenedActionPerformed(evt);
            }
        });

        jLabelArquivo.setText("Arquivo: foto.jpg");

        jLabelServidor.setText("Servidor: Escravo X");

        jLabelBarraStatus.setText("Carregando...");

        javax.swing.GroupLayout jPanelBarraStatusLayout = new javax.swing.GroupLayout(jPanelBarraStatus);
        jPanelBarraStatus.setLayout(jPanelBarraStatusLayout);
        jPanelBarraStatusLayout.setHorizontalGroup(
            jPanelBarraStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBarraStatusLayout.createSequentialGroup()
                .addGroup(jPanelBarraStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelBarraStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelBarraStatusLayout.setVerticalGroup(
            jPanelBarraStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBarraStatusLayout.createSequentialGroup()
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelBarraStatus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBarraStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelServidor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelArquivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelServidor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanelBarraStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        fecharJanela();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void windowOpenedActionPerformed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowOpenedActionPerformed
        solicitaDownload();
    }//GEN-LAST:event_windowOpenedActionPerformed

    // Este método fecha a janela
    private void fecharJanela() {
        dispose();
    }

        // Este método, cria o socket do cliente e inicia a comunicação com co servidor
    private void iniciarComunicao() {
        try {
            // Conecto ao servidor
            socketCliente = new Socket( InfoServidorPrincipal.SERVIDOR_PRINCIPAL.ip,
                                        InfoServidorPrincipal.SERVIDOR_PRINCIPAL.porta);
        }
        catch(Exception ex) {
            jLabelBarraStatus.setText("Erro em inciar comunicação com o Servidor: " + ex);
        }
    }

    // Envia uma solicitação de downloada
    private void solicitaDownload() {
        iniciarComunicao();
        // jLabelBarraStatus.setText(janelaPai.getInfoDeArquivo().toString());
        jLabelArquivo.setText("Arquivo: "   + janelaPai.getInfoDeArquivo().getNome());
        jLabelServidor.setText("Servidor: " + janelaPai.getInfoDeArquivo().getInfoServidorEscravo().getNome());

        // Envia solicitação de Download...
        try {
            saida = new ObjectOutputStream(socketCliente.getOutputStream());
            saida.writeObject(TipoSolicitacao.DOWNLOAD);
            saida.flush();

            // Envia dados do arquivo...
            saida.writeObject(janelaPai.getInfoDeArquivo());
            saida.flush();
        }
        catch(Exception ex) {
            jLabelBarraStatus.setText("Erro ao enviar solicitação de Download: " + ex);
            return;
        }

        // Faz Download do arquivo...
        downloadDeArquivo();
    }

    // Este metodo faz o download do arquivo...
    // ainda n;
    private void downloadDeArquivo() {
        try {
            // Dados vindo do servidor
            FileInputStream    entrada          = (FileInputStream) socketCliente.getInputStream();

            // Crina novo arquivo...
            File                arquivo         = new File(pastaDeDownloads + "\\" + janelaPai.getInfoDeArquivo().getNome());
            FileOutputStream    saidaArquivo    = new FileOutputStream(arquivo);

            byte[] b = {0};

            /**
             * Isso aqui não ficou claro o suficiente para mim!
             * de alguma forma ficam 4 bytes no InputStream
             * e por isso eu estou pulando eles (skip), mas isso é uma solução
             * provisória até descobrir de onde estão vindo essa 4 bytes ;) 58.657
             */

            entrada.skip(4);     // para evitar bug!!!

            jProgressBar.setMaximum((int) janelaPai.getInfoDeArquivo().getTamanho());
            int i = 1;
            while(entrada.read(b) != -1) {
                jProgressBar.setValue(i);
                saidaArquivo.write(b);
                i++;
            }

            saidaArquivo.close();   // fecha arquivo
            entrada.close();        // fecha stream de entrada
            socketCliente.close();  // fecha socket
        }
        catch(Exception ex) {
            jLabelBarraStatus.setText("Erro ao Download o arquivo do servidor: " + ex);
        }
    }

    /*
     * Declaração das minhas varíaveis
     */

    // Socket para conexão de controle...
    private Socket              socketCliente;
    private ObjectInputStream   entrada;
    private ObjectOutputStream  saida;
    private JanelaPrincipal     janelaPai;

    private static final String pastaDeDownloads = "Downloads";

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabelArquivo;
    private javax.swing.JLabel jLabelBarraStatus;
    private javax.swing.JLabel jLabelServidor;
    private javax.swing.JPanel jPanelBarraStatus;
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JSeparator jSeparator;
    // End of variables declaration//GEN-END:variables
}