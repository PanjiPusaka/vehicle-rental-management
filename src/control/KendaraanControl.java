/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;
import dao.KendaraanDAO;
import java.util.List;
import model.Kendaraan;

public class KendaraanControl {
    private KendaraanDAO kDao = new KendaraanDAO();
    
     public void insertDataKendaraan(Kendaraan k) {
         kDao.insertKendaraan(k);
    }
    public String showDataKendaraan() {

         List<Kendaraan> dataKendaraan = kDao.showKendaraan();

         String kendaraanString = "";
             for (int i=0; i < dataKendaraan.size(); i++) {
                 kendaraanString = kendaraanString + dataKendaraan.get(i).showDataKendaraan()+ "\n";
             }
        return kendaraanString;
   }
    
 public Kendaraan  searchKendaraan(String id){
       Kendaraan k=null;
       k = kDao.searchKendaraan(id);
      return k;
   }
    
   public void updateDataKendaraan(Kendaraan k, String id){
       kDao.updateKendaraan(k,id);
   }
   
   public void deleteDataKendaraan(String id){
       kDao.deleteKendaraan(id);
   }

}
