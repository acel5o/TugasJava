import java.io.*;
import java.net.*; 
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyClient { 
    public static void main(String[] args) { 
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(args[0]);
            // load a properties file
            prop.load(input);
            mulai(prop.getProperty("server"),prop.getProperty("port"));
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

public static void mulai(String prop, String prop1){
    try{ 
        Socket s=new Socket(prop,Integer.parseInt(prop1)); 
        DataInputStream dis=new DataInputStream(s.getInputStream()); 
        DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);

        System.out.print("Pesan Keluar : ");
        String pesan=br.readLine();

        while(!pesan.equals("exit")){
            dout.writeUTF(pesan); 
            dout.flush();

            String str=(String)dis.readUTF(); 
            System.out.println("Pesan Masuk : "+str); 

            System.out.print("Pesan Keluar : ");
            pesan=br.readLine();
        }
            dout.close(); 
           s.close(); 
        
    }catch(Exception e){
        System.out.println(e);
    } 
}

}