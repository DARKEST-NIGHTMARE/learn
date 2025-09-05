import java.util.Scanner;

public class AreaCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the side of the square: ");
        double squareSide = scanner.nextDouble();

        Square mySquare = new Square(squareSide);
        System.out.println("Area of the square is: " + mySquare.calculateArea());
        System.out.println("----------------------------------------");
        System.out.print("Enter the radius of the circle: ");
        double circleRadius = scanner.nextDouble();
        Circle myCircle = new Circle(circleRadius);
        System.out.printf("Area of the circle is: %.2f\n", myCircle.calculateArea());
        System.out.println("----------------------------------------");
        System.out.print("Enter the length of the rectangle: ");
        double rectLength = scanner.nextDouble();
        System.out.print("Enter the breadth of the rectangle: ");
        double rectBreadth = scanner.nextDouble();
        Rectangle myRectangle = new Rectangle(rectLength, rectBreadth);
        System.out.println("Area of the rectangle is: " + myRectangle.calculateArea());
        scanner.close();
    }
}