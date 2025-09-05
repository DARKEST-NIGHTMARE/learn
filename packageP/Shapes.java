import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Shapes {
    static Map<String,Double>results = new HashMap<>();
    // 1. Add shape
    // -> Square - Rectangle - Circle -> Side / H * W / Radius
    // 2. Exit -> sum of all the areas


    public static void main(String[] args) {
        System.out.println("1.Enter the shape ");
        System.out.println("2.Exit");

        Scanner ns = new Scanner(System.in);
        char c = ns.nextLine().charAt(0);
        if (c == '1') {
            System.out.println("ENter the preferred shape to find area");
            System.out.println("1.square  \n 2.circle \n 3.rectangle");
            int shape = ns.nextInt();
            switch (shape){
                case 1:
                    System.out.println("enter the side of square");
                    double side = ns.nextDouble();
                    Square mySquare = new Square(side);
                    System.out.println("Area of the square is: " + mySquare.calculateArea());
                    results.put("square", mySquare.calculateArea());
                    break;
                case 2:
                    System.out.println("enter the radius of circle");
                    double radius = ns.nextDouble();
                    Circle myCircle = new Circle(radius);
                    System.out.printf("Area of the circle is: %.2f\n", myCircle.calculateArea());
                    results.put("circle", myCircle.calculateArea());
                    break;
                case 3:
                    System.out.println("enter the length");
                    double length = ns.nextDouble();
                    System.out.println("enter the breadth");
                    double breadth = ns.nextDouble();
                    Rectangle myRectangle = new Rectangle(length, breadth);
                    System.out.println("Area of the rectangle is: " + myRectangle.calculateArea());
                    results.put("rectangle", myRectangle.calculateArea());

            }


        }
        else {
            System.exit(0);
        }

    }
}
