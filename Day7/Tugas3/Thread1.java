import java.util.List;

public class Thread1 extends Thread {
    List<Integer> listnumber;
    public Thread1(List<Integer> listnumber) {
        this.listnumber = listnumber;
    }
    public void run() {
        for (int obj: listnumber) {
            System.out.println(obj);
        }
    }  
}
