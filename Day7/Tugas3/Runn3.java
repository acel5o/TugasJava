import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Runn3 {
    public static Scanner keyboard = new Scanner(System.in);
    public static String filename;
    public static int jumworker;
    public static List<Integer> listnumber = new ArrayList<Integer>();
    public static void main(String[] args) {
        filename=args[0];
        jumworker=Integer.parseInt(args[1]);
        ToList();
        menu();
    }
    public static void menu(){
        int keyInput;
       
            System.out.println("MENU\n1. Print Simple Thread\n2. Print Thread Pool\n3. Thread Print, Thread Read ASC & DESC\n0. Exit\n");
            System.out.print("Pilih Menu : ");
            keyInput = Integer.parseInt(keyboard.nextLine());
            if(keyInput!=0){
            switch (keyInput) {
                case 1:
                    simpleThread();
                    menu();
                    break;
                case 2:
                    PoolThread(jumworker);
                    menu();
                    break;
                case 3:
                    AscDsc(jumworker);
                    ASCThread t1=new ASCThread(listnumber);  
                    DSCThread t2=new DSCThread(listnumber);
                    t1.start();  
                    t2.start();  
                    menu();
                    break;
                default:
                    break;
            }
        } 
    }
    public static void PoolThread(int jumworker){
        System.out.println("Jumlah Worker : "+jumworker);
        ExecutorService executor = Executors.newFixedThreadPool(jumworker);       
        for (int i: listnumber){
            Runnable worker = new ThreadPool(String.format(""+ i));
            executor.execute(worker);//calling execute method of ExecutorService  
        }
        executor.shutdown();  
        while (!executor.isTerminated()) {   }  
 
       System.out.println("Finished all threads");  
    }

    public static void AscDsc(int jumworker){
        System.out.println("Jumlah Worker : "+jumworker);
        ExecutorService executor = Executors.newFixedThreadPool(jumworker);       
        for (int i: listnumber){
            Runnable worker = new ThreadPool(String.format(""+ i));
            executor.execute(worker);//calling execute method of ExecutorService  
        }
        executor.shutdown();  
        while (!executor.isTerminated()) {   }  
 
       System.out.println("Finished all threads");  
    }
    public static void ToList(){
        String textfile = "";
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            int i;
            while ((i = br.read()) != -1) {

                textfile += (char) i;
            }
            fr.close();
            br.close();
            String[] values = textfile.split(",");
            for (String obj: values) {
                listnumber.add(Integer.parseInt(obj));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void simpleThread(){
        List<Integer> thread1 = listnumber.subList(0, 25);
        List<Integer> thread2 = listnumber.subList(25, 50);
        List<Integer> thread3 = listnumber.subList(50, 75);
        List<Integer> thread4 = listnumber.subList(75,100);
            
        Thread1 t1=new Thread1(thread1);
        Thread2 t2=new Thread2(thread2);  
        Thread3 t3=new Thread3(thread3);  
        Thread4 t4=new Thread4(thread4);  
        
        t1.start();  
        t2.start();  
        t3.start();  
        t4.start();  
    }
}
