//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M3LPBD
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: JOAB TORRES ALENCAR
//******************************************************
package view;

import model.bean.Disciplina;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.dao.DisciplinaModel;

public class ViewPrincipal extends javax.swing.JFrame {
    //OBJETIVO: Quando é instanciado a classe é chamado os respectivos métodos, para carrega os componetes e os resultados na consulta do banco.
    public ViewPrincipal() {
        initComponents();
        this.resultRead(jTableDisciplina);
    }
    //OBJETIVO: O método resultRead(tabela) é responsável para fazer a consulta no banco através da classe disciplinaModel.read() e carregado os respetivos dados na tabela;
    private void resultRead(javax.swing.JTable tabela) {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        tabela.setRowSorter(new TableRowSorter(model));
        model.setNumRows(0);
        DisciplinaModel disciplinaModel = DisciplinaModel.getInstance();
        for (Disciplina disciplina : disciplinaModel.read()) {
            model.addRow(new Object[]{
                disciplina.getCod(),
                disciplina.getNome(),
                disciplina.getCarga_horaria(),
                disciplina.getCurso(),
                disciplina.getVagas(),
                disciplina.getPeriodo()
            });
        }
    }
    //OBJETIVO: O método search(tabela) é responsável para fazer a consulta no banco através da classe disciplinaModel.read(coluna, campo) e carregado os respetivos dados na tabela;
    private void search(javax.swing.JTable tabela) {
        if (!(jTextCampo.getText()).equals("")) {
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            tabela.setRowSorter(new TableRowSorter(model));
            model.setNumRows(0);
            DisciplinaModel disciplinaModel = DisciplinaModel.getInstance();
            for (Disciplina disciplina : disciplinaModel.read(jComboCategoria.getSelectedItem().toString(), jTextCampo.getText())) {

                model.addRow(new Object[]{
                    disciplina.getCod(),
                    disciplina.getNome(),
                    disciplina.getCarga_horaria(),
                    disciplina.getCurso(),
                    disciplina.getVagas(),
                    disciplina.getPeriodo()
                });
            }
        } else {
            this.resultRead(tabela);
        }
    }
    //OBJETIVO: responsável para excluir uma determinada linha da tabela e chama novamente o método resultRead(jTableDisciplina);
    private void delete() {
        if (jTableDisciplina.getSelectedRow() != -1) {
            if (DisciplinaModel.delete((int) jTableDisciplina.getValueAt(jTableDisciplina.getSelectedRow(), 0))) {
                resultRead(jTableDisciplina);
            }
        }
    }
    //OBJETIVO: Responsável para criar uma instância da classe Disciplina e salva os respectivos registro de uma linha específica da tabela para posteriormente instancia a classe ViewFormDisciplina passando como parametro a instância da classe recem criada disciplina;
    private void upload() {
        if (jTableDisciplina.getSelectedRow() != -1) {
            Disciplina disciplina = new Disciplina();
            disciplina.setCod((int) jTableDisciplina.getValueAt(jTableDisciplina.getSelectedRow(), 0));
            disciplina.setNome((String) jTableDisciplina.getValueAt(jTableDisciplina.getSelectedRow(), 1));
            disciplina.setCarga_horaria((String) jTableDisciplina.getValueAt(jTableDisciplina.getSelectedRow(), 2));
            disciplina.setCurso((String) jTableDisciplina.getValueAt(jTableDisciplina.getSelectedRow(), 3));
            disciplina.setVagas((int) jTableDisciplina.getValueAt(jTableDisciplina.getSelectedRow(), 4));
            disciplina.setPeriodo((String) jTableDisciplina.getValueAt(jTableDisciplina.getSelectedRow(), 5));
            ViewFormDisciplina viewFormDisciplina = new ViewFormDisciplina(disciplina);
            viewFormDisciplina.setVisible(true);
            this.dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuOpcaoTabela = new javax.swing.JPopupMenu();
        jMenuItemEditar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemExcluir = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonPesquisar = new javax.swing.JButton();
        jTextCampo = new javax.swing.JTextField();
        jComboCategoria = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDisciplina = new javax.swing.JTable();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        jMenuItemEditar.setText("Editar");
        jMenuItemEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditarActionPerformed(evt);
            }
        });
        jPopupMenuOpcaoTabela.add(jMenuItemEditar);
        jPopupMenuOpcaoTabela.add(jSeparator1);

        jMenuItemExcluir.setText("Excluir");
        jMenuItemExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExcluirActionPerformed(evt);
            }
        });
        jPopupMenuOpcaoTabela.add(jMenuItemExcluir);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle Disciplinar");
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(1051, 571));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Pesquisar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Campo:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Por:");

        jButtonPesquisar.setBackground(new java.awt.Color(0, 153, 102));
        jButtonPesquisar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jTextCampo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextCampo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jComboCategoria.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cod", "Curso", "Disciplina" }));
        jComboCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextCampo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12)), "Lista de Disciplinas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 12))); // NOI18N
        jPanel3.setToolTipText("");

        jTableDisciplina.setAutoCreateRowSorter(true);
        jTableDisciplina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Disciplina", "Carga Horaria", "Curso", "Vagas", "Período"
            }
        ));
        jTableDisciplina.setGridColor(new java.awt.Color(255, 255, 255));
        jTableDisciplina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableDisciplinaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableDisciplinaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDisciplina);

        jButtonAdicionar.setBackground(new java.awt.Color(0, 153, 102));
        jButtonAdicionar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonAdicionar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonEditar.setBackground(new java.awt.Color(255, 153, 0));
        jButtonEditar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonEditar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEditar.setText("Editar");
        jButtonEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setBackground(new java.awt.Color(204, 0, 0));
        jButtonExcluir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonExcluir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //objetivo: dispara evento isPopupTrigger, que tem como finalidade carrega o jPopupMenuOpcaoTabela sobre a tabela, com opção de editar e excluir
    private void jTableDisciplinaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDisciplinaMouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenuOpcaoTabela.show(jTableDisciplina, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTableDisciplinaMouseReleased
        //objetivo: dispara evento isPopupTrigger, que tem como finalidade carrega o jPopupMenuOpcaoTabela sobre a tabela, com opção de editar e excluir
    private void jTableDisciplinaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDisciplinaMousePressed
        if (evt.isPopupTrigger()) {
            jPopupMenuOpcaoTabela.show(jTableDisciplina, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTableDisciplinaMousePressed
    //OBJETIVO: QUANDO CLICAR SOBRE jButtonAdicionar será criado uma instância para ViewFormDisciplina(), setada a vizualização e ocutado a ViewPrincipal();
    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        ViewFormDisciplina cadastrar = new ViewFormDisciplina();
        cadastrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonAdicionarActionPerformed
    //OBJETIVO: QUANDO CLICAR NO BOTAO ButtonExcluir, ELE CHAMARA O MÉTODO DELETE();
    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        this.delete();
    }//GEN-LAST:event_jButtonExcluirActionPerformed
    //OBJETIVO: QUANDO CLICAR NO BOTAO jButtonEdita, ELE CHAMARA O MÉTODO upload();
    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        this.upload();
    }//GEN-LAST:event_jButtonEditarActionPerformed
    //OBJETIVO: QUANDO CLICAR NO BOTAO jButtonPesquisar, ELE CHAMARA O MÉTODO search(jTableDisciplina);
    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        this.search(jTableDisciplina);
    }//GEN-LAST:event_jButtonPesquisarActionPerformed
    //OBJETIVO: QUANDO CLICAR NO MENU jMenuItemEditar, ELE CHAMARA O MÉTODO upload();
    private void jMenuItemEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditarActionPerformed
        this.upload();
    }//GEN-LAST:event_jMenuItemEditarActionPerformed
    //OBJETIVO: QUANDO CLICAR NO MENU jMenuItemExcluir, ELE CHAMARA O MÉTODO delete();
    private void jMenuItemExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExcluirActionPerformed
        this.delete();
    }//GEN-LAST:event_jMenuItemExcluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JComboBox<String> jComboCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItemEditar;
    private javax.swing.JMenuItem jMenuItemExcluir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenuOpcaoTabela;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTableDisciplina;
    private javax.swing.JTextField jTextCampo;
    // End of variables declaration//GEN-END:variables
}
