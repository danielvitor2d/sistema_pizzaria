package telas;

import java.awt.HeadlessException;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.ProdutoBean;
import model.bean.ReceitaBean;
import model.dao.ProdutosDAO;
import model.dao.ReceitaDAO;

public class produtos extends javax.swing.JFrame {

    double soma = 0, np, p, pt, prec;

    public produtos() {
        initComponents();
        ImageIcon icone = new ImageIcon("images/ligeirinho.png");
        setIconImage(icone.getImage());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        DefaultTableModel modelo = (DefaultTableModel) produtos.getModel();
        produtos.setRowSorter(new TableRowSorter(modelo));
        readJTable();
        readJComboBox2();
    }

    public void readJTable() {

        DefaultTableModel modelo = (DefaultTableModel) produtos.getModel();
        modelo.setNumRows(0);
        ProdutosDAO pdao = new ProdutosDAO();

        DecimalFormat df = new DecimalFormat("0.##########");

        pdao.read().forEach((p) -> {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNp(),
                p.getPrec(),
                p.getPlr(),
                p.getPrev(),
                df.format(p.getPl())

            });
        });

    }

    public void readJTableForDesc(String desc) {

        DefaultTableModel modelo = (DefaultTableModel) produtos.getModel();
        modelo.setNumRows(0);
        ProdutosDAO pdao = new ProdutosDAO();

        DecimalFormat df = new DecimalFormat("0.############");

        pdao.readForDesc(desc).forEach((p) -> {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNp(),
                p.getPrec(),
                p.getPlr(),
                p.getPrev(),
                df.format(p.getPl())
            });
        });
    }

    public void readJComboBox2() {
        ReceitaDAO dao = new ReceitaDAO();

        cxaReceitas.removeAllItems();

        for (ReceitaBean b : dao.readForJComboBox()) {
            cxaReceitas.addItem(b.getReceita());

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtaum = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        produtos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtbusca = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        cxaReceitas = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setToolTipText("");
        jPanel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Preço de Venda:");

        txtaum.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Receita");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        produtos.setBackground(new java.awt.Color(254, 254, 254));
        produtos.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificador", "Nome do Produto", "Preço da Receita", "Percentual de lucro (receita)", "Preço de Revenda", "Percentual de lucro (revenda)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        produtos.setGridColor(new java.awt.Color(102, 102, 102));
        produtos.setSelectionBackground(new java.awt.Color(153, 255, 153));
        produtos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        produtos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                produtosMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                produtosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                produtosMouseEntered(evt);
            }
        });
        produtos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                produtosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                produtosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(produtos);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel8.setText("PRODUTOS");

        jButton1.setBackground(new java.awt.Color(1, 1, 1));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(254, 254, 254));
        jButton1.setText("Limpar tela");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(1, 1, 1));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(254, 254, 254));
        jButton2.setText("Remover");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(1, 1, 1));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(254, 254, 254));
        jButton3.setText("Atualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(1, 1, 1));
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton5.setForeground(new java.awt.Color(254, 254, 254));
        jButton5.setText("Voltar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtbusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscaActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(1, 1, 1));
        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton7.setForeground(new java.awt.Color(254, 254, 254));
        jButton7.setText("Criar produto");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        cxaReceitas.setBackground(new java.awt.Color(1, 1, 1));
        cxaReceitas.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        cxaReceitas.setForeground(new java.awt.Color(1, 1, 1));
        cxaReceitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxaReceitasActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(1, 1, 1));
        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton6.setForeground(new java.awt.Color(254, 254, 254));
        jButton6.setText("Consultar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(cxaReceitas, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtaum, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(361, 361, 361)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 194, Short.MAX_VALUE)
                .addGap(381, 381, 381))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)
                        .addGap(11, 11, 11)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(13, 13, 13)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtaum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cxaReceitas))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
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
    }// </editor-fold>//GEN-END:initComponents

    private void produtosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_produtosMouseClicked
        if (produtos.getSelectedRow() != -1) {

            cxaReceitas.setSelectedItem(produtos.getValueAt(produtos.getSelectedRow(), 1).toString());

            txtaum.setText(produtos.getValueAt(produtos.getSelectedRow(), 4).toString());

            cxaReceitas.setSelectedItem(produtos.getValueAt(produtos.getSelectedRow(), 1));
        }
    }//GEN-LAST:event_produtosMouseClicked

    private void produtosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_produtosMouseEntered

    }//GEN-LAST:event_produtosMouseEntered

    private void produtosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_produtosMousePressed

    }//GEN-LAST:event_produtosMousePressed

    private void produtosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_produtosKeyPressed

    }//GEN-LAST:event_produtosKeyPressed

    private void produtosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_produtosKeyReleased
        if (produtos.getSelectedRow() != -1) {

            cxaReceitas.setSelectedItem(produtos.getValueAt(produtos.getSelectedRow(), 1).toString());

            txtaum.setText(produtos.getValueAt(produtos.getSelectedRow(), 4).toString());

            cxaReceitas.setSelectedItem(produtos.getValueAt(produtos.getSelectedRow(), 1));
        }
    }//GEN-LAST:event_produtosKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtaum.setText("");
        readJTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            if (produtos.getSelectedRow() != -1) {

                ProdutoBean p = new ProdutoBean();
                ProdutosDAO dao = new ProdutosDAO();

                p.setId((int) produtos.getValueAt(produtos.getSelectedRow(), 0));

                dao.delete(p);

                txtaum.setText("");

                readJTable();

            } else {

                JOptionPane.showMessageDialog(null, " Selecione a linha para que seja removida.", null, JOptionPane.WARNING_MESSAGE);

            }

            JOptionPane.showMessageDialog(null, "Removido com sucesso!");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Você não selecionou nada que possa ser deletado", null, JOptionPane.WARNING_MESSAGE);

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            if (produtos.getSelectedRow() != -1) {
                ReceitaDAO dao2 = new ReceitaDAO();

                double preco = dao2.precototal(cxaReceitas.getSelectedItem().toString());

                if (Double.parseDouble(txtaum.getText()) > preco) {
                    ProdutoBean bean = new ProdutoBean();
                    ProdutosDAO dao = new ProdutosDAO();

                    bean.setNp(produtos.getValueAt(produtos.getSelectedRow(), 1).toString());
                    bean.setPrec(preco);

                    bean.setPrev(Double.parseDouble(txtaum.getText()));
                    bean.setAumento(Double.parseDouble(txtaum.getText()) - preco);

                    bean.setPlr(100 * (Double.parseDouble(txtaum.getText()) - bean.getPrec()) / bean.getPrec());

                    bean.setPl((100 * (Double.parseDouble(txtaum.getText()) - preco)) / Double.parseDouble(txtaum.getText()));
                    bean.setId((int) produtos.getValueAt(produtos.getSelectedRow(), 0));

                    dao.update(bean);

                    txtaum.setText("");

                    readJTable();

                    JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "O preço de venda digitado é inferior ao da receita\n O preço de venda tem que ser superior ao da receita"
                            + " que no caso é: " + preco, null, JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Você não selecionou nada para ser atualizado ou não digitou", null, JOptionPane.WARNING_MESSAGE);

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new TelaMenus().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtbuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscaActionPerformed

    }//GEN-LAST:event_txtbuscaActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int cont = 0;
        for (int r = 0; r < produtos.getRowCount(); r++) {
            String g = produtos.getValueAt(r, 1).toString();
            if (g.equals(cxaReceitas.getSelectedItem())) {
                cont++;
            }
        }

        if (!txtaum.getText().equals("") && cont == 0) {
            ReceitaDAO dao = new ReceitaDAO();

            double preco = dao.precototal(cxaReceitas.getSelectedItem().toString());

            if (Double.parseDouble(txtaum.getText()) > preco) {
                try {
                    ProdutosDAO PDAO = new ProdutosDAO();
                    ProdutoBean PBEAN = new ProdutoBean();

                    PBEAN.setNp(cxaReceitas.getSelectedItem().toString());
                    PBEAN.setPrec(preco);
                    PBEAN.setAumento(Double.parseDouble(txtaum.getText()) - preco);
                    PBEAN.setPrev(Double.parseDouble(txtaum.getText()));
                    PBEAN.setPlr(100 * (Double.parseDouble(txtaum.getText()) - PBEAN.getPrec()) / PBEAN.getPrec());
                    PBEAN.setPl((100 * (Double.parseDouble(txtaum.getText()) - preco)) / Double.parseDouble(txtaum.getText()));

                    PDAO.create(PBEAN);

                    readJTable();

                    JOptionPane.showMessageDialog(null, "Produto criado com sucesso!");

                    txtaum.setText("");
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "O preço de venda digitado é inferior ao da receita\n O preço de venda tem que ser superior ao da receita"
                        + " que no caso é: " + preco, null, JOptionPane.WARNING_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(null, "A receita selecionada já tem um produto cadastrado ou você se esqueceu de preencher o campo de preço de venda.", null, JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void cxaReceitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxaReceitasActionPerformed

    }//GEN-LAST:event_cxaReceitasActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            readJTableForDesc(txtbusca.getText());
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new produtos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cxaReceitas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable produtos;
    private javax.swing.JTextField txtaum;
    private javax.swing.JTextField txtbusca;
    // End of variables declaration//GEN-END:variables
}
