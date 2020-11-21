import java.util.List;

public class Thread4 extends Thread {
    List<Integer> listnumber;
    public Thread4(List<Integer> listnumber) {
        this.listnumber = listnumber;
    }
    public void run() {
        for (int obj: listnumber) {
            System.out.println(obj);
        }
    }  
}