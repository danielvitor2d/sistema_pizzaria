package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.LoginBean;

public class LoginDAO {

    public boolean checkLogin(LoginBean usuario) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM login WHERE login = ? and senha = ?");
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            rs = stmt.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }

    public void updateSenha(String senha, String senhaatual) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE login SET senha = ? WHERE senha = ?");
            stmt.setString(1, senha);
            stmt.setString(2, senhaatual);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void updateLogin(String login, String loginatual) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE login SET login = ? WHERE login = ?");
            stmt.setString(1, login);
            stmt.setString(2, loginatual);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public String showSenha() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String senha = "";

        try {
            stmt = con.prepareStatement("SELECT senha FROM login");
            rs = stmt.executeQuery();
            while (rs.next()) {
                senha = rs.getString(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return senha;
    }

    public String showLogin() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String login = "";

        try {
            stmt = con.prepareStatement("SELECT login FROM login");
            rs = stmt.executeQuery();
            while (rs.next()) {
                login = rs.getString(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return login;
    }
}
