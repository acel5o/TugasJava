import java.io.*;
import java.util.*;

public class Runn{
    public static ArrayList<Staff> staff = new ArrayList<>();
    public static ArrayList<Manajer> manajer = new ArrayList<>();

    private static final String HORIZONTAL_SEP = " ";
    private String verticalSep;
    private String joinSep;
    private String[] headers;
    private List<String[]> rows = new ArrayList<>();
    private boolean rightAlign;

    public Runn() {
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

    //save to file
    public void savetofile()throws Exception{
        try {
            FileWriter writer = new FileWriter("Worker.txt");
            BufferedWriter buffer = new BufferedWriter(writer);   
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
                //save line
                for (int i = 0; i < maxWidths.length; i++) {
                    String line = String.join("", Collections.nCopies(maxWidths[i] +
                            verticalSep.length() + 1, HORIZONTAL_SEP));
                    buffer.write(joinSep + line + (i == maxWidths.length - 1 ? joinSep : ""));
                }
                buffer.write("\n");

                //save row
                for (int i = 0; i < headers.length; i++) {
                    String s = headers[i];
                    String verStrTemp = i == headers.length - 1 ? verticalSep : "";
                    if (rightAlign) {
                        buffer.write(String.format("%s %" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp));
                    } else {
                        buffer.write(String.format("%s %-" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp));
                    }
                }
                buffer.write("\n");

                //save line
                for (int i = 0; i < maxWidths.length; i++) {
                    String line = String.join("", Collections.nCopies(maxWidths[i] +
                            verticalSep.length() + 1, HORIZONTAL_SEP));
                            buffer.write(joinSep + line + (i == maxWidths.length - 1 ? joinSep : ""));
                }
                buffer.write("\n");
            }
            for (String[] cells : rows) {
                //save row
                for (int i = 0; i < cells.length; i++) {
                    String s = cells[i];
                    String verStrTemp = i == cells.length - 1 ? verticalSep : "";
                    if (rightAlign) {
                        buffer.write(String.format("%s %" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp));
                    } else {
                        buffer.write(String.format("%s %-" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp));
                    }
                }
                buffer.write("\n");
            }
            if (headers != null) {
                for (int i = 0; i < maxWidths.length; i++) {
                    String line = String.join("", Collections.nCopies(maxWidths[i] +
                            verticalSep.length() + 1, HORIZONTAL_SEP));
                    buffer.write(joinSep + line + (i == maxWidths.length - 1 ? joinSep : ""));
                }
                buffer.write("\n");
            }
            buffer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        TampilMenu();
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        String Menu="";
        try {
            while (!Menu.equals("6")){
                System.out.print("Pilih Menu 1/2/3/4/5/6: ");
                Menu=br.readLine();
                switch (Menu){
                    case "1":
                        System.out.println();
                        InputData();
                        TampilMenu();
                        break;
                    case "2":
                        System.out.println();
                        Absen();
                        TampilMenu();
                        break;
                    case "3":
                        System.out.println();
                        Tunjangan();
                        TampilMenu();
                        break;
                    case "4":
                        System.out.println();
                        total();
                        TampilMenu();
                    break;
                    case "5":
                        System.out.println();
                        tampil();
                        TampilMenu();
                    break;
                    default :
                        System.out.println();
                        TampilMenu();
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
        int absen=20;
        int Pulsa = 50000;
        int GapokS = 5000000;
        int GapokM = 10000000;
       

        try {
            InputStreamReader r=new InputStreamReader(System.in);
            BufferedReader br=new BufferedReader(r);
            System.out.print("Masukan Id: ");
            id=br.readLine();
            System.out.print("Masukan Nama: ");
            nama=br.readLine();
            System.out.print("Masukan Jabatan: ");
            jabatan=br.readLine();
            switch(jabatan){
                case "Staff":
                    Staff stf = new Staff(Integer.parseInt(id),nama,jabatan,Pulsa,GapokS);
                    stf.setAbsen(absen);
                    stf.setMakan(0);
                    staff.add(stf);
                break;
                case "Manajer":
                    Manajer mng = new Manajer(Integer.parseInt(id),nama,jabatan,Pulsa,GapokM);
                    mng.setAbsen(absen);
                    mng.setTrans(0);
                    mng.setEnt(0);
                    manajer.add(mng);
                break;
                default:
                    
                break;
            }
            System.out.println("Input Data Berhasil!!");
            TampilMenu();
        } catch (Exception e){
            System.out.println(e);
            TampilMenu();
        }
    }

    private static void Absen() throws Exception{
        String jabatan="";
        String id="";
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        System.out.print("Masukan Jabatan : ");
        jabatan=br.readLine();
        switch(jabatan){
            case "Manajer" :
            System.out.print("Masukkan Id : ");
            id=br.readLine();
            for (int i=0;i<manajer.size();i++){
                if (manajer.get(i).getId()==Integer.parseInt(id)){
                int absen= manajer.get(i).getAbsen() + 1;
                System.out.println("Nama : "+manajer.get(i).getNama());
                System.out.println("Jabatan : "+manajer.get(i).getJabatan());
                System.out.println("Absensi : "+staff.get(i).getAbsen());
                Manajer mng = new Manajer(manajer.get(i).getId(),manajer.get(i).getNama(),manajer.get(i).getJabatan(),manajer.get(i).getPulsa(),manajer.get(i).getGapok());
                mng.setAbsen(absen);
                manajer.set(i,mng);
                }
            }
            break;
            case "Staff" :
            System.out.print("Masukan Id : ");
            id=br.readLine();
            for (int i=0;i<staff.size();i++){
                if (staff.get(i).getId()==Integer.parseInt(id)){
                int absen= staff.get(i).getAbsen() + 1;
                System.out.println("Nama : "+staff.get(i).getNama());
                System.out.println("Jabatan : "+staff.get(i).getJabatan());
                System.out.println("Absensi : "+staff.get(i).getAbsen());
                Staff stf = new Staff(staff.get(i).getId(),staff.get(i).getNama(),staff.get(i).getJabatan(),staff.get(i).getPulsa(),staff.get(i).getGapok());
                stf.setAbsen(absen);
                staff.set(i,stf);
                }
            }
            break;
            default:

            break;
        }
    }

    private static void Tunjangan() throws Exception{
        String jabatan="";
        String id="";
        String ent;
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        System.out.print("Masukan Jabatan : ");
        jabatan=br.readLine();
        switch(jabatan){
            case "Manajer" :
            System.out.print("Masukan Id : ");
            id=br.readLine();
            System.out.print("Jumlah Entertaiment : ");
            ent=br.readLine();
            for (int i=0;i<manajer.size();i++){
                if (manajer.get(i).getId()==Integer.parseInt(id)){
                Manajer mng = new Manajer(manajer.get(i).getId(),manajer.get(i).getNama(),manajer.get(i).getJabatan(),manajer.get(i).getPulsa(),manajer.get(i).getGapok());
                mng.setAbsen(manajer.get(i).getAbsen());
                mng.setTrans(manajer.get(i).getAbsen());
                mng.setEnt(Integer.parseInt(ent));
                manajer.set(i,mng);
                }
            }
            break;
            case "Staff" :
            System.out.print("Masukan Id : ");
            id=br.readLine();
            for (int i=0;i<staff.size();i++){
                if (staff.get(i).getId()==Integer.parseInt(id)){
                Staff stf = new Staff(staff.get(i).getId(),staff.get(i).getNama(),staff.get(i).getJabatan(),staff.get(i).getPulsa(),staff.get(i).getGapok());
                stf.setAbsen(staff.get(i).getAbsen());
                stf.setMakan(staff.get(i).getAbsen());
                staff.set(i,stf);
                }
            }
            break;
            default:

            break;
        }
    }

    private static void total()throws Exception{
        String jabatan="";

        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        System.out.print("Masukan Jabatan : ");
        jabatan=br.readLine();
        switch(jabatan){
            case "Manajer" :
            for (int i=0;i<manajer.size();i++){
                {
                    for (Manajer obj: manajer){
                        manajer.get(i).GajiTotal(obj.getId());
                    }
                }
            }
            break;
            case "Staff" :
            for (int i=0;i<staff.size();i++){
                {
                    for (Staff obj: staff){
                        staff.get(i).GajiTotal(obj.getId());
                    }
                }
            }
            break;
            default:

            break;
        }
    }

    
    private static void tampil() throws Exception{
        Runn st = new Runn();
        //st.setRightAlign(true);//if true then cell text is right aligned
        st.setShowVerticalLines(true);//if false (default) then no vertical lines are shown
        st.setHeaders("ID","Nama", "Jabatan", "Gaji Total");//optional - if not used then there will be no header and horizontal lines
        for (Manajer obj: manajer) {
            st.addRow(Integer.toString(obj.getId()),obj.getNama(), obj.getJabatan(),Integer.toString(obj.getTotal()));
        }
        for (Staff obj: staff) {
            st.addRow(Integer.toString(obj.getId()),obj.getNama(),obj.getJabatan(),Integer.toString(obj.getTotal()));
        }
        st.print();
        st.savetofile();
        TampilMenu();
    }


    private static void TampilMenu(){
        System.out.println("Silahkan Pilih Menu");
        System.out.println("1. Buat Staff");
        System.out.println("2. Tambah Absen");
        System.out.println("3. Tunjangan");
        System.out.println("4. Total Gaji");
        System.out.println("5. Tampil");
        System.out.println("6. Exit");
    }

}
