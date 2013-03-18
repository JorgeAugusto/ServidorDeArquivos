/**
 * Classe que modela a GUI do Servidor Escravo
 * @author: Jorge Augusto C. dos Reis
 * @data..: 18/03/2013 às 04:34
 * @Descrição:
 * Esta classe modela a GUI do servidor escravo
 */

package escravo;

import base.InfoServidor;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JanelaEscravo extends javax.swing.JFrame {

    /**
     * Creates new form JanelaPrincipal
     */
    public JanelaEscravo() {

        initComponents();

        // Coloca janela no centro da tela
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneArquivos = new javax.swing.JScrollPane();
        jTableArquivos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jSeparator = new javax.swing.JSeparator();
        jLabelBarraStatus = new javax.swing.JLabel();
        jScrollPaneConexoes = new javax.swing.JScrollPane();
        jTableConexoes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuArquivo = new javax.swing.JMenu();
        jMenuItemConfigConServidor = new javax.swing.JMenuItem();
        jMenuItemSair = new javax.swing.JMenuItem();
        jMenuAjuda = new javax.swing.JMenu();
        jMenuItemSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor Escravo - Sistema Servidor de Arquivos");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setName("framePrincipal");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                windowOpenedActionPerformed(evt);
            }
        });

        jTableArquivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome do Arquivo", "Tamanho"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableArquivos.setColumnSelectionAllowed(true);
        jTableArquivos.getTableHeader().setReorderingAllowed(false);
        jScrollPaneArquivos.setViewportView(jTableArquivos);
        jTableArquivos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableArquivos.getColumnModel().getColumn(1).setMinWidth(120);
        jTableArquivos.getColumnModel().getColumn(1).setPreferredWidth(120);
        jTableArquivos.getColumnModel().getColumn(1).setMaxWidth(120);

        jLabel1.setText("Lista de Arquivos Disponíveis Neste Servidor Escravo");

        jLabelBarraStatus.setText("Carregando...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBarraStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelBarraStatus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableConexoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Host", "Requisição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConexoes.setColumnSelectionAllowed(true);
        jTableConexoes.getTableHeader().setReorderingAllowed(false);
        jScrollPaneConexoes.setViewportView(jTableConexoes);
        jTableConexoes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableConexoes.getColumnModel().getColumn(0).setMinWidth(200);
        jTableConexoes.getColumnModel().getColumn(0).setPreferredWidth(200);
        jTableConexoes.getColumnModel().getColumn(0).setMaxWidth(200);

        jLabel3.setText("Histórico de Requisições");

        jMenuArquivo.setText("Arquivo");

        jMenuItemConfigConServidor.setText("Configurar Conexão com Servidor");
        jMenuItemConfigConServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConfigConServidorActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemConfigConServidor);

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemSair);

        jMenuBar.add(jMenuArquivo);

        jMenuAjuda.setText("Ajuda");

        jMenuItemSobre.setText("Sobre");
        jMenuItemSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSobreActionPerformed(evt);
            }
        });
        jMenuAjuda.add(jMenuItemSobre);

        jMenuBar.add(jMenuAjuda);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneArquivos, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPaneConexoes, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneArquivos, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                    .addComponent(jScrollPaneConexoes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSobreActionPerformed
        exibiSobre();
    }//GEN-LAST:event_jMenuItemSobreActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        fechaJanela();
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jMenuItemConfigConServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConfigConServidorActionPerformed
        abriJanelaConfigConServidor();
    }//GEN-LAST:event_jMenuItemConfigConServidorActionPerformed

    private void windowOpenedActionPerformed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowOpenedActionPerformed
        inicializacao();
    }//GEN-LAST:event_windowOpenedActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaEscravo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaEscravo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaEscravo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaEscravo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JanelaEscravo janela = new JanelaEscravo();
                janela.setVisible(true);
            }
        });
    }

    /**
     * Aqui inicia a implementaçãos dos meus métodos, deste ponto em diante
     * não existe código que não tenha sido feito por mim.
     */

    /**
     * Este é um método de teste de algumas classes
     */
    private void TestaClasse() {

    }

    /**
     * Método que exibe a mensagem do Sobre
     */
    private void exibiSobre() {
        JOptionPane.showMessageDialog(rootPane,
        "<html><b><font size='5'>Sistema Servidor de Arquivos</font></b><br>"                   +
        "<b><font size='3'>IESAM - Institudo de Estudos Superiores da Amazônia</font></b><br>"  +
        "<b><font size='3'>Engenharia de Computação</font></b><br><br>"                         +
        "Programador: <b><font color='red'>Jorge Augusto C. dos Reis</font></b><br>"            +
        "E-mail: <b><font color='blue'>engjorgeaugusto@gmail.com</font></b><br>",
        "Sobre", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Este método fecha a janela e sai do programa
     */
    private void fechaJanela() {
        dispose();
    }

    /**
     * Este método abri a janela de configuração de conexão com o servidor
     */
    private void abriJanelaConfigConServidor() {
        janConfiConServidor = new JanelaConfigConServidor(this, true);

        janConfiConServidor.setVisible(true);
    }

    /**
     * Este método escreve uma mensagem na barra de status
     */
    public void escreveNaBarraStatus(String mensagens) {
        jLabelBarraStatus.setText(mensagens);
    }

    /**
     * Este métod atualiza a tabela de arquivos disponíveis
     */
    private void atualizaTabelaArquivos() {

    }

    /**
     * Este métod atualiza a tabela de clientes conectados
     */
    public void atualizaTabelaClientesConectados() {

    }

    /**
     * Este método carrega as informações de conexão do
     */
    public void carregaConfigConServidor() {
        try {
            File arq = new File(Escravo.ARQ_CONFIG_CON_SERVIDOR);

            InfoServidor infoServidor = new InfoServidor("Servidor", "localhost", 2002);

            if(!arq.exists() || !arq.isFile()) {
                InfoServidor.salvaEmArquivo(infoServidor, Escravo.ARQ_CONFIG_CON_SERVIDOR);
            }

            escravo.setInfoServidor(InfoServidor.carregaDeArquivo(infoServidor, Escravo.ARQ_CONFIG_CON_SERVIDOR));
        }
        catch(Exception ex) {

        }
    }

    /**
     * Este método é executado no momento de abertura da janela
     */
    private void inicializacao() {
        carregaConfigConServidor();
    }

    /**
     * Retorna o atribudo escravo
     */
    public Escravo getEscravo() {
        return escravo;
    }

    /**
     * Declaração dos meus atributos.
     */
    private Escravo                 escravo = new Escravo();
    private JanelaConfigConServidor janConfiConServidor;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelBarraStatus;
    private javax.swing.JMenu jMenuAjuda;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItemConfigConServidor;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenuItem jMenuItemSobre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPaneArquivos;
    private javax.swing.JScrollPane jScrollPaneConexoes;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JTable jTableArquivos;
    private javax.swing.JTable jTableConexoes;
    // End of variables declaration//GEN-END:variables

}
