import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;



public class FileThreading implements Runnable {
    private static final int MAX_WORDS = 10000;
    private static final String OUTPUT_FILE = "dummy.txt";

    @Override
    public void run() {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            System.out.println("File thread started, adding to " + OUTPUT_FILE);
            int wordsWritten = 0;

            for (int i = 0; i < MAX_WORDS; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("File thread was interrupted. Stopping.");
                    break;
                }
                String randomWord = generateRandomWord();
                writer.write(randomWord);
                writer.newLine();
                wordsWritten++;
                Thread.sleep(10);
            }
            System.out.println("File thread over. Total words: " + wordsWritten);

        } catch (IOException e) {
            System.err.println("Error adding to file: " + e.getMessage());
        } catch (InterruptedException e) {
                    System.out.println("File thread was interrupted while sleeping. Stopping.");
            Thread.currentThread().interrupt();
        }
    }

    private String generateRandomWord() {
        Random rnd = new Random();
        int length = rnd.nextInt(8) + 3;
        StringBuilder word = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char c = (char) ('a' + rnd.nextInt(26));
            word.append(c);
        }
        return word.toString();
    }
}


