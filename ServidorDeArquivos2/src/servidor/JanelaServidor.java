/**
 * Classe que modela Janela principal do Servidor
 * @author: Jorge Augusto C. dos Reis
 * @data..: 17/03/2013 às 23:14
 * @Descrição:
 * Esta classe modela a GUI do servidor principal
 */

package servidor;

import javax.swing.JOptionPane;

public class JanelaServidor extends javax.swing.JFrame {

    /**
     * Creates new form JanelaPrincipal
     */
    public JanelaServidor() {

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
        jScrollPaneEscravos = new javax.swing.JScrollPane();
        jTableEscravos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jSeparator = new javax.swing.JSeparator();
        jLabelBarraStatus = new javax.swing.JLabel();
        jScrollPaneConexoes = new javax.swing.JScrollPane();
        jTableConexoes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuArquivo = new javax.swing.JMenu();
        jMenuItemCadServEscravo = new javax.swing.JMenuItem();
        jMenuItemSair = new javax.swing.JMenuItem();
        jMenuAjuda = new javax.swing.JMenu();
        jMenuItemSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor Principal - Sistema Servidor de Arquivos");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setName("framePrincipal");
        setResizable(false);

        jTableArquivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome do Arquivo", "Local", "Tamanho"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableArquivos.getTableHeader().setReorderingAllowed(false);
        jScrollPaneArquivos.setViewportView(jTableArquivos);
        jTableArquivos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableArquivos.getColumnModel().getColumn(1).setMinWidth(80);
        jTableArquivos.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTableArquivos.getColumnModel().getColumn(1).setMaxWidth(80);
        jTableArquivos.getColumnModel().getColumn(2).setMinWidth(120);
        jTableArquivos.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTableArquivos.getColumnModel().getColumn(2).setMaxWidth(120);

        jLabel1.setText("Lista de Arquivos Disponíveis");

        jTableEscravos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "IP", "Porta", "Situação"
            }
        ));
        jTableEscravos.setEnabled(false);
        jScrollPaneEscravos.setViewportView(jTableEscravos);
        jTableEscravos.getColumnModel().getColumn(1).setMinWidth(100);
        jTableEscravos.getColumnModel().getColumn(1).setMaxWidth(100);
        jTableEscravos.getColumnModel().getColumn(2).setMinWidth(60);
        jTableEscravos.getColumnModel().getColumn(2).setMaxWidth(60);
        jTableEscravos.getColumnModel().getColumn(3).setMinWidth(100);
        jTableEscravos.getColumnModel().getColumn(3).setMaxWidth(100);

        jLabel2.setText("Lista de Escravos");

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
                "Cliente", "Estado", "Arquivo", "%"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConexoes.getTableHeader().setReorderingAllowed(false);
        jScrollPaneConexoes.setViewportView(jTableConexoes);
        jTableConexoes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableConexoes.getColumnModel().getColumn(0).setMinWidth(50);
        jTableConexoes.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableConexoes.getColumnModel().getColumn(0).setMaxWidth(50);
        jTableConexoes.getColumnModel().getColumn(1).setMinWidth(80);
        jTableConexoes.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTableConexoes.getColumnModel().getColumn(1).setMaxWidth(80);
        jTableConexoes.getColumnModel().getColumn(3).setMinWidth(50);
        jTableConexoes.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTableConexoes.getColumnModel().getColumn(3).setMaxWidth(50);

        jLabel3.setText("Lista de Clientes Conectados");

        jMenuArquivo.setText("Arquivo");

        jMenuItemCadServEscravo.setText("Cadastrar Servidor Escravo");
        jMenuItemCadServEscravo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadServEscravoActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemCadServEscravo);

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
                    .addComponent(jScrollPaneEscravos)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneArquivos, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPaneConexoes, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))))
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
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneEscravos, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
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

    private void jMenuItemCadServEscravoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadServEscravoActionPerformed
        // abriJanCadServEscravo();
    }//GEN-LAST:event_jMenuItemCadServEscravoActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JanelaServidor janela = new JanelaServidor();
                janela.setVisible(true);
            }
        });
    }

    /**
     * Aqui inicia a implementaçãos dos meus métodos, deste ponto em diante
     * não existe código que não tenha sido feito por mim.
     */

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelBarraStatus;
    private javax.swing.JMenu jMenuAjuda;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItemCadServEscravo;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenuItem jMenuItemSobre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPaneArquivos;
    private javax.swing.JScrollPane jScrollPaneConexoes;
    private javax.swing.JScrollPane jScrollPaneEscravos;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JTable jTableArquivos;
    private javax.swing.JTable jTableConexoes;
    private javax.swing.JTable jTableEscravos;
    // End of variables declaration//GEN-END:variables
}