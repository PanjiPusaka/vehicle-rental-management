package control;
/**
 * Nama : Made Riksi Purnama Sadnya Agung
 * NPM  : 210711396
 * 
 * Nama : I Made Panji Pusaka Suryeswara
 * NPM  : 210711397
 */
import dao.CustomerDAO;
import java.util.List;
import model.Customer;
import table.TableCustomer;

public class CustomerControl {
    private CustomerDAO cDao = new CustomerDAO();
    
    public void insertCustomer(Customer c){
        cDao.insertCustomer(c);
    }
    
    public void deleteCustomer(int id){
        cDao.deleteCustomer(id);
    }
    
    public void updateCustomer(Customer c){
        cDao.updateCustomer(c);
    }
    
    public TableCustomer showCustomerBySearch(String query){
        List<Customer> list = cDao.showCustomerBySearch(query);
        TableCustomer tableCustomer =  new TableCustomer(list);
        
        return tableCustomer;
    }
}
