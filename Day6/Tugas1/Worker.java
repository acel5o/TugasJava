public  class Worker {
    int id;
    String nama;
    int absen;
    String jabatan;

    void SetId(int id){
        this.id = id;
    }

    int GetId(){
        return id;
    }

    void SetNama(String nama){
        this.nama = nama;
    }

    String GetNama(){
        return nama;
    }

    void SetJabatan(String nama){
        this.nama = nama;
    }

    String GetJabatan(){
        return nama;
    }

    void SetAbsen(int absen){
        this.absen = this.absen + absen;
    }

    int GetAbsen(){
        return absen;
    }

    // public abstract void SetId(){
        
    // }

    // public abstract int GetId(){
        
    // }

    // public abstract void SetNama(){
        
    // }

    // public abstract String GetNama(){
    //     return nama;
    // }

    // public abstract void SetJabatan(){
        
    // }

    // public abstract String GetJabatan(){
    
    // }

    // public abstract void SetAbsen(){
        
    // }

    // public abstract int GetAbsen(){
        
    // }
}
