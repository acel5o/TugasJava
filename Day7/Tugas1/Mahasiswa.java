import java.util.*;
class Mahasiswa {
    Integer Id;
    String nama;
    ArrayList<Double> Nilai = new ArrayList<>();

    public Mahasiswa(int Id, String Nama, Double ing, Double fi, Double al){
        this.Id = Id;
        this.nama = Nama;
        Nilai.add(ing);
        Nilai.add(fi);
        Nilai.add(al);
    }

    ArrayList<Double> getNilai(){
        return Nilai;
    }

    void setNama(String Nama) {
        nama = Nama;
       
    }

    public Integer getID(){
        return Integer.valueOf(this.Id);
    }

    String getNama() {
         return nama;
    } 
}