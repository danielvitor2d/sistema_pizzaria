package telas;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.ClienteBean;
import model.bean.EstoqueBean;
import model.bean.ProdutoBean;
import model.bean.ReceitaBean;
import model.bean.VendaBean;
import model.dao.ClienteDAO;
import model.dao.EstoqueDAO;
import model.dao.ProdutosDAO;
import model.dao.ReceitaDAO;
import model.dao.VendaDAO;

public class TelaFazerVenda extends javax.swing.JFrame {

    List<String> ingredBanco;
    List<Double> qtdBanco;

    List<String> ingredReceita;
    List<Double> qtdReceita;

    ArrayList<Integer> index_faltando;

    boolean podeComprar = true;

    public boolean validaVenda() {
        index_faltando = new ArrayList<>();

        for (int i = 0; i < ingredBanco.size(); i++) {
            if (qtdBanco.get(i) < 0) {
                podeComprar = false;
                index_faltando.add(i);
            }
        }
        return podeComprar;
    }

    public int contaProduto_banco() {

        EstoqueDAO dao = new EstoqueDAO();

        ingredBanco = new ArrayList<>();
        qtdBanco = new ArrayList<>();

        for (EstoqueBean ebe : dao.readBanco()) {
            ingredBanco.add(ebe.getProd());
            qtdBanco.add(ebe.getQdtoupe());
        }

        System.out.println("Quantidade no banco: ");
        System.out.println(ingredBanco);
        System.out.println(qtdBanco);
        System.out.println("----------------------------");

        int cont = 0;
        for (int k = 0; k < ingredBanco.size(); k++) {
            if (qtdBanco.get(k) < 0) {
                cont++;
            }
        }
        return cont;
    }

    public void contaProduto_receita(String nome_receita) {
        double qtdes = 0;

        if (txtqtd.getText().equals("")) {
            qtdes = 1;
        } else {
            qtdes = Double.parseDouble(txtqtd.getText());
        }

        ReceitaDAO dao = new ReceitaDAO();

        ingredReceita = new ArrayList<>();
        qtdReceita = new ArrayList<>();

        if (ingredReceita.size() > 0) {
            ingredReceita.clear();
        }
        if (qtdReceita.size() > 0) {
            qtdReceita.clear();
        }

        for (ReceitaBean b : dao.readRece(nome_receita)) {
            ingredReceita.add(b.getProduto());
            qtdReceita.add((b.getQtdoupeso() * qtdes));
        }

        System.out.println("Quantidade na receita:");
        System.out.println(ingredReceita);
        System.out.println(qtdReceita);
        System.out.println("------------------------");
    }

    public void retiraBanco() {
        int num_ingredientes = ingredReceita.size();
        for (int i = 0; i < num_ingredientes; i++) {
            String ingred = ingredReceita.get(i);

            double tot_rece = qtdReceita.get(i);

            int index = 0;

            for (int y = 0; y < ingredBanco.size(); y++) {
                if (ingred.equals(ingredBanco.get(y))) {
                    index = y;
                }
            }

            double tot_banco = qtdBanco.get(index);

            double qtd_final_banco = tot_banco - tot_rece;

            qtdBanco.set(index, qtd_final_banco);

        }

        System.out.println("Quantidade final no banco:");
        System.out.println(ingredBanco);
        System.out.println(qtdBanco);
        System.out.println("---------------------------------");
    }

    public TelaFazerVenda() {
        initComponents();
        ImageIcon icone = new ImageIcon("images/ligeirinho.png");
        setIconImage(icone.getImage());
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        readJComboBox();
        readJComboBox2();
        contaProduto_banco();
    }

    DecimalFormat df = new DecimalFormat("0.####");

    public void readJComboBox() {
        VendaDAO dao = new VendaDAO();

        cxaClientes.removeAllItems();

        for (ClienteBean b : dao.readForJComboBox()) {
            String[] nome = {b.getNome()};
            Arrays.sort(nome);

            cxaClientes.addItem(b.getNome());
        }
    }

    public void readJComboBox2() {
        ProdutosDAO dao = new ProdutosDAO();

        cxaProdutos.removeAllItems();

        for (ProdutoBean b : dao.readForJComboBox()) {
            cxaProdutos.addItem(b.getNp());
        }
    }

    public void pesqN() {
        ClienteDAO pdao = new ClienteDAO();
        System.out.println(pdao.readForDesc2(txtbusca.getText()));
        cxaClientes.setSelectedItem(pdao.readForDesc2(txtbusca.getText()));
    }

    public double arrumaJTable() {
        double precofinal = 0;
        for (int i = 0; i < venda.getRowCount(); i++) {
            precofinal += Double.parseDouble(venda.getValueAt(i, 1).toString());
        }
        lblPrecoFinal.setText(Double.toString(precofinal));
        return precofinal;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        venda = new javax.swing.JTable();
        cxaClientes = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        lblPrecoFinal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cxaProdutos = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        txtbusca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtqtd = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDesconto = new javax.swing.JTextField();
        txtDinheiro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtTroco = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jLabel1.setBackground(new java.awt.Color(1, 1, 1));
        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 36)); // NOI18N
        jLabel1.setText("Realizar venda");

        jLabel2.setBackground(new java.awt.Color(1, 1, 1));
        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 18)); // NOI18N
        jLabel2.setText("Buscar pelo número do Cliente:");

        jButton1.setBackground(new java.awt.Color(1, 1, 1));
        jButton1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(254, 254, 254));
        jButton1.setText("Realizar venda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        venda.setBackground(new java.awt.Color(254, 254, 254));
        venda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Preço(R$)", "Quantidade", "Preco real (R$)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        venda.setSelectionBackground(new java.awt.Color(153, 255, 153));
        venda.setSelectionForeground(new java.awt.Color(1, 1, 1));
        jScrollPane1.setViewportView(venda);

        cxaClientes.setBackground(new java.awt.Color(1, 1, 1));
        cxaClientes.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        cxaClientes.setForeground(new java.awt.Color(1, 1, 1));
        cxaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxaClientesActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(1, 1, 1));
        jButton2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(254, 254, 254));
        jButton2.setText("Limpar tudo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblPrecoFinal.setBackground(new java.awt.Color(1, 1, 1));
        lblPrecoFinal.setFont(new java.awt.Font("Microsoft JhengHei", 0, 18)); // NOI18N
        lblPrecoFinal.setText("0.0");

        jLabel7.setBackground(new java.awt.Color(1, 1, 1));
        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei", 0, 18)); // NOI18N
        jLabel7.setText("Preço Total: R$");

        jButton3.setBackground(new java.awt.Color(1, 1, 1));
        jButton3.setFont(new java.awt.Font("Microsoft JhengHei", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(254, 254, 254));
        jButton3.setText("Voltar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(1, 1, 1));
        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei", 0, 18)); // NOI18N
        jLabel6.setText("Quantidade:");

        cxaProdutos.setBackground(new java.awt.Color(1, 1, 1));
        cxaProdutos.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        cxaProdutos.setForeground(new java.awt.Color(1, 1, 1));
        cxaProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxaProdutosActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(1, 1, 1));
        jButton4.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(254, 254, 254));
        jButton4.setText("Adicionar produto");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(1, 1, 1));
        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei", 0, 18)); // NOI18N
        jLabel3.setText("Cliente:");

        jButton5.setBackground(new java.awt.Color(1, 1, 1));
        jButton5.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(254, 254, 254));
        jButton5.setText("Pesquisar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(1, 1, 1));
        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei", 0, 18)); // NOI18N
        jLabel8.setText("Produto:");

        jLabel9.setBackground(new java.awt.Color(1, 1, 1));
        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei", 0, 18)); // NOI18N
        jLabel9.setText("Desconto:");

        jLabel10.setBackground(new java.awt.Color(1, 1, 1));
        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei", 0, 18)); // NOI18N
        jLabel10.setText("Dinheiro:");

        jButton7.setBackground(new java.awt.Color(1, 1, 1));
        jButton7.setFont(new java.awt.Font("Microsoft JhengHei", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(254, 254, 254));
        jButton7.setText("Calcular");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(1, 1, 1));
        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei", 0, 18)); // NOI18N
        jLabel11.setText("Troco: R$");

        txtTroco.setBackground(new java.awt.Color(1, 1, 1));
        txtTroco.setFont(new java.awt.Font("Microsoft JhengHei", 0, 18)); // NOI18N
        txtTroco.setText("0.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(367, 367, 367)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtbusca)
                    .addComponent(cxaProdutos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cxaClientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPrecoFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtqtd, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(36, 36, 36)
                .addComponent(jButton1)
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cxaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cxaProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtqtd, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDesconto, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(lblPrecoFinal))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTroco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addGap(20, 20, 20))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton1)))
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
        new TelaMenus().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    public void xxt() {
        DefaultTableModel model = (DefaultTableModel) venda.getModel();
        model.setNumRows(0);
        txtbusca.setText("");
        txtDesconto.setText("");
        txtDinheiro.setText("");
        txtqtd.setText("");
        txtTroco.setText("");
        lblPrecoFinal.setText("");
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new TelaFazerVenda().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cxaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxaClientesActionPerformed

    }//GEN-LAST:event_cxaClientesActionPerformed
    public void comPDF() {
        if (venda.getRowCount() > 0 && !txtDinheiro.getText().equals("")) {
            boolean podeComprar = validaVenda();

            ArrayList<String> ingred_faltando = new ArrayList<>();

            for (int i = 0; i < index_faltando.size(); i++) {
                ingred_faltando.add(ingredBanco.get(index_faltando.get(i)));
            }

            if (podeComprar) {
                int returnVal = jFileChooser1.showSaveDialog(this);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = jFileChooser1.getSelectedFile();

                    //Início do PDF
                    Document doc;
                    OutputStream os;

                    try {
                        doc = new Document(PageSize.A4);
                        os = new FileOutputStream(file.getAbsoluteFile() + ".pdf");

                        PdfWriter.getInstance(doc, os);
                        doc.open();

                        //Título do arquivo
                        Font fonte01 = new Font(FontFamily.COURIER, 20, Font.BOLD);

                        Paragraph title = new Paragraph("Descrição da venda", fonte01);
                        title.setAlignment(Element.ALIGN_CENTER);
                        doc.add(title);

                        //Fim - Título do arquivo
                        //Quebras de linha
                        doc.add(new Paragraph(" "));
                        doc.add(new Paragraph(" "));

                        //Fim - Quebras de linha
                        //Nome do cliente
                        String cliente = cxaClientes.getSelectedItem().toString();
                        doc.add(new Paragraph("Cliente: " + cliente));

                        //Fim - Nome do cliente
                        //Horário
                        Calendar cal = new GregorianCalendar();

                        String hora = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
                        String minuto = Integer.toString(cal.get(Calendar.MINUTE));
                        String segundo = Integer.toString(cal.get(Calendar.SECOND));

                        if (hora.length() == 1) {
                            hora = "0" + hora;
                        }
                        if (minuto.length() == 1) {
                            minuto = "0" + minuto;
                        }
                        if (segundo.length() == 1) {
                            segundo = "0" + segundo;
                        }

                        String dia = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
                        String mes = Integer.toString((cal.get(Calendar.MONTH) + 1));
                        String ano = Integer.toString(cal.get(Calendar.YEAR));

                        if (dia.length() == 1) {
                            dia = "0" + dia;
                        }
                        if (mes.length() == 1) {
                            mes = "0" + mes;
                        }
                        if (ano.length() == 1) {
                            ano = "0" + ano;
                        }

                        doc.add(new Paragraph("Horário -> " + hora + ":" + minuto + ":" + segundo));
                        doc.add(new Paragraph("Data -> " + dia + "/" + mes + "/" + ano));
                        doc.add(new Paragraph(" "));

                        //Fim - Horário
                        //Início da tabela
                        PdfPTable tabela = new PdfPTable(new float[]{0.34f, 0.33f, 0.33f});

                        tabela.addCell(new Phrase("Produto"));
                        tabela.addCell(new Phrase("Preço total (R$)"));
                        tabela.addCell(new Phrase("Quantidade (quantidade ou peso)"));

                        for (int i = 0; i < venda.getRowCount(); i++) {
                            tabela.addCell(new Phrase(venda.getValueAt(i, 0).toString()));
                            tabela.addCell(new Phrase(venda.getValueAt(i, 1).toString()));
                            tabela.addCell(new Phrase(venda.getValueAt(i, 2).toString()));
                        }
                        doc.add(tabela);

                        //Calculando os valores
                        double desconto = 0;
                        double dinheiro = Double.parseDouble(txtDinheiro.getText());

                        if (!txtDesconto.getText().equals("")) {
                            desconto = Double.parseDouble(txtDesconto.getText());
                        }

                        double preco_total = arrumaJTable();
                        double preco_final = preco_total - desconto;
                        double troco = dinheiro - preco_final;

                        doc.add(new Paragraph("Preço total: " + preco_total));
                        doc.add(new Paragraph("Desconto: " + desconto));
                        doc.add(new Paragraph("Preço final: " + preco_final));
                        doc.add(new Paragraph("Dinheiro: " + dinheiro));
                        doc.add(new Paragraph("Troco: " + troco));

                        //Fim - Calculando os valores
                        //Fim - Tabela
                        doc.close();
                        os.close();
                        Desktop.getDesktop().open(new File(file.getAbsoluteFile() + ".pdf"));

                        //Finalização do PDF
                        //Salvar a venda no banco de dados
                        VendaBean obj_venda = new VendaBean();
                        VendaDAO query_venda = new VendaDAO();

                        for (int j = 0; j < venda.getRowCount(); j++) {
                            obj_venda.setCliente(cliente);
                            obj_venda.setHora(hora);
                            obj_venda.setMinuto(minuto);
                            obj_venda.setSegundo(segundo);
                            obj_venda.setDia(dia);
                            obj_venda.setMes(mes);
                            obj_venda.setAno(ano);
                            obj_venda.setNvenda(dia + mes + ano + hora + minuto + segundo);
                            obj_venda.setProduto(venda.getValueAt(j, 0).toString());
                            obj_venda.setQtdoupe(Double.parseDouble(venda.getValueAt(j, 2).toString()));
                            obj_venda.setPreco(Double.parseDouble(venda.getValueAt(j, 1).toString()));
                            obj_venda.setDesc(desconto);

                            obj_venda.setPrecoreal(Double.parseDouble(venda.getValueAt(j, 3).toString()));

                            query_venda.create(obj_venda);
                        }
                        EstoqueDAO query_estoque = new EstoqueDAO();
                        for (int g = 0; g < qtdBanco.size(); g++) {
                            query_estoque.retiraEstoque(ingredBanco.get(g), qtdBanco.get(g));
                        }
                        //Fim - Salvar a venda no banco de dados
                    } catch (DocumentException | IOException | NumberFormatException e) {
                        System.out.println(e);
                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingredientes faltando: " + ingred_faltando);
            }
        } else if (venda.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Tabela de compra vazia.");
        } else if (txtDinheiro.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo dinheiro vazio.");
        }
    }

    public void semPDF() {
        if (venda.getRowCount() > 0) {
            boolean podeComprar = validaVenda();

            if (podeComprar) {
                String cliente = cxaClientes.getSelectedItem().toString();

                Calendar cal = new GregorianCalendar();

                String hora = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
                String minuto = Integer.toString(cal.get(Calendar.MINUTE));
                String segundo = Integer.toString(cal.get(Calendar.SECOND));

                if (hora.length() == 1) {
                    hora = "0" + hora;
                }
                if (minuto.length() == 1) {
                    minuto = "0" + minuto;
                }
                if (segundo.length() == 1) {
                    segundo = "0" + segundo;
                }

                String dia = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
                String mes = Integer.toString((cal.get(Calendar.MONTH) + 1));
                String ano = Integer.toString(cal.get(Calendar.YEAR));

                if (dia.length() == 1) {
                    dia = "0" + dia;
                }
                if (mes.length() == 1) {
                    mes = "0" + mes;
                }
                if (ano.length() == 1) {
                    ano = "0" + ano;
                }

                //Calculando os valores
                double desconto = 0;
                double dinheiro = Double.parseDouble(txtDinheiro.getText());

                if (!txtDesconto.getText().equals("")) {
                    desconto = Double.parseDouble(txtDesconto.getText());
                }

                double preco_total = arrumaJTable();
                double preco_final = preco_total - desconto;
                double troco = dinheiro - preco_final;

                //Salvar a venda no banco de dados
                VendaBean obj_venda = new VendaBean();
                VendaDAO query_venda = new VendaDAO();

                for (int j = 0; j < venda.getRowCount(); j++) {
                    obj_venda.setCliente(cliente);
                    obj_venda.setHora(hora);
                    obj_venda.setMinuto(minuto);
                    obj_venda.setSegundo(segundo);
                    obj_venda.setDia(dia);
                    obj_venda.setMes(mes);
                    obj_venda.setAno(ano);
                    obj_venda.setNvenda(dia + mes + ano + hora + minuto + segundo);
                    obj_venda.setProduto(venda.getValueAt(j, 0).toString());
                    obj_venda.setQtdoupe(Double.parseDouble(venda.getValueAt(j, 2).toString()));
                    obj_venda.setPreco(Double.parseDouble(venda.getValueAt(j, 1).toString()));
                    obj_venda.setPrecoreal(Double.parseDouble(venda.getValueAt(j, 3).toString()));
                    obj_venda.setDesc(desconto);

                    query_venda.create(obj_venda);
                }
                EstoqueDAO query_estoque = new EstoqueDAO();
                for (int g = 0; g < qtdBanco.size(); g++) {
                    query_estoque.retiraEstoque(ingredBanco.get(g), qtdBanco.get(g));
                }
                //Fim - Salvar a venda no banco de dados
            } else {
                ArrayList<String> ingred_faltando = new ArrayList<>();

                for (int i = 0; i < index_faltando.size(); i++) {
                    ingred_faltando.add(ingredBanco.get(index_faltando.get(i)));
                }

                JOptionPane.showMessageDialog(null, "Ingredientes faltando: " + ingred_faltando);
            }
        } else if (venda.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Tabela de compra vazia.");
        } else if (txtDinheiro.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo dinheiro vazio.");
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String[] botoes = {"Cancelar", "Não", "Sim"};
        int res;
        res = JOptionPane.showOptionDialog(null, "Deseja que o PDF de venda seja feito?", null, JOptionPane.CLOSED_OPTION, JOptionPane.QUESTION_MESSAGE, null, botoes, null);
        if (res == 0) {

        } else if (res == 1) {
            semPDF();
        } else if (res == 2) {
            comPDF();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String nome_produto = cxaProdutos.getSelectedItem().toString();

        ArrayList<String> produtos = new ArrayList<>();
        for (int i = 0; i < venda.getRowCount(); i++) {
            produtos.add(venda.getValueAt(i, 0).toString());
        }

        boolean existeProduto = false;

        for (int j = 0; j < venda.getRowCount(); j++) {
            if (nome_produto.equals(produtos.get(j))) {
                existeProduto = true;
            }
        }

        if (!existeProduto) {

            double qtdes = 0;

            if (txtqtd.getText().equals("")) {
                qtdes = 1;
            } else {
                qtdes = Double.parseDouble(txtqtd.getText());
            }

            DefaultTableModel modelo = (DefaultTableModel) venda.getModel();

            ProdutosDAO dao = new ProdutosDAO();
            ProdutoBean bean = dao.selecionarProduto(nome_produto);

            modelo.addRow(new Object[]{
                bean.getNp(),
                bean.getPrev() * qtdes,
                qtdes,
                bean.getPrec() * qtdes
            });

            contaProduto_receita(nome_produto);
            retiraBanco();
            lblPrecoFinal.setText(Double.toString(arrumaJTable()));

        } else {
            JOptionPane.showMessageDialog(null, "Produto já adicionado na tabela.");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cxaProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxaProdutosActionPerformed

    }//GEN-LAST:event_cxaProdutosActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        pesqN();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        double desconto = 0;
        double dinheiro = 0;
        double troco = 0;
        double precototal = Double.parseDouble(lblPrecoFinal.getText());

        if (!txtDinheiro.getText().equals("")) {
            if (!txtDesconto.getText().equals("")) {
                desconto = Double.parseDouble(txtDesconto.getText());
            } else {
                desconto = 0;
            }
            if (!txtDinheiro.getText().equals("")) {
                dinheiro = Double.parseDouble(txtDinheiro.getText());
            } else {
                dinheiro = 0;
            }
            troco = dinheiro - (precototal - desconto);

            if (troco >= 0) {
                txtTroco.setText(Double.toString(troco));
            } else {
                JOptionPane.showMessageDialog(null, "Dinheiro insuficiente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campo dinheiro não pode estar vazio.");
        }

    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaFazerVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFazerVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFazerVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFazerVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFazerVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cxaClientes;
    private javax.swing.JComboBox<String> cxaProdutos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPrecoFinal;
    private javax.swing.JTextField txtDesconto;
    private javax.swing.JTextField txtDinheiro;
    private javax.swing.JLabel txtTroco;
    private javax.swing.JTextField txtbusca;
    private javax.swing.JTextField txtqtd;
    private javax.swing.JTable venda;
    // End of variables declaration//GEN-END:variables
}
