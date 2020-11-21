class MobilDemo {
    public static void main(String[] args) {

        // Create two different 
        // Bicycle objects
        Mobil Mobil1 = new Mobil();
        Mobil Mobil2 = new Mobil();

        // Invoke methods on 
        // those objects
        Mobil1.Merek1("Subaru");
        Mobil1.TambahGigi(1);
        Mobil1.KurangGigi(1);
        Mobil1.Mengerem(100);
        Mobil1.printStates();

        Mobil2.Warna1("Jingga");
        Mobil2.TambahGigi(2);
        Mobil2.Mengerem(50);
        Mobil2.printStates();
    }
}
