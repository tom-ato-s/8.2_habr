
import java.util.Queue;


public class Produser implements Runnable {
Queue<Double> sharedQueue;
private final int SIZE; // размер очереди

    public Produser(Queue<Double> sharedQueue, int size) {
            this.sharedQueue = sharedQueue;
            this.SIZE = size;
    }


    @Override
    public void run() {
        while (true) {
            try {
               // System.out.println("Produser 1");
                produser();
                System.out.println("Produser 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produser()throws InterruptedException {

        synchronized (sharedQueue) {
            if (sharedQueue.size() == SIZE) {
                System.out.println("очередь полна,ждет produser");
               //если очередь полна
                sharedQueue.wait(); // produser ждет
            } else {
          // for(int i = 0; i<SIZE; i++) {
               double rand = Math.random();
                sharedQueue.add(rand); // сгенерированное значение добавлено в очередь
                System.out.println("Добевлено в очередь " + rand);
        //    }
                sharedQueue.notifyAll();

         //   System.out.println("return");
            }
        }
    }
}
