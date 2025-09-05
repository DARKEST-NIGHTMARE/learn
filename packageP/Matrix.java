import java.util.Random;

public class Matrix {


    public static void fillMatrix(int[][] A) {
        Random rand = new Random();
        int length = 100;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                A [i][j] = rand.nextInt(5);

            }
        }
    }}


