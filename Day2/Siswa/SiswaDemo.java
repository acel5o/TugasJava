class SiswaDemo {
    public static void main(String[] args) {// fungsi main --> harus ada String[] args untuk menyimpan argumen
        Siswa murid = new Siswa(9,3,2000); //membuat objek murid
        murid.PrintLahir(murid.GetBulan()); 
        murid.PrintUmur(murid.GetTahun());
        murid.PrintKelas(murid.GetUmur());
        murid.PrintHistori(murid.GetTahun());

        Siswa nilai_murid = new Siswa(10);//membuat objek nilai
        nilai_murid.PrintGrade();   
    }
}