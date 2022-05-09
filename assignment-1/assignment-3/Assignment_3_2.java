// Implement a group of classes that have common behavior/state as Shape.
// Create Circle, Rectangle and Square for now as later on we may need more shapes.
// They should have the ability to calculate the area.
// They should be able to compare using area.
// Please write a program to demonstrate the classes and comparison.
// You can use either abstract or interface. Comparator or Comparable interface.

public class Assignment_3_2 {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(2,2);
        Square s = new Square(2);
        System.out.println(r.compareTo(s));
    }
}

abstract class Shape implements Comparable<Shape>{
    public abstract double calculateArea();
}

class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {return Math.PI * radius * radius;}

    @Override
    public int compareTo(Shape o) {
        if (calculateArea() > o.calculateArea()) return 1;
        else if (calculateArea() == o.calculateArea()) return 0;
        else return -1;
    }
}

class Rectangle extends Shape {
    double length;
    double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

    @Override
    public int compareTo(Shape o) {
        if (calculateArea() > o.calculateArea()) return 1;
        else if (calculateArea() == o.calculateArea()) return 0;
        else return -1;
    }
}

class Square extends Shape {
    double side;

    public Square(double side) {
        this.side = side;
    }

    public double calculateArea() {
        return side * side;
    }

    @Override
    public int compareTo(Shape o) {
        if (calculateArea() > o.calculateArea()) return 1;
        else if (calculateArea() == o.calculateArea()) return 0;
        else return -1;
    }
}


