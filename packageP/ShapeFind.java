abstract class ShapeFind {
    abstract double calculateArea();
}

class Square extends ShapeFind {

    private double side;
    public Square(double side) {
        this.side = side;
    }


    @Override
    public double calculateArea() {
        return side * side;
    }
}


class Circle extends ShapeFind {

    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends ShapeFind {
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double calculateArea() {
        return length * breadth;
    }
}


