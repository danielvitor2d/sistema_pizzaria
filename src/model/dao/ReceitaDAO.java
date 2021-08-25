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
import model.bean.EstoqueBean;
import model.bean.ReceitaBean;

public class ReceitaDAO {

    public void create(ReceitaBean b) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO receitas (produto, qtdoupeso, precofinal, receita) VALUES (?, ?, ?, ?)");
            stmt.setString(1, b.getProduto());
            stmt.setDouble(2, b.getQtdoupeso());
            stmt.setDouble(3, b.getPrecofinal());
            stmt.setString(4, b.getReceita());

            stmt.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no cadastro, reinicie o programa e tente novamente." + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<ReceitaBean> read(String rec) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ReceitaBean> receita = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT DISTINCT * FROM receitas WHERE receita = ?");
            stmt.setString(1, rec);

            rs = stmt.executeQuery();

            while (rs.next()) {
                ReceitaBean rece = new ReceitaBean();

                rece.setProduto(rs.getString("produto"));
                rece.setQtdoupeso(rs.getDouble("qtdoupeso"));
                rece.setPrecofinal(rs.getDouble("precofinal"));

                receita.add(rece);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return receita;
    }

    public List<ReceitaBean> readForJComboBox() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ReceitaBean> receita = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT DISTINCT receita FROM receitas");

            rs = stmt.executeQuery();

            while (rs.next()) {
                ReceitaBean rece = new ReceitaBean();

                rece.setReceita(rs.getString("receita"));

                receita.add(rece);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return receita;
    }

    public void update(ReceitaBean rec) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE receitas SET produto = ?, qtdoupeso = ?, precofinal = ? WHERE receita = ?");
            stmt.setString(1, rec.getProduto());
            stmt.setDouble(2, rec.getQtdoupeso());
            stmt.setDouble(3, rec.getPrecofinal());
            stmt.setString(4, rec.getReceita());

            stmt.executeUpdate();

        } catch (Exception e) {

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(ReceitaBean rec) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM receitas WHERE receita = ?");
            stmt.setString(1, rec.getReceita());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public double precototal(String nomereceita) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double soma = 0;

        try {
            stmt = con.prepareStatement("SELECT SUM(precofinal) FROM receitas WHERE receita = ?");
            stmt.setString(1, nomereceita);

            rs = stmt.executeQuery();

            while (rs.next()) {
                soma = rs.getDouble(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return soma;
    }

    public double readpreco(String produto) {

        double r = 0;

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT * FROM estoque WHERE prod = ?");

            stmt.setString(1, produto);

            rs = stmt.executeQuery();

            while (rs.next()) {

                EstoqueBean bean = new EstoqueBean();

                bean.setPreco(rs.getDouble("preco"));

                r = bean.getPreco();

            }

        } catch (SQLException ex) {

            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return r;

    }

    public List<ReceitaBean> readRece(String receita) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ReceitaBean> bea = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM receitas WHERE receita = ?");

            stmt.setString(1, receita);

            rs = stmt.executeQuery();

            while (rs.next()) {

                ReceitaBean bean = new ReceitaBean();

                bean.setProduto(rs.getString("produto"));
                bean.setQtdoupeso(rs.getDouble("qtdoupeso"));
                bean.setPrecofinal(rs.getDouble("precofinal"));

                bea.add(bean);

            }

        } catch (SQLException ex) {

            System.out.println(ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return bea;

    }
}
