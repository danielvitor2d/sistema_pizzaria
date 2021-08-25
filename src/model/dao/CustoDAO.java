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
import model.bean.CustoBean;

public class CustoDAO {

    public void create(CustoBean p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO custo (agua, luz, tel, net, gas, ml, piz, aux, cai, ent, divulg, dia, mes, ano) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setDouble(1, p.getAgua());
            stmt.setDouble(2, p.getLuz());
            stmt.setDouble(3, p.getTel());
            stmt.setDouble(4, p.getNet());
            stmt.setDouble(5, p.getGas());
            stmt.setDouble(6, p.getMl());
            stmt.setDouble(7, p.getPiz());
            stmt.setDouble(8, p.getAux());
            stmt.setDouble(9, p.getCai());
            stmt.setDouble(10, p.getEnt());
            stmt.setDouble(11, p.getDivulg());
            stmt.setString(12, p.getDia());
            stmt.setString(13, p.getMes());
            stmt.setString(14, p.getAno());

            stmt.executeUpdate();

            System.out.println("Salvo com sucesso!!");

        } catch (SQLException ex) {

            System.out.println("Erro ao salvar! " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<CustoBean> read(String dia, String mes, String ano) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<CustoBean> custos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM custo WHERE dia = ? AND mes = ? AND ano = ?");
            stmt.setString(1, dia);
            stmt.setString(2, mes);
            stmt.setString(3, ano);

            rs = stmt.executeQuery();

            while (rs.next()) {

                CustoBean custo = new CustoBean();

                custo.setId(rs.getInt("id"));
                custo.setAgua(rs.getDouble("agua"));
                custo.setLuz(rs.getDouble("luz"));
                custo.setTel(rs.getDouble("tel"));
                custo.setNet(rs.getDouble("net"));
                custo.setGas(rs.getDouble("gas"));
                custo.setMl(rs.getDouble("ml"));
                custo.setPiz(rs.getDouble("piz"));
                custo.setAux(rs.getDouble("aux"));
                custo.setCai(rs.getDouble("cai"));
                custo.setEnt(rs.getDouble("ent"));
                custo.setDivulg(rs.getDouble("divulg"));
                custo.setDia(rs.getString("dia"));
                custo.setMes(rs.getString("mes"));
                custo.setAno(rs.getString("ano"));

                custos.add(custo);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return custos;

    }

    public List<CustoBean> read() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<CustoBean> custos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM custo");
            rs = stmt.executeQuery();

            while (rs.next()) {

                CustoBean custo = new CustoBean();

                custo.setId(rs.getInt("id"));
                custo.setAgua(rs.getDouble("agua"));
                custo.setLuz(rs.getDouble("luz"));
                custo.setTel(rs.getDouble("tel"));
                custo.setNet(rs.getDouble("net"));
                custo.setGas(rs.getDouble("gas"));
                custo.setMl(rs.getDouble("ml"));
                custo.setPiz(rs.getDouble("piz"));
                custo.setAux(rs.getDouble("aux"));
                custo.setCai(rs.getDouble("cai"));
                custo.setEnt(rs.getDouble("ent"));
                custo.setDivulg(rs.getDouble("divulg"));
                custo.setDia(rs.getString("dia"));
                custo.setMes(rs.getString("mes"));
                custo.setAno(rs.getString("ano"));

                custos.add(custo);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return custos;
    }

    public void update(CustoBean p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE custo SET agua = ?, luz = ?, tel = ? , net = ?, ml = ?, piz = ?, aux = ?, cai = ?, ent = ?, divulg = ?, dia = ?, mes = ?, ano = ? WHERE id = ?");
            stmt.setDouble(1, p.getAgua());
            stmt.setDouble(2, p.getLuz());
            stmt.setDouble(3, p.getTel());
            stmt.setDouble(4, p.getNet());
            stmt.setDouble(5, p.getMl());
            stmt.setDouble(6, p.getPiz());
            stmt.setDouble(7, p.getAux());
            stmt.setDouble(8, p.getCai());
            stmt.setDouble(9, p.getEnt());
            stmt.setDouble(10, p.getDivulg());
            stmt.setString(11, p.getDia());
            stmt.setString(12, p.getMes());
            stmt.setString(13, p.getAno());
            stmt.setInt(14, p.getId());

            stmt.executeUpdate();

            System.out.println("Atualizado com sucesso!");

        } catch (SQLException ex) {

            System.out.println("Erro ao atualizar! " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(CustoBean p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM custo WHERE id = ?");

            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            System.out.println("Excluido com sucesso!");

        } catch (SQLException ex) {

            System.out.println("Erro ao excluir! " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<CustoBean> readForDesc(String desc) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<CustoBean> custos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM custo WHERE data LIKE ?");

            stmt.setString(1, "%" + desc + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {

                CustoBean custo = new CustoBean();

                custo.setId(rs.getInt("id"));
                custo.setAgua(rs.getDouble("agua"));
                custo.setLuz(rs.getDouble("luz"));
                custo.setTel(rs.getDouble("tel"));
                custo.setNet(rs.getDouble("net"));
                custo.setGas(rs.getDouble("gas"));
                custo.setMl(rs.getDouble("ml"));
                custo.setPiz(rs.getDouble("piz"));
                custo.setAux(rs.getDouble("aux"));
                custo.setCai(rs.getDouble("cai"));
                custo.setEnt(rs.getDouble("ent"));
                custo.setDivulg(rs.getDouble("divulg"));
                custo.setDia(rs.getString("dia"));
                custo.setDia(rs.getString("mes"));
                custo.setDia(rs.getString("ano"));
                custos.add(custo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return custos;
    }

    public List<CustoBean> readForJComboBox() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<CustoBean> custo = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM custo");

            rs = stmt.executeQuery();

            while (rs.next()) {
                CustoBean bean = new CustoBean();

                bean.setDia(rs.getString("dia"));
                bean.setMes(rs.getString("mes"));
                bean.setAno(rs.getString("ano"));

                custo.add(bean);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return custo;
    }
}
