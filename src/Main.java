import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList<Double> sharedQueue = new LinkedList<>();
        int SIZE = 4;

        Produser produser = new Produser(sharedQueue, SIZE);
        Consumer consumer = new Consumer(sharedQueue);
        Thread prodThread = new Thread(produser, "Produser");
        Thread consThread = new Thread(consumer, "Consumer");
        prodThread.start();
        consThread.start();
    }
}
