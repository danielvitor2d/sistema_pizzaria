package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.ClienteBean;
import model.bean.EstoqueBean;
import model.bean.VendaBean;

public class VendaDAO {

    public void create(VendaBean bean) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO vendas (cliente, produto, preco, quantidade, hora, minuto, segundo, nvenda, precoreal, dia, mes, ano, desconto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, bean.getCliente());
            stmt.setString(2, bean.getProduto());
            stmt.setDouble(3, bean.getPreco());
            stmt.setDouble(4, bean.getQtdoupe());
            stmt.setString(5, bean.getHora());
            stmt.setString(6, bean.getMinuto());
            stmt.setString(7, bean.getSegundo());
            stmt.setString(8, bean.getNvenda());
            stmt.setDouble(9, bean.getPrecoreal());
            stmt.setString(10, bean.getDia());
            stmt.setString(11, bean.getMes());
            stmt.setString(12, bean.getAno());
            stmt.setDouble(13, bean.getDesc());

            stmt.executeUpdate();

            System.out.println("Venda feita com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

    public List<ClienteBean> readForJComboBox() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ClienteBean> cl = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM clientes ORDER BY nome");

            rs = stmt.executeQuery();

            while (rs.next()) {
                ClienteBean cliente = new ClienteBean();

                cliente.setNome(rs.getString("nome"));

                cl.add(cliente);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return cl;
    }

    public void delete() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM vendas");

            stmt.execute();
        } catch (SQLException e) {

            System.out.println(e);
        }
    }

    public List<VendaBean> readForJComboBox3() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<VendaBean> cl = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT DISTINCT dia, mes, ano FROM vendas");

            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaBean cliente = new VendaBean();

                cliente.setDia(rs.getString("dia"));
                cliente.setMes(rs.getString("mes"));
                cliente.setAno(rs.getString("ano"));

                cl.add(cliente);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return cl;
    }

    public List<VendaBean> readForJComboBox4() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<VendaBean> cl = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT DISTINCT mes, ano FROM vendas");

            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaBean cliente = new VendaBean();

                cliente.setMes(rs.getString("mes"));
                cliente.setAno(rs.getString("ano"));

                cl.add(cliente);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return cl;
    }

    public List<EstoqueBean> readForJComboBox2() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<EstoqueBean> es = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT prod FROM estoque");

            rs = stmt.executeQuery();

            while (rs.next()) {
                EstoqueBean estoque = new EstoqueBean();

                estoque.setProd(rs.getString("prod"));

                es.add(estoque);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return es;
    }

    public double returnPreco(String produto) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double preco = 0;

        try {
            stmt = con.prepareStatement("SELECT preco FROM estoque WHERE prod = ?");
            stmt.setString(1, produto);

            rs = stmt.executeQuery();

            while (rs.next()) {
                preco = rs.getDouble("preco");
            }

            System.out.println("Certo");

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        return preco;
    }

    public double returnQtd(String produto) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double qtd = 0;

        try {
            stmt = con.prepareStatement("SELECT qtd FROM estoque WHERE prod = ?");
            stmt.setString(1, produto);

            rs = stmt.executeQuery();

            while (rs.next()) {
                qtd = rs.getDouble("qtd");
            }

            System.out.println("Certo");

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        return qtd;
    }

    public boolean atualEstoque(String produto, double qtdvdd) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        boolean x = false;

        try {
            stmt = con.prepareStatement("UPDATE estoque SET qtd = ? WHERE prod = ?");
            stmt.setDouble(1, qtdvdd);
            stmt.setString(2, produto);

            stmt.executeUpdate();

            x = true;

            System.out.println("Estoque atualizado corretamente!");
        } catch (SQLException e) {
            System.out.println("Produto não disponível o suficiente. " + e);

        }
        return x;
    }

    public List<VendaBean> listVendasForDay(String dia, String mes, String ano) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<VendaBean> lista = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM vendas WHERE dia = ? AND mes = ? AND ano = ?");
            stmt.setString(1, dia);
            stmt.setString(2, mes);
            stmt.setString(3, ano);

            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaBean venda = new VendaBean();
                venda.setProduto(rs.getString("produto"));
                venda.setPreco(rs.getDouble("preco"));
                venda.setQtdoupe(rs.getDouble("quantidade"));
                venda.setCliente(rs.getString("cliente"));
                venda.setPrecoreal(rs.getDouble("precoreal"));
                venda.setDesc(rs.getDouble("desconto"));
                venda.setDia(rs.getString("dia"));
                venda.setMes(rs.getString("mes"));
                venda.setAno(rs.getString("ano"));

                lista.add(venda);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lista;
    }

    public List<VendaBean> listVendasForDayClien(String dia, String mes, String ano, String cliente) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<VendaBean> lista = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM vendas WHERE dia = ? AND mes = ? AND ano = ? AND cliente = ?");
            stmt.setString(1, dia);
            stmt.setString(2, mes);
            stmt.setString(3, ano);
            stmt.setString(4, cliente);

            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaBean venda = new VendaBean();
                venda.setProduto(rs.getString("produto"));
                venda.setPreco(rs.getDouble("preco"));
                venda.setQtdoupe(rs.getDouble("quantidade"));
                venda.setCliente(rs.getString("cliente"));
                venda.setPrecoreal(rs.getDouble("precoreal"));
                venda.setDesc(rs.getDouble("desconto"));
                venda.setDia(rs.getString("dia"));
                venda.setMes(rs.getString("mes"));
                venda.setAno(rs.getString("ano"));

                lista.add(venda);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lista;
    }

    public List<VendaBean> listVendasForDayCLient(String dia, String mes, String ano, String client) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<VendaBean> lista = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM vendas WHERE dia = ? AND mes = ? AND ano = ? AND cliente = ?");
            stmt.setString(1, dia);
            stmt.setString(2, mes);
            stmt.setString(3, ano);
            stmt.setString(4, client);

            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaBean venda = new VendaBean();
                venda.setProduto(rs.getString("produto"));
                venda.setPreco(rs.getDouble("preco"));
                venda.setQtdoupe(rs.getDouble("quantidade"));
                venda.setCliente(rs.getString("cliente"));
                venda.setPrecoreal(rs.getDouble("precoreal"));
                venda.setDesc(rs.getDouble("desconto"));
                venda.setDia(rs.getString("dia"));
                venda.setMes(rs.getString("mes"));
                venda.setAno(rs.getString("ano"));

                lista.add(venda);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lista;
    }

    public List<VendaBean> listVendasForDayProd(String dia, String mes, String ano, String prod) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<VendaBean> lista = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM vendas WHERE dia = ? AND mes = ? AND ano = ? AND produto = ?");
            stmt.setString(1, dia);
            stmt.setString(2, mes);
            stmt.setString(3, ano);
            stmt.setString(4, prod);

            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaBean venda = new VendaBean();
                venda.setProduto(rs.getString("produto"));
                venda.setPreco(rs.getDouble("preco"));
                venda.setQtdoupe(rs.getDouble("quantidade"));
                venda.setCliente(rs.getString("cliente"));
                venda.setPrecoreal(rs.getDouble("precoreal"));
                venda.setDesc(rs.getDouble("desconto"));
                venda.setDia(rs.getString("dia"));
                venda.setMes(rs.getString("mes"));
                venda.setAno(rs.getString("ano"));

                lista.add(venda);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lista;
    }

    public double readVenda(String nvenda) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        double desconto = 0;

        try {
            stmt = con.prepareStatement("SELECT * FROM vendas WHERE nvenda = ?");
            stmt.setString(1, nvenda);

            rs = stmt.executeQuery();

            if (rs.next()) {
                desconto = rs.getDouble("desconto");
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return desconto;
    }

    public List<VendaBean> readMen(String mes, String ano) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<VendaBean> es = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM vendas WHERE mes = ? AND ano = ?");
            stmt.setString(1, mes);
            stmt.setString(2, ano);

            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaBean venda = new VendaBean();
                venda.setProduto(rs.getString("produto"));
                venda.setQtdoupe(rs.getDouble("quantidade"));
                venda.setPreco(rs.getDouble("preco"));
                venda.setPrecoreal(rs.getDouble("precoreal"));
                venda.setDesc(rs.getDouble("desconto"));

                es.add(venda);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return es;
    }

    public List<String> selectAllNVenda(String mes, String ano) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<String> nvendas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT DISTINCT nvenda FROM vendas WHERE mes = ? AND ano = ?");
            stmt.setString(1, mes);
            stmt.setString(2, ano);

            rs = stmt.executeQuery();

            while (rs.next()) {
                nvendas.add(rs.getString("nvenda"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return nvendas;
    }

    public double readDescMes(String nvenda, String mes, String ano) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        double desc = 0;

        try {
            stmt = con.prepareStatement("SELECT desconto FROM vendas WHERE nvenda = ? AND mes = ? AND ano = ?");
            stmt.setString(1, nvenda);
            stmt.setString(2, mes);
            stmt.setString(3, ano);

            rs = stmt.executeQuery();

            while (rs.next()) {
                desc = rs.getDouble("desconto");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return desc;
    }

    public List<VendaBean> read(String dia, String mes, String ano) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<VendaBean> es = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM vendas WHERE dia = ? AND mes = ? AND ano = ?");
            stmt.setString(1, dia);
            stmt.setString(2, mes);
            stmt.setString(3, ano);

            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaBean venda = new VendaBean();
                venda.setProduto(rs.getString("produto"));
                venda.setQtdoupe(rs.getDouble("quantidade"));
                venda.setPreco(rs.getDouble("preco"));
                venda.setCliente(rs.getString("cliente"));
                venda.setPrecoreal(rs.getDouble("precoreal"));
                venda.setDesc(rs.getDouble("desconto"));
                es.add(venda);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return es;
    }

    public List<VendaBean> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<VendaBean> es = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM vendas");
            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaBean venda = new VendaBean();
                venda.setCliente(rs.getString("cliente"));
                venda.setAno(rs.getString("ano"));
                venda.setMes(rs.getString("mes"));
                venda.setDia(rs.getString("dia"));
                es.add(venda);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return es;
    }

    public double readDescDiaMes(String nvenda, String dia, String mes, String ano) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        double desc = 0;

        try {
            stmt = con.prepareStatement("SELECT desconto FROM vendas WHERE nvenda = ? AND dia = ? AND mes = ? AND ano = ?");
            stmt.setString(1, nvenda);
            stmt.setString(2, dia);
            stmt.setString(3, mes);
            stmt.setString(4, ano);

            rs = stmt.executeQuery();

            while (rs.next()) {
                desc = rs.getDouble("desconto");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return desc;
    }

    public List<String> selectAllNVendaDiaMesAno(String dia, String mes, String ano) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<String> nvendas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT DISTINCT nvenda FROM vendas WHERE dia = ? AND mes = ? AND ano = ?");
            stmt.setString(1, dia);
            stmt.setString(2, mes);
            stmt.setString(3, ano);

            rs = stmt.executeQuery();

            while (rs.next()) {
                nvendas.add(rs.getString("nvenda"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return nvendas;
    }

    public List<VendaBean> read(String mes) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<VendaBean> es = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM vendas WHERE mes = ?");
            stmt.setString(1, mes);

            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaBean venda = new VendaBean();
                venda.setProduto(rs.getString("produto"));
                venda.setQtdoupe(rs.getDouble("quantidade"));
                venda.setPreco(rs.getDouble("preco"));
                venda.setPrecoreal(rs.getDouble("precoreal"));
                venda.setDesc(rs.getDouble("desconto"));

                es.add(venda);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return es;
    }

    public List<VendaBean> ver(String mes) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<VendaBean> es = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM vendas WHERE cliente = ?");
            stmt.setString(1, mes);

            rs = stmt.executeQuery();

            while (rs.next()) {
                VendaBean venda = new VendaBean();
                venda.setProduto(rs.getString("produto"));
                venda.setPreco(rs.getDouble("preco"));
                venda.setQtdoupe(rs.getDouble("quantidade"));
                venda.setDia(rs.getString("dia"));
                venda.setMes(rs.getString("mes"));
                venda.setAno(rs.getString("ano"));

                es.add(venda);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return es;
    }

    public List<String> verProduto(String mes) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String produto = "";
        List<String> es = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT produto FROM vendas WHERE cliente = ?");
            stmt.setString(1, mes);

            rs = stmt.executeQuery();

            while (rs.next()) {
                produto = rs.getString("produto");

                es.add(produto);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return es;
    }

    public List<String> verDia(String mes) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String produto = "";
        List<String> es = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT dia FROM vendas WHERE cliente = ?");
            stmt.setString(1, mes);

            rs = stmt.executeQuery();

            while (rs.next()) {

                produto = rs.getString("dia");
                es.add(produto);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return es;
    }

    public List<String> verMes(String mes) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String produto = "";
        List<String> es = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT mes FROM vendas WHERE cliente = ?");
            stmt.setString(1, mes);

            rs = stmt.executeQuery();

            while (rs.next()) {
                produto = rs.getString("mes");
                es.add(produto);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return es;
    }

    public List<String> verAno(String mes) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String produto = "";
        List<String> es = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT ano FROM vendas WHERE cliente = ?");
            stmt.setString(1, mes);

            rs = stmt.executeQuery();

            while (rs.next()) {

                produto = rs.getString("ano");
                es.add(produto);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return es;
    }

    public List<Double> verPreco(String mes) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double preco = 0;
        List<Double> es = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT preco FROM vendas WHERE cliente = ?");
            stmt.setString(1, mes);

            rs = stmt.executeQuery();

            while (rs.next()) {

                preco = rs.getDouble("preco");
                es.add(preco);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return es;
    }

    public List<Double> verQtd(String mes) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double qtd = 0;
        List<Double> es = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT quantidade FROM vendas WHERE cliente = ?");
            stmt.setString(1, mes);

            rs = stmt.executeQuery();

            while (rs.next()) {

                qtd = rs.getDouble("quantidade");
                es.add(qtd);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return es;
    }

    public double returnPrecoCliente(String nome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double preco = 0;

        try {
            stmt = con.prepareStatement("SELECT * FROM vendas WHERE cliente = ?");
            stmt.setString(1, nome);

            rs = stmt.executeQuery();

            while (rs.next()) {
                preco = rs.getDouble("preco");
            }

            System.out.println("Certo");

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        return preco;
    }

    public double returnQtdCliente(String nome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double quantidade = 0;

        try {
            stmt = con.prepareStatement("SELECT quantidade FROM vendas WHERE cliente = ?");
            stmt.setString(1, nome);

            rs = stmt.executeQuery();
            while (rs.next()) {

                quantidade = rs.getDouble("quantidade");
            }

            System.out.println("Certo");

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        return quantidade;
    }

    public String returnProdutoCliente(String nome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String produto = "";

        try {
            stmt = con.prepareStatement("SELECT produto FROM vendas WHERE cliente = ?");
            stmt.setString(1, nome);

            rs = stmt.executeQuery();

            while (rs.next()) {
                produto = rs.getString("produto");
            }

            System.out.println("Certo");

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        return produto;
    }

    public String returnDiaCliente(String nome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String dia = "";

        try {
            stmt = con.prepareStatement("SELECT dia FROM vendas WHERE cliente = ?");
            stmt.setString(1, nome);

            rs = stmt.executeQuery();

            while (rs.next()) {
                dia = rs.getString("dia");
            }

            System.out.println("Certo");

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        return dia;
    }

    public String returnMesCliente(String nome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String mes = "";

        try {
            stmt = con.prepareStatement("SELECT mes FROM vendas WHERE cliente = ?");
            stmt.setString(1, nome);

            rs = stmt.executeQuery();

            while (rs.next()) {
                mes = rs.getString("mes");
            }

            System.out.println("Certo");

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        return mes;
    }

    public String returnAnoCliente(String nome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String ano = "";

        try {
            stmt = con.prepareStatement("SELECT ano FROM vendas WHERE cliente = ?");
            stmt.setString(1, nome);

            rs = stmt.executeQuery();

            while (rs.next()) {
                ano = rs.getString("ano");
            }

            System.out.println("Certo");

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        return ano;
    }

    public String returnNvendaCliente(String nome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String numero = "";

        try {
            stmt = con.prepareStatement("SELECT nvenda FROM vendas WHERE cliente = ?");
            stmt.setString(1, nome);

            rs = stmt.executeQuery();

            while (rs.next()) {
                numero = rs.getString("nvenda");
            }

            System.out.println("Certo");

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        return numero;
    }

}
