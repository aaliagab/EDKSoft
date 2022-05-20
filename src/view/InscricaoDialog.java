/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Toast;
import dao.BussinessException;
import dao.InscricaoDAOImplement;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import pojos.Categoria;
import pojos.Inscricao;
import pojos.Aluno;
import pojos.TipoInscricao;

/**
 *
 * @author
 */
public class InscricaoDialog extends javax.swing.JDialog {

    /**
     * Creates new form ClienteDialog
     */
    private final String busca1 = "Busca por código",
            busca2 = "Busca por aluno";
    Main pai;
    Toast msg;
    List<Inscricao> list_atual;
    List<TipoInscricao> tipos;
    List<Categoria> categorias;
    List<Aluno> alunos;
    InscricaoDAOImplement daoObject;

    public InscricaoDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pai = (Main) parent;
        daoObject = pai.control.getInscricaoDAO();
        this.setLocationRelativeTo(null);
        //Atualizar tabela
        updateJTable();
        AutoCompleteDecorator.decorate(combo);
        preecherCombo();
        data.setDate(new Date());
        data.setMinSelectableDate(new Date());

        String toolTip = "Inscricao";
        jButton2.setToolTipText("Inserir " + toolTip);
        jButton4.setToolTipText("Apagar seleção de " + toolTip);
        botao_actualizar1.setToolTipText("Atualizar " + toolTip);
    }

    public void inicializarForm() {
        data.setDate(new Date());
    }

    public void addRowTableModel(DefaultTableModel model, Inscricao obj) {
        model.addRow(new Object[]{
            obj.getAluno().getPessoa().getNome() + " " + obj.getAluno().getPessoa().getSobrenome(),
            obj.getData(),
            obj.getCategoria().getNome(),
            obj.getTipoInscricao().getNome()
        });
    }

    public void preecherCombo() {
        try {
            tipos = pai.control.getTipoInscricaoDAO().findAll();
            for (TipoInscricao obj : tipos) {
                combo.addItem(obj.getNome());
            }

            alunos = pai.control.getAlunoDAO().findAll();
            for (Aluno obj : alunos) {
                comboAluno.addItem(obj.getPessoa().getNome() + " " + obj.getPessoa().getSobrenome());
            }
            
            categorias = pai.control.getCategoriaDAO().findAll();
            for (Categoria obj : categorias) {
                comboCat.addItem(obj.getNome());
            }
        } catch (BussinessException ex) {
            pai.control.messageErroBussiness(ex);
        }
    }

    public void updateJTable() {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.setNumRows(0);
        try {
            List<Inscricao> list = daoObject.findAll();
            list_atual = list;
            for (Inscricao obj : list) {
                addRowTableModel(model, obj);
            }
        } catch (BussinessException ex) {
            pai.control.messageErroBussiness(ex);
        }
    }

    public void updateJTableBusca(List<Inscricao> list) {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.setNumRows(0);
        for (Inscricao obj : list) {
            addRowTableModel(model, obj);
        }
    }

    public void editar(Inscricao obj) {
        if (data.getDate() != null) {
            try {
                obj.setData(data.getDate());
                obj.setCategoria(categorias.get(comboCat.getSelectedIndex()));
                obj.setAluno(alunos.get(comboAluno.getSelectedIndex()));
                obj.setTipoInscricao(tipos.get(combo.getSelectedIndex()));
                daoObject.update(obj);
                updateJTable();
                inicializarForm();
                pai.control.messageOperacaoSucesso();
            } catch (BussinessException ex) {
                pai.control.messageErroBussiness(ex);
            }
        } else {
            pai.control.messageFieldEmpty();
        }
    }

    public void focusGained(JTextField jtf, String field) {
        if (jtf.getText().equals(field)) {
            jtf.setText("");
        }
        jtf.setForeground(Color.BLACK);
    }

    public void focusLost(JTextField jtf, String field) {
        if (jtf.getText().equals("")) {
            jtf.setText(field);
        }
        if (jtf.getText().equals(field)) {
            jtf.setForeground(new Color(153, 153, 153));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        busca_nome = new javax.swing.JTextField();
        botao_actualizar1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        data = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        comboCat = new javax.swing.JComboBox<>();
        atribuir_aluno = new javax.swing.JButton();
        comboAluno = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GERENCIAR INSCRIÇÃO");

        tabela.setAutoCreateRowSorter(true);
        tabela.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Aluno", "Data", "Categoria", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jLabel1.setText("Aluno:");

        jButton2.setText("Inserir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Remover");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        busca_nome.setForeground(new java.awt.Color(153, 153, 153));
        busca_nome.setText("Busca por aluno");
        busca_nome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                busca_nomeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                busca_nomeFocusLost(evt);
            }
        });
        busca_nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                busca_nomeKeyPressed(evt);
            }
        });

        botao_actualizar1.setText("Editar");
        botao_actualizar1.setToolTipText("Actualizar dados do funcionário");
        botao_actualizar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botao_actualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_actualizar1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo:");

        jLabel5.setText("Data:");

        jLabel7.setText("Categoria:");

        atribuir_aluno.setText("Fazer pagamento");
        atribuir_aluno.setToolTipText("Actualizar dados");
        atribuir_aluno.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        atribuir_aluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atribuir_alunoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(14, 14, 14)
                        .addComponent(jButton4)
                        .addGap(14, 14, 14)
                        .addComponent(botao_actualizar1)
                        .addGap(18, 18, 18)
                        .addComponent(atribuir_aluno))
                    .addComponent(busca_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboCat, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(busca_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel5)
                                .addComponent(comboAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(botao_actualizar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(atribuir_aluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(comboCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (data.getDate() == null) {
            pai.control.messageFieldEmpty();
        } else {
            Inscricao obj = new Inscricao();
            obj.setData(data.getDate());
            obj.setCategoria(categorias.get(comboCat.getSelectedIndex()));
            obj.setAluno(alunos.get(comboAluno.getSelectedIndex()));
            obj.setTipoInscricao(tipos.get(combo.getSelectedIndex()));

            try {
                daoObject.save(obj);
                updateJTable();
                pai.control.messageOperacaoSucesso();
                inicializarForm();
            } catch (BussinessException ex) {
                pai.control.messageErroBussiness(ex);
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int opcao = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja excluir esses registros?",
                "CONFIRMAR REMOÇÃO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcao == JOptionPane.YES_OPTION) {
            try {
                int[] rows = tabela.getSelectedRows();
                if (rows.length != 0) {
                    for (int indice : rows) {
                        daoObject.delete(list_atual.get(indice).getId());
                    }
                    inicializarForm();
                    updateJTable();
                    pai.control.messageOperacaoSucesso();
                } else {
                    pai.control.messageLinhasExcluir();
                }

            } catch (BussinessException ex) {
                pai.control.messageErroBussiness(ex);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void busca_nomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_busca_nomeFocusGained
        focusGained(busca_nome, busca2);
    }//GEN-LAST:event_busca_nomeFocusGained

    private void busca_nomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_busca_nomeFocusLost
        focusLost(busca_nome, busca2);
    }//GEN-LAST:event_busca_nomeFocusLost

    private void busca_nomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_busca_nomeKeyPressed
        List<Inscricao> list = new ArrayList<>();
        updateJTable();
        boolean flag = false;
        for (Inscricao list1 : list_atual) {
            if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE
                    && !list1.getAluno().getPessoa().getNome().toUpperCase().contains(
                            (busca_nome.getText().substring(0, busca_nome.getText().length() - 1)).toUpperCase()
                    )) {
                flag = true;
            } else if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE
                    && !list1.getAluno().getPessoa().getNome().toUpperCase().contains(
                            (busca_nome.getText() + evt.getKeyChar()).toUpperCase()
                    )) {
                flag = true;
            } else {
                list.add(list1);
            }
        }
        list_atual = list;
        updateJTableBusca(list);
    }//GEN-LAST:event_busca_nomeKeyPressed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        Inscricao obj = list_atual.get(tabela.getSelectedRow());
        data.setDate(obj.getData());
        combo.setSelectedItem(obj.getTipoInscricao().getNome());
        comboCat.setSelectedItem(obj.getCategoria().getNome());
        comboAluno.setSelectedItem(obj.getAluno().getPessoa().getNome() + " " + obj.getAluno().getPessoa().getSobrenome());
    }//GEN-LAST:event_tabelaMouseClicked

    private void botao_actualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_actualizar1ActionPerformed
        int opcao = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja modificar este registro?",
                "CONFIRMAR A MODIFICAÇÃO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcao == JOptionPane.YES_OPTION) {
            int[] rows = tabela.getSelectedRows();
            if (rows.length > 0) {
                if (rows.length == 1) {
                    Inscricao obj = list_atual.get(rows[0]);
                    editar(obj);
                } else {
                    pai.control.messageUmaLinha();
                }
            } else {
                pai.control.messageSelecaoEditar();
            }
        }
    }//GEN-LAST:event_botao_actualizar1ActionPerformed

    private void atribuir_alunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atribuir_alunoActionPerformed
        int[] rows = tabela.getSelectedRows();
        if (rows.length > 0) {
            if (rows.length == 1) {
                Inscricao util = list_atual.get(rows[0]);
//                AlunoInscricaoDialog obj = new AlunoInscricaoDialog(pai, false);
//                obj.setInscricao(util);
//                obj.setVisible(true);
//                dispose();
            } else {
                pai.control.messageUmaLinha();
            }
        } else {
            pai.control.messageSelecaoEditar();
        }
    }//GEN-LAST:event_atribuir_alunoActionPerformed

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
            java.util.logging.Logger.getLogger(InscricaoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InscricaoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InscricaoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InscricaoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InscricaoDialog dialog = new InscricaoDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atribuir_aluno;
    private javax.swing.JButton botao_actualizar1;
    private javax.swing.JTextField busca_nome;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JComboBox<String> comboAluno;
    private javax.swing.JComboBox<String> comboCat;
    private com.toedter.calendar.JDateChooser data;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
