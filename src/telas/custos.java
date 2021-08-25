package telas;

import java.awt.HeadlessException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.CustoBean;
import model.dao.CustoDAO;

public class custos extends javax.swing.JFrame {

    public custos() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) estoque.getModel();
        estoque.setRowSorter(new TableRowSorter(modelo));
        readJTable();
        ImageIcon icone = new ImageIcon("images/ligeirinho.png");
        setIconImage(icone.getImage());

        Calendar calendar = new GregorianCalendar();

        String mes = Integer.toString(calendar.get(Calendar.MONTH) + 1);

        if (mes.length() == 1) {
            mes = "0" + mes;
        }

        txtDia.setText(Integer.toString(calendar.get(Calendar.DAY_OF_MONTH)));
        txtMes.setText(mes);
        txtAno.setText(Integer.toString(calendar.get(Calendar.YEAR)).substring(2, 4));
    }

    public void readJTable() {

        DefaultTableModel modelo = (DefaultTableModel) estoque.getModel();
        modelo.setNumRows(0);
        CustoDAO pdao = new CustoDAO();

        pdao.read().forEach((p) -> {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getAgua(),
                p.getLuz(),
                p.getTel(),
                p.getNet(),
                p.getMl(),
                p.getPiz(),
                p.getAux(),
                p.getCai(),
                p.getEnt(),
                p.getDivulg(),
                p.getDia() + "/" + p.getMes() + "/" + p.getAno()

            });
        });

    }

    public void readJTableForDesc(String desc) {

        DefaultTableModel modelo = (DefaultTableModel) estoque.getModel();
        modelo.setNumRows(0);
        CustoDAO pdao = new CustoDAO();

        pdao.readForDesc(desc).forEach((p) -> {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getAgua(),
                p.getLuz(),
                p.getTel(),
                p.getNet(),
                p.getMl(),
                p.getPiz(),
                p.getAux(),
                p.getCai(),
                p.getEnt(),
                p.getDivulg(),
                p.getDia() + "/" + p.getMes() + "/" + p.getAno()

            });
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtinternet = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txttelefone = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtpizzaiodo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtmaterial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        estoque = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtluz = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        txtagua = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        txtauxiliar = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtcaixa = new javax.swing.JTextField();
        txtentregador = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        valorCusto = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDivulg = new javax.swing.JTextField();
        txtDia = new javax.swing.JTextField();
        txtMes = new javax.swing.JTextField();
        txtAno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        txtinternet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtinternet.setMinimumSize(new java.awt.Dimension(6, 25));

        jLabel1.setBackground(new java.awt.Color(1, 1, 1));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText(" Água:");

        txttelefone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel2.setBackground(new java.awt.Color(1, 1, 1));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Luz:");

        txtpizzaiodo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel3.setBackground(new java.awt.Color(1, 1, 1));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Telefone:");

        txtmaterial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setBackground(new java.awt.Color(1, 1, 1));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Pizzaiolo:");

        jLabel5.setBackground(new java.awt.Color(1, 1, 1));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Internet:");

        estoque.setBackground(new java.awt.Color(254, 254, 254));
        estoque.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        estoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Agua", "Luz", "Telefone", "Internet", "Limpeza", "Pizzaiolo", "Auxiliar", "Caixa", "Combustível", "Divulgação", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
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

        jLabel6.setBackground(new java.awt.Color(1, 1, 1));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Limpeza:");

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
        jLabel8.setText("Custos");

        jButton2.setBackground(new java.awt.Color(1, 1, 1));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(254, 254, 254));
        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtluz.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jButton3.setBackground(new java.awt.Color(1, 1, 1));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(254, 254, 254));
        jButton3.setText("Alterar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtagua.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtagua.setMinimumSize(new java.awt.Dimension(6, 25));

        jLabel9.setBackground(new java.awt.Color(1, 1, 1));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Auxiliar:");

        jButton6.setBackground(new java.awt.Color(1, 1, 1));
        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(254, 254, 254));
        jButton6.setText("Voltar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        txtauxiliar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jButton7.setBackground(new java.awt.Color(1, 1, 1));
        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(254, 254, 254));
        jButton7.setText("Limpar campos");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(1, 1, 1));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Caixa:");

        txtcaixa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtentregador.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel12.setBackground(new java.awt.Color(1, 1, 1));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Combustível");

        valorCusto.setFont(new java.awt.Font("Microsoft JhengHei", 0, 18)); // NOI18N
        valorCusto.setText("Divulgação:");

        jLabel11.setBackground(new java.awt.Color(1, 1, 1));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Data:");

        txtDivulg.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        txtDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtagua, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(24, 24, 24))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtluz)
                                                .addGap(6, 6, 6))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtcaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtmaterial)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtentregador)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel3)
                                                .addGap(23, 23, 23)
                                                .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtpizzaiodo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(valorCusto)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDivulg, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtauxiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtinternet, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7)
                                .addGap(52, 52, 52)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtagua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)
                            .addComponent(jLabel2)
                            .addComponent(txtluz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtmaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtpizzaiodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtentregador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtinternet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtauxiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(21, 21, 21)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(valorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDivulg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
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

    private void estoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estoqueMouseClicked

        if (estoque.getSelectedRow() != -1) {
            txtagua.setText(estoque.getValueAt(estoque.getSelectedRow(), 1).toString());
            txtluz.setText(estoque.getValueAt(estoque.getSelectedRow(), 2).toString());
            txttelefone.setText(estoque.getValueAt(estoque.getSelectedRow(), 3).toString());
            txtinternet.setText(estoque.getValueAt(estoque.getSelectedRow(), 4).toString());
            txtmaterial.setText(estoque.getValueAt(estoque.getSelectedRow(), 5).toString());
            txtpizzaiodo.setText(estoque.getValueAt(estoque.getSelectedRow(), 6).toString());
            txtauxiliar.setText(estoque.getValueAt(estoque.getSelectedRow(), 7).toString());
            txtcaixa.setText(estoque.getValueAt(estoque.getSelectedRow(), 8).toString());
            txtentregador.setText(estoque.getValueAt(estoque.getSelectedRow(), 9).toString());
            txtDivulg.setText(estoque.getValueAt(estoque.getSelectedRow(), 10).toString());
            String data = estoque.getValueAt(estoque.getSelectedRow(), 11).toString();
            int x;
            int y;
            x = data.indexOf("/");
            y = data.lastIndexOf("/");
            String dia = data.substring(0, x);
            String mes = data.substring(x + 1, y);
            String ano = data.substring(y + 1);

            txtDia.setText(dia);
            txtMes.setText(mes);
            txtAno.setText(ano);

        }
    }//GEN-LAST:event_estoqueMouseClicked

    private void estoqueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_estoqueKeyReleased

        if (estoque.getSelectedRow() != -1) {
            txtagua.setText(estoque.getValueAt(estoque.getSelectedRow(), 1).toString());
            txtluz.setText(estoque.getValueAt(estoque.getSelectedRow(), 2).toString());
            txttelefone.setText(estoque.getValueAt(estoque.getSelectedRow(), 3).toString());
            txtinternet.setText(estoque.getValueAt(estoque.getSelectedRow(), 4).toString());
            txtmaterial.setText(estoque.getValueAt(estoque.getSelectedRow(), 5).toString());
            txtpizzaiodo.setText(estoque.getValueAt(estoque.getSelectedRow(), 6).toString());
            txtauxiliar.setText(estoque.getValueAt(estoque.getSelectedRow(), 7).toString());
            txtcaixa.setText(estoque.getValueAt(estoque.getSelectedRow(), 8).toString());
            txtentregador.setText(estoque.getValueAt(estoque.getSelectedRow(), 9).toString());
            txtDivulg.setText(estoque.getValueAt(estoque.getSelectedRow(), 10).toString());
            String data = estoque.getValueAt(estoque.getSelectedRow(), 11).toString();
            int x;
            int y;
            x = data.indexOf("/");
            y = data.lastIndexOf("/");
            String dia = data.substring(0, x);
            String mes = data.substring(x + 1, y);
            String ano = data.substring(y + 1);

            txtDia.setText(dia);
            txtMes.setText(mes);
            txtAno.setText(ano);

        }
    }//GEN-LAST:event_estoqueKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (txtagua.getText().equals("") == false) {
                CustoBean p = new CustoBean();
                CustoDAO dao = new CustoDAO();

                p.setAgua(Double.parseDouble(txtagua.getText()));
                p.setLuz(Double.parseDouble(txtluz.getText()));
                p.setNet(Double.parseDouble(txtinternet.getText()));
                p.setTel(Double.parseDouble(txttelefone.getText()));
                p.setMl(Double.parseDouble(txtmaterial.getText()));
                p.setPiz(Double.parseDouble(txtpizzaiodo.getText()));
                p.setAux(Double.parseDouble(txtauxiliar.getText()));
                p.setCai(Double.parseDouble(txtcaixa.getText()));
                p.setEnt(Double.parseDouble(txtentregador.getText()));
                p.setDivulg(Double.parseDouble(txtDivulg.getText()));
                p.setDia(txtDia.getText());
                p.setMes(txtMes.getText());
                p.setAno(txtAno.getText());

                txtagua.setText("");
                txtluz.setText("");
                txtinternet.setText("");
                txttelefone.setText("");
                txtmaterial.setText("");
                txtpizzaiodo.setText("");
                txtauxiliar.setText("");
                txtcaixa.setText("");
                txtentregador.setText("");
                txtDia.setText("");
                txtMes.setText("");
                txtAno.setText("");
                txtDivulg.setText("");

                dao.create(p);

                readJTable();
            } else {
                JOptionPane.showMessageDialog(null, "Valores em branco.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Você não digitou nada para ser adicionado", "Ops, algo deu errado...", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            if (estoque.getSelectedRow() != -1) {

                CustoBean p = new CustoBean();
                CustoDAO dao = new CustoDAO();

                p.setId((int) estoque.getValueAt(estoque.getSelectedRow(), 0));

                dao.delete(p);

                txtagua.setText("");
                txtluz.setText("");
                txttelefone.setText("");
                txtinternet.setText("");
                txtmaterial.setText("");
                txtpizzaiodo.setText("");
                txtauxiliar.setText("");
                txtcaixa.setText("");
                txtentregador.setText("");
                txtDia.setText("");
                txtMes.setText("");
                txtAno.setText("");
                txtDivulg.setText("");

                readJTable();

            } else {

                JOptionPane.showMessageDialog(null, " Selecione a linha para que esta seja removida.");

            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Você não selecionou nada para que possa ser deletado", "Ops, algo deu errado...", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            if (estoque.getSelectedRow() != -1) {

                CustoBean p = new CustoBean();
                CustoDAO dao = new CustoDAO();

                p.setAgua(Double.parseDouble(txtagua.getText()));
                p.setLuz(Double.parseDouble(txtluz.getText()));
                p.setTel(Double.parseDouble(txttelefone.getText()));
                p.setNet(Double.parseDouble(txtinternet.getText()));
                p.setMl(Double.parseDouble(txtmaterial.getText()));
                p.setPiz(Double.parseDouble(txtpizzaiodo.getText()));
                p.setAux(Double.parseDouble(txtauxiliar.getText()));
                p.setCai(Double.parseDouble(txtcaixa.getText()));
                p.setEnt(Double.parseDouble(txtentregador.getText()));
                p.setDia(txtDia.getText());
                p.setMes(txtMes.getText());
                p.setAno(txtAno.getText());
                p.setDivulg(Double.parseDouble(txtDivulg.getText()));

                p.setId((int) estoque.getValueAt(estoque.getSelectedRow(), 0));

                dao.update(p);

                txtagua.setText("");
                txtluz.setText("");
                txtinternet.setText("");
                txttelefone.setText("");
                txtmaterial.setText("");
                txtpizzaiodo.setText("");
                txtauxiliar.setText("");
                txtcaixa.setText("");
                txtentregador.setText("");
                txtDia.setText("");
                txtMes.setText("");
                txtAno.setText("");
                txtDivulg.setText("");

                readJTable();

            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Você não selecionou nada para ser atualizado ou não digitou", "Ops, algo deu errado...", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        TelaMenus g = new TelaMenus();
        g.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        txtagua.setText("");
        txtluz.setText("");
        txtinternet.setText("");
        txttelefone.setText("");
        txtmaterial.setText("");
        txtpizzaiodo.setText("");
        txtauxiliar.setText("");
        txtcaixa.setText("");
        txtentregador.setText("");
        txtDia.setText("");
        txtMes.setText("");
        txtAno.setText("");
        txtDivulg.setText("");

        readJTable();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txtDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaActionPerformed

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
            java.util.logging.Logger.getLogger(custos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(custos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(custos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(custos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new custos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable estoque;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtDivulg;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtagua;
    private javax.swing.JTextField txtauxiliar;
    private javax.swing.JTextField txtcaixa;
    private javax.swing.JTextField txtentregador;
    private javax.swing.JTextField txtinternet;
    private javax.swing.JTextField txtluz;
    private javax.swing.JTextField txtmaterial;
    private javax.swing.JTextField txtpizzaiodo;
    private javax.swing.JTextField txttelefone;
    private javax.swing.JLabel valorCusto;
    // End of variables declaration//GEN-END:variables
}
