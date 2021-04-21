/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managebook.dao;

import managebook.dto.BookDTO;
import managebook.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author amtluan
 */
public class BookDAO implements Serializable {

    Connection conn = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public BookDAO() {
    }

    private void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<BookDTO> getListBook() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<BookDTO> list = null;
        BookDTO dto = null;
        String bookID, bookname, author, publisher;
        int publisherYear;
        boolean forRent;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT bookID, bookname, author, publisher, publishedYear, forRent "
                    + "FROM TblBookManagement";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            list = new ArrayList<>(); 
            while (rs.next()) {                
                bookID = rs.getString("bookID");
                bookname = rs.getString("bookName");
                author = rs.getString("author");
                publisher = rs.getString("publisher");
                publisherYear = rs.getInt("publishedYear");
                forRent = rs.getBoolean("forRent");
                dto = new BookDTO(bookID, bookname, author, publisher, publisherYear, forRent);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;

      
    }

    public BookDTO getBookDetail(String bookID) throws ClassNotFoundException, SQLException, Exception {
        BookDTO dto = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT bookID, bookName, author, publisher, publishedYear, forRent "
                    + "FROM TblBookManagement "
                    + "WHERE bookID = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, bookID);
            rs = stm.executeQuery();
            if (rs.next()) {
                dto = new BookDTO();
                dto.setBookID(bookID);
                dto.setBookName(rs.getString("bookName"));
                dto.setAuthor(rs.getString("author"));
                dto.setPulisher(rs.getString("publisher"));
                dto.setPublishedYear(rs.getInt("publishedYear"));
                dto.setForRent(rs.getBoolean("forRent"));
            }
        } finally {
            closeConnection();
        }
        return dto;
      
    }

    public ArrayList<BookDTO> findByLikeName(String name) throws ClassNotFoundException, SQLException, Exception {

        ArrayList<BookDTO> list = new ArrayList<>();
        BookDTO dto = null;
       
        String bookID, bookname, author, publisher;
        int publisherYear;
        boolean forRent;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT bookID, bookName, author, publisher, publishedYear, forRent "
                    + "FROM TblBookManagement "
                    + "WHERE bookName LIKE ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + name + "%");
            rs = stm.executeQuery();
            while (rs.next()) {                
                bookID = rs.getString("bookID");
                bookname = rs.getString("bookname");
                author = rs.getString("author");
                publisher = rs.getString("publisher");
                publisherYear = rs.getInt("publishedYear");
                forRent = rs.getBoolean("forRent");
                dto = new BookDTO(bookID, bookname, author, publisher, publisherYear, forRent);
                list.add(dto);
            
            }
           
        } finally {
            closeConnection();
           
        }
        return list;
      
    }

    public BookDTO findByID(String id) throws ClassNotFoundException, SQLException, Exception {
        BookDTO dto = new BookDTO();
        int temp = 0;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT bookID, bookname, author, publisher,publishedYear, forRent "
                    + "FROM TblBookManagement "
                    + "WHERE bookID = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                dto.setBookID(rs.getString("bookID"));
                dto.setBookName(rs.getString("bookName"));
                dto.setAuthor(rs.getString("author"));
                dto.setPulisher(rs.getString("publisher"));
                dto.setPublishedYear(rs.getInt("publishedYear"));
                dto.setForRent(rs.getBoolean("forRent"));
                 temp++;
            }
           
            if (temp == 0) {
                JOptionPane.showMessageDialog(null, "Empty ID or ID does not exist");
                
            }
        } 
        finally {
            closeConnection();
        }
        return dto;   

    }

    public ArrayList<BookDTO> sortAscendingByBookName() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<BookDTO> list = new ArrayList<>();
        BookDTO dto = null;
        String bookID, bookname, author, publisher;
        int publisherYear;
        boolean forRent;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT bookID, bookname, author, publisher,publishedYear, forRent "
                    + "FROM TblBookManagement "
                    + "ORDER BY bookName ASC";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {                
                bookID = rs.getString("bookID");
                bookname = rs.getString("bookname");
                author = rs.getString("author");
                publisher = rs.getString("publisher");
                publisherYear = rs.getInt("publishedYear");
                forRent = rs.getBoolean("forRent");
                dto = new BookDTO(bookID, bookname, author, publisher, publisherYear, forRent);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }
        return list;

     
    }

    public ArrayList<BookDTO> sortDescendingByBookName() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<BookDTO> list = new ArrayList<>();
        BookDTO dto = null;
        String bookID, bookname, author, publisher;
        int publisherYear;
        boolean forRent;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT bookID, bookname , author , publisher , publishedYear, forRent FROM TblBookManagement ORDER BY bookname DESC";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                bookID = rs.getString("bookID");
                bookname = rs.getString("bookname");
                author = rs.getString("author");
                publisher = rs.getString("publisher");
                publisherYear = rs.getInt("publishedYear");
                forRent = rs.getBoolean("forRent");
                dto = new BookDTO(bookID, bookname, author, publisher, publisherYear, forRent);
                list.add(dto);
            }

        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean insert(BookDTO dto) throws ClassNotFoundException, SQLException, Exception {
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            String sql = "INSERT INTO TblBookManagement(bookID, bookName, author, publisher,publishedYear, forRent) VALUES(?,?,?,?,?,?)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getBookID());
            stm.setString(2, dto.getBookName());
            stm.setString(3, dto.getAuthor());
            stm.setString(4, dto.getPulisher());
            stm.setInt(5, dto.getPublishedYear());
            stm.setBoolean(6, dto.isForRent());
            check = stm.executeUpdate() > 0;
        } catch (Exception e) {
            if (e.getMessage().contains("Violation of PRIMARY KEY")) {
                JOptionPane.showMessageDialog(null, "Duplicate ID");
            }
            JOptionPane.showMessageDialog(null, "INSERT FAIL");
           
        } finally {
            closeConnection();
        }
        return check;

    }

    public boolean update(BookDTO dto) throws ClassNotFoundException, SQLException, Exception {
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            String sql = "UPDATE TblBookManagement SET bookname = ?,author = ?,publisher = ?, publishedYear = ?, forRent = ? "
                    + "WHERE bookID= ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getBookName());
            stm.setString(2, dto.getAuthor());
            stm.setString(3, dto.getPulisher());
            stm.setInt(4, dto.getPublishedYear());
            stm.setBoolean(5, dto.isForRent());
            stm.setString(6, dto.getBookID());
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;

     
    }

    public boolean delete(BookDTO dto) throws ClassNotFoundException, SQLException, Exception {
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
          String sql ="DELETE  FROM TblBookManagement WHERE bookID =?";
          
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getBookID());
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
