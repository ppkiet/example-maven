/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import bean.Students;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Connect;

/**
 *
 * @author PC
 */
public class User_DAO {

    private Connection conn;
    private ResultSet rs;
    private PreparedStatement stmt;

    public boolean loginUser(String username, String password) {
        try {
            Connect a = new Connect();
            conn = a.getSQLServerConnection();
            String sql = "Select \"Username\" from public.\"User\" WHERE \"Username\" like ? and \"Password\" like ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public ArrayList<Students> listStudent() {
        try {
            Connect c = new Connect();
            conn = c.getSQLServerConnection();
            String query = "select \"Name\",\"Mark\",\"Major\" from public.\"Demo\"";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            ArrayList<Students> list = new ArrayList<>();
            while (rs.next()) {
                Students st = new Students();
                st.setName(rs.getString(1));
                st.setMark(rs.getString(2));
                st.setMajor(rs.getString(3));
                list.add(st);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

//    public String resetPassword(String username) {
//        String newpass = this.Random();
//        try {
//            Connect a = new Connect();
//            conn = a.getSQLServerConnection();
//            String sql = "UPDATE Staffs SET Password = ? WHERE Username = ? and isdelete = 0";
//            stmt = conn.prepareStatement(sql);
//            //SET
//            stmt.setString(1, newpass);
//            stmt.setString(2, username);
//            stmt.executeUpdate();
//        } catch (SQLException | ClassNotFoundException e) {
//        }
//        return newpass;
//    }
//    public String Random() {
//        Random rd = new Random();
//        int a = rd.nextInt(1000);
//        String str1 = String.valueOf(a);
//        int b = rd.nextInt(1000);
//        String str2 = String.valueOf(b);
//        int c = rd.nextInt(1000);
//        String random = (str1 + str2);
//        return random;
//    }
    public static void main(String[] args) {
        User_DAO d = new User_DAO();
//        System.out.println(d.loginUser("admin", "admin"));
        try {
            List<Students> list = d.listStudent();
            for (Students s : list) {
                System.out.println(s.getName());
                System.out.println(s.getMajor());
                System.out.println(s.getMark());
                System.out.println("-----------------------------");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
