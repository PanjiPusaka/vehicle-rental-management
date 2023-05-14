package table;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Penyewaan;
        
/**
 * Nama : Made Riksi Purnama Sadnya Agung
 * NPM  : 210711396
 * 
 * Nama : I Made Panji Pusaka Suryeswara
 * NPM  : 210711397
 */
public class TablePenyewaan extends AbstractTableModel{
    private List<Penyewaan> list;

    public TablePenyewaan(List<Penyewaan> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    public int getColumnCount(){
        return 8;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getKendaraan().getMerk();
            case 1:
                return list.get(rowIndex).getKendaraan().getJenis();
            case 2:
                return list.get(rowIndex).getCustomer().getNama();
            case 3:
                return list.get(rowIndex).getLama_sewa();
            case 4:
                return list.get(rowIndex).getTotal_harga();
            case 5:
                return list.get(rowIndex).getFasilitas();
            case 6:
                return list.get(rowIndex).getKendaraan().getJumlah_penumpang();
            case 7:
                return list.get(rowIndex).getKendaraan().getJenis_tak();
            case 8:
                return list.get(rowIndex).getId();
            case 9:
                return list.get(rowIndex).getKendaraan().getId();
            case 10:
                return list.get(rowIndex).getCustomer().getId();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0 :
                return "Merk Kendaraan";
            case 1 :
                return "Jenis Kendaraan";
            case 2 :
                return "Nama Customer";
            case 3 :
                return "Lama Sewa";
            case 4 :
                return "Total Harga";
            case 5 :
                return "Fasilitas";
            case 6 :
                return "Jumlah Penumpang";
            case 7 :
                return "Jenis Motor";
            default :
                return null;
        }
    }
    
}
