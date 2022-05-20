/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Toast;
import dao.BussinessException;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import pojos.Aluno;
import pojos.Exame;
import pojos.AlunoExame;
import pojos.Categoria;
import pojos.Inscricao;

/**
 *
 * @author 
 */
public class AlunoExameDialog extends javax.swing.JDialog {

    /**
     * Creates new form ClienteDialog
     */
    private final String busca1 = "Busca por código",
            busca2 = "Busca por nome";
    Main main;
    Toast msg;
    List<Aluno> list_atual;
    List<AlunoExame> list_atual_atribuidos;
    List<Aluno> atributos;
    Exame exame;

    public AlunoExameDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        main = (Main) parent;
        this.setLocationRelativeTo(null);
        //Atualizar tabela
        String toolTip = "Notas de Aluno";
        atribuir.setToolTipText("Atribuir " + toolTip);
        naoAtribuir.setToolTipText("Não Atribuir " + toolTip);

    }
    
    public boolean categoriaAluno(Aluno al, Categoria cat){
        for (Inscricao obj : al.getInscricaos()) {
            if(obj.getCategoria().getId()==cat.getId())
                return true;
        }
        return false;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
        jLabel2.setText((" - INSTRUTOR: "+exame.getInstructor().getFuncionario().getPessoa().getNome()+
                " - TIPO: "+exame.getTipo().getNome()).toUpperCase());
        updateList(exame);
        updateJTable();
        updateJTableAtribuida();
    }

    public void addRowTableModel(DefaultTableModel model, Aluno obj) {
        model.addRow(new Object[]{
            obj.getPessoa().getNome()+" "+obj.getPessoa().getSobrenome()
        });
    }

    public void addRowTableModelAtribuida(DefaultTableModel model, AlunoExame obj) {
        model.addRow(new Object[]{
            obj.getAluno().getPessoa().getNome()+" "+obj.getAluno().getPessoa().getSobrenome(),
            obj.getAvaliacaoQuantitativa(),
            obj.getAvaliacaoQualitativa()
        });
    }

    public void updateList(Exame obj) {
        list_atual = new ArrayList<Aluno>();
        list_atual_atribuidos = new ArrayList<AlunoExame>();
        for (AlunoExame salest : obj.getAlunoExames()) {
            list_atual_atribuidos.add(salest);
        }

        try {
            List<Aluno> objs = main.control.getAlunoDAO().findAll();
            for (Aluno atr : objs) {
                boolean flag = false;
                for (AlunoExame aden : list_atual_atribuidos) {
                    if (aden.getAluno().getId() == atr.getId()) {
                        flag = true;
                        break;
                    }
                }
                if (!flag && categoriaAluno(atr, exame.getCategoria())) {
                    list_atual.add(atr);
                }
            }
        } catch (BussinessException ex) {
            main.control.messageErroBussiness(ex);
        }

    }

    public void updateJTable() {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.setNumRows(0);
        for (Aluno obj : list_atual) {
            addRowTableModel(model, obj);
        }
    }

    public void updateJTableBusca(List<Aluno> list) {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.setNumRows(0);
        for (Aluno obj : list) {
            addRowTableModel(model, obj);
        }
    }

    public void updateJTableAtribuida() {
        DefaultTableModel model = (DefaultTableModel) tabelaAtribuida.getModel();
        model.setNumRows(0);
        for (AlunoExame obj : exame.getAlunoExames()) {
            addRowTableModelAtribuida(model, obj);
        }
    }

    public void updateJTableBuscaAtribuida(List<AlunoExame> list) {
        DefaultTableModel model = (DefaultTableModel) tabelaAtribuida.getModel();
        model.setNumRows(0);
        for (AlunoExame obj : list) {
            addRowTableModelAtribuida(model, obj);
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
        tabelaAtribuida = new javax.swing.JTable();
        busca_nome = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        busca_nome_atribuidos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        valores = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        atribuir = new javax.swing.JButton();
        naoAtribuir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GERENCIAR NOTAS DOS ALUNOS");

        tabelaAtribuida.setAutoCreateRowSorter(true);
        tabelaAtribuida.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tabelaAtribuida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Aluno", "Quantitativa", "Qualitativa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaAtribuida);

        busca_nome.setForeground(new java.awt.Color(153, 153, 153));
        busca_nome.setText("Busca por nome");
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

        tabela.setAutoCreateRowSorter(true);
        tabela.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Aluno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabela);

        busca_nome_atribuidos.setForeground(new java.awt.Color(153, 153, 153));
        busca_nome_atribuidos.setText("Busca por nome");
        busca_nome_atribuidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                busca_nome_atribuidosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                busca_nome_atribuidosFocusLost(evt);
            }
        });
        busca_nome_atribuidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                busca_nome_atribuidosKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("EXAME");

        jLabel3.setText("Avaliação Quantitativa:");

        try {
            valores.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("Avaliação Qualitativa:");

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----", "B", "R", "M" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(busca_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(valores, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(busca_nome_atribuidos, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(busca_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(busca_nome_atribuidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        atribuir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_add_user_male_28px.png"))); // NOI18N
        atribuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atribuirActionPerformed(evt);
            }
        });

        naoAtribuir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons8_denied_28px.png"))); // NOI18N
        naoAtribuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naoAtribuirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(atribuir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(naoAtribuir, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(251, 251, 251))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(atribuir)
                    .addComponent(naoAtribuir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void busca_nomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_busca_nomeKeyPressed
        List<Aluno> list = new ArrayList<>();
        updateList(exame);
        updateJTable();
        boolean flag = false;
        for (Aluno list1 : list_atual) {
            if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE
                    && !(list1.getPessoa().getNome()).toUpperCase().contains(
                            (busca_nome.getText().substring(0, busca_nome.getText().length() - 1)).toUpperCase()
                    )) {
                flag = true;
            } else if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE
                    && !(list1.getPessoa().getNome()).toUpperCase().contains(
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

    private void busca_nomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_busca_nomeFocusLost
        focusLost(busca_nome, busca2);
    }//GEN-LAST:event_busca_nomeFocusLost

    private void busca_nomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_busca_nomeFocusGained
        focusGained(busca_nome, busca2);
    }//GEN-LAST:event_busca_nomeFocusGained

    private void atribuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atribuirActionPerformed
        int[] rows = tabela.getSelectedRows();

        if (rows.length == 0) {
            msg = new Toast("Você tem que fazer uma seleção dos alunos a asignar para a exame", 3000);
            msg.showToast();
        } else {
            try {
                for (int row : rows) {
                    AlunoExame obj = new AlunoExame(list_atual.get(row),
                            exame, Integer.parseInt(valores.getText()),combo.getSelectedItem().toString());

                    main.control.getAlunoExameDAO().save(obj);
                    exame = main.control.getExameDAO().get(exame.getId());
                }

                updateList(exame);
                updateJTable();
                updateJTableAtribuida();

            } catch (BussinessException ex) {
                main.control.messageErroBussiness(ex);
            }

        }
    }//GEN-LAST:event_atribuirActionPerformed

    private void naoAtribuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naoAtribuirActionPerformed
        int[] rows = tabelaAtribuida.getSelectedRows();
        if (rows.length == 0) {
            msg = new Toast("Você tem que fazer uma seleção dos alunos a apagar para a exame", 3000);
            msg.showToast();
        } else {
            try {

                for (int row : rows) {
                    main.control.getAlunoExameDAO().delete(list_atual_atribuidos.get(row).getId());
                    exame = main.control.getExameDAO().get(exame.getId());
                }
                updateList(exame);
                updateJTable();
                updateJTableAtribuida();
            } catch (BussinessException ex) {
                main.control.messageErroBussiness(ex);
            }

        }
    }//GEN-LAST:event_naoAtribuirActionPerformed

    private void busca_nome_atribuidosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_busca_nome_atribuidosFocusGained
        focusGained(busca_nome_atribuidos, busca2);
    }//GEN-LAST:event_busca_nome_atribuidosFocusGained

    private void busca_nome_atribuidosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_busca_nome_atribuidosFocusLost
        focusLost(busca_nome_atribuidos, busca2);
    }//GEN-LAST:event_busca_nome_atribuidosFocusLost

    private void busca_nome_atribuidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_busca_nome_atribuidosKeyPressed
        List<AlunoExame> list = new ArrayList<>();
        updateList(exame);
        updateJTableAtribuida();
        boolean flag = false;
        for (AlunoExame list1 : list_atual_atribuidos) {
            if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE
                    && !(list1.getAluno().getPessoa().getNome()).toUpperCase().contains(
                            (busca_nome_atribuidos.getText().substring(0, busca_nome_atribuidos.getText().length() - 1)).toUpperCase()
                    )) {
                flag = true;
            } else if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE
                    && !(list1.getAluno().getPessoa().getNome()).toUpperCase().contains(
                            (busca_nome_atribuidos.getText() + evt.getKeyChar()).toUpperCase()
                    )) {
                flag = true;
            } else {
                list.add(list1);
            }
        }
        list_atual_atribuidos = list;
        updateJTableBuscaAtribuida(list);
    }//GEN-LAST:event_busca_nome_atribuidosKeyPressed

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
            java.util.logging.Logger.getLogger(AlunoExameDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlunoExameDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlunoExameDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlunoExameDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
      

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AlunoExameDialog dialog = new AlunoExameDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton atribuir;
    private javax.swing.JTextField busca_nome;
    private javax.swing.JTextField busca_nome_atribuidos;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton naoAtribuir;
    private javax.swing.JTable tabela;
    private javax.swing.JTable tabelaAtribuida;
    private javax.swing.JFormattedTextField valores;
    // End of variables declaration//GEN-END:variables
}
