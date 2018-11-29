package by.it._examples_.jd01_08._04_Point;

public class Runner {
    public static void main(String[] args) {
        PointReport d = new PointReport();
        Point1D p1 = new Point1D(-7);
        d.printReport(p1);
        Point2D p2 = new Point2D(3, 4);
        d.printReport(p2);
        Point3D p3 = new Point3D(3, 4, 5);
        d.printReport(p3);
    }
}