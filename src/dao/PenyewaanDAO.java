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

public class PenyewaanDAO {
    DbConnection dbcon = new DbConnection();
    private Connection con;
    
    public void insertPenyewaan(Penyewaan p){
        con = dbcon.makeConnection();
        
        String sql = "INSERT INTO penyewaan(id_kendaraan, id_customer, lama_sewa, total_harga, fasilitas) VALUES "
                + " ('"+p.getKendaraan().getId()+"', "+p.getCustomer().getId()+", '"+p.getLama_sewa()+"',"
                + " "+p.getTotal_harga()+", '"+p.getFasilitas()+"')";
        
        System.out.println("Insert data penyewaan...");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Insert "+result+" penyewaan");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error insert penyewaan....");
            System.out.println(e);
        }
        
        dbcon.closeConnection();
    }
    
    public List<Penyewaan> showPenyewaan(String query){
        con = dbcon.makeConnection();
        
        String sql = "SELECT p.*, c.*, k.* FROM penyewaan as p JOIN customer as c ON (p.id_customer = c.id)"
                + " JOIN kendaraan as k ON (p.id_kendaraan = k.id) WHERE "
                + " (k.merk LIKE '%"+query+"%' OR k.jenis LIKE '%"+query+"%' OR c.nama LIKE '%"+query+"%'"
                + " OR p.lama_sewa LIKE '%"+query+"%' OR p.total_harga = '"+query+"'"
                + " OR p.fasilitas LIKE '%"+query+"%' OR k.jumlah_penumpang = '"+query+"'"
                + " OR k.jenis_tak LIKE '%"+query+"%')";
        
        List<Penyewaan> list = new ArrayList<Penyewaan>();
        System.out.println("Collecting data penyewaan...");
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    Kendaraan k = new Kendaraan(rs.getString("k.id"),
                            rs.getString("k.merk"),rs.getString("k.jenis"),
                            Integer.parseInt(rs.getString("k.tahunPembuatan")),
                            rs.getString("k.noPlat"), Integer.parseInt(rs.getString("k.jumlah_penumpang")), 
                            rs.getString("k.jenis_tak"));
                    
                    Customer c = new Customer(Integer.parseInt(rs.getString("c.id")), rs.getString("c.nama"),
                            rs.getString("c.ktp"), rs.getString("c.no_telepon"));
                    
                    Penyewaan p = new Penyewaan(Integer.parseInt(rs.getString("p.id")), rs.getString("p.lama_sewa"),
                            Float.parseFloat(rs.getString("p.total_harga")), rs.getString("p.fasilitas"),
                            k, c);
                    
                    list.add(p);
                }
            }
            System.out.println("Success collecting data penyewaan...");
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error collecting data penyewaan....");
            System.out.println(e);
        }
        
        dbcon.closeConnection();
        return list;
    }
    
    public void updatePenyewaan(Penyewaan p){
        con = dbcon.makeConnection();
        
        String sql = "UPDATE penyewaan SET id_kendaraan = '"+p.getKendaraan().getId()+"', id_customer = "+p.getCustomer().getId()+","
                + " lama_sewa = '"+p.getLama_sewa()+"', total_harga = "+p.getTotal_harga()+", fasilitas = '"+p.getFasilitas()+"'"
                + " WHERE id = "+p.getId()+"";
        
        System.out.println("Updating data penyewaan");
        try {
            Statement statement = con.createStatement();
            int resut = statement.executeUpdate(sql);
            System.out.println("Update "+resut+" penyewaan...");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error updating data penyewaan....");
            System.out.println(e);
        }
        dbcon.closeConnection();
    }
    
    public void deletePenyewaan(int id){
        con = dbcon.makeConnection();
        
        String sql = "DELETE FROM penyewaan WHERE id = '"+id+"' ";
        
        System.out.println("Deleting penyewaan...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Success deleting "+result+" penyewaan");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting penyewaan...");
            System.out.println(e);
        }
        dbcon.closeConnection();
    }
}
