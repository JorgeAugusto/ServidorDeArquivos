/**
 * Classe que modela Janela principal do Servidor
 * @author: Jorge Augusto C. dos Reis
 * @data..: 17/03/2013 às 23:14
 * @Descrição:
 * Esta classe modela a GUI do servidor principal
 */

package servidor;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
        jScrollPaneConexoes1 = new javax.swing.JScrollPane();
        jTableHistorico = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                windowOpenedActionPerformed(evt);
            }
        });

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

        jLabel1.setText(" Arquivos Disponíveis");

        jTableEscravos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "IP", "Porta", "Situação"
            }
        ));
        jTableEscravos.setColumnSelectionAllowed(true);
        jTableEscravos.setEnabled(false);
        jTableEscravos.getTableHeader().setReorderingAllowed(false);
        jScrollPaneEscravos.setViewportView(jTableEscravos);
        jTableEscravos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableEscravos.getColumnModel().getColumn(1).setMinWidth(100);
        jTableEscravos.getColumnModel().getColumn(1).setMaxWidth(100);
        jTableEscravos.getColumnModel().getColumn(2).setMinWidth(60);
        jTableEscravos.getColumnModel().getColumn(2).setMaxWidth(60);
        jTableEscravos.getColumnModel().getColumn(3).setMinWidth(100);
        jTableEscravos.getColumnModel().getColumn(3).setMaxWidth(100);

        jLabel2.setText(" Servidores Escravos Conectados");

        jLabelBarraStatus.setText("Inicializando...");

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
        jTableConexoes.getColumnModel().getColumn(1).setMinWidth(50);
        jTableConexoes.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTableConexoes.getColumnModel().getColumn(1).setMaxWidth(50);
        jTableConexoes.getColumnModel().getColumn(3).setMinWidth(50);
        jTableConexoes.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTableConexoes.getColumnModel().getColumn(3).setMaxWidth(50);

        jLabel3.setText(" Clientes Conectados");

        jTableHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mensagem", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableHistorico.getTableHeader().setReorderingAllowed(false);
        jScrollPaneConexoes1.setViewportView(jTableHistorico);
        jTableHistorico.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableHistorico.getColumnModel().getColumn(1).setMinWidth(50);
        jTableHistorico.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTableHistorico.getColumnModel().getColumn(1).setMaxWidth(50);

        jLabel4.setText(" Histórico de Atividades");

        jMenuArquivo.setText("Arquivo");

        jMenuItemCadServEscravo.setText("Configurar Portas");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPaneArquivos, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                    .addComponent(jScrollPaneEscravos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneConexoes1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPaneConexoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneConexoes, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneConexoes1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneArquivos, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneEscravos, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        abrirJanelaConfigPortas();
    }//GEN-LAST:event_jMenuItemCadServEscravoActionPerformed

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
     * Este método é executado no momento de abertura da janela
     */
    private void inicializacao() {
        adicionarHistorico("Inicializando Sistema", "OK");

        servidor = new Servidor(this);
    }

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
    private void abrirJanelaConfigPortas() {
        adicionarHistorico("Abrindo janela de configuração de portas", "OK");

        janConfiPortas = new JanelaConfigPortas(this, true);
        janConfiPortas.setVisible(true);
    }

    /**
     * Este método escreve uma mensagem na barra de status
     */
    public void escreverNaBarraStatus(String mensagens) {
        jLabelBarraStatus.setText(mensagens);
    }

    /**
     * Este método adiciona uma mensagem ao histórico
     */
    public void adicionarHistorico(String mensagem, String estado) {
        DefaultTableModel model = (DefaultTableModel) jTableHistorico.getModel();
        model.addRow(new String[]{mensagem, estado});
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
     * Retorna o atribudo servidor
     */
    public Servidor getServidor() {
        return servidor;
    }

    /**
     * Declaração dos meus atributos.
     */
    private Servidor                servidor;
    private JanelaConfigPortas      janConfiPortas;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JScrollPane jScrollPaneConexoes1;
    private javax.swing.JScrollPane jScrollPaneEscravos;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JTable jTableArquivos;
    private javax.swing.JTable jTableConexoes;
    private javax.swing.JTable jTableEscravos;
    private javax.swing.JTable jTableHistorico;
    // End of variables declaration//GEN-END:variables

}
