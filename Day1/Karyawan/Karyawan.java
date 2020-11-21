class Karyawan { //declaring class Karyawan dengan modifier protected
    String Nama = ""; //deklarasi variabel Nama dengan type String (attributes declaration)
    String Jabatan = ""; //deklarasi variabel Jabatan dengan type String (attributes declaration)
    int Gaji = 0; //deklarasi variabel Gaji dengan tipe integer (attributes declaration)

    public Karyawan(String nama, String jabatan, int gaji){ //inisialisasi construktor Karyawan dengan parameter nama(String),jabatan(string),gaji(integer)
        Nama = nama;
        Jabatan = jabatan;
        Gaji = gaji; 
    }

    void SetNama(String newNama) {//declaring method SetNama dengan tipe variabel void(kosong)
         Nama = newNama;
    }

    String GetNama() {//declaringmethod GetNama dengan tipe String
        return Nama;
    }

    void SetJabatan(String newJabatan) {//declaringmethod SetJabatan dengan tipe variabel void(kosong)
        Jabatan = newJabatan;
    }

    String GetJabatan() {//declaringmethod GetJabatan dengan tipe String
         return Jabatan;
    }

    void SetGaji(int increment) {//declaringmethod SetGaji dengan tipe variabel void(kosong)
         Gaji = increment;   
    }

    int GetGaji() {//declaring method GetGaji dengan tipe integer
        return Gaji;  
   }

    void printStates() {//declaring Method printStates
         System.out.println("Nama :" + Nama + "\n" + "Jabatan :" + Jabatan + "\n" +
                            "Gaji :" +Gaji+"\n" +"------------------------------");
    }
}
