package telas;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.ClienteBean;
import model.dao.ClienteDAO;
import model.dao.VendaDAO;

public class Cliente extends javax.swing.JFrame {

    public Cliente() {
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
        ClienteDAO pdao = new ClienteDAO();

        pdao.read().forEach((p) -> {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getApelido(),
                p.getRua(),
                p.getNumero(),
                p.getComplemento(),
                p.getCidade(),
                p.getBairro(),
                p.getNumerot()

            });
        });

    }

    public void readJTableForDesc(String desc) {

        DefaultTableModel modelo = (DefaultTableModel) estoque.getModel();
        modelo.setNumRows(0);
        ClienteDAO pdao = new ClienteDAO();

        pdao.readForDesc(desc).forEach((p) -> {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getApelido(),
                p.getRua(),
                p.getNumero(),
                p.getComplemento(),
                p.getCidade(),
                p.getBairro(),
                p.getNumerot()

            });
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtrua = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtnumero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtbairro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtcidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtcomplemento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        estoque = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtapelido = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        txtnome = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtbusca = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        txtnumerot = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        txtrua.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtrua.setMinimumSize(new java.awt.Dimension(6, 25));

        jLabel1.setBackground(new java.awt.Color(1, 1, 1));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Nome completo:");

        txtnumero.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel2.setBackground(new java.awt.Color(1, 1, 1));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Apelido:");

        txtbairro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel3.setBackground(new java.awt.Color(1, 1, 1));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Número:");

        txtcidade.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setBackground(new java.awt.Color(1, 1, 1));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Bairro:");

        txtcomplemento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel5.setBackground(new java.awt.Color(1, 1, 1));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Rua:");

        estoque.setBackground(new java.awt.Color(254, 254, 254));
        estoque.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        estoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Apelido", "Rua", "Número", "Complemento", "Cidade", "Bairro", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        estoque.setSelectionBackground(new java.awt.Color(153, 255, 153));
        estoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                estoqueMouseClicked(evt);
            }
        });
        estoque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                estoqueKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(estoque);
        if (estoque.getColumnModel().getColumnCount() > 0) {
            estoque.getColumnModel().getColumn(0).setMinWidth(22);
            estoque.getColumnModel().getColumn(0).setPreferredWidth(22);
            estoque.getColumnModel().getColumn(0).setMaxWidth(22);
            estoque.getColumnModel().getColumn(4).setMinWidth(70);
            estoque.getColumnModel().getColumn(4).setPreferredWidth(70);
            estoque.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        jLabel6.setBackground(new java.awt.Color(1, 1, 1));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Cidade:");

        jLabel7.setBackground(new java.awt.Color(1, 1, 1));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Complemento:");

        jButton1.setBackground(new java.awt.Color(1, 1, 1));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(254, 254, 254));
        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(1, 1, 1));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel8.setText("Clientes");

        jButton2.setBackground(new java.awt.Color(1, 1, 1));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(254, 254, 254));
        jButton2.setText("Compras");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtapelido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jButton3.setBackground(new java.awt.Color(1, 1, 1));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(254, 254, 254));
        jButton3.setText("Alterar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtnome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtnome.setMinimumSize(new java.awt.Dimension(6, 25));

        jButton5.setBackground(new java.awt.Color(1, 1, 1));
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(254, 254, 254));
        jButton5.setText("Consultar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(1, 1, 1));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Número de Telefone:");

        jButton6.setBackground(new java.awt.Color(1, 1, 1));
        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(254, 254, 254));
        jButton6.setText("Voltar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        txtnumerot.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jButton7.setBackground(new java.awt.Color(1, 1, 1));
        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(254, 254, 254));
        jButton7.setText("Limpar campos");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(1, 1, 1));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(254, 254, 254));
        jButton4.setText("Excluir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(txtapelido, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtbusca)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jButton7))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtrua, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addGap(9, 9, 9)
                                        .addComponent(txtcomplemento)))
                                .addGap(15, 15, 15))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcidade, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtnumerot, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                .addGap(24, 24, 24)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtapelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtrua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcomplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnumerot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            readJTableForDesc(txtbusca.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Digite algo para ser pesquisado no Banco de Dados", "Ops, algo deu errado...", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int cont = 0;
        for (int r = 0; r < estoque.getRowCount(); r++) {
            String g = estoque.getValueAt(r, 1).toString();
            if (g.equals(txtnome.getText())) {
                cont++;
            }
        }

        try {
            if (txtnome.getText().equals("") == false && cont == 0) {
                ClienteBean p = new ClienteBean();
                ClienteDAO dao = new ClienteDAO();

                p.setNome(txtnome.getText());
                p.setApelido(txtapelido.getText());
                p.setRua(txtrua.getText());
                p.setNumero(txtnumero.getText());
                p.setComplemento(txtcomplemento.getText());
                p.setCidade(txtcidade.getText());
                p.setBairro(txtbairro.getText());
                p.setNumerot(txtnumerot.getText());

                txtnome.setText("");
                txtapelido.setText("");
                txtrua.setText("");
                txtnumero.setText("");
                txtcomplemento.setText("");
                txtcidade.setText("");
                txtbairro.setText("");
                txtnumerot.setText("");
                dao.create(p);

                readJTable();
            } else {
                JOptionPane.showMessageDialog(null, "Digite um nome / Nome já usado");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Você não digitou nada para ser adicionado", "Ops, algo deu errado...", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            if (estoque.getSelectedRow() != -1) {

                ClienteBean p = new ClienteBean();
                ClienteDAO dao = new ClienteDAO();

                p.setNome(txtnome.getText());
                p.setApelido(txtapelido.getText());
                p.setRua(txtrua.getText());
                p.setNumero(txtnumero.getText());
                p.setComplemento(txtcomplemento.getText());
                p.setCidade(txtcidade.getText());
                p.setBairro(txtbairro.getText());
                p.setNumerot(txtnumerot.getText());

                p.setId((int) estoque.getValueAt(estoque.getSelectedRow(), 0));

                dao.update(p);

                txtnome.setText("");
                txtapelido.setText("");
                txtrua.setText("");
                txtnumero.setText("");
                txtcomplemento.setText("");
                txtcidade.setText("");
                txtbairro.setText("");
                txtnumerot.setText("");
                readJTable();

            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Você não selecionou nada para ser atualizado ou não digitou", "Ops, algo deu errado...", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            VendaDAO vd = new VendaDAO();

            ArrayList<String> produtos = new ArrayList<>();
            ArrayList<Double> preco = new ArrayList<>();
            ArrayList<Double> qtd = new ArrayList<>();
            ArrayList<String> data = new ArrayList<>();

            if (estoque.getSelectedRow() != -1) {

                txtnome.setText(estoque.getValueAt(estoque.getSelectedRow(), 1).toString());
                txtapelido.setText(estoque.getValueAt(estoque.getSelectedRow(), 2).toString());
                txtrua.setText(estoque.getValueAt(estoque.getSelectedRow(), 3).toString());
                txtnumero.setText(estoque.getValueAt(estoque.getSelectedRow(), 4).toString());
                txtcomplemento.setText(estoque.getValueAt(estoque.getSelectedRow(), 5).toString());
                txtcidade.setText(estoque.getValueAt(estoque.getSelectedRow(), 6).toString());
                txtbairro.setText(estoque.getValueAt(estoque.getSelectedRow(), 7).toString());
                txtnumerot.setText(estoque.getValueAt(estoque.getSelectedRow(), 8).toString());

                for (int i = 0; i < vd.ver(txtnome.getText()).size(); i++) {

                    produtos.add(vd.verProduto(txtnome.getText()).get(i));
                    preco.add(vd.verPreco(txtnome.getText()).get(i));
                    qtd.add(vd.verQtd(txtnome.getText()).get(i));
                    data.add(vd.verDia(txtnome.getText()).get(i) + "/" + vd.verMes(txtnome.getText()).get(i) + "/" + vd.verAno(txtnome.getText()).get(i));

                }

                dados d = new dados(produtos, preco, qtd, data);

                d.setVisible(true);

                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Você não selecionou nem um cliente", null, JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Deu merda", null, JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        TelaMenus g = new TelaMenus();
        g.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void estoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estoqueMouseClicked

        if (estoque.getSelectedRow() != -1) {
            txtnome.setText(estoque.getValueAt(estoque.getSelectedRow(), 1).toString());
            txtapelido.setText(estoque.getValueAt(estoque.getSelectedRow(), 2).toString());
            txtrua.setText(estoque.getValueAt(estoque.getSelectedRow(), 3).toString());
            txtnumero.setText(estoque.getValueAt(estoque.getSelectedRow(), 4).toString());
            txtcomplemento.setText(estoque.getValueAt(estoque.getSelectedRow(), 5).toString());
            txtcidade.setText(estoque.getValueAt(estoque.getSelectedRow(), 6).toString());
            txtbairro.setText(estoque.getValueAt(estoque.getSelectedRow(), 7).toString());
            txtnumerot.setText(estoque.getValueAt(estoque.getSelectedRow(), 8).toString());

        }
    }//GEN-LAST:event_estoqueMouseClicked

    private void estoqueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_estoqueKeyReleased

        if (estoque.getSelectedRow() != -1) {
            txtnome.setText(estoque.getValueAt(estoque.getSelectedRow(), 1).toString());
            txtapelido.setText(estoque.getValueAt(estoque.getSelectedRow(), 2).toString());
            txtrua.setText(estoque.getValueAt(estoque.getSelectedRow(), 3).toString());
            txtnumero.setText(estoque.getValueAt(estoque.getSelectedRow(), 4).toString());
            txtcomplemento.setText(estoque.getValueAt(estoque.getSelectedRow(), 5).toString());
            txtcidade.setText(estoque.getValueAt(estoque.getSelectedRow(), 6).toString());
            txtbairro.setText(estoque.getValueAt(estoque.getSelectedRow(), 7).toString());
            txtnumerot.setText(estoque.getValueAt(estoque.getSelectedRow(), 8).toString());

        }
    }//GEN-LAST:event_estoqueKeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        txtnome.setText("");
        txtapelido.setText("");
        txtrua.setText("");
        txtnumero.setText("");
        txtcomplemento.setText("");
        txtcidade.setText("");
        txtbairro.setText("");
        txtnumerot.setText("");
        txtbusca.setText("");
        readJTable();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {
            if (estoque.getSelectedRow() != -1) {
                ClienteBean bean = new ClienteBean();
                ClienteDAO dao = new ClienteDAO();
                bean.setId((int) estoque.getValueAt(estoque.getSelectedRow(), 0));
                dao.delete(bean);

                readJTable();
                txtnome.setText("");
                txtapelido.setText("");
                txtrua.setText("");
                txtnumero.setText("");
                txtcomplemento.setText("");
                txtcidade.setText("");
                txtbairro.setText("");
                txtnumerot.setText("");
                txtbusca.setText("");

            } else {

                JOptionPane.showMessageDialog(null, " Selecione a linha para que seja removida.");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Você não selecionou nada que possa ser deletado", null, JOptionPane.WARNING_MESSAGE);

        }

    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Cliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
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
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtapelido;
    private javax.swing.JTextField txtbairro;
    private javax.swing.JTextField txtbusca;
    private javax.swing.JTextField txtcidade;
    private javax.swing.JTextField txtcomplemento;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtnumero;
    private javax.swing.JTextField txtnumerot;
    private javax.swing.JTextField txtrua;
    // End of variables declaration//GEN-END:variables
}
