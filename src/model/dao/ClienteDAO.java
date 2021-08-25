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
import model.bean.ClienteBean;

public class ClienteDAO {

    public void create(ClienteBean p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO clientes (nome, apelido, rua, numero, complemento, cidade, bairro, numerot) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getApelido());
            stmt.setString(3, p.getRua());
            stmt.setString(4, p.getNumero());
            stmt.setString(5, p.getComplemento());
            stmt.setString(6, p.getCidade());
            stmt.setString(7, p.getBairro());
            stmt.setString(8, p.getNumerot());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, " Salvo com sucesso!!!");
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, " Erro ao salvar!!!");
            System.out.println(ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    //LEITURA DE INFORMAÇÕES
    public List<ClienteBean> read() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ClienteBean> clientess = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM clientes");
            rs = stmt.executeQuery();

            while (rs.next()) {

                ClienteBean clientes = new ClienteBean();

                clientes.setId(rs.getInt("id"));
                clientes.setNome(rs.getString("nome"));
                clientes.setApelido(rs.getString("apelido"));
                clientes.setRua(rs.getString("rua"));
                clientes.setNumero(rs.getString("numero"));
                clientes.setComplemento(rs.getString("complemento"));
                clientes.setCidade(rs.getString("cidade"));
                clientes.setBairro(rs.getString("bairro"));
                clientes.setNumerot(rs.getString("numerot"));

                clientess.add(clientes);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return clientess;
    }

    public void update(ClienteBean p) {
        //CODIGO DE CONEXÃO
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE clientes SET nome = ?, apelido = ?, rua = ?, numero = ?, complemento = ?, cidade = ?, bairro = ?, numerot = ? WHERE id = ?");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getApelido());
            stmt.setString(3, p.getRua());
            stmt.setString(4, p.getNumero());
            stmt.setString(5, p.getComplemento());
            stmt.setString(6, p.getCidade());
            stmt.setString(7, p.getBairro());
            stmt.setString(8, p.getNumerot());
            stmt.setInt(9, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, " Atualizado com sucesso!!!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, " Erro ao Atualizar!!! " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(ClienteBean p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM clientes WHERE id = ?");

            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, " Excluido com sucesso!!!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, " Erro ao excluir!!!" + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<ClienteBean> readForDesc(String desc) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ClienteBean> clientess = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM clientes WHERE nome LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                ClienteBean clientes = new ClienteBean();

                clientes.setId(rs.getInt("id"));
                clientes.setNome(rs.getString("nome"));
                clientes.setApelido(rs.getString("apelido"));
                clientes.setRua(rs.getString("rua"));
                clientes.setNumero(rs.getString("numero"));
                clientes.setComplemento(rs.getString("complemento"));
                clientes.setCidade(rs.getString("cidade"));
                clientes.setBairro(rs.getString("bairro"));
                clientes.setNumerot(rs.getString("numerot"));

                clientess.add(clientes);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return clientess;
    }

    public int contBairro(String bairro) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int qtde = 0;

        try {

            stmt = con.prepareStatement("SELECT bairro FROM clientes WHERE bairro = ?");

            stmt.setString(1, bairro);

            rs = stmt.executeQuery();

            while (rs.next()) {

                qtde++;

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return qtde;
    }

    public List<bairros> bairros() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<bairros> bairros = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT DISTINCT bairro FROM clientes");

            rs = stmt.executeQuery();

            while (rs.next()) {
                bairros br = new bairros();
                br.setBairro(rs.getString("bairro"));
                bairros.add(br);
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro: " + ex);

        } finally {

            ConnectionFactory.closeConnection(con, stmt, rs);

        }

        return bairros;
    }

    public List<ClienteBean> pesqN(String desc) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ClienteBean> clientess = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM clientes WHERE numerot LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                ClienteBean clientes = new ClienteBean();

                clientes.setNome(rs.getString("nome"));
                clientess.add(clientes);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return clientess;
    }

    public String readForDesc2(String desc) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String nome = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM clientes WHERE numerot = ?");
            stmt.setString(1, desc);

            rs = stmt.executeQuery();

            while (rs.next()) {

                nome = rs.getString("nome");

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return nome;
    }
}
