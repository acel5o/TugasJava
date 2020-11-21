class MahasiswaDemo {
    public static void main(String[] args) {

        // Create two different 
        // Bicycle objects
        Mahasiswa M1 = new Mahasiswa();
        Mahasiswa M2 = new Mahasiswa();

        // Invoke methods on 
        // those objects
        M1.SetNama("Zefanya");
        M1.SetJK("Pria");
        M1.SetUmur(10);

        M1.GetNama();
        M1.GetJK();
        M1.GetUmur();

        M1.printStates();


        M2.SetNama("Marcelia");
        M2.SetJK("Wanita");
        M2.SetUmur(20);

        M2.GetNama();
        M2.GetJK();
        M2.GetUmur();

        M2.printStates();

    }
}
