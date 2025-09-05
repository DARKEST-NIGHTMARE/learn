import java.util.Scanner;

public class anmika {

    public static void main(String[] args) {
        int number = 0;
        int input = 0;
        Scanner ns = new Scanner(System.in);
        System.out.println("enter a numer");
        while (input != -1) {
            input = ns.nextInt();
            number += input;


        }
        System.out.println("The sum is" + number);
    }
}

