import java.util.regex.*;
import java.util.*;
import java.net.*;
import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Server {
    public static boolean LoggedIn = false;
    public static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) throws Exception{ 
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(args[0]);
            // load a properties file
            prop.load(input);
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
                        mulai(prop.getProperty("port"));
                    } else {
                        System.out.println("Gagal Login");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while (LoggedIn != true);
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

    public static void Login(String email, String pass) throws Exception {
        String emailTemp="zefanya.marcel@gmail.com";
        String passTemp="M4h4n4im123@";
        boolean emailCorrect = Pattern.compile("^[\\w._%+-]+@[\\w.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(email).matches();
        boolean passCorrect = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$").matcher(pass).matches();
        if (emailCorrect && passCorrect){
            if (Pattern.matches(email, emailTemp) && Pattern.matches(pass, passTemp)){
                LoggedIn = true;
            } else {
                System.out.println("Email atau Password salah");
            }
        }else {
            System.out.println("Password harus lebih dari 8 character, ada huruf besar dan kecil, memiliki special character");
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
            String[] values = str.split("\\n");

            for (String string : values){
                String[] data = string.split(",");
                for (int i = 0; i<data.length; i++){
                    if (i==0){
                        System.out.println("Nama : "+data[i]);
                    } else if (i==1){
                        System.out.println("Nilai Fisika : "+data[i]);
                    } else if (i==2){
                        System.out.println("Nilai Biologi : "+data[i]);
                    } else if (i==3){
                        System.out.println("Nilai Kimia : "+data[i]);
                    }
                    dout.writeUTF("Data Done Processing"); 
                    dout.flush();
                }
            }
           }catch(Exception e){
               System.out.println(e);
           } 
    }
}