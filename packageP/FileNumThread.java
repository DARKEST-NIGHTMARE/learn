public class FileNumThread {

    public static void main(String[] args) {
        FileThreading t1 = new FileThreading();
        Thread fileThread = new Thread(t1, "WordWriterThread");

        NumberGen t2 = new NumberGen(fileThread);
        Thread numberGenThread = new Thread(t2, "NumberGeneratorThread");

        System.out.println("Starting both threads...");

        fileThread.start();
        numberGenThread.start();

        try {
            fileThread.join();
            numberGenThread.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread was interrupted.");
            Thread.currentThread().interrupt();
        }

        System.out.println("\nAll threads finished.");
    }
}
