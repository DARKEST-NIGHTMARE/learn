import java.util.Random;

public class NumberGen implements Runnable {
    private final Thread threadToInterrupt;

    public NumberGen(Thread threadToInterrupt) {
        this.threadToInterrupt = threadToInterrupt;
    }

    @Override
    public void run() {
        System.out.println(" Number generator thread has started.");
        Random random = new Random();

        while (!Thread.currentThread().isInterrupted()) {
            int number = random.nextInt(100) + 1;
            System.out.println("Generated number: " + number);

            if (number == 77) {
                System.out.println("\nnumber 77 generated, Interrupting file thread\n");
                this.threadToInterrupt.interrupt();
                break;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Number generator thread interrupted.");
                break;
            }
        }
        System.out.println(" Number generator thread finished.");
    }
}
