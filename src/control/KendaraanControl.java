package control;

import dao.KendaraanDAO;
import java.util.List;
import model.Kendaraan;
/**
 * Nama : Made Riksi Purnama Sadnya Agung
 * NPM  : 210711396
 * 
 * Nama : I Made Panji Pusaka Suryeswara
 * NPM  : 210711397
 */
public class KendaraanControl {
    private KendaraanDAO kDao = new KendaraanDAO();
    
     public void insertDataKendaraan(Kendaraan k) {
         kDao.insertKendaraan(k);
    }
    public String showDataMobil(){
        List<Kendaraan> dataKendaraan = kDao.showKendaraan();
        String mobilString="";
        for (int i=0; i < dataKendaraan.size(); i++) {
            if(dataKendaraan.get(i).getJenis().endsWith("Mobil")){
                 mobilString = mobilString + dataKendaraan.get(i).showDataKendaraan()+ "\n";
            }
         }
        return mobilString;
    }
    
    public String showDataMotor(){
        List<Kendaraan> dataKendaraan = kDao.showKendaraan();
        String motorString="";
        for (int i=0; i < dataKendaraan.size(); i++) {
            if(dataKendaraan.get(i).getJenis().endsWith("Motor")){
                 motorString = motorString + dataKendaraan.get(i).showDataKendaraan()+ "\n";
            }
         }
        return motorString;
    }
    
    public int countKendaraan(String jenis){
        List<Kendaraan> dataKendaraan = kDao.showKendaraan();
        int count = 0;
        int length = 0;
        for (int i=0; i < dataKendaraan.size(); i++) {
            if(dataKendaraan.get(i).getId().contains("MBL-") && dataKendaraan.get(i).getJenis().equals(jenis)){
                if (dataKendaraan.get(i).getId().length() >= length) {
                    length = dataKendaraan.get(i).getId().length();
                    count = Integer.parseInt(dataKendaraan.get(i).getId().substring(4));
                }
            }else if(dataKendaraan.get(i).getId().contains("MTR-") && dataKendaraan.get(i).getJenis().equals(jenis)){
                if (dataKendaraan.get(i).getId().length() >= length) {
                    length = dataKendaraan.get(i).getId().length();
                    count = Integer.parseInt(dataKendaraan.get(i).getId().substring(4));
                }
            }
         }
        return count;
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
   
   public List<Kendaraan> showAllKendaraan(){
        List<Kendaraan> dataKendaraan = kDao.showKendaraan();
        return dataKendaraan;
    }
}
