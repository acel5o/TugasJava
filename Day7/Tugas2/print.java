import java.util.*;
public class print extends Thread{
    public static ArrayList<Mahasiswa> student;
    public print(ArrayList<Mahasiswa> list){
        student=list; 
    }
    public void run(){
        try {
            tabel st = new tabel();
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
}
