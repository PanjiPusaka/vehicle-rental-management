package table;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Customer;

/**
 * Nama : Made Riksi Purnama Sadnya Agung
 * NPM  : 210711396
 * 
 * Nama : I Made Panji Pusaka Suryeswara
 * NPM  : 210711397
 */
public class TableCustomer extends AbstractTableModel{
    private List<Customer> list;

    public TableCustomer(List<Customer> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public int getColumnCount(){
        return 4;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getKtp();
            case 3:
                return list.get(rowIndex).getNo_telepon();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nama";
            case 2:
                return "No. KTP";
            case 3:
                return "No. Telepon";
            default:
                return null;
        }
    }
}
