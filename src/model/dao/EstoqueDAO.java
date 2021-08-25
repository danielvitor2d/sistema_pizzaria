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
import model.bean.EstoqueBean;

public class EstoqueDAO {

    public void create(EstoqueBean p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO estoque (prod, qtd, preco, tipo) VALUES (?, ?, ?, ?)");
            stmt.setString(1, p.getProd());
            stmt.setDouble(2, p.getQdtoupe());
            stmt.setDouble(3, p.getPreco());
            stmt.setString(4, p.getTipo());

            stmt.executeUpdate();

            System.out.println("Salvo com sucesso!!");

        } catch (SQLException ex) {

            System.out.println("Erro ao salvar! " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<EstoqueBean> read() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<EstoqueBean> estoques = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM estoque");
            rs = stmt.executeQuery();

            while (rs.next()) {

                EstoqueBean estoque = new EstoqueBean();

                estoque.setId(rs.getInt("id"));
                estoque.setProd(rs.getString("prod"));
                estoque.setQdtoupe(rs.getDouble("qtd"));
                estoque.setPreco(rs.getDouble("preco"));

                estoques.add(estoque);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return estoques;
    }

    public void update(EstoqueBean p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE estoque SET prod = ?, qtd = ?, preco = ? WHERE id = ?");
            stmt.setString(1, p.getProd());
            stmt.setDouble(2, p.getQdtoupe());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getId());

            stmt.executeUpdate();

            System.out.println("Atualizado com sucesso!");

        } catch (SQLException ex) {

            System.out.println("Erro ao atualizar! " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void updateProd(EstoqueBean p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE estoque SET qtd = ? WHERE prod = ?");
            stmt.setDouble(1, p.getQdtoupe());
            stmt.setString(2, p.getProd());

            stmt.executeUpdate();

            System.out.println("Atualizado com sucesso!");

        } catch (SQLException ex) {

            System.out.println("Erro ao atualizar! " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(EstoqueBean p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM estoque WHERE id = ?");

            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            System.out.println("Excluido com sucesso!");

        } catch (SQLException ex) {

            System.out.println("Erro ao excluir! " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<EstoqueBean> readForDesc(String desc) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<EstoqueBean> estoques = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM estoque WHERE prod LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                EstoqueBean estoque = new EstoqueBean();

                estoque.setId(rs.getInt("id"));
                estoque.setProd(rs.getString("prod"));
                estoque.setQdtoupe(rs.getDouble("qtd"));
                estoque.setPreco(rs.getDouble("preco"));

                estoques.add(estoque);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return estoques;
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

    public String pouq(String pouq) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String tipo = null;

        try {

            stmt = con.prepareStatement("SELECT tipo FROM estoque WHERE id = ?");
            stmt.setString(1, pouq);
            rs = stmt.executeQuery();

            while (rs.next()) {
                tipo = rs.getString(1);
            }

            System.out.println("Deu certo!");
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
        return tipo;
    }

    public String pouq2(String nome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String tipo = null;

        try {

            stmt = con.prepareStatement("SELECT tipo FROM estoque WHERE prod = ?");
            stmt.setString(1, nome);
            rs = stmt.executeQuery();

            while (rs.next()) {
                tipo = rs.getString(1);
            }

            System.out.println("Deu certo!");
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
        return tipo;
    }

    public double readqtd(String produto) {

        double r = 0;

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT qtd FROM estoque WHERE prod = ?");

            stmt.setString(1, produto);

            rs = stmt.executeQuery();

            while (rs.next()) {

                r = rs.getDouble(1);

            }

        } catch (SQLException ex) {

            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return r;

    }

    public List<EstoqueBean> readBanco() {

        double r = 0;

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<EstoqueBean> estoques = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM estoque");

            rs = stmt.executeQuery();

            while (rs.next()) {
                EstoqueBean bean = new EstoqueBean();

                bean.setProd(rs.getString("prod"));
                bean.setQdtoupe(rs.getDouble("qtd"));

                estoques.add(bean);
            }

        } catch (SQLException ex) {

            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }
        return estoques;

    }

    public void retiraEstoque(String prod, double qtd) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE estoque SET qtd = ? WHERE prod = ?");
            stmt.setDouble(1, qtd);
            stmt.setString(2, prod);

            stmt.executeUpdate();

            System.out.println("Atualizado com sucesso!");
        } catch (SQLException ex) {

            System.out.println("Erro ao atualizar! " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
