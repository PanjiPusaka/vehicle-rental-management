package dao;
/**
 * Nama : Made Riksi Purnama Sadnya Agung
 * NPM  : 210711396
 * 
 * Nama : I Made Panji Pusaka Suryeswara
 * NPM  : 210711397
 */
import connection.DbConnection;
import model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
public class CustomerDAO {
    DbConnection dbcon = new DbConnection();
    private Connection con;
    
    public void insertCustomer(Customer c){
        con = dbcon.makeConnection();
        
        String sql = "INSERT INTRO customer(nama, ktp, no_telepon) VALUES ('"+c.getNama()+"',"
                + " '"+c.getKtp()+"', '"+c.getNo_telepon()+"') ";
        System.out.println("Insert data customer...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Success insert data customer...");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error insert customer....");
            System.out.println(e);
        }
        
        dbcon.closeConnection();
    }
    
    public List<Customer> showCustomerBySearch(String query){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM customer WHERE (id="+Integer.valueOf(query)+""
                + " OR nama LIKE '%"+query+"%' OR ktp LIKE '%"+query+"%'"
                + " OR no_telepon LIKE '%"+query+"%')";
        
        System.out.println("Collecting data customer...");
        List<Customer> list = new ArrayList<Customer>();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs!=null) {
                while(rs.next()){
                    Customer c = new Customer(rs.getInt("id"), rs.getString("nama"),
                            rs.getString("ktp"), rs.getString("no_telepon"));
                    list.add(c);
                }
            }
            
            System.out.println("Success collecting data customer...");
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error collecting data customer...");
            System.out.println(e);
        }
        dbcon.closeConnection();
        
        return list;
    }
    
    public void updateCustomer(Customer c){
        con = dbcon.makeConnection();
        
        String sql = "UPDATE customer SET nama = '"+c.getNama()+"', ktp = '"+c.getKtp()+"',"
                + " no_telepon = '"+c.getNo_telepon()+"' WHERE id = "+c.getId()+"";
        
        System.out.println("Updating data customer...");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Update "+result+" customer");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error update data customer....");
            System.out.println(e);
        }
        
        dbcon.closeConnection();
    }
    
    public void deleteCustomer(int id){
        con = dbcon.makeConnection();
        
        String sql = "DELETE * FROM customer WHERE id = "+id+"";
        
        System.out.println("Deleting data customer...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete "+result+" customer");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error update data customer....");
            System.out.println(e);
        }
        
        dbcon.closeConnection();
    }
}
