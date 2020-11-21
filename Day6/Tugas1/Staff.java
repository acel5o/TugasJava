import java.io.*;
import java.util.*;

public class Staff extends Worker implements Comparable{

    public static ArrayList<Staff> staff = new ArrayList<>();
    private static final String HORIZONTAL_SEP = " ";
    private String verticalSep;
    private String joinSep;
    private String[] headers;
    private List<String[]> rows = new ArrayList<>();
    private boolean rightAlign;

    // void SetId(int id){
    //     this.id = id;
    // }

    // int GetId(){
    //     return id;
    // }

    // void SetNama(String nama){
    //     this.nama = nama;
    // }

    // String GetNama(){
    //     return nama;
    // }

    // void SetJabatan(String nama){
    //     this.nama = nama;
    // }

    // String GetJabatan(){
    //     return nama;
    // }

    // void SetAbsen(int absen){
    //     this.absen = this.absen + absen;
    // }

    // int GetAbsen(){
    //     return absen;
    // }

    public Staff() {
        setShowVerticalLines(false);
    }

    public void setRightAlign(boolean rightAlign) {
        this.rightAlign = rightAlign;
    }

    public void setShowVerticalLines(boolean showVerticalLines) {
        verticalSep = showVerticalLines ? " " : "";
        joinSep = showVerticalLines ? " " : " ";
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

    public static void main(String[] args) {
        TampilMenu();
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        String Menu="";
        try {
            while (!Menu.equals("4")){
                System.out.print("Pilih Menu 1/2/3/4: ");
                Menu=br.readLine();
                switch (Menu){
                    case "1":
                        System.out.println();
                        InputData();
                        break;
                    case "2":
                        System.out.println();
                        plusAbsen();
                        break;
                    case "3":
                        System.out.println();
                        tampil();
                        break;
                    default :
                        System.out.println();
                    break;
                }
            }
        } catch (Exception e){
            System.out.println("Error: "+e);
        }
    }

    private static void InputData(){
        String jabatan;
        String id="";
        String nama="";
        String absen="0";
        try {
            InputStreamReader r=new InputStreamReader(System.in);
            BufferedReader br=new BufferedReader(r);
            System.out.print("Masukan Id: ");
            id=br.readLine();
                for (int i=0;i<staff.size();i++){
                    if (staff.get(i).GetId()==Integer.parseInt(id)){
                        System.out.println("ID telah Terdaftar");
                        System.out.println("Masukan Id lain: ");
                        id=br.readLine();
                    }
                }
            System.out.print("Masukan Nama: ");
            nama=br.readLine();
            System.out.print("Masukan Jabatan: ");
            jabatan=br.readLine();
            Staff stf = new Staff();
            stf.SetId(Integer.parseInt(id));
            stf.SetNama(nama);
            stf.SetJabatan(jabatan);
            stf.SetAbsen(Integer.parseInt(absen));
            staff.add(stf);
            System.out.println("Input Data Berhasil!!");
            TampilMenu();
        } catch (Exception e){
            System.out.println(e);
            TampilMenu();
        }
    }

    private static void plusAbsen() throws Exception{
        String id="";
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        System.out.print("Masukan Id : ");
        id=br.readLine();
        for (int i=0;i<staff.size();i++){
            if (staff.get(i).GetId()==Integer.parseInt(id)){
            int absen= staff.get(i).GetAbsen() + 1;
            System.out.println("Nama : "+staff.get(i).GetNama());
            System.out.println("Absen : "+staff.get(i).GetAbsen());
            Staff stf = new Staff();
            stf.SetId(staff.get(i).GetId());
            stf.SetNama(staff.get(i).GetNama());
            stf.SetAbsen(absen);
            staff.set(i,stf);
            }
        }
    }

    private static void tampil(){
        Collections.sort(staff);
        Staff st = new Staff();
        //st.setRightAlign(true);//if true then cell text is right aligned
        st.setShowVerticalLines(true);//if false (default) then no vertical lines are shown
        st.setHeaders("ID", "Nama", "Jabatan", "Absen");//optional - if not used then there will be no header and horizontal lines
        for(Staff obj: staff){
            st.addRow(Integer.toString(obj.GetId()), obj.GetNama(), obj.GetJabatan(), Integer.toString(obj.GetAbsen()));
        }
        st.print();
        TampilMenu();
    }

    private static void TampilMenu(){
            System.out.println("Silahkan Pilih Menu");
            System.out.println("1. Buat Staff");
            System.out.println("2. Tambah Absen");
            System.out.println("3. Tampil Laporan");
            System.out.println("4. Exit");
    }

    @Override 
    public int compareTo(Object o) {
        int banding= ((Staff)o).GetId();
        return this.id-banding;
    }

    // @Override
    // void SetId() {
    //     // TODO Auto-generated method stub

    // }

    // @Override
    // void SetNama() {
    //     // TODO Auto-generated method stub

    // }

    // @Override
    // void SetJabatan() {
    //     // TODO Auto-generated method stub

    // }

    // @Override
    // void SetAbsen() {
    //     // TODO Auto-generated method stub

    // }
}