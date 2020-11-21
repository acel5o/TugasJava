class KaryawanRun { //declaring class KaryawanRun dengan modifier protected
    public static void main(String[] args) {// fungsi main --> harus ada String[] args untuk menyimpan argumen
        Karyawan Manajer = new Karyawan("Zefanya","Manager",10000000); //membuat objek Manajer
        Karyawan Supervisor = new Karyawan("Marcel","Supervisor",7000000);// membuat objek supervisor
        Karyawan Staff = new Karyawan("Kurnia Jaya","Staff",5000000);// membuat objek Staff

        Manajer.printStates(); //memanggil method printStates dari objek Manajer
        Supervisor.printStates(); //memanggil method printStates dari objek Supervisor
        Staff.printStates(); //memanggil method printStates dari objek Staff
    }
}
