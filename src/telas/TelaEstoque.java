package telas;

import java.awt.HeadlessException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.EstoqueBean;
import model.dao.EstoqueDAO;

public class TelaEstoque extends javax.swing.JFrame {

    private double precot;

    public double getPrecot() {
        return precot;
    }

    public void setPrecot(double precot) {
        this.precot = precot;
    }

    public TelaEstoque() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) estoque.getModel();
        estoque.setRowSorter(new TableRowSorter(modelo));
        readJTable();
        ImageIcon icone = new ImageIcon("images/ligeirinho.png");
        setIconImage(icone.getImage());
    }

    public void readJTable() {

        DefaultTableModel modelo = (DefaultTableModel) estoque.getModel();
        modelo.setNumRows(0);
        EstoqueDAO pdao = new EstoqueDAO();

        pdao.read().forEach((p) -> {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getProd(),
                p.getQdtoupe(),
                p.getPreco(),
                0
            });
        });

        for (int i = 0; i < estoque.getRowCount(); i++) {
            String tipo = pdao.pouq(estoque.getValueAt(i, 0).toString());

            if (tipo.equals("Q")) {
                double precof = Double.parseDouble(estoque.getValueAt(i, 2).toString()) * Double.parseDouble(estoque.getValueAt(i, 3).toString());
                estoque.setValueAt(precof, i, 4);
            } else if (tipo.equals("P")) {
                double precof = Double.parseDouble(estoque.getValueAt(i, 2).toString()) * Double.parseDouble(estoque.getValueAt(i, 3).toString()) / 1000;
                estoque.setValueAt(precof, i, 4);
            }

        }

    }

    public void readJTableForDesc(String desc) {

        DefaultTableModel modelo = (DefaultTableModel) estoque.getModel();
        modelo.setNumRows(0);
        EstoqueDAO pdao = new EstoqueDAO();

        pdao.readForDesc(desc).forEach((p) -> {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getProd(),
                p.getQdtoupe(),
                p.getPreco(),
                p.getPreco(),
                p.getPreco(),
                0
            });
        });

        for (int i = 0; i < estoque.getRowCount(); i++) {
            String tipo = pdao.pouq(estoque.getValueAt(i, 0).toString());

            if (tipo.equals("Q")) {
                double precof = Double.parseDouble(estoque.getValueAt(i, 2).toString()) * Double.parseDouble(estoque.getValueAt(i, 3).toString());
                estoque.setValueAt(precof, i, 4);
            } else if (tipo.equals("P")) {
                double precof = Double.parseDouble(estoque.getValueAt(i, 2).toString()) * Double.parseDouble(estoque.getValueAt(i, 3).toString()) / 1000;
                estoque.setValueAt(precof, i, 4);
            }

        }
    }

    public double precot() {

        precot = Integer.parseInt(txtqdtoupe.getText()) * Double.parseDouble(txtprecokg.getText());
        return precot;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtprod = new javax.swing.JTextField();
        txtqdtoupe = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtprecokg = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        estoque = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtbusca = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        radpeso = new javax.swing.JRadioButton();
        radunid = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setToolTipText("");
        jPanel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Ingrediente:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Unidade ou peso (em gramas):");

        txtprod.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtprod.setMinimumSize(new java.awt.Dimension(6, 25));

        txtqdtoupe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Preço (unid. ou Kg):");

        txtprecokg.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtprecokg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecokgActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        estoque.setBackground(new java.awt.Color(254, 254, 254));
        estoque.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        estoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificador", "Nome do Ingrediente", "Unid. ou peso (em gramas)", "Preço  (da unid. ou do Kg)", "Preço Total (R$)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        estoque.setGridColor(new java.awt.Color(102, 102, 102));
        estoque.setSelectionBackground(new java.awt.Color(153, 255, 153));
        estoque.setSelectionForeground(new java.awt.Color(0, 0, 0));
        estoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                estoqueMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                estoqueMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                estoqueMouseEntered(evt);
            }
        });
        estoque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                estoqueKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                estoqueKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(estoque);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel8.setText("Ingredientes");

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

        jButton4.setBackground(new java.awt.Color(1, 1, 1));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton4.setForeground(new java.awt.Color(254, 254, 254));
        jButton4.setText("Consultar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(1, 1, 1));
        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton7.setForeground(new java.awt.Color(254, 254, 254));
        jButton7.setText("Adicionar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        radpeso.setText("Peso");
        radpeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radpesoActionPerformed(evt);
            }
        });

        radunid.setText("Unidade");
        radunid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radunidActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(txtprod, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtqdtoupe))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtprecokg, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(radpeso)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(radunid))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(355, 355, 355)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(386, 386, 386))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtprod, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtqdtoupe, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtprecokg, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radpeso)
                            .addComponent(radunid))
                        .addGap(18, 18, 18)
                        .addComponent(txtbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(13, 13, 13)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            if (Double.parseDouble(txtprecokg.getText()) > 0 && Double.parseDouble(txtqdtoupe.getText()) >= 0) {

                if (estoque.getSelectedRow() != -1) {

                    EstoqueBean bean = new EstoqueBean();
                    EstoqueDAO dao = new EstoqueDAO();

                    String tipo = dao.pouq(estoque.getValueAt(estoque.getSelectedRow(), 0).toString());

                    if (tipo.equals("Q")) {
                        bean.setProd(txtprod.getText());
                        bean.setQdtoupe(Double.parseDouble(txtqdtoupe.getText()));
                        bean.setPreco(Double.parseDouble(txtprecokg.getText()));
                        bean.setId((int) estoque.getValueAt(estoque.getSelectedRow(), 0));
                    } else if (tipo.equals("P")) {
                        bean.setProd(txtprod.getText());
                        bean.setQdtoupe(Double.parseDouble(txtqdtoupe.getText()));
                        bean.setPreco(Double.parseDouble(txtprecokg.getText()));
                        bean.setId((int) estoque.getValueAt(estoque.getSelectedRow(), 0));
                    }

                    dao.update(bean);

                    txtprod.setText("");
                    txtqdtoupe.setText("");
                    txtprecokg.setText("");
                    radpeso.setSelected(false);
                    radunid.setSelected(false);

                    readJTable();

                    JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não pode haver quantidade/peso e/ou preço negativo.");
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Você não selecionou nada para ser atualizado ou não digitou", "Ops, algo deu errado...", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new TelaMenus().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtprecokgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecokgActionPerformed

    }//GEN-LAST:event_txtprecokgActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtbusca.setText("");
        txtprecokg.setText("");
        txtprod.setText("");
        txtqdtoupe.setText("");
        radpeso.setSelected(false);
        radunid.setSelected(false);

        readJTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            if (estoque.getSelectedRow() != -1) {

                EstoqueBean p = new EstoqueBean();
                EstoqueDAO dao = new EstoqueDAO();

                p.setId((int) estoque.getValueAt(estoque.getSelectedRow(), 0));

                dao.delete(p);

                txtprod.setText("");
                txtqdtoupe.setText("");
                txtprecokg.setText("");
                radpeso.setSelected(false);
                radunid.setSelected(false);

                readJTable();

            } else {

                JOptionPane.showMessageDialog(null, " Selecione a linha para que seja removida.");

            }

            JOptionPane.showMessageDialog(null, "Removido com sucesso!");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Você não selecionou nada que possa ser deletado", "Ops, algo deu errado...", JOptionPane.WARNING_MESSAGE);

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            readJTableForDesc(txtbusca.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Digite algo para ser pesquisado no Banco de Dados", "Ops, algo deu errado...", JOptionPane.WARNING_MESSAGE);
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void estoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estoqueMouseClicked
        if (estoque.getSelectedRow() != -1) {
            txtprod.setText(estoque.getValueAt(estoque.getSelectedRow(), 1).toString());
            txtqdtoupe.setText(estoque.getValueAt(estoque.getSelectedRow(), 2).toString());
            txtprecokg.setText(estoque.getValueAt(estoque.getSelectedRow(), 3).toString());

            EstoqueDAO dao = new EstoqueDAO();

            String tipo = dao.pouq2(estoque.getValueAt(estoque.getSelectedRow(), 1).toString());

            if (tipo.equals("Q")) {
                radunid.setSelected(true);
                radpeso.setSelected(false);
            } else if (tipo.equals("P")) {
                radunid.setSelected(false);
                radpeso.setSelected(true);
            }
        }
    }//GEN-LAST:event_estoqueMouseClicked

    private void estoqueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_estoqueKeyReleased
        if (estoque.getSelectedRow() != -1) {
            txtprod.setText(estoque.getValueAt(estoque.getSelectedRow(), 1).toString());
            txtqdtoupe.setText(estoque.getValueAt(estoque.getSelectedRow(), 2).toString());
            txtprecokg.setText(estoque.getValueAt(estoque.getSelectedRow(), 3).toString());

            EstoqueDAO dao = new EstoqueDAO();

            String tipo = dao.pouq2(estoque.getValueAt(estoque.getSelectedRow(), 1).toString());

            if (tipo.equals("Q")) {
                radunid.setSelected(true);
                radpeso.setSelected(false);
            } else if (tipo.equals("P")) {
                radunid.setSelected(false);
                radpeso.setSelected(true);
            }
        }
    }//GEN-LAST:event_estoqueKeyReleased

    private void txtbuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscaActionPerformed

    }//GEN-LAST:event_txtbuscaActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        int cont = 0;
        for (int r = 0; r < estoque.getRowCount(); r++) {
            String g = estoque.getValueAt(r, 1).toString();
            if (g.equals(txtprod.getText())) {
                cont++;
            }
        }
        if (cont == 0) {
            if (Double.parseDouble(txtprecokg.getText()) > 0 && Double.parseDouble(txtqdtoupe.getText()) > 0) {
                if (radunid.isSelected() == true && radpeso.isSelected() == false) {
                    try {
                        EstoqueDAO dao = new EstoqueDAO();
                        EstoqueBean bean = new EstoqueBean();

                        bean.setProd(txtprod.getText());
                        bean.setPreco(Double.parseDouble(txtprecokg.getText()));
                        bean.setQdtoupe(Integer.parseInt(txtqdtoupe.getText()));
                        bean.setTipo("Q");

                        dao.create(bean);

                        txtprod.setText("");
                        txtqdtoupe.setText("");
                        txtprecokg.setText("");
                        radpeso.setSelected(false);
                        radunid.setSelected(false);

                        readJTable();

                        JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");
                    } catch (HeadlessException | NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao adicionar, reinicie o programa e tente novamente.");
                    }
                } else if (radpeso.isSelected() == true && radunid.isSelected() == false) {
                    try {
                        EstoqueDAO dao = new EstoqueDAO();
                        EstoqueBean bean = new EstoqueBean();

                        bean.setProd(txtprod.getText());
                        bean.setPreco(Double.parseDouble(txtprecokg.getText()));
                        bean.setQdtoupe(Integer.parseInt(txtqdtoupe.getText()));
                        bean.setTipo("P");

                        dao.create(bean);

                        txtprod.setText("");
                        txtqdtoupe.setText("");
                        txtprecokg.setText("");
                        radpeso.setSelected(false);
                        radunid.setSelected(false);

                        readJTable();

                        JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");
                    } catch (HeadlessException | NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao adicionar, reinicie o programa e tente novamente.");
                    }
                } else if (radunid.isSelected() && radpeso.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Selecione por peso ou pela unidade.");
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione por peso ou pela unidade.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não pode haver quantidade/peso e/ou preço negativo.");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Esse ingrediente já existe no estoque.", "", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void radpesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radpesoActionPerformed
        if (radpeso.isSelected() == true) {
            radunid.setSelected(false);
        }
    }//GEN-LAST:event_radpesoActionPerformed

    private void estoqueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_estoqueKeyPressed
        if (estoque.getSelectedRow() != -1) {
            txtprod.setText(estoque.getValueAt(estoque.getSelectedRow(), 1).toString());
            txtqdtoupe.setText(estoque.getValueAt(estoque.getSelectedRow(), 2).toString());
            txtprecokg.setText(estoque.getValueAt(estoque.getSelectedRow(), 3).toString());

            EstoqueDAO dao = new EstoqueDAO();

            String tipo = dao.pouq2(estoque.getValueAt(estoque.getSelectedRow(), 1).toString());

            if (tipo.equals("Q")) {
                radunid.setSelected(true);
                radpeso.setSelected(false);
            } else if (tipo.equals("P")) {
                radunid.setSelected(false);
                radpeso.setSelected(true);
            }
        }
    }//GEN-LAST:event_estoqueKeyPressed

    private void estoqueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estoqueMouseEntered

    }//GEN-LAST:event_estoqueMouseEntered

    private void estoqueMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estoqueMousePressed

    }//GEN-LAST:event_estoqueMousePressed

    private void radunidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radunidActionPerformed
        if (radunid.isSelected() == true) {
            radpeso.setSelected(false);
        }
    }//GEN-LAST:event_radunidActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable estoque;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radpeso;
    private javax.swing.JRadioButton radunid;
    private javax.swing.JTextField txtbusca;
    private javax.swing.JTextField txtprecokg;
    private javax.swing.JTextField txtprod;
    private javax.swing.JTextField txtqdtoupe;
    // End of variables declaration//GEN-END:variables
}
