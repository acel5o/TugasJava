public class Staff extends Worker{
    public Staff(int id, String nama, String jabatan, int pulsa, int gapok) {
        super(id, nama, jabatan, pulsa, gapok);
        // TODO Auto-generated constructor stub
    }
    int TMakan = 0;
    int Total;

    void setAbsen(int absen){
        this.Absen = absen;
    }

    void setMakan(int absen){
        this.TMakan = absen * 20000;
    }

    int getMakan(){
        return TMakan;
    }

    public void GajiTotal(int id){
        if (id == this.IDKaryawan){
            this.Total = this.Gapok + this.Pulsa + this.TMakan;
        }
    }

    int getTotal(){
        return this.Total;
    }
}