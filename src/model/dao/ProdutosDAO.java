package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.ProdutoBean;

public class ProdutosDAO {

    public void create(ProdutoBean p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO produtos (np, prec, prev, pl, aumento, plr) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, p.getNp());
            stmt.setDouble(2, p.getPrec());
            stmt.setDouble(3, p.getPrev());
            stmt.setDouble(4, p.getPl());
            stmt.setDouble(5, p.getAumento());
            stmt.setDouble(6, p.getPlr());
            stmt.executeUpdate();

            System.out.println("Salvo com sucesso!!");

        } catch (SQLException ex) {

            System.out.println("Erro ao salvar! " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<ProdutoBean> read() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ProdutoBean> produtoss = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produtos");
            rs = stmt.executeQuery();

            while (rs.next()) {

                ProdutoBean produtos = new ProdutoBean();

                produtos.setId(rs.getInt("id"));
                produtos.setNp(rs.getString("np"));
                produtos.setPrec(rs.getDouble("prec"));
                produtos.setPrev(rs.getDouble("prev"));
                produtos.setPl(rs.getDouble("pl"));
                produtos.setAumento(rs.getDouble("aumento"));
                produtos.setPlr(rs.getDouble("plr"));
                produtoss.add(produtos);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return produtoss;
    }

    public void update(ProdutoBean p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE produtos SET np = ?, prec = ?, prev = ?, pl = ?, aumento = ?, plr = ? WHERE id = ?");
            stmt.setString(1, p.getNp());
            stmt.setDouble(2, p.getPrec());
            stmt.setDouble(3, p.getPrev());
            stmt.setDouble(4, p.getPl());
            stmt.setDouble(5, p.getAumento());
            stmt.setDouble(6, p.getPlr());
            stmt.setInt(7, p.getId());

            stmt.executeUpdate();

            System.out.println("Atualizado com sucesso!");

        } catch (SQLException ex) {

            System.out.println("Erro ao atualizar! " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(ProdutoBean p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM produtos WHERE id = ?");

            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            System.out.println("Excluido com sucesso!");

        } catch (SQLException ex) {

            System.out.println("Erro ao excluir! " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<ProdutoBean> readForDesc(String desc) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ProdutoBean> produtoss = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produtos WHERE np LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                ProdutoBean produtos = new ProdutoBean();

                produtos.setId(rs.getInt("id"));
                produtos.setNp(rs.getString("np"));
                produtos.setPrec(rs.getDouble("prec"));
                produtos.setPrev(rs.getDouble("prev"));
                produtos.setPl(rs.getDouble("pl"));
                produtos.setAumento(rs.getDouble("aumento"));
                produtos.setPlr(rs.getDouble("plr"));

                produtoss.add(produtos);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return produtoss;
    }

    public double readaumento(int id) {

        double r = 0;

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT * FROM produtos WHERE id = ?");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {

                ProdutoBean bean = new ProdutoBean();

                bean.setAumento(rs.getDouble("aumento"));

                r = bean.getAumento();

            }

        } catch (SQLException ex) {

            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return r;

    }

    public double precoProduto(String np) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        double precv = 0;

        try {
            stmt = con.prepareStatement("SELECT prev FROM produtos WHERE np = ?");
            stmt.setString(1, np);

            rs = stmt.executeQuery();

            while (rs.next()) {
                precv = rs.getDouble("prev");

            }

        } catch (Exception e) {

            System.out.println("precoProduto " + e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return precv;
    }

    public double precoReal(String np) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        double precv = 0;

        try {
            stmt = con.prepareStatement("SELECT prec FROM produtos WHERE np = ?");
            stmt.setString(1, np);

            rs = stmt.executeQuery();

            while (rs.next()) {
                precv = rs.getDouble("prec");

            }

        } catch (Exception e) {

            System.out.println("precoReal " + e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return precv;
    }

    public List<ProdutoBean> readForJComboBox() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ProdutoBean> produto = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT DISTINCT np FROM produtos");

            rs = stmt.executeQuery();

            while (rs.next()) {
                ProdutoBean prod = new ProdutoBean();

                prod.setNp(rs.getString("np"));

                produto.add(prod);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produto;
    }

    public ProdutoBean selecionarProduto(String nome_produto) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String nome_produto2;
        double preco_venda, preco_real;

        ProdutoBean bean = new ProdutoBean();

        try {
            stmt = con.prepareStatement("SELECT * FROM produtos WHERE np = ?");
            stmt.setString(1, nome_produto);

            rs = stmt.executeQuery();

            while (rs.next()) {
                nome_produto2 = rs.getString("np");
                preco_venda = rs.getDouble("prev");
                preco_real = rs.getDouble("prec");

                bean.setNp(nome_produto2);
                bean.setPrev(preco_venda);
                bean.setPrec(preco_real);

            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return bean;
    }

}
