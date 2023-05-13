package model;
/**
 * Nama : Made Riksi Purnama Sadnya Agung
 * NPM  : 210711396
 * 
 * Nama : I Made Panji Pusaka Suryeswara
 * NPM  : 210711397
 */
public class Customer {
    private int id;
    private String nama;
    private String ktp;
    private String no_telepon;

    public Customer(int id, String nama, String ktp, String no_telepon) {
        this.id = id;
        this.nama = nama;
        this.ktp = ktp;
        this.no_telepon = no_telepon;
    }

    public Customer(String nama, String ktp, String no_telepon) {
        this.nama = nama;
        this.ktp = ktp;
        this.no_telepon = no_telepon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }
    
    @Override
    public String toString(){
        return nama;
    }
}
