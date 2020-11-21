class Siswa {
    String nama = "";
    String nilai = "";
    String gender = "";
    String kelas = "";
    String bulan= "";
    int umur = 0;
    int lahir_tgl = 0;
    int lahir_bln = 0;
    int lahir_thn = 0;
    int tahun = 2020;
    int values=0;

    public Siswa(int tgl, int bln, int thn){//constructor siswa(parameter tgl,bln,thn)
        this.lahir_tgl = tgl;
        this.lahir_bln = bln;
        this.lahir_thn = thn;
    }

    public Siswa(int value){//constructor siswa(parameter value)
        this.values = value;
    }

    int GetBulan(){//method get bulan
        return this.lahir_bln;
    }

    int GetTahun(){//method get tahun
        return this.lahir_thn;
    }

    int GetUmur(){//method get umur
        return this.umur;
    }

    void PrintLahir(int lahir_bln) {//method tampil Tanggal Lahir String
        //logika bulan int to string
        if(lahir_bln==1){
            bulan="Januari";
        }
        else if(lahir_bln==2){
            bulan="Februari";
        }
        else if(lahir_bln==3){
            bulan="Maret";
        }
        else if(lahir_bln==4){
            bulan="April";
        }
        else if(lahir_bln==5){
            bulan="Mei";
        }
        else if(lahir_bln==6){
            bulan="Juni";
        }
        else if(lahir_bln==7){
            bulan="Juli";
        }
        else if(lahir_bln==8){
            bulan="Agustus";
        }
        else if(lahir_bln==9){
            bulan="September";
        }
        else if(lahir_bln==10){
            bulan="Oktober";
        }
        else if(lahir_bln==11){
            bulan="November";
        }
        else if(lahir_bln==12){
            bulan="Desember";
        }else{
            bulan="";
        }
        System.out.println("Tanggal Lahir : " + lahir_tgl + " " + bulan + " " + lahir_thn);
    }

    void PrintUmur(int lahir_thn) {// method tampil umur
        umur = tahun - lahir_thn; //hitung umur 
        System.out.println("Umur : " + umur);
    }

    void PrintGrade() {//method tampil Grade
        //logika Grade(String) 
        if (values >= 90) {
            nilai = "A";
        } else if (values >= 80) {
            nilai = "B";
        } else if (values >= 70) {
            nilai = "C";
        } else if (values >= 60) {
            nilai = "D";
        } else {
            nilai = "E";
        }
        System.out.println("Nilai Anda : " + nilai);
    }

    void PrintKelas(int umur) {//method tampil pendidikan berdasar umur
        if (umur == 14) {
            kelas = "Kelas 1 SMA";
        } else if (umur == 15) {
            kelas = "Kelas 2 SMA";
        } else if (umur == 16) {
            kelas = "Kelas 3 SMA";
        } else if (umur == 17) {
            kelas = "Semester 1";
        } else if (umur == 18) {
            kelas = "Semester 2";
        } else if (umur == 19) {
            kelas = "Semester 3";
        } else if (umur == 20) {
            kelas = "Semester 4";
        } else{
            kelas = "";
        }
        System.out.println("Pendidikan : " + kelas);
    }

    void PrintHistori(int lahir_thn) {//method tampil histori usia
        int usia=0;
        System.out.println("History :");
        //perulangan untuk tahun dan usia
        for(int i = lahir_thn; i<=2020; i++){
            System.out.println("- Tahun : " + i + " " + "Umur :" + usia++);
        }
    }
}
