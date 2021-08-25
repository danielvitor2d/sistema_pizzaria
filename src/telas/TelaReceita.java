package telas;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.EstoqueBean;
import model.bean.ReceitaBean;
import model.dao.EstoqueDAO;
import model.dao.ReceitaDAO;

public class TelaReceita extends javax.swing.JFrame {

    double preco = 0;

    public TelaReceita() {

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        ImageIcon icone = new ImageIcon("images/ligeirinho.png");
        setIconImage(icone.getImage());
        readJComboBox();
        readJComboBox2();
    }

    public void readJComboBox() {
        ReceitaDAO dao = new ReceitaDAO();

        cxaReceitas.removeAllItems();

        for (ReceitaBean b : dao.readForJComboBox()) {
            cxaReceitas.addItem(b.getReceita());
        }
    }

    public void readJComboBox2() {
        EstoqueDAO dao = new EstoqueDAO();

        cxaIngredientes.removeAllItems();

        for (EstoqueBean b : dao.read()) {
            cxaIngredientes.addItem(b.getProd());
        }
    }

    public void readJTable(String rece) {
        DefaultTableModel modelo = (DefaultTableModel) receita.getModel();
        modelo.setNumRows(0);

        ReceitaDAO dao = new ReceitaDAO();

        dao.read(rece).forEach((p) -> {
            modelo.addRow(new Object[]{
                p.getProduto(),
                p.getQtdoupeso(),
                p.getPrecofinal()
            });
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtvalor = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        receita = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtqtd = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        radqtd = new javax.swing.JRadioButton();
        radpe = new javax.swing.JRadioButton();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cxaReceitas = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        nomereceita = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        cxaIngredientes = new javax.swing.JComboBox<>();
        jButton10 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Calculador do preço da Receita");

        txtvalor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtvalor.setText("R$ 00,00");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Preço:");

        jButton5.setBackground(new java.awt.Color(1, 1, 1));
        jButton5.setFont(new java.awt.Font("Microsoft JhengHei", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(254, 254, 254));
        jButton5.setText("Voltar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Ingrediente:");

        receita.setBackground(new java.awt.Color(254, 254, 254));
        receita.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));
        receita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ingrediente", "Quantidade ou peso (em gramas)", "Preço Final do Produto (R$)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        receita.setGridColor(new java.awt.Color(102, 102, 102));
        receita.setSelectionBackground(new java.awt.Color(153, 255, 153));
        receita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                receitaMouseClicked(evt);
            }
        });
        receita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                receitaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                receitaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(receita);

        jButton1.setBackground(new java.awt.Color(1, 1, 1));
        jButton1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(254, 254, 254));
        jButton1.setText("Adicionar ingrediente a receita");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(1, 1, 1));
        jButton2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(254, 254, 254));
        jButton2.setText("Calcular preço da receita");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Digite a quantidade do ingrediente:");

        jButton4.setBackground(new java.awt.Color(1, 1, 1));
        jButton4.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jButton4.setForeground(new java.awt.Color(254, 254, 254));
        jButton4.setText("Excluir ingrediente");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/garcom.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setText("Digite o peso, em gramas, do ingrediente:");

        radqtd.setBackground(new java.awt.Color(1, 1, 1));
        radqtd.setForeground(new java.awt.Color(1, 1, 1));
        radqtd.setText("Por quantidade");

        radpe.setBackground(new java.awt.Color(1, 1, 1));
        radpe.setForeground(new java.awt.Color(1, 1, 1));
        radpe.setText("Por peso");

        jButton6.setBackground(new java.awt.Color(1, 1, 1));
        jButton6.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jButton6.setForeground(new java.awt.Color(254, 254, 254));
        jButton6.setText("Limpar tudo");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(1, 1, 1));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(254, 254, 254));
        jButton3.setText("Excluir receita");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cxaReceitas.setBackground(new java.awt.Color(1, 1, 1));
        cxaReceitas.setForeground(new java.awt.Color(254, 254, 254));

        jButton7.setBackground(new java.awt.Color(1, 1, 1));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton7.setForeground(new java.awt.Color(254, 254, 254));
        jButton7.setText("Abrir receita");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(1, 1, 1));
        jButton8.setFont(new java.awt.Font("Microsoft JhengHei", 0, 16)); // NOI18N
        jButton8.setForeground(new java.awt.Color(254, 254, 254));
        jButton8.setText("Salvar nova receita");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(1, 1, 1));
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton9.setForeground(new java.awt.Color(254, 254, 254));
        jButton9.setText("Salvar alterações");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        cxaIngredientes.setBackground(new java.awt.Color(1, 1, 1));
        cxaIngredientes.setForeground(new java.awt.Color(254, 254, 254));

        jButton10.setBackground(new java.awt.Color(1, 1, 1));
        jButton10.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jButton10.setForeground(new java.awt.Color(254, 254, 254));
        jButton10.setText("Selecionar ingrediente");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei", 0, 18)); // NOI18N
        jLabel6.setText("Receita:");

        jButton12.setBackground(new java.awt.Color(1, 1, 1));
        jButton12.setFont(new java.awt.Font("Microsoft JhengHei", 0, 13)); // NOI18N
        jButton12.setForeground(new java.awt.Color(254, 254, 254));
        jButton12.setText("Atualizar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(297, 297, 297)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(cxaIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radqtd)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtqtd)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(radpe)
                                            .addComponent(jLabel2)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPeso))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton10))
                                .addGap(29, 29, 29)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(nomereceita, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtvalor)))
                        .addContainerGap(57, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cxaReceitas, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(38, 38, 38))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radqtd)
                            .addComponent(radpe))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtqtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cxaIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton10)
                        .addGap(18, 29, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton4)
                            .addComponent(jButton6)
                            .addComponent(jButton12))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomereceita, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtvalor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cxaReceitas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        dispose();
        new TelaMenus().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int cont = 0;
        for (int r = 0; r < receita.getRowCount(); r++) {
            String g = receita.getValueAt(r, 0).toString();
            if (g.equals(cxaIngredientes.getSelectedItem().toString())) {
                cont++;
            }
        }

        if (cont == 0) {
            try {
                if (radpe.isSelected() == false && radqtd.isSelected() == false) {
                    JOptionPane.showMessageDialog(null, "Marque um tipo de ingrediente, por peso ou por quantidade.");
                }

                DefaultTableModel dtm = (DefaultTableModel) receita.getModel();
                if (radqtd.isSelected() == true) {
                    double pf = preco * Double.parseDouble(txtqtd.getText());
                    Object[] dados = {cxaIngredientes.getSelectedItem(), txtqtd.getText(), pf};
                    dtm.addRow(dados);
                } else if (radpe.isSelected() == true) {
                    double pf = preco * Double.parseDouble(txtPeso.getText());
                    Object[] dados = {cxaIngredientes.getSelectedItem(), txtPeso.getText(), pf};
                    dtm.addRow(dados);
                }

                txtqtd.setText("");
                txtPeso.setText("");
                txtPeso.setEnabled(true);
                txtqtd.setEnabled(true);
                radpe.setSelected(false);
                radqtd.setSelected(false);
                radqtd.setEnabled(true);
                radpe.setEnabled(true);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Você se esqueceu de preencher algum campo.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Produto já existente na receita.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public Double calR() {
        double soma = 0;
        for (int i = 0; i < receita.getRowCount(); i++) {
            soma = soma + Double.parseDouble(receita.getValueAt(i, 2).toString());
        }
        txtvalor.setText("R$" + " " + soma);
        return soma;
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        calR();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if (receita.getSelectedRow() != -1) {

            DefaultTableModel res = (DefaultTableModel) receita.getModel();
            res.removeRow(receita.getSelectedRow());

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um ingrediente para que ele seja excluido");
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void receitaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_receitaKeyReleased
        if (receita.getSelectedRow() != -1) {
            EstoqueDAO dao = new EstoqueDAO();
            String pouqtd = dao.pouq2(receita.getValueAt(receita.getSelectedRow(), 0).toString());

            cxaIngredientes.setSelectedItem(receita.getValueAt(receita.getSelectedRow(), 0));

            if (pouqtd.equals("P")) {
                radqtd.setEnabled(false);
                txtqtd.setEnabled(false);
                txtPeso.setEnabled(true);
                txtPeso.setText(receita.getValueAt(receita.getSelectedRow(), 1).toString());
                radpe.setEnabled(true);
                radpe.setSelected(true);

                radqtd.setSelected(false);
                txtqtd.setText("");
            } else {
                radpe.setEnabled(false);
                txtPeso.setEnabled(false);
                txtqtd.setEnabled(true);
                txtqtd.setText(receita.getValueAt(receita.getSelectedRow(), 1).toString());
                radqtd.setEnabled(true);
                radqtd.setSelected(true);

                radpe.setSelected(false);
                txtPeso.setText("");
            }
        }
    }//GEN-LAST:event_receitaKeyReleased

    private void receitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receitaMouseClicked
        if (receita.getSelectedRow() != -1) {
            EstoqueDAO dao = new EstoqueDAO();
            double preco = dao.readpreco(receita.getValueAt(receita.getSelectedRow(), 0).toString());
            String pouqtd = dao.pouq2(receita.getValueAt(receita.getSelectedRow(), 0).toString());

            cxaIngredientes.setSelectedItem(receita.getValueAt(receita.getSelectedRow(), 0));

            if (pouqtd.equals("P")) {
                radqtd.setEnabled(false);
                txtqtd.setEnabled(false);
                txtPeso.setEnabled(true);
                txtPeso.setText(receita.getValueAt(receita.getSelectedRow(), 1).toString());
                radpe.setEnabled(true);
                radpe.setSelected(true);

                radqtd.setSelected(false);
                txtqtd.setText("");
            } else {
                radpe.setEnabled(false);
                txtPeso.setEnabled(false);
                txtqtd.setEnabled(true);
                txtqtd.setText(receita.getValueAt(receita.getSelectedRow(), 1).toString());
                radqtd.setEnabled(true);
                radqtd.setSelected(true);

                radpe.setSelected(false);
                txtPeso.setText("");
            }
        }
    }//GEN-LAST:event_receitaMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        nomereceita.setText("");
        txtqtd.setText("");
        txtPeso.setText("");
        radpe.setSelected(false);
        radqtd.setSelected(false);

        DefaultTableModel model = (DefaultTableModel) receita.getModel();
        model.setRowCount(0);

        radpe.setEnabled(true);
        radqtd.setEnabled(true);
        txtPeso.setEnabled(true);
        txtqtd.setEnabled(true);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            ReceitaDAO dao = new ReceitaDAO();
            ReceitaBean bean = new ReceitaBean();

            bean.setReceita(cxaReceitas.getSelectedItem().toString());

            dao.delete(bean);

            DefaultTableModel modelo = (DefaultTableModel) receita.getModel();
            modelo.setNumRows(0);

            JOptionPane.showMessageDialog(null, "Receita excluída com sucesso!");

        } catch (Exception e) {
            System.out.println(e);
        }
        readJComboBox();

    }//GEN-LAST:event_jButton3ActionPerformed
    public void abrirR() {
        nomereceita.setText(cxaReceitas.getSelectedItem().toString());

        readJTable(cxaReceitas.getSelectedItem().toString());
    }
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        abrirR();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        List<String> receitas = new ArrayList<String>();

        ReceitaDAO dao2 = new ReceitaDAO();

        for (ReceitaBean b : dao2.readForJComboBox()) {
            receitas.add(b.getReceita());
        }

        int count = 0;
        for (int i = 0; i < receitas.size(); i++) {
            if (receitas.get(i).equals(nomereceita.getText())) {
                count++;
            }
        }

        if (count == 0 && !(receita.getRowCount() == 0)) {
            try {
                ReceitaDAO dao = new ReceitaDAO();
                ReceitaBean bean = new ReceitaBean();

                int linhas = receita.getRowCount();

                for (int i = 0; i < linhas; i++) {
                    bean.setReceita(nomereceita.getText());
                    bean.setProduto(receita.getValueAt(i, 0).toString());
                    bean.setQtdoupeso(Double.parseDouble(receita.getValueAt(i, 1).toString()));
                    bean.setPrecofinal(Double.parseDouble(receita.getValueAt(i, 2).toString()));

                    dao.create(bean);
                }

                JOptionPane.showMessageDialog(null, "Receita cadastrada com sucesso.");
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro no cadastro, reinicie o programa e tente novamente." + e);
            }
            readJComboBox();

            DefaultTableModel model = (DefaultTableModel) receita.getModel();
            model.setNumRows(0);

        } else {
            JOptionPane.showMessageDialog(null, "Receita já existente com o mesmo nome / Receita vazia");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            ReceitaDAO dao = new ReceitaDAO();
            ReceitaBean bean = new ReceitaBean();

            bean.setReceita(cxaReceitas.getSelectedItem().toString());

            dao.delete(bean);

            int linhas = receita.getRowCount();

            for (int i = 0; i < linhas; i++) {
                bean.setReceita(nomereceita.getText());
                bean.setProduto(receita.getValueAt(i, 0).toString());
                bean.setQtdoupeso(Double.parseDouble(receita.getValueAt(i, 1).toString()));
                bean.setPrecofinal(Double.parseDouble(receita.getValueAt(i, 2).toString()));

                dao.create(bean);
            }

            JOptionPane.showMessageDialog(null, "Receita atualizada com sucesso.");

            DefaultTableModel model = (DefaultTableModel) receita.getModel();
            model.setNumRows(0);
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro na atualização, reinicie o programa e tente novamente." + e);
        }
        readJComboBox();
        readJComboBox2();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        EstoqueDAO dao = new EstoqueDAO();
        double preço = dao.readpreco(cxaIngredientes.getSelectedItem().toString());

        String pqtd = dao.pouq2(cxaIngredientes.getSelectedItem().toString());

        if (pqtd.equals("P")) {

            radpe.setEnabled(true);
            txtPeso.setEnabled(true);
            radpe.setSelected(true);
            preco = preço / 1000;
            radqtd.setEnabled(false);
            txtqtd.setEnabled(false);

        } else if (pqtd.equals("Q")) {

            radqtd.setEnabled(true);
            txtqtd.setEnabled(true);
            radqtd.setSelected(true);
            preco = preço;
            radpe.setEnabled(false);
            txtPeso.setEnabled(false);

        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void receitaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_receitaKeyPressed
        if (receita.getSelectedRow() != -1) {
            EstoqueDAO dao = new EstoqueDAO();
            String pouqtd = dao.pouq2(receita.getValueAt(receita.getSelectedRow(), 0).toString());

            cxaIngredientes.setSelectedItem(receita.getValueAt(receita.getSelectedRow(), 0));

            if (pouqtd.equals("P")) {

                radqtd.setEnabled(false);
                txtqtd.setEnabled(false);
                txtPeso.setEnabled(true);
                txtPeso.setText(receita.getValueAt(receita.getSelectedRow(), 1).toString());
                radpe.setEnabled(true);
                radpe.setSelected(true);
                radqtd.setSelected(false);
                txtqtd.setText("");

            } else {

                radpe.setEnabled(false);
                txtPeso.setEnabled(false);
                txtqtd.setEnabled(true);
                txtqtd.setText(receita.getValueAt(receita.getSelectedRow(), 1).toString());
                radqtd.setEnabled(true);
                radqtd.setSelected(true);
                radpe.setSelected(false);
                txtPeso.setText("");

            }
        }
    }//GEN-LAST:event_receitaKeyPressed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (receita.getSelectedRow() != -1) {
            EstoqueDAO dao = new EstoqueDAO();

            String pouqtd = dao.pouq2(receita.getValueAt(receita.getSelectedRow(), 0).toString());
            double prec = dao.readpreco(receita.getValueAt(receita.getSelectedRow(), 0).toString());

            if (pouqtd.equals("P")) {
                receita.setValueAt((prec * Double.parseDouble(txtPeso.getText()) / 1000), receita.getSelectedRow(), 2);
                receita.setValueAt(txtPeso.getText(), receita.getSelectedRow(), 1);
            } else {
                receita.setValueAt((prec * Double.parseDouble(txtqtd.getText())), receita.getSelectedRow(), 2);
                receita.setValueAt(txtqtd.getText(), receita.getSelectedRow(), 1);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione algum ingrediente.");
        }
    }//GEN-LAST:event_jButton12ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaReceita().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cxaIngredientes;
    private javax.swing.JComboBox<String> cxaReceitas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomereceita;
    private javax.swing.JRadioButton radpe;
    private javax.swing.JRadioButton radqtd;
    private javax.swing.JTable receita;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtqtd;
    private javax.swing.JLabel txtvalor;
    // End of variables declaration//GEN-END:variables
}
