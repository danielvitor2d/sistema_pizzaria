package telas;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import graficos.Grafico_Produto;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.bean.ClienteBean;
import model.bean.CustoBean;
import model.bean.EstoqueBean;
import model.bean.ProdutoBean;
import model.bean.ReceitaBean;
import model.bean.VendaBean;
import model.dao.ClienteDAO;
import model.dao.CustoDAO;
import model.dao.EstoqueDAO;
import model.dao.ProdutosDAO;
import model.dao.ReceitaDAO;
import model.dao.VendaDAO;
import model.dao.bairros;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Relatorios extends javax.swing.JFrame {

    public Relatorios() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon icone = new ImageIcon("images/ligeirinho.png");
        setIconImage(icone.getImage());
        initComponents();
        readJComboBox1();
        readJComboBox2();
        readJComboBox3();
        readJComboBox4();
        readComboCliente();
        readComboProduto();

        cbbMesAno.addItem("Último mês");
        cbbMesAno.addItem("Último ano");

        cbbMesAno1.addItem("Último mês");
        cbbMesAno1.addItem("Último ano");

        cbbMesAno2.addItem("Último mês");
        cbbMesAno2.addItem("Último ano");
    }
    DecimalFormat df = new DecimalFormat("0.##");

    public void readJComboBox1() {
        ReceitaDAO dao = new ReceitaDAO();

        cxaReceitas.removeAllItems();

        for (ReceitaBean b : dao.readForJComboBox()) {
            cxaReceitas.addItem(b.getReceita());
        }
    }

    public void readJComboBox4() {
        VendaDAO dao = new VendaDAO();
        cxaDataMen.removeAllItems();
        for (VendaBean b : dao.readForJComboBox4()) {
            String data = b.getMes() + "/" + b.getAno();
            cxaDataMen.addItem(data);
        }

    }

    public void readJComboBox2() {
        CustoDAO dao = new CustoDAO();

        cxaData.removeAllItems();

        for (CustoBean b : dao.readForJComboBox()) {
            String data = b.getDia() + "/" + b.getMes() + "/" + b.getAno();
            cxaData.addItem(data);
        }
    }

    public void readJComboBox3() {
        VendaDAO dao = new VendaDAO();

        cxaDataVenda.removeAllItems();

        for (VendaBean b : dao.readForJComboBox3()) {
            String data = b.getDia() + "/" + b.getMes() + "/" + b.getAno();
            cxaDataVenda.addItem(data);
        }
    }

    public void readComboCliente() {
        ClienteDAO dao = new ClienteDAO();

        cbbClientes2.removeAllItems();

        List<ClienteBean> cls = dao.read();
        for (int j = 0; j < cls.size(); j++) {
            cbbClientes2.addItem(cls.get(j).getNome());
        }

    }

    public void readComboProduto() {
        ProdutosDAO dao = new ProdutosDAO();

        cbbClientes.removeAllItems();

        List<ProdutoBean> cls = dao.read();
        System.out.println("arii");
        for (ProdutoBean pb : cls) {
            System.out.println("veja:   " + pb.getNp());
            cbbClientes.addItem(pb.getNp());
        }

    }

    public void Intervalo(String dataInicial, String dataFinal) {
        int resl = dataInicial.compareTo(dataFinal);
        if (resl > 0) {
            JOptionPane.showMessageDialog(null, "A data inicial esta sendo maior que a final.");
        } else {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cxaReceitas = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cxaData = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cxaDataVenda = new javax.swing.JComboBox<>();
        dia = new javax.swing.JRadioButton();
        mes = new javax.swing.JRadioButton();
        cxaDataMen = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbbClientes = new javax.swing.JComboBox<>();
        cbbClientes2 = new javax.swing.JComboBox<>();
        cbbMesAno = new javax.swing.JComboBox<>();
        cbbMesAno1 = new javax.swing.JComboBox<>();
        cbbMesAno2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("RELATÓRIOS");

        jButton1.setBackground(new java.awt.Color(254, 254, 254));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdficon.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(254, 254, 254));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdficon.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(254, 254, 254));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdficon.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(254, 254, 254));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdficon.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Clientes :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Clientes por Bairro:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Ingredientes");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Receitas:");

        cxaReceitas.setBackground(new java.awt.Color(254, 254, 254));
        cxaReceitas.setForeground(new java.awt.Color(1, 1, 1));

        jButton5.setBackground(new java.awt.Color(1, 1, 1));
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(254, 254, 254));
        jButton5.setText("Voltar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(254, 254, 254));
        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdficon.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Custos:");

        jButton7.setBackground(new java.awt.Color(254, 254, 254));
        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdficon.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Produtos:");

        jButton8.setBackground(new java.awt.Color(254, 254, 254));
        jButton8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdficon.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("Geral:");

        cxaData.setBackground(new java.awt.Color(254, 254, 254));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Gráfico de Produtos");

        cxaDataVenda.setBackground(new java.awt.Color(254, 254, 254));

        dia.setText("Geral Diário");
        dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diaActionPerformed(evt);
            }
        });

        mes.setText("Geral Mensal");
        mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesActionPerformed(evt);
            }
        });

        cxaDataMen.setBackground(new java.awt.Color(254, 254, 254));

        jButton9.setBackground(new java.awt.Color(254, 254, 254));
        jButton9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdficon.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(254, 254, 254));
        jButton10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdficon.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(254, 254, 254));
        jButton11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdficon.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setText("Data dos Custos:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Gráfico de Compras");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Gráfico de Produtos por Cliente");

        cbbClientes.setBackground(new java.awt.Color(254, 254, 254));
        cbbClientes.setForeground(new java.awt.Color(1, 1, 1));

        cbbClientes2.setBackground(new java.awt.Color(254, 254, 254));
        cbbClientes2.setForeground(new java.awt.Color(1, 1, 1));
        cbbClientes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbClientes2ActionPerformed(evt);
            }
        });

        cbbMesAno.setBackground(new java.awt.Color(254, 254, 254));
        cbbMesAno.setForeground(new java.awt.Color(1, 1, 1));

        cbbMesAno1.setBackground(new java.awt.Color(254, 254, 254));
        cbbMesAno1.setForeground(new java.awt.Color(1, 1, 1));

        cbbMesAno2.setBackground(new java.awt.Color(254, 254, 254));
        cbbMesAno2.setForeground(new java.awt.Color(1, 1, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(56, 56, 56)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(cxaReceitas, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(81, 81, 81)
                                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbbMesAno, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)
                                        .addComponent(cbbMesAno1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(dia)
                                    .addComponent(mes))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cxaData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cxaDataVenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cxaDataMen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(103, 103, 103))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addContainerGap(24, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbbClientes2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbMesAno2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(dia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(mes))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(cxaData, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cxaDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cxaDataMen, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cbbMesAno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbbMesAno2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbbMesAno1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(116, 116, 116)
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(cxaReceitas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(53, 53, 53)
                                    .addComponent(jLabel7)
                                    .addGap(106, 106, 106))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbClientes2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int returnVal = jFileChooser1.showSaveDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File file = jFileChooser1.getSelectedFile();

            Document doc;
            OutputStream os;
            Font f, f2;

            try {
                doc = new Document(PageSize.A4, -60, -60, 15, 25);
                os = new FileOutputStream(file.getAbsoluteFile() + ".pdf");
                f = new Font(FontFamily.TIMES_ROMAN, 40, Font.BOLD); //fonte do título

                PdfWriter.getInstance(doc, os);
                doc.open();

                Paragraph p = new Paragraph("Clientes cadastrados", f);
                p.setAlignment(Element.ALIGN_CENTER);
                doc.add(p);

                Paragraph p2 = new Paragraph("                             ");
                Paragraph p3 = new Paragraph("                             ");
                doc.add(p2);
                doc.add(p3);

                f2 = new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD);

                Phrase nm = new Phrase("NOME", f2);
                Phrase ru = new Phrase("RUA", f2);
                Phrase nu = new Phrase("NÚMERO", f2);
                Phrase com = new Phrase("COMPLEMENTO", f2);
                Phrase bai = new Phrase("BAIRRO", f2);
                Phrase tele = new Phrase("TELEFONE", f2);

                PdfPTable table = new PdfPTable(new float[]{0.28f, 0.28f, 0.12f, 0.23f, 0.12f, 0.17f});

                ClienteDAO dao = new ClienteDAO();

                table.addCell(nm);
                table.addCell(ru);
                table.addCell(nu);
                table.addCell(com);
                table.addCell(bai);
                table.addCell(tele);

                for (ClienteBean cl : dao.read()) {
                    Phrase nome = new Phrase(cl.getNome(), f2);
                    Phrase rua = new Phrase(cl.getRua(), f2);
                    Phrase ndc = new Phrase(cl.getNumero(), f2);
                    Phrase compl = new Phrase(cl.getComplemento(), f2);
                    Phrase bairro = new Phrase(cl.getBairro(), f2);
                    Phrase tel = new Phrase(cl.getNumerot(), f2);

                    table.addCell(nome);
                    table.addCell(rua);
                    table.addCell(ndc);
                    table.addCell(compl);
                    table.addCell(bairro);
                    table.addCell(tel);
                }
                doc.add(table);

                doc.close();
                os.close();
                Desktop.getDesktop().open(new File(file.getAbsoluteFile() + ".pdf"));

            } catch (FileNotFoundException ex) {
                Logger.getLogger(TelaMenus.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(TelaMenus.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (mes.isSelected() == true) {
            if (cxaData.getItemCount() != 0) {

                if (cxaDataVenda.getItemCount() != 0) {
                    int returnVal = jFileChooser1.showSaveDialog(this);

                    if (returnVal == JFileChooser.APPROVE_OPTION) {

                        File file = jFileChooser1.getSelectedFile();

                        Document doc;
                        OutputStream os;
                        Font f, f2;

                        try {
                            doc = new Document(PageSize.A4, -60, -60, 15, 25);
                            os = new FileOutputStream(file.getAbsoluteFile() + ".pdf");
                            f = new Font(FontFamily.TIMES_ROMAN, 40, Font.BOLD);
                            f2 = new Font(FontFamily.TIMES_ROMAN, 20, Font.NORMAL);

                            PdfWriter.getInstance(doc, os);
                            doc.open();

                            Paragraph p = new Paragraph("Relatório geral", f);
                            p.setAlignment(Element.ALIGN_CENTER);
                            doc.add(p);

                            Paragraph p2 = new Paragraph("                             ");
                            Paragraph p3 = new Paragraph("                             ");
                            doc.add(p2);
                            doc.add(p3);

                            Paragraph title = new Paragraph("Custos", f2);
                            doc.add(title);

                            Phrase ag = new Phrase("Água");
                            Phrase lu = new Phrase("Luz");
                            Phrase tel = new Phrase("Telefone");
                            Phrase inte = new Phrase("Internet");
                            Phrase lim = new Phrase("Limpeza");
                            Phrase piz = new Phrase("Pizzaiolo");
                            Phrase aux = new Phrase("Auxiliar");
                            Phrase cai = new Phrase("Caixa");
                            Phrase ent = new Phrase("Entregador");
                            Phrase dat = new Phrase("Data");

                            PdfPTable table = new PdfPTable(new float[]{0.09f, 0.09f, 0.09f, 0.09f, 0.09f, 0.09f, 0.09f, 0.09f, 0.09f, 0.1f});

                            CustoDAO dao = new CustoDAO();

                            double custo = 0;

                            table.addCell(ag);
                            table.addCell(lu);
                            table.addCell(tel);
                            table.addCell(inte);
                            table.addCell(lim);
                            table.addCell(piz);
                            table.addCell(aux);
                            table.addCell(cai);
                            table.addCell(ent);
                            table.addCell(dat);

                            String data = cxaData.getSelectedItem().toString();

                            int x;
                            int y;
                            x = data.indexOf("/");
                            y = data.lastIndexOf("/");
                            String da = data.substring(0, x);
                            String es = data.substring(x + 1, y);
                            String ano = data.substring(y + 1);

                            for (CustoBean cl : dao.read(da, es, ano)) {
                                Phrase agu = new Phrase(Double.toString(cl.getAgua()));
                                Phrase luz = new Phrase(Double.toString(cl.getLuz()));
                                Phrase te = new Phrase(Double.toString(cl.getTel()));
                                Phrase ne = new Phrase(Double.toString(cl.getNet()));
                                Phrase m = new Phrase(Double.toString(cl.getMl()));
                                Phrase pi = new Phrase(Double.toString(cl.getPiz()));
                                Phrase au = new Phrase(Double.toString(cl.getAux()));
                                Phrase ca = new Phrase(Double.toString(cl.getCai()));
                                Phrase en = new Phrase(Double.toString(cl.getEnt()));

                                double meses = Double.parseDouble(cl.getMes());

                                String mesesint = df.format(meses);

                                Phrase dt = new Phrase(cl.getDia() + "/" + mesesint + "/" + cl.getAno());

                                custo += (cl.getAgua() + cl.getLuz() + cl.getTel() + cl.getNet() + cl.getMl() + cl.getPiz() + cl.getAux() + cl.getCai() + cl.getEnt());

                                table.addCell(agu);
                                table.addCell(luz);
                                table.addCell(te);
                                table.addCell(ne);
                                table.addCell(m);
                                table.addCell(pi);
                                table.addCell(au);
                                table.addCell(ca);
                                table.addCell(en);
                                table.addCell(dt);
                            }
                            doc.add(table);

                            Paragraph cust = new Paragraph("                          O custo total vale R$ " + custo);

                            // Vendas
                            Paragraph title2 = new Paragraph("Vendas", f2);

                            doc.add(title2);

                            Phrase nm1 = new Phrase("PRODUTO");
                            Phrase nu2 = new Phrase("QUANTIDADE");
                            Phrase nu1 = new Phrase("PREÇO TOTAL(R$)");
                            Phrase a1 = new Phrase("PREÇO REAL(R$)");
                            PdfPTable _2121 = new PdfPTable(new float[]{0.25f, 0.25f, 0.25f, 0.25f});

                            _2121.addCell(nm1);
                            _2121.addCell(nu2);
                            _2121.addCell(nu1);
                            _2121.addCell(a1);
                            VendaDAO a = new VendaDAO();

                            String dt = cxaDataMen.getSelectedItem().toString();

                            int x2;
                            x2 = dt.indexOf("/");
                            String ms = dt.substring(0, x2);
                            String ao = dt.substring(x2 + 1);
                            System.out.println("mes" + ms);
                            System.out.println("ano" + ao);
                            double vendafeita = 0;
                            double precoreal = 0;

                            for (VendaBean b : a.readMen(ms, ao)) {
                                Phrase l1 = new Phrase(b.getProduto());
                                Phrase l2 = new Phrase(Double.toString(b.getQtdoupe()));
                                Phrase l3 = new Phrase(Double.toString(b.getPreco()));
                                Phrase l4 = new Phrase(Double.toString(b.getPrecoreal()));
                                precoreal += b.getPrecoreal();
                                vendafeita += (b.getPreco());

                                _2121.addCell(l1);
                                _2121.addCell(l2);
                                _2121.addCell(l3);
                                _2121.addCell(l4);
                            }

                            doc.add(_2121);

                            List<String> nvendas = a.selectAllNVenda(ms, ao);
                            double desconto = 0;

                            for (String str : nvendas) {
                                desconto += a.readDescMes(str, ms, ao);
                            }

                            Paragraph vendafeit = new Paragraph("                         O valor ganho com todas as vendas vale R$ " + vendafeita);
                            Paragraph precoreally = new Paragraph("                         O valor gasto com todas os ingredientes vale R$ " + precoreal);
                            Paragraph descontos = new Paragraph("                         O total dos descontos é de R$ " + desconto);

                            double lucro = vendafeita - precoreal - custo - desconto;

                            Paragraph lucrot = new Paragraph("                         O lucro da pizzaria é de R$ " + lucro);

                            doc.add(cust);
                            doc.add(vendafeit);
                            doc.add(precoreally);
                            doc.add(descontos);
                            doc.add(lucrot);

                            doc.close();
                            os.close();
                            Desktop.getDesktop().open(new File(file.getAbsoluteFile() + ".pdf"));

                        } catch (FileNotFoundException | DocumentException ex) {
                            Logger.getLogger(TelaMenus.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Data não especificada.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Data não especificada.");
            }
        } else if (dia.isSelected() == true) {

            if (cxaData.getItemCount() != 0) {

                if (cxaDataVenda.getItemCount() != 0) {
                    int returnVal = jFileChooser1.showSaveDialog(this);

                    if (returnVal == JFileChooser.APPROVE_OPTION) {

                        File file = jFileChooser1.getSelectedFile();

                        Document doc;
                        OutputStream os;
                        Font f, f2;

                        try {
                            doc = new Document(PageSize.A4, -60, -60, 15, 25);
                            os = new FileOutputStream(file.getAbsoluteFile() + ".pdf");
                            f = new Font(FontFamily.TIMES_ROMAN, 40, Font.BOLD);
                            f2 = new Font(FontFamily.TIMES_ROMAN, 20, Font.NORMAL);

                            PdfWriter.getInstance(doc, os);
                            doc.open();

                            Paragraph p = new Paragraph("Relatório geral", f);
                            p.setAlignment(Element.ALIGN_CENTER);
                            doc.add(p);

                            Paragraph p2 = new Paragraph("                             ");
                            Paragraph p3 = new Paragraph("                             ");
                            doc.add(p2);
                            doc.add(p3);

                            // Vendas
                            Paragraph title2 = new Paragraph("Vendas", f2);

                            doc.add(title2);

                            Phrase nm1 = new Phrase("PRODUTO");
                            Phrase nu2 = new Phrase("QUANTIDADE");
                            Phrase nu1 = new Phrase("PREÇO TOTAL(R$)");
                            Phrase a1 = new Phrase("PREÇO REAL(R$)");
                            Phrase d = new Phrase("Data");
                            PdfPTable _2121 = new PdfPTable(new float[]{0.25f, 0.25f, 0.25f, 0.25f, 0.25f});

                            _2121.addCell(nm1);
                            _2121.addCell(nu2);
                            _2121.addCell(nu1);
                            _2121.addCell(a1);
                            _2121.addCell(d);

                            VendaDAO da = new VendaDAO();

                            String dt = cxaDataVenda.getSelectedItem().toString();

                            int x2;
                            int y2;
                            x2 = dt.indexOf("/");
                            y2 = dt.lastIndexOf("/");
                            String day = dt.substring(0, x2);
                            String ms = dt.substring(x2 + 1, y2);
                            String ao = dt.substring(y2 + 1);
                            System.out.println("dia" + day);
                            System.out.println("mes" + ms);
                            System.out.println("ano" + ao);
                            double vendafeita = 0;
                            double precoreal = 0;

                            for (VendaBean b : da.read(day, ms, ao)) {
                                Phrase l1 = new Phrase(b.getProduto());
                                Phrase l2 = new Phrase(Double.toString(b.getQtdoupe()));
                                Phrase l3 = new Phrase(Double.toString(b.getPreco()));
                                Phrase l4 = new Phrase(Double.toString(b.getPrecoreal()));
                                Phrase l5 = new Phrase(day + "/" + ms + "/" + ao);
                                precoreal += b.getPrecoreal();
                                vendafeita += (b.getPreco());

                                _2121.addCell(l1);
                                _2121.addCell(l2);
                                _2121.addCell(l3);
                                _2121.addCell(l4);
                                _2121.addCell(l5);

                            }

                            doc.add(_2121);

                            List<String> nvendas = da.selectAllNVendaDiaMesAno(day, ms, ao);

                            double desconto = 0;
                            for (String nvenda : nvendas) {
                                desconto += da.readDescDiaMes(nvenda, day, ms, ao);
                            }

                            Paragraph vendafeit = new Paragraph("                         O valor ganho com todas as vendas vale R$ " + vendafeita);
                            Paragraph precoreally = new Paragraph("                         O valor gasto com todas os ingredientes vale R$ " + precoreal);
                            Paragraph descontos = new Paragraph("                         O total dos descontos é de R$ " + desconto);

                            double lucro = vendafeita - precoreal - desconto;

                            Paragraph lucrot = new Paragraph("                         O lucro da pizzaria é de R$ " + lucro);

                            doc.add(vendafeit);
                            doc.add(precoreally);
                            doc.add(descontos);
                            doc.add(lucrot);

                            doc.close();
                            os.close();
                            Desktop.getDesktop().open(new File(file.getAbsoluteFile() + ".pdf"));

                        } catch (FileNotFoundException | DocumentException ex) {
                            Logger.getLogger(TelaMenus.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Data não especificada.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Data não especificada.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Você deve selecionar uma opção, para que o PDF Geral seja gerado", null, JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int returnVal = jFileChooser1.showSaveDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File file = jFileChooser1.getSelectedFile();

            Document doc;
            OutputStream os;
            Font f, f2;

            try {
                doc = new Document(PageSize.A4, -60, -60, 15, 25);
                os = new FileOutputStream(file.getAbsoluteFile() + ".pdf");
                f = new Font(FontFamily.TIMES_ROMAN, 40, Font.BOLD); //fonte do título

                PdfWriter.getInstance(doc, os);
                doc.open();

                Paragraph p = new Paragraph("Estoque", f);
                p.setAlignment(Element.ALIGN_CENTER);
                doc.add(p);

                Paragraph p2 = new Paragraph("                             ");
                Paragraph p3 = new Paragraph("                             ");
                doc.add(p2);
                doc.add(p3);

                f2 = new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD);

                Phrase nm = new Phrase("INGREDIENTE", f2);
                Phrase com = new Phrase("QUANTIDADE", f2);
                Phrase bai = new Phrase("PREÇO DA UNIDADE", f2);
                Phrase tele = new Phrase("PREÇO TOTAL(R$)", f2);

                PdfPTable table = new PdfPTable(new float[]{0.17f, 0.17f, 0.17f, 0.17f});

                EstoqueDAO dao = new EstoqueDAO();

                table.addCell(nm);
                table.addCell(com);
                table.addCell(bai);
                table.addCell(tele);

                for (EstoqueBean cl : dao.read()) {
                    Phrase produto = new Phrase(cl.getProd(), f2);
                    Phrase qtd = new Phrase(Double.toString(cl.getQdtoupe()), f2);
                    Phrase preco = new Phrase(Double.toString(cl.getPreco()), f2);
                    Phrase precotot = new Phrase(Double.toString(cl.getQdtoupe() * cl.getPreco()), f2);

                    table.addCell(produto);
                    table.addCell(qtd);
                    table.addCell(preco);
                    table.addCell(precotot);
                }
                doc.add(table);

                doc.close();
                os.close();
                Desktop.getDesktop().open(new File(file.getAbsoluteFile() + ".pdf"));

            } catch (FileNotFoundException ex) {
                Logger.getLogger(TelaMenus.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(TelaMenus.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int returnVal = jFileChooser1.showSaveDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File file = jFileChooser1.getSelectedFile();

            Document doc;
            OutputStream os;
            Font f, f2, f3, f4;

            try {
                ReceitaDAO dao = new ReceitaDAO();

                doc = new Document(PageSize.A4, 15, 15, 15, 25);
                os = new FileOutputStream(file.getAbsoluteFile() + ".pdf");
                f = new Font(FontFamily.TIMES_ROMAN, 40, Font.BOLD); //fonte do título

                PdfWriter.getInstance(doc, os);
                doc.open();

                Paragraph p = new Paragraph("Receita - " + cxaReceitas.getSelectedItem().toString(), f);
                p.setAlignment(Element.ALIGN_CENTER);
                doc.add(p);

                Paragraph p2 = new Paragraph("                             ");
                Paragraph p3 = new Paragraph("                             ");
                doc.add(p2);
                doc.add(p3);

                f2 = new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD);
                f3 = new Font(FontFamily.SYMBOL, 8, Font.STRIKETHRU);

                Phrase nm = new Phrase("PRODUTO", f2);
                Phrase ru = new Phrase("QUANTIDADE OU PESO(em gramas)", f2);
                Phrase nu = new Phrase("PREÇO TOTAL(R$)", f2);

                PdfPTable table = new PdfPTable(new float[]{0.33f, 0.33f, 0.34f});

                table.addCell(nm);
                table.addCell(ru);
                table.addCell(nu);

                for (ReceitaBean cl : dao.read(cxaReceitas.getSelectedItem().toString())) {
                    Phrase produto = new Phrase(cl.getProduto(), f2);
                    Phrase qtdoupe = new Phrase(Double.toString(cl.getQtdoupeso()), f2);
                    Phrase precototal = new Phrase(Double.toString(cl.getPrecofinal()), f2);

                    table.addCell(produto);
                    table.addCell(qtdoupe);
                    table.addCell(precototal);
                }

                doc.add(table);

                Phrase frase = new Phrase("Preço total: " + dao.precototal(cxaReceitas.getSelectedItem().toString()));

                doc.add(frase);

                doc.close();
                os.close();
                Desktop.getDesktop().open(new File(file.getAbsoluteFile() + ".pdf"));

            } catch (FileNotFoundException ex) {
                Logger.getLogger(TelaMenus.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(TelaMenus.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        TelaMenus menu = new TelaMenus();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int returnVal = jFileChooser1.showSaveDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File file = jFileChooser1.getSelectedFile();

            Document doc;
            OutputStream os;
            Font f, f2;

            try {
                doc = new Document(PageSize.A4, -60, -60, 15, 25);
                os = new FileOutputStream(file.getAbsoluteFile() + ".pdf");
                f = new Font(FontFamily.TIMES_ROMAN, 40, Font.BOLD); //fonte do título

                PdfWriter.getInstance(doc, os);
                doc.open();

                Paragraph p = new Paragraph("Custos", f);
                p.setAlignment(Element.ALIGN_CENTER);
                doc.add(p);

                Paragraph p2 = new Paragraph("                             ");
                Paragraph p3 = new Paragraph("                             ");
                doc.add(p2);
                doc.add(p3);

                f2 = new Font(FontFamily.TIMES_ROMAN, 15, Font.BOLD);

                Paragraph title = new Paragraph("Custos", f2);
                doc.add(title);

                Phrase ag = new Phrase("Água");
                Phrase lu = new Phrase("Luz");
                Phrase tel = new Phrase("Telefone");
                Phrase inte = new Phrase("Internet");
                Phrase gas = new Phrase("Gás");
                Phrase lim = new Phrase("Limpeza");
                Phrase piz = new Phrase("Pizzaiolo");
                Phrase aux = new Phrase("Auxiliar");
                Phrase cai = new Phrase("Caixa");
                Phrase dat = new Phrase("Data");
                Phrase ent = new Phrase("Entregador");

                PdfPTable table = new PdfPTable(new float[]{0.09f, 0.09f, 0.09f, 0.09f, 0.09f, 0.09f, 0.09f, 0.09f, 0.09f, 0.09f, 0.1f});

                CustoDAO dao = new CustoDAO();

                double custo = 0;

                table.addCell(ag);
                table.addCell(lu);
                table.addCell(tel);
                table.addCell(inte);
                table.addCell(gas);
                table.addCell(lim);
                table.addCell(piz);
                table.addCell(aux);
                table.addCell(cai);
                table.addCell(ent);
                table.addCell(dat);

                for (CustoBean cl : dao.read()) {
                    Phrase agu = new Phrase(Double.toString(cl.getAgua()));
                    Phrase luz = new Phrase(Double.toString(cl.getLuz()));
                    Phrase te = new Phrase(Double.toString(cl.getTel()));
                    Phrase ne = new Phrase(Double.toString(cl.getNet()));
                    Phrase ga = new Phrase(Double.toString(cl.getGas()));
                    Phrase m = new Phrase(Double.toString(cl.getMl()));
                    Phrase pi = new Phrase(Double.toString(cl.getPiz()));
                    Phrase au = new Phrase(Double.toString(cl.getAux()));
                    Phrase ca = new Phrase(Double.toString(cl.getCai()));
                    Phrase en = new Phrase(Double.toString(cl.getEnt()));
                    Phrase dt = new Phrase(cl.getDia() + "/" + cl.getMes() + "/" + cl.getAno());

                    custo += (cl.getAgua() + cl.getLuz() + cl.getTel() + cl.getNet() + cl.getGas() + cl.getMl() + cl.getPiz() + cl.getAux() + cl.getCai() + cl.getEnt());

                    table.addCell(agu);
                    table.addCell(luz);
                    table.addCell(te);
                    table.addCell(ne);
                    table.addCell(ga);
                    table.addCell(m);
                    table.addCell(pi);
                    table.addCell(au);
                    table.addCell(ca);
                    table.addCell(en);
                    table.addCell(dt);
                }
                doc.add(table);

                Paragraph cust = new Paragraph("                                    O custo total vale R$ " + custo, f2);
                doc.add(cust);

                doc.close();
                os.close();
                Desktop.getDesktop().open(new File(file.getAbsoluteFile() + ".pdf"));

            } catch (FileNotFoundException ex) {
                Logger.getLogger(TelaMenus.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(TelaMenus.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int returnVal = jFileChooser1.showSaveDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File file = jFileChooser1.getSelectedFile();

            // TODO add your handling code here:
            Document doc;
            OutputStream os;
            Font f, f2;

            try {
                doc = new Document(PageSize.A4, -60, -60, 15, 25);
                os = new FileOutputStream(file.getAbsoluteFile() + ".pdf");
                f = new Font(FontFamily.TIMES_ROMAN, 40, Font.BOLD); //fonte do título

                PdfWriter.getInstance(doc, os);
                doc.open();

                Paragraph p = new Paragraph("Produtos", f);
                p.setAlignment(Element.ALIGN_CENTER);
                doc.add(p);

                Paragraph p2 = new Paragraph("                             ");
                Paragraph p3 = new Paragraph("                             ");
                doc.add(p2);
                doc.add(p3);

                f2 = new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD);

                Phrase np = new Phrase("Nome do Produto", f2);
                Phrase pr = new Phrase("Preço real", f2);
                Phrase pre = new Phrase("Preço de venda", f2);
                Phrase pl = new Phrase("Percentual de Lucro (%)", f2);

                PdfPTable table = new PdfPTable(new float[]{0.09f, 0.09f, 0.09f, 0.09f});

                ProdutosDAO dao = new ProdutosDAO();

                table.addCell(np);
                table.addCell(pr);
                table.addCell(pre);
                table.addCell(pl);
                for (ProdutoBean cl : dao.read()) {
                    Phrase n = new Phrase(cl.getNp(), f2);
                    Phrase pe = new Phrase(Double.toString(cl.getPrec()), f2);
                    Phrase r = new Phrase(Double.toString(cl.getPrev()), f2);
                    Phrase l = new Phrase(df.format(cl.getPl()), f2);

                    table.addCell(n);
                    table.addCell(pe);
                    table.addCell(r);
                    table.addCell(l);
                }
                doc.add(table);

                doc.close();
                os.close();
                Desktop.getDesktop().open(new File(file.getAbsoluteFile() + ".pdf"));

            } catch (FileNotFoundException ex) {
                Logger.getLogger(TelaMenus.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(TelaMenus.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int returnVal = jFileChooser1.showSaveDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File file = jFileChooser1.getSelectedFile();

            Document document;
            PdfWriter writer;
            PdfContentByte content;
            PdfTemplate template;
            Graphics2D graphics;
            Rectangle2D rectangle;
            JFreeChart chart;
            DefaultCategoryDataset dataSet;
            document = new Document();
            try {
                writer = PdfWriter.getInstance(document, new FileOutputStream(file.getAbsoluteFile() + ".pdf"));
                Rectangle pgz = writer.getPageSize();
                int x1 = 0;
                int y1 = 0;
                int x2 = (int) pgz.getWidth();
                int y2 = (int) pgz.getHeight();
                document.open();
                content = writer.getDirectContent();
                template = content.createTemplate(x2, y2);
                graphics = template.createGraphics(x2, y2);
                rectangle = new Rectangle2D.Double(x1, y1, x2, y2);
                dataSet = new DefaultCategoryDataset();

                ClienteDAO dao = new ClienteDAO();

                for (bairros b : dao.bairros()) {

                    dataSet.setValue(dao.contBairro(b.getBairro()), "Clientes", b.getBairro());

                }
                chart = ChartFactory.createBarChart("Clientes por bairro", "Bairros", "Quantidade de Clientes", dataSet, PlotOrientation.VERTICAL, true, true, true);
                chart.draw(graphics, rectangle);
                graphics.dispose();
                content.addTemplate(template, 0, 0);
                document.close();
                Desktop.getDesktop().open(new File(file.getAbsoluteFile() + ".pdf"));
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesActionPerformed
        // TODO add your handling code here:
        if (mes.isSelected() == true) {
            dia.setEnabled(false);
            cxaDataVenda.setEnabled(false);
        } else {
            dia.setEnabled(true);
            cxaDataVenda.setEnabled(true);
        }

    }//GEN-LAST:event_mesActionPerformed

    private void diaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diaActionPerformed
        // TODO add your handling code here:
        if (dia.isSelected() == true) {
            mes.setEnabled(false);
            cxaDataMen.setEnabled(false);
            cxaData.setEnabled(false);
        } else {
            mes.setEnabled(true);
            cxaDataMen.setEnabled(true);
            cxaData.setEnabled(true);
        }
    }//GEN-LAST:event_diaActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (cbbMesAno.getSelectedItem().toString().equals("Último mês")) {
            List<String> nomes = new ArrayList<>();
            List<Double> qtd = new ArrayList<>();

            List<VendaBean> vendaB = new ArrayList<>();
            VendaDAO dao = new VendaDAO();

            LocalDate hoje = LocalDate.now();
            for (int i = 0; i < 30; i++) {
                List<VendaBean> vendaBean = dao.listVendasForDay(String.valueOf(hoje.getDayOfMonth()), String.valueOf(hoje.getMonthValue()), String.valueOf(hoje.getYear()));
                for (int j = 0; j < vendaBean.size(); j++) {
                    vendaB.add(vendaBean.get(j));
                }
                LocalDate ontem = hoje.minusDays(1);
                hoje = null;
                hoje = ontem;
            }

            for (VendaBean vB : vendaB) {
                if (!nomes.contains(vB.getProduto())) {
                    nomes.add(vB.getProduto());
                    qtd.add(vB.getQtdoupe());
                } else {
                    int indice = nomes.indexOf(vB.getProduto());
                    qtd.set(indice, qtd.get(indice) + vB.getQtdoupe());
                }
            }

            Grafico_Produto gp = new Grafico_Produto();

            gp.criarGrafico(nomes, qtd, "Produto", "Quantidade", "Venda de Produtos");
        } else if (cbbMesAno.getSelectedItem().toString().equals("Último ano")) {
            List<String> nomes = new ArrayList<>();
            List<Double> qtd = new ArrayList<>();

            List<VendaBean> vendaB = new ArrayList<>();
            VendaDAO dao = new VendaDAO();

            LocalDate hoje = LocalDate.now();
            for (int i = 0; i < 365; i++) {
                List<VendaBean> vendaBean = dao.listVendasForDay(String.valueOf(hoje.getDayOfMonth()), String.valueOf(hoje.getMonthValue()), String.valueOf(hoje.getYear()));
                for (int j = 0; j < vendaBean.size(); j++) {
                    vendaB.add(vendaBean.get(j));
                }
                LocalDate ontem = hoje.minusDays(1);
                hoje = null;
                hoje = ontem;
            }

            for (VendaBean vB : vendaB) {
                if (!nomes.contains(vB.getProduto())) {
                    nomes.add(vB.getProduto());
                    qtd.add(vB.getQtdoupe());
                } else {
                    int indice = nomes.indexOf(vB.getProduto());
                    qtd.set(indice, qtd.get(indice) + vB.getQtdoupe());
                }
            }

            Grafico_Produto gp = new Grafico_Produto();

            gp.criarGrafico(nomes, qtd, "Produto", "Quantidade", "Venda de Produtos");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (cbbMesAno1.getSelectedItem().toString().equals("Último mês")) {
            List<String> nome = new ArrayList<>();
            List<Double> qtd = new ArrayList<>();

            List<VendaBean> vendB = new ArrayList<>();

            VendaDAO dao = new VendaDAO();

            LocalDate hoje = LocalDate.now();
            for (int i = 0; i < 30; i++) {
                List<VendaBean> venda = dao.listVendasForDayCLient(String.valueOf(hoje.getDayOfMonth()), String.valueOf(hoje.getMonthValue()), String.valueOf(hoje.getYear()), cbbClientes2.getSelectedItem().toString());
                for (int j = 0; j < venda.size(); j++) {
                    vendB.add(venda.get(j));
                }
                LocalDate ontem = hoje.minusDays(1);
                hoje = null;
                hoje = ontem;
            }

            for (VendaBean vB : vendB) {
                if (!nome.contains(vB.getProduto())) {
                    nome.add(vB.getProduto());
                    qtd.add(vB.getQtdoupe());
                } else {
                    int indice = nome.indexOf(vB.getProduto());
                    qtd.set(indice, qtd.get(indice) + vB.getQtdoupe());
                }
            }

            Grafico_Produto gra = new Grafico_Produto();
            gra.criarGrafico(nome, qtd, "Produto", "Quantidade", "Compras por cliente");
        } else if (cbbMesAno1.getSelectedItem().toString().equals("Último ano")) {
            List<String> nome = new ArrayList<>();
            List<Double> qtd = new ArrayList<>();

            List<VendaBean> vendB = new ArrayList<>();

            VendaDAO dao = new VendaDAO();

            LocalDate hoje = LocalDate.now();
            for (int i = 0; i < 365; i++) {
                List<VendaBean> venda = dao.listVendasForDayCLient(String.valueOf(hoje.getDayOfMonth()), String.valueOf(hoje.getMonthValue()), String.valueOf(hoje.getYear()), cbbClientes2.getSelectedItem().toString());
                for (int j = 0; j < venda.size(); j++) {
                    vendB.add(venda.get(j));
                }
                LocalDate ontem = hoje.minusDays(1);
                hoje = null;
                hoje = ontem;
            }

            for (VendaBean vB : vendB) {
                if (!nome.contains(vB.getProduto())) {
                    nome.add(vB.getProduto());
                    qtd.add(vB.getQtdoupe());
                } else {
                    int indice = nome.indexOf(vB.getProduto());
                    qtd.set(indice, qtd.get(indice) + vB.getQtdoupe());
                }
            }

            Grafico_Produto gra = new Grafico_Produto();
            gra.criarGrafico(nome, qtd, "Produto", "Quantidade", "Compras por cliente");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if (cbbMesAno2.getSelectedItem().toString().equals("Último mês")) {
            List<String> nome = new ArrayList<>();
            List<Double> qtd = new ArrayList<>();

            List<VendaBean> vendB = new ArrayList<>();

            VendaDAO dao = new VendaDAO();

            LocalDate hoje = LocalDate.now();
            for (int i = 0; i < 30; i++) {
                List<VendaBean> venda = dao.listVendasForDayProd(String.valueOf(hoje.getDayOfMonth()), String.valueOf(hoje.getMonthValue()), String.valueOf(hoje.getYear()), cbbClientes.getSelectedItem().toString());
                for (int j = 0; j < venda.size(); j++) {
                    vendB.add(venda.get(j));
                }
                LocalDate ontem = hoje.minusDays(1);
                hoje = null;
                hoje = ontem;
            }

            for (VendaBean vB : vendB) {
                if (!nome.contains(vB.getCliente())) {
                    nome.add(vB.getCliente());
                    qtd.add(vB.getQtdoupe());
                } else {
                    int indice = nome.indexOf(vB.getCliente());
                    qtd.set(indice, qtd.get(indice) + vB.getQtdoupe());
                }
            }

            Grafico_Produto gra = new Grafico_Produto();
            gra.criarGrafico(nome, qtd, "Clientes", "Quantidade", "Clientes por produto");

        } else if (cbbMesAno2.getSelectedItem().toString().equals("Último ano")) {
            List<String> nome = new ArrayList<>();
            List<Double> qtd = new ArrayList<>();

            List<VendaBean> vendB = new ArrayList<>();

            VendaDAO dao = new VendaDAO();

            LocalDate hoje = LocalDate.now();
            for (int i = 0; i < 365; i++) {
                List<VendaBean> venda = dao.listVendasForDayProd(String.valueOf(hoje.getDayOfMonth()), String.valueOf(hoje.getMonthValue()), String.valueOf(hoje.getYear()), cbbClientes.getSelectedItem().toString());
                for (int j = 0; j < venda.size(); j++) {
                    vendB.add(venda.get(j));
                }
                LocalDate ontem = hoje.minusDays(1);
                hoje = null;
                hoje = ontem;
            }

            for (VendaBean vB : vendB) {
                if (!nome.contains(vB.getCliente())) {
                    nome.add(vB.getCliente());
                    qtd.add(vB.getQtdoupe());
                } else {
                    int indice = nome.indexOf(vB.getCliente());
                    qtd.set(indice, qtd.get(indice) + vB.getQtdoupe());
                }
            }

            Grafico_Produto gra = new Grafico_Produto();
            gra.criarGrafico(nome, qtd, "Clientes", "Quantidade", "Clientes por produto");

        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void cbbClientes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbClientes2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbClientes2ActionPerformed

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
            java.util.logging.Logger.getLogger(Relatorios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Relatorios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Relatorios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Relatorios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Relatorios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbClientes;
    private javax.swing.JComboBox<String> cbbClientes2;
    private javax.swing.JComboBox<String> cbbMesAno;
    private javax.swing.JComboBox<String> cbbMesAno1;
    private javax.swing.JComboBox<String> cbbMesAno2;
    private javax.swing.JComboBox<String> cxaData;
    private javax.swing.JComboBox<String> cxaDataMen;
    private javax.swing.JComboBox<String> cxaDataVenda;
    private javax.swing.JComboBox<String> cxaReceitas;
    private javax.swing.JRadioButton dia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton mes;
    // End of variables declaration//GEN-END:variables
}
