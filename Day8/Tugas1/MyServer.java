import java.io.*; 
import java.net.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

 public class MyServer { 
     public static void main(String[] args){ 
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(args[0]);
            // load a properties file
            prop.load(input);
            mulai(prop.getProperty("port"));
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    } 

    public static void mulai(String prop){
        try{ 
            ServerSocket ss=new ServerSocket(Integer.parseInt(prop));
            Socket s=ss.accept();//establishes connection 
   
            DataInputStream dis=new DataInputStream(s.getInputStream()); 
            DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 
            InputStreamReader r=new InputStreamReader(System.in);
            BufferedReader br=new BufferedReader(r);
   
               String str=(String)dis.readUTF(); 
               System.out.println("Pesan Masuk : "+str); 
   
               while(!str.equals("exit")){
                   System.out.print("Pesan Keluar: ");
                   String pesan=br.readLine();
                   dout.writeUTF(pesan); 
                   dout.flush();  
                   str=(String)dis.readUTF(); 
                   System.out.println("Pesan Masuk : "+str); 
               }
                    dout.close(); 
                    s.close();
                    ss.close();
                
           }catch(Exception e){
               System.out.println(e);
           } 
    }
}