import java.util.Scanner;

public class test1 {
    interface  inter{
        void measure();
    }


    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int c = 0;
            Double n;
            do {
                System.out.println("Choose Conversion units");
                System.out.println("1 for Converting Kilometers <-> Miles ");
                System.out.println("2 for Converting Kilograms <-> Pounds ");
                System.out.println("3 for Converting Celsius <-> Fahrenheit ");
                c = sc.nextInt();
                if (c == 1) {
                    System.out.println("Enter Kilometer");
                    n = sc.nextDouble();
                    System.out.println(n + " Kilometers in Miles = " + (0.621371 * n));
                } else if (c == 2) {
                    System.out.println("Enter Kilograms");
                    n = sc.nextDouble();
                    System.out.println(n + " Kilograms in Pounds = " + (2.20462 * n));
                } else if (c == 3) {
                    System.out.println("Enter Celsius");
                    n = sc.nextDouble();
                    System.out.println(n + " Celsius in Fahrenheit = " + (n * (9 / 5)) + 32);
                } else {
                    System.out.println("Enter valid input");
                    continue;
                }
            } while (c == 1 || c == 2 || c == 3);
        } catch (Exception e) {
            System.out.println(e);
            main(args);

        }
    }
}
