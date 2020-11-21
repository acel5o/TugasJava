public abstract class Worker {
    int IDKaryawan;
    String Nama;
    String Jabatan;
    int Pulsa;
    int Gapok;
    int Absen;
    int Totali;

    public Worker(int id, String nama, String jabatan, int pulsa, int gapok){
        this.IDKaryawan = id;
        this.Nama = nama;
        this.Jabatan = jabatan;
        this.Pulsa = pulsa;
        this.Gapok = gapok;
    }

    abstract void setAbsen(int absen);

    int getId(){
        return IDKaryawan;
    }

    String getNama(){
        return Nama;
    }

    String getJabatan(){
        return Jabatan;
    }

    int getPulsa(){
        return Pulsa;
    }

    int getGapok(){
        return Gapok;
    }

    int getAbsen(){
        return Absen;
    }

    void setTotal(int total){
        Totali = total;
    }

    int getTotal(){
        return Totali;
    }
}
