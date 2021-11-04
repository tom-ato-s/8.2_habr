import java.util.Queue;

public class Consumer implements Runnable{

    Queue<Double> sharedQueue;
    public Consumer(Queue<Double> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }



    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumer " + consumer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Double consumer() throws InterruptedException{
        synchronized (sharedQueue) {
            if(sharedQueue.isEmpty()) {
                //если очередь пуста - ждем
                sharedQueue.wait();
            }
            sharedQueue.notifyAll();
            return sharedQueue.poll();
        }
    }

}
