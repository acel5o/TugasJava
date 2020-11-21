class Mahasiswa {
    String Nama = "";
    String JK = "";
    int Umur = 0;

    void SetNama(String newNama) {
         Nama = newNama;
    }

    String GetNama() {
        return Nama;
    }

    void SetJK(String newJK) {
        JK = newJK;
    }

    String GetJK() {
        return JK;
    }

    void SetUmur(int newUmur) {
        Umur = newUmur;
    }

    int GetUmur() {
         return Umur;
    }


    void printStates() {
         System.out.println("Data Nama Mahasiswa"+"\n"+" Nama :" + Nama + "\n" +" Jenis Kelamin :"+ 
         JK +"\n"+" Umur :" + Umur+ "\n" + "-------------------------");
    }
}
