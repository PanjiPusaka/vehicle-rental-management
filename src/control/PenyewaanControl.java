package control;
/**
 * Nama : Made Riksi Purnama Sadnya Agung
 * NPM  : 210711396
 * 
 * Nama : I Made Panji Pusaka Suryeswara
 * NPM  : 210711397
 */
import dao.PenyewaanDAO;
import java.util.List;
import model.Penyewaan;
import table.TablePenyewaan;

public class PenyewaanControl {
    private PenyewaanDAO pDao = new PenyewaanDAO();
    
    public void insertPenyewaan(Penyewaan p){
        pDao.insertPenyewaan(p);
    }
    
    public void updatePenyewaan(Penyewaan p){
        pDao.updatePenyewaan(p);
    }
    
    public void deletePenyewaan(int id){
        pDao.deletePenyewaan(id);
    }
    
    public TablePenyewaan showPenyewaan(String query){
        List<Penyewaan> list = pDao.showPenyewaan(query);
        TablePenyewaan tablePenyewaan = new TablePenyewaan(list);
        return tablePenyewaan;
    }
}
