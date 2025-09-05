import java.io.*;
import java.util.Random;
//import packageP.Test232;

public class MatrixMult extends Matrix{

    static int [][] A = new int[100][100];
    static int [][] B = new int[100][100];


    static void printMatrix(int[][] A, int row, int column) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(A[i][j] + " ");
            }
                System.out.println();



        }

    }

    static void multiply(int row1, int col1, int[][] A, int row2, int col2, int[][] B) {
        int i, j, k;
        System.out.println("\n Matrix A ");
        printMatrix(A, row1, col1);
        System.out.println("\n Matrix B");
        printMatrix(B, row2, col2);
        if (row2 != col1) {
            System.out.println("Matrix Multiplication not possible");
            return;
        }
        int[][] C = new int[row1][col2];
        for (i = 0; i < row1; i++) {
            for (j = 0; j < col2; j++) {
                for (k = 0; k < row2; k++) {
                    C[i][j] += A[i][k] * B[k][j];

                }

            }


        }
        System.out.println("Result matrix");
        printMatrix(C, row1, col2);

    }

    public static void main(String[] args) {
        int row1 = 100, col1 = 100, row2 = 100, col2 = 100;

//        int[][] A = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}};
//
//        int[][] B = {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}};
        Matrix.fillMatrix(A);
        Matrix.fillMatrix(B);
        long t1 = System.currentTimeMillis();

        multiply(row1, col1, A, row2, col2, B);
        long t2 = System.currentTimeMillis();
        long t3 = t2-t1;
        System.out.println("Executed in: " +t3+"ms"   );
    }


}
