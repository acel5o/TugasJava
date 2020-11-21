class Mobil {
     String Merek = "Avanza";
    String Warna = "Merah";
    int Gigi = 1;
    int Kecepatan = 200;

    void TambahGigi(int newValue) {
         Gigi = Gigi+newValue;
    }

    void Warna1(String newValue) {
        Warna = newValue;
    }

    void Merek1(String newValue) {
        Merek = newValue;
    }

    void KurangGigi(int newValue) {
         Gigi = Gigi-newValue;
    }

    void Mengerem(int decrement) {
         Kecepatan = Kecepatan - decrement;   
    }


    void printStates() {
         System.out.println("Mobil :" + Merek + " Warna :"+ Warna +" Gigi :" +
             Gigi + " Kecepatan :" + 
             Kecepatan);
    }
}
