package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import longnbp.dtos.ProductsDTO;
import utils.DBUtils;

public class ProductDAO {

    public static Vector getProductList() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.openConnection();
            String sql = "Select productId, productName, unit, price, quantity, categoryid From TblProducts";
            ps = conn.prepareStatement(sql);
            Vector<Vector<String>> proList = new Vector<Vector<String>>();
            rs = ps.executeQuery();
            while (rs.next()) {
                Vector<String> productDetail = new Vector<String>();
                productDetail.add(rs.getString("productId"));
                productDetail.add(rs.getString("productName"));
                productDetail.add(rs.getString("categoryid"));
                productDetail.add(rs.getString("unit"));
                productDetail.add(rs.getFloat("price") + "");
                productDetail.add(rs.getInt("quantity") + "");

                proList.add(productDetail);
            }
            return proList;
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

    }

    public static boolean InsertProduct(ProductsDTO newProduct) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean result = false;
        try {
            conn = DBUtils.openConnection();
            String sql = "Insert into TblProducts values(?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(2, newProduct.getProductName());
            ps.setString(1, newProduct.getProductID());
            ps.setString(3, newProduct.getUnit());
            ps.setFloat(4, newProduct.getPrice());
            ps.setInt(5, newProduct.getQuantity());
            ps.setString(6, newProduct.getCategory());

            result = (ps.executeUpdate() > 0);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public static boolean updateProduct(ProductsDTO newProduct) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean result = false;
        try {
            conn = DBUtils.openConnection();
            String sql = "Update TblProducts set productName=?, unit=?,price=?, quantity=?, categoryid=?  Where  productID =?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, newProduct.getProductName());
            ps.setString(2, newProduct.getUnit());
            ps.setInt(4, newProduct.getQuantity());
            ps.setFloat(3, newProduct.getPrice());
            ps.setString(5, newProduct.getCategory());
            ps.setString(6, newProduct.getProductID());
            result = (ps.executeUpdate() > 0);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public static boolean checkProductCode(String code) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.openConnection();
            String sql = "Select productName  From TblProducts Where productID= ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, code);
            rs = ps.executeQuery();
            if (rs.next()) {
                String proname = rs.getString("productName");
                if (!"".equals(proname)) {
                    return true;
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return false;

    }

    public static boolean deleteProduct(ProductsDTO newProduct) throws Exception {
       Connection conn  = null;
       PreparedStatement ps= null;
       boolean result = false;
        try {
            conn = DBUtils.openConnection();
            String sql= "Delete TblProducts Where productID =?";
            ps= conn.prepareStatement(sql);
            ps.setString(1, newProduct.getProductID());
            result = (ps.executeUpdate()>0);
        } catch (Exception e) {throw  new Exception(e.getMessage());
        }
        return result;
       


    }

    public ProductsDTO getProductDetail(String productID) throws Exception {
       Connection conn = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
        try {
            conn = DBUtils.openConnection();
            String sql = "Select productID, productName, unit, price , quantity, categoryid from TblProducts Where productID=?";
            ps= conn.prepareStatement(sql);
            ps.setString(1, productID);
            rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("productName");
                String unit = rs.getString("unit");
                float price = rs.getFloat("price");
                Integer quantity = rs.getInt("quantity");
                String categoryid = rs.getString("categoryid");
                return new ProductsDTO(productID, name, unit    , price,quantity, categoryid);
            }
        } catch (Exception e) {
            throw  new Exception(e.getMessage());
        }finally{
            if (rs!= null) {
                rs.close();
            }
            if (ps!=null) {
                ps.close();
                
            }
            if (conn!=null) {
                conn.close();
            }
        }
        return null;
    }

}
