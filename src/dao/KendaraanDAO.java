/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 * @author 
 * Made Riksi Purnama Sadnya Agung / 210711396
 * Pemrograman Berorientasi Obyek C
 */
package dao;
/**
 * Nama : Made Riksi Purnama Sadnya Agung
 * NPM  : 210711396
 * 
 * Nama : I Made Panji Pusaka Suryeswara
 * NPM  : 210711397
 */
import connection.DbConnection;
import model.Kendaraan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class KendaraanDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertKendaraan(Kendaraan k){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO kendaraan(id, merk, jenis, tahunPembuatan, noPlat, jumlah_penumpang, jenis_tak)" +
                "VALUES ('" +k.getId()+ "', '" +k.getMerk()+ "', '"
                +k.getJenis()+ "', " +k.getTahunPembuatan()+ ", '" +k.getNoPlat()+"', "
                +k.getJumlah_penumpang()+",'"+k.getJenis_tak()+"')";
        
        System.out.println("Adding kendaraan...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding kendaraan..");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public List<Kendaraan> showKendaraan(){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM kendaraan ORDER BY id";
        System.out.println("Collecting data kendaraan..");
        
        List<Kendaraan> list = new ArrayList<>();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    Kendaraan k = new Kendaraan(rs.getString("id"),
                            rs.getString("merk"),rs.getString("jenis"),
                            Integer.parseInt(rs.getString("tahunPembuatan")),
                            rs.getString("noPlat"), Integer.parseInt(rs.getString("jumlah_penumpang")), 
                            rs.getString("jenis_tak"));
                    
                    list.add(k);
                }
                System.out.println("Success collecting data kendaraan !");
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error collecting data kendaraan..");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }
    
    public Kendaraan searchKendaraan(String id){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * from kendaraan WHERE id = '" +id+ "'";
        System.out.println("Searching kendaraan...");
        Kendaraan k = null;
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    k = new Kendaraan(rs.getString("id"),
                            rs.getString("merk"),rs.getString("jenis"),
                            Integer.parseInt(rs.getString("tahunPembuatan")),
                            rs.getString("noPlat"), Integer.parseInt(rs.getString("jumlah_penumpang")), 
                            rs.getString("jenis_tak"));               
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error searching kendaraan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return k;
    }
    
    public void updateKendaraan(Kendaraan k, String id){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE kendaraan SET id = '" +k.getId()+ "', merk = '" +k.getMerk()+ "',"
                + " jenis = '" +k.getJenis()+ "', tahunPembuatan = " +k.getTahunPembuatan()+ ","
                + " noPlat = '" +k.getNoPlat()+ "', jumlah_penumpang = " +k.getJumlah_penumpang()+ ","
                + " jenis_tak = '" +k.getJenis_tak()+ "' WHERE id = '" +id+"' ";
        System.out.println("Updating data kendaraan..");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error updating data kendaraan..");
        }
        dbCon.closeConnection();
    }
    public void deleteKendaraan(String id){
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM kendaraan WHERE id = '" +id+ "'";
        System.out.println("Deleting data kendaraan...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error delete data kendaraan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
}
