/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class UserDAO {

    private List<UserDTO> listAcount;

    public List<UserDTO> getListAcount() {
        return listAcount;
    }

    public UserDAO() {
        try {
            load();
        } catch (SQLException e) {
            System.out.println("Error Connection!!!");
        } catch (NamingException e) {
            System.out.println("Error Connection!!!");
        }
    }

    public void load() throws SQLException, NamingException {
        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        if (this.listAcount == null) {
            this.listAcount = new ArrayList<>();
        }
        try {
            cnn = DBUtils.openConnection();
            if (cnn != null) {
                String sql = "Select userID, password from TblUsers";
                ps = cnn.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String password = rs.getString("password");

                    UserDTO dto = new UserDTO(userID, password);
                    this.listAcount.add(dto);

                }
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        }

       
    }

    public boolean checkLogin(String userId, String password) {
//        for (int i = 0; i < listAcount.size(); i++) {
//            if (listAcount.get(i).getUserID().equalsIgnoreCase(userId) && listAcount.get(i).getPassword().equals(password)) {
//                return true;
//            }
//        }
//        return false;


        for (int i = 0; i < listAcount.size(); i++) {
            if (listAcount.get(i).getUserID().equalsIgnoreCase(userId)&& listAcount.get(i).getPassword().equals(password)) {
                return true;
            }
        
    }
        return false;
}
}
