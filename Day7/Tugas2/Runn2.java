import java.util.*;

public class Runn2 {
    public static Scanner keyboard = new Scanner(System.in);
    public static ArrayList<Mahasiswa> student = new ArrayList<Mahasiswa>();
    public static boolean LoggedIn = false;
    public static int ID = 101;

    
    public static void main(String[] args) throws Exception{
        menu();
    }

    public static void menu() throws Exception{
        int keyInput;
            System.out.println("MENU\n1. Create & Input Data Mahasiswa\n2. Edit or Delete Data Mahasiswa\n3. Tampilkan laporan Nilai Data Mahasiswa\n\n4. Exit\n");
            System.out.print("Pilih Menu : ");
            keyInput = Integer.parseInt(keyboard.nextLine());
        if(keyInput!=4){
            switch (keyInput) {
                case 1:
                    buatMhs();
                    ID++;
                    menu();
                    break;
                case 2:
                    if(keyInput!=9){
                        System.out.println("MENU\n1. Edit Data Mahasiswa\n2. Delete Data Mahasiswa\n\n3. Back to Main Menu\n");
                        System.out.print("Pilih Menu : ");
                        keyInput = Integer.parseInt(keyboard.nextLine());
                        switch (keyInput ) {
                            case 1:
                                ubahMhs();
                                menu();
                                break;
                            case 2:
                                hapusMhs();
                                menu();
                                break;
                            default:
                                break;
                        }
                    }
                    break;      
                case 3:
                    System.out.println("Laporan Mahasiswa");
                    laporanMhs();
                    tulis();
                    menu();
                    break;
                default:
                    break;
            }
        }
    }

    public static void buatMhs(){
        System.out.println("Tambah Mahasiswa");
        try {
            System.out.println("NIM : " +ID);
            System.out.print("Masukan Nama : ");
            String nama = keyboard.nextLine();
            System.out.print("Masukan Nilai Bahasa Inggris: ");
            Double bing = Double.parseDouble(keyboard.nextLine());
            System.out.print("Masukan Nilai Fisika : ");
            Double fis = Double.parseDouble(keyboard.nextLine());
            System.out.print("Masukan Nilai Algoritma : ");
            Double alg = Double.parseDouble(keyboard.nextLine());
            student.add(new Mahasiswa(ID, nama,bing,fis,alg));
        } catch (Exception e) {
            System.out.println(e);
        } 
    }

    public static void ubahMhs(){
        System.out.println("\nEdit Mahasiswa");
        try {
            System.out.print("Masukan NIM : ");
            int id = Integer.parseInt(keyboard.nextLine());
            int index;
            Comparator<Mahasiswa> c = new Comparator<Mahasiswa>() 
            { 
                public int compare(Mahasiswa u1, Mahasiswa u2) 
                { 
                    return u1.getID().compareTo(u2.getID()); 
                } 
            }; 
            index = Collections.binarySearch(student, new Mahasiswa(id, null,null,null,null), c);
            System.out.print("Masukan Nama : ");
            String nama = keyboard.nextLine(); 
			student.get(index).setNama(nama);
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            System.out.println("Sukses!!");
        }
    }

    public static void hapusMhs(){
        System.out.println("\nRemove Mahasiswa");
        try {
            System.out.print("Masukan NIM : ");
            int id = Integer.parseInt(keyboard.nextLine());
            int index;
            Comparator<Mahasiswa> c = new Comparator<Mahasiswa>() 
            { 
                public int compare(Mahasiswa u1, Mahasiswa u2) 
                { 
                    return u1.getID().compareTo(u2.getID()); 
                } 
            }; 
            index = Collections.binarySearch(student, new Mahasiswa(id, null,null,null,null), c);
			student.remove(index);
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            System.out.println("Sukses!!");
        }
    }
    
    public static void laporanMhs(){
        try {
            tabel show = new tabel();
            show.setShowVerticalLines(true);
            show.setHeaders("ID","Nama", "Bahasa Inggris", "Fisika", "Algoritma");
            for (Mahasiswa obj: student) {
                show.addRow(Integer.toString(obj.getID()),obj.getNama(),Double.toString(obj.getNilai().get(0)),Double.toString(obj.getNilai().get(1)),Double.toString(obj.getNilai().get(2)));
            }
            show.print();
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
     public static void tulis(){
        try {
            tabel show = new tabel();
            show.setShowVerticalLines(true);
            show.setHeaders("ID","Nama", "Bahasa Inggris", "Fisika", "Algoritma");
            for (Mahasiswa obj: student) {
                show.addRow(Integer.toString(obj.getID()),obj.getNama(),Double.toString(obj.getNilai().get(0)),Double.toString(obj.getNilai().get(1)),Double.toString(obj.getNilai().get(2)));
            }
            show.savetofile();
        } catch (Exception e) {
            System.out.println(e);
        } 
        
    }
}