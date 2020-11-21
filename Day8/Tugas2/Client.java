import java.util.regex.*;
import java.util.*;
import java.net.*;
import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Client {
    
    public static String filename;
    public static boolean LoggedIn = false;
    public static Scanner keyboard = new Scanner(System.in);
    public static Socket r;
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
                        menu(prop.getProperty("server"),prop.getProperty("port"));
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

    public static void menu(String prop, String prop1) throws Exception{
        int keyInput;
            System.out.println("MENU\n1. Connect Socket\n2. Send Data to Server\n3. Close Socket\n\n4. Exit\n");
            System.out.print("Pilih Menu : ");
            keyInput = Integer.parseInt(keyboard.nextLine());
        if(keyInput!=4){
            switch (keyInput) {
                case 1:
                    r=new Socket(prop,Integer.parseInt(prop1));
                    menu(prop,prop1);
                    break;  
                case 2:
                    sendData(r);
                    menu(prop,prop1);
                break;  
                case 3:
                    closeCnn(r);
                    menu(prop,prop1);
                    break;
                default:
                    break;
            }
        }
    }

    public static void closeCnn(Socket s) throws Exception{
        s.close();
    }

    public static void sendData(Socket s) throws Exception{
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        System.out.print("File : ");
        String pesan=br.readLine();

        String textfile="";

        FileReader fr = new FileReader(pesan);
        int i;
        while ((i = fr.read()) != -1) {
            textfile += (char) i;
        }
        fr.close();
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        dout.writeUTF(textfile); 
        dout.flush();
        

        DataInputStream dis=new DataInputStream(s.getInputStream()); 
        String str=(String)dis.readUTF(); 
        System.out.println(str); 

        dout.close();
    }
}
