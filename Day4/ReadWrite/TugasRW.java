import java.io.FileOutputStream; 
import java.io.FileInputStream; 
public class TugasRW { 
    public static void main(String args[]){ 
        try{ 
                
            FileOutputStream fout=new FileOutputStream("./home/flathat/"+args[0]);
            String s=args[1];
                byte b[]=s.getBytes();//converting string into byte array 
                fout.write(b); 
                fout.close(); 

            FileInputStream fin=new FileInputStream("./home/flathat/"+args[0]); 
            int i=0; while((i=fin.read())!=-1){ 
                System.out.print((char)i); 
            } fin.close();     

            System.out.print("\n"); 
        }catch(Exception e){
            System.out.println(e);
        }
}
}