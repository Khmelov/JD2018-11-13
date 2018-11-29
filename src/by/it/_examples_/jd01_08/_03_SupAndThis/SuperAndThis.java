package by.it._examples_.jd01_08._03_SupAndThis;

public class SuperAndThis {

    public class Point1D {
        private int x;
        public Point1D(int x) {
            this.x = x;
        }
    }
    public class Point2D extends Point1D {
        private int y;
        public Point2D(int x, int y) {
            super(x);
            this.y = y;
        }
    }
    public class Point3D extends Point2D {
        private int z;
        public Point3D(int x, int y, int z) {
            super(x, y);
            this.z = z;
        }
    }

}
