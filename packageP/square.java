import java.util.Scanner;

public class square {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the side length of square");
        int a = sc.nextInt();
        for (int j = 0; j < a; j++) {
            for (int i = 0; i < a; i++) {
                if (1 <= j && j < a - 1 && 1 <= i && i < a - 1)
                    System.out.print(" ");
                else
                    System.out.print("*");
                System.out.print(" ");
            }

            System.out.println("");
        }

    }

}

