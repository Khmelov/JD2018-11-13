package by.it._examples_.jd01_08._04_Point;

public class Point1D {
    private int x;
    public Point1D(int x) {
        this.x = x;
    }
    public double length() {
        return Math.abs(x);
    }
    @Override
    public String toString() {
        return " x=" + x;
    }
}

