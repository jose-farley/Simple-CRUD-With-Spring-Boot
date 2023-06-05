
package com.example.demo;

import com.example.demo.contract.ProductDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProductDAO {
    Connection db;
    PreparedStatement psm;
    ResultSet rs;
    ArrayList<ProductDTO> productList = new ArrayList<>();
    public void save(ProductDTO product) throws SQLException{
      String sql = "insert into product (name, code, price) values(?,?,?)"; 
      String url = "jdbc:postgresql://silly.db.elephantsql.com:5432/gebpetdx?user=gebpetdx&password=pVUVVV4e-PS9kVRMu0u8aeZKOzmRBL2J";
      db = DriverManager.getConnection(url);
      try{
        psm = db.prepareStatement(sql);
        psm.setString(1, product.getName());
        psm.setString(2, product.getCode());
        psm.setDouble(3, product.getPrice());
        psm.execute();
        psm.close();
      }catch(Error e){
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
    }
    public void update(ProductDTO product) throws SQLException{
    String sql = "UPDATE product SET name = ?, price = ?, code = ? WHERE id = ?;"; 
      String url = "jdbc:postgresql://silly.db.elephantsql.com:5432/gebpetdx?user=gebpetdx&password=pVUVVV4e-PS9kVRMu0u8aeZKOzmRBL2J";
      db = DriverManager.getConnection(url);
      try{
        psm = db.prepareStatement(sql);
        psm.setString(1, product.getName());
        psm.setDouble(2, product.getPrice());
        psm.setString(3, product.getCode());
        psm.setInt(4, product.getId());
        psm.execute();
        psm.close();
      }catch(Error e){
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
    }
    public void delete(int id) throws SQLException{
      String sql = "delete from product where id=?"; 
      String url = "jdbc:postgresql://silly.db.elephantsql.com:5432/gebpetdx?user=gebpetdx&password=pVUVVV4e-PS9kVRMu0u8aeZKOzmRBL2J";
      db = DriverManager.getConnection(url);
      try{
        psm = db.prepareStatement(sql);
        psm.setInt(1, id);
        psm.execute();
        psm.close();
      }catch(Error e){
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
    }
    public ArrayList<ProductDTO> ListProducts() throws SQLException{
      String sql = "select * from product"; 
      String url = "jdbc:postgresql://silly.db.elephantsql.com:5432/gebpetdx?user=gebpetdx&password=pVUVVV4e-PS9kVRMu0u8aeZKOzmRBL2J";
      db = DriverManager.getConnection(url);
        try{
          psm = db.prepareStatement(sql);
          rs = psm.executeQuery();
          while(rs.next()){
              ProductDTO prod = new ProductDTO();
              prod.setId(rs.getInt("id"));
              prod.setName(rs.getString("name"));
              prod.setCode(rs.getString("code"));
              prod.setPrice(rs.getDouble("price"));
              productList.add(prod);
          }
        }catch(Error e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            return productList;
        }
        
    }
}
