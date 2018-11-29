package by.it._examples_.jd01_08._04_Point;

public class Point3D extends Point2D {
    private int z;
    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
    public Point3D() {
        this(-1, -1, -1); // вызов конструктора
        // Point3D с параметрами
    }
    @Override
    public double length() {
        return Math.hypot(super.length(), z);
    }
    @Override
    public String toString() {
        return super.toString() + " z=" + z;
    }
}