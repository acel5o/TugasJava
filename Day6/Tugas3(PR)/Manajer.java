public class Manajer extends Worker{

    public Manajer(int id, String nama, String jabatan, int pulsa, int gapok) {
        super(id, nama, jabatan, pulsa, gapok);
        // TODO Auto-generated constructor stub
    }
    int TTransport=0;
    int TEntertaint=0;
    int Total=0;

    void setAbsen(int absen){
        this.Absen = absen;
    }

    void setEnt(int Ent){
        this.TEntertaint = Ent * 500000;
    }

    int getEnt(){
        return TEntertaint;
    }

    void setTrans(int absen){
        this.TTransport = absen * 50000;
    }

    int getTrans(){
        return TTransport;
    }

    public void GajiTotal(int id){
        if (id == this.IDKaryawan){
            this.Total = this.Gapok + this.TEntertaint + this.TTransport;
        }
    }

    int getTotal(){
        return this.Total;
    }
}
