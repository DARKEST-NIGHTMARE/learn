import java.util.Random;

public class Test232 extends Matrix{
    static class RowMultiplier implements Runnable {
        private final int[][] result;
        private final int[][] matrixA;
        private final int[][] matrixB;
        private final int row;
        private final int n;

        public RowMultiplier(int[][] result, int[][] matrixA, int[][] matrixB, int row) {
            this.result = result;
            this.matrixA = matrixA;
            this.matrixB = matrixB;
            this.row = row;
            this.n = matrixA.length;
        }

        @Override
        public void run() {
            for (int j = 0; j < n; j++) {
                result[row][j] = 0;
                for (int k = 0; k < n; k++) {
                    result[row][j] += matrixA[row][k] * matrixB[k][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
//        int n = rand.nextInt(998) + 3;
        int n =100;
        System.out.println("Performing multiplication, Size: " + n + "x" + n);

        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        int[][] C = new int[n][n];

        Matrix.fillMatrix(A);
        Matrix.fillMatrix(B);

        System.out.println("Starting parallel matrix multiplication...");
        long startTime = System.currentTimeMillis();

        Thread[] threads = new Thread[n];
        for (int i = 0; i < n; i++) {
            threads[i] = new Thread(new RowMultiplier(C, A, B, i));
            threads[i].start();
        }

        try {
            for (int i = 0; i < n; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Multiplication finished.");
        System.out.println("Execution time: " + (endTime - startTime) + " ms");



            System.out.println("\nMatrix A:");
            printMatrix(A);
            System.out.println("\nMatrix B:");
            printMatrix(B);
            System.out.println("\nResult Matrix C:");
            printMatrix(C);

    }


//    public static void fillMatrix(int[][] matrix) {
//        Random rand = new Random();
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                matrix[i][j] = rand.nextInt(10);
//            }
//        }
//    }


    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}