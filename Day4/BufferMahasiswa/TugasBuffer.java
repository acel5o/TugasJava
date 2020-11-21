import java.io.*;
public class TugasRW2 {
    String id = "";
    String nama = "";
    String gender = "";
    public static void main(String args[]){ 
        try{       
            FileOutputStream fout = new FileOutputStream("Mahasiswa.txt");
            TugasRW2 s = new TugasRW2("1", "Zefa", "Pria");
            TugasRW2 ss = new TugasRW2("2", "Marcel", "Pria");
            TugasRW2 sss = new TugasRW2("3", "KJ", "Pria");
            BufferedOutputStream bout = new BufferedOutputStream(fout);
            String s1 = "Id : " + s.getId() + " " + "Nama : " + s.getNama() + " " + "Gender : " + " " + s.getGender() + "\n" +
                        "Id : " + ss.getId() + " " + "Nama : " + ss.getNama() + " " + "Gender : " + " " + ss.getGender() + "\n" +
                        "Id : " + sss.getId() + " " + "Nama : " + sss.getNama() + " " + "Gender : " + " " + sss.getGender();
            byte b[]=s1.getBytes();//converting string into byte array 
            bout.write(b);
            bout.flush(); 
            bout.close();
            fout.close(); 
            System.out.println("success");


            FileInputStream fin=new FileInputStream("Mahasiswa.txt"); 
            int i=0; while((i=fin.read())!=-1){ 
                System.out.print((char)i); 
            } fin.close();     

            System.out.print("\n"); 
        }catch(Exception e){
            System.out.println(e);
        }
}
public TugasRW2(String id, String nama, String gender){
    this.id = id;
    this.nama = nama;
    this.gender = gender;
}

    String getId(){
        return this.id;
    }

    String getNama(){
        return this.nama;
    }

    String getGender(){
        return this.gender;
    }
}
