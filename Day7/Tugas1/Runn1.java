import java.util.*;
import java.util.regex.*;
import java.io.*;

public class Runn1 {
    public static Scanner keyboard = new Scanner(System.in);
    public static ArrayList<Mahasiswa> student = new ArrayList<Mahasiswa>();
    public static boolean LoggedIn = false;
    public static int ID = 101;
    private static final String HORIZONTAL_SEP = "-";
    private String verticalSep;
    private String joinSep;
    private String[] headers;
    private List<String[]> rows = new ArrayList<>();
    private boolean rightAlign;

    public Runn1() {
        setShowVerticalLines(false);
    }

    public void setRightAlign(boolean rightAlign) {
        this.rightAlign = rightAlign;
    }

    public void setShowVerticalLines(boolean showVerticalLines) {
        verticalSep = showVerticalLines ? "|" : "";
        joinSep = showVerticalLines ? "+" : " ";
    }

    public void setHeaders(String... headers) {
        this.headers = headers;
    }

    public void addRow(String... cells) {
        rows.add(cells);
    }

    public void print() {
        int[] maxWidths = headers != null ?
                Arrays.stream(headers).mapToInt(String::length).toArray() : null;

        for (String[] cells : rows) {
            if (maxWidths == null) {
                maxWidths = new int[cells.length];
            }
            if (cells.length != maxWidths.length) {
                throw new IllegalArgumentException("Number of row-cells and headers should be consistent");
            }
            for (int i = 0; i < cells.length; i++) {
                maxWidths[i] = Math.max(maxWidths[i], cells[i].length());
            }
        }

        if (headers != null) {
            printLine(maxWidths);
            printRow(headers, maxWidths);
            printLine(maxWidths);
        }
        for (String[] cells : rows) {
            printRow(cells, maxWidths);
        }
        if (headers != null) {
            printLine(maxWidths);
        }
    }

    private void printLine(int[] columnWidths) {
        for (int i = 0; i < columnWidths.length; i++) {
            String line = String.join("", Collections.nCopies(columnWidths[i] +
                    verticalSep.length() + 1, HORIZONTAL_SEP));
            System.out.print(joinSep + line + (i == columnWidths.length - 1 ? joinSep : ""));
        }
        System.out.println();
    }

    private void printRow(String[] cells, int[] maxWidths) {
        for (int i = 0; i < cells.length; i++) {
            String s = cells[i];
            String verStrTemp = i == cells.length - 1 ? verticalSep : "";
            if (rightAlign) {
                System.out.printf("%s %" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
            } else {
                System.out.printf("%s %-" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
            }
        }
        System.out.println();
    }

    
    public static void main(String[] args) throws Exception{
        do {
            System.out.println("LOGIN");
            System.out.print("Username : ");
            String username = keyboard.nextLine();
            System.out.print("Password : ");
            String password = keyboard.nextLine();
            try {
                Login(username, password);
                if (LoggedIn) {
                    System.out.println("Berhasil Login");
                    menu();
                } else {
                    System.out.println("Gagal Login");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (LoggedIn != true);
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
            Runn1 st = new Runn1();
            st.setShowVerticalLines(true);
            st.setHeaders("ID","Nama", "Bahasa Inggris", "Fisika", "Algoritma");
            for (Mahasiswa obj: student) {
                st.addRow(Integer.toString(obj.getID()),obj.getNama(),Double.toString(obj.getNilai().get(0)),Double.toString(obj.getNilai().get(1)),Double.toString(obj.getNilai().get(2)));
            }
            st.print();
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
    public static void Login(String email, String pass) throws Exception {
        String emailTemp="";
        String passTemp="";
        boolean emailCorrect = Pattern.compile("^[\\w._%+-]+@[\\w.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(email).matches();
        boolean passCorrect = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$").matcher(pass).matches();
        if (emailCorrect && passCorrect){
            FileReader username=new FileReader("username.txt");
            FileReader password=new FileReader("password.txt");
            BufferedReader uname=new BufferedReader(username);
            BufferedReader pw=new BufferedReader(password);
            int i;
            while((i=uname.read())!=-1){
                emailTemp+=(char)i;
            }
            while((i=pw.read())!=-1){
                passTemp+=(char)i;
            }

            if (Pattern.matches(email, emailTemp) && Pattern.matches(pass, passTemp)){
                LoggedIn = true;
            } else {
                System.out.println("Email atau Password salah");
            }
            uname.close();
            pw.close();
            username.close();
            password.close();
        }else {
            System.out.println("Password harus lebih dari 8 character, ada huruf besar dan kecil, memiliki special character");
        }

    }
}
