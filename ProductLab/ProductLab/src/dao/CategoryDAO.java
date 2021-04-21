/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import longnbp.dtos.CategoriesDTO;
import utils.DBUtils;


public class CategoryDAO {

    public static Vector getCategoryList() throws Exception {
       Connection conn  = null;
       PreparedStatement ps=null;
       ResultSet rs = null;
        try {
            conn = DBUtils.openConnection();
            String sql ="Select categoryID,categoryName, description from TblCategories  ";
            ps= conn.prepareStatement(sql);
            Vector<Vector<String>> categoryList = new Vector<Vector<String>>();
            rs = ps.executeQuery();
            while (rs.next()) {                
                Vector<String>  categoryDetail = new Vector<String>();
                categoryDetail.add(rs.getString("categoryId"));
                categoryDetail.add(rs.getString("categoryName"));
                categoryDetail.add(rs.getString("description"));
                categoryList.add(categoryDetail);
            }
            return categoryList;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }finally{
            if (rs!=null) {
                rs.close();
            }
             if (ps!=null) {
                ps.close();
            }
              if (conn!=null) {
                conn.close();
            }
        }

    }

    public static boolean InsertCategory(CategoriesDTO NewProduct) throws Exception {
       Connection conn = null;
       PreparedStatement ps= null;
       boolean result = false;
        try {
            conn = DBUtils.openConnection();
            String sql = "Insert into TblCategories values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, NewProduct.getCategoryID());
            ps.setString(2, NewProduct.getCategoryName());
            ps.setString(3, NewProduct.getDescription());
            result = (ps.executeUpdate()>0);
        } catch (Exception e) {
            throw  new Exception(e.getMessage());
        }finally{
            if (ps!=null) {
                ps.close();
            }
            if (conn!=null) {
                conn.close();
            }
        }
        return result;
    }

    public static boolean updateCategory(CategoriesDTO NewProduct) throws Exception {
      Connection conn = null;
      PreparedStatement ps= null;
      boolean result = false;
        try {
            conn = DBUtils.openConnection();
            String sql = "UPDATE  TblCategories set categoryName=?, description=? where categoryID=? ";
            ps= conn.prepareStatement(sql);
            ps.setString(3, NewProduct.getCategoryID());
            ps.setString(1, NewProduct.getCategoryName());
            ps.setString(2, NewProduct.getDescription());
            result =(ps.executeUpdate()>0);
        } catch (Exception e) {
            throw  new Exception(e.getMessage());
        }finally{
            if (ps!=null) {
                ps.close();
            }
            if (conn!= null) {
                conn.close();
            }
        }
        return result;
    }

    public static boolean checkCode(String code) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.openConnection();
            String sql = "SELECT categoryName FROM TblCategories WHERE categoryID=?";
            ps= conn.prepareStatement(sql);
            ps.setString(1, code);
            rs = ps.executeQuery();
            if (rs.next()) {
                String cateName = rs.getString("categoryName");
                if (!"".equals(cateName)) {
                    return true;
                }
            }
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return false;
    }

    public static boolean deleteCategory(CategoriesDTO NewCate) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean result = false;
            try {
                conn = DBUtils.openConnection();
                String sql= "Delete TblCategories where categoryID = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, NewCate.getCategoryID());
                result =(ps.executeUpdate()>0);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }finally{
                if (ps!=null) {
                    ps.close();
                }
                 if (conn!=null) {
                    conn.close();
                }
            }
        return result;
        
    }

    public CategoriesDTO getCategoryDetail(String categoryID) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.openConnection();
            String sql = "select categoryName,description From TblCategories Where categoryID =?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, categoryID);
            rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("categoryName");
                String description = rs.getString("description");
                return new CategoriesDTO(categoryID, name, description);
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;

    }

    public Vector<String> getCombobox() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector<String> list = null;
        try {
            conn = DBUtils.openConnection();
            String sql = "Select categoryID, categoryName From TblCategories ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (list == null) {
                    list = new Vector<>();
                    list.add("Choose one");
                }
                String cate = rs.getString("categoryID") + " - " + rs.getString("categoryName");
                list.add(cate);
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;

    }

    public static String getCate(String categoryID) throws Exception {
        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            cnn = DBUtils.openConnection();
            String strSQL = "Select categoryID, categoryName From TblCategories Where categoryID = ? ";
            ps = cnn.prepareStatement(strSQL);
            ps.setString(1, categoryID);
            rs = ps.executeQuery();
            if (rs.next()) {
                String cate = rs.getString("categoryID") + "-" + rs.getString("categoryName");
                return cate;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
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
        return "";
    }

    public boolean checkDupID(String categoryID) throws Exception {
        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            cnn = DBUtils.openConnection();
            String strSQL = "Select productID From TblProducts Where categoryid = ? ";
            ps = cnn.prepareStatement(strSQL);
            ps.setString(1, categoryID);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
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
        return false;
    }

}
