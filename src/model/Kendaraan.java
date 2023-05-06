/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;
/**
 * Nama : Made Riksi Purnama Sadnya Agung
 * NPM  : 210711396
 * 
 * Nama : I Made Panji Pusaka Suryeswara
 * NPM  : 210711397
 */
public class Kendaraan {
    private String id;
    private String merk;
    private String jenis;
    private int tahunPembuatan;
    private String noPlat;
    private int jumlah_penumpang;
    private String jenis_tak;
    public Kendaraan(String id, String merk, String jenis, int tahunPembuatan, String noPlat, int jumlah_penumpang, String jenis_tak) {
        this.id = id;
        this.merk = merk;
        this.jenis = jenis;
        this.tahunPembuatan = tahunPembuatan;
        this.noPlat = noPlat;
        if(jenis.equalsIgnoreCase("Mobil")){
            this.jumlah_penumpang = jumlah_penumpang;
            this.jenis_tak = "";
        }else{ 
            this.jenis_tak = jenis_tak;
            this.jumlah_penumpang = 0;
        }
    }
    public String getId() {
        return id;
    }
    public String getMerk() {
        return merk;
    }
    public String getJenis() {
        return jenis;
    }
    public int getTahunPembuatan() {
        return tahunPembuatan;
    }
    public String getNoPlat() {
        return noPlat;
    }
    public int getJumlah_penumpang() {
        return jumlah_penumpang;
    }
    public String getJenis_tak() {
        return jenis_tak;
    }

    public String showDataKendaraan(){
        if (jenis.equalsIgnoreCase("Mobil")) {
            return "ID : "+id+"\nMerk : "+merk+"\nTahun : "+tahunPembuatan+
                "\nNomor : "+noPlat+"\nJumlah Penumpang : "+jumlah_penumpang+"\n\n";
        }else{
            return "ID : "+id+"\nMerk : "+merk+"\nTahun : "+tahunPembuatan+
                    "\nNomor : "+noPlat+"\nJenis Motor : "+jenis_tak+"\n\n";
        }
    }
    
}
