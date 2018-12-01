package by.it._examples_.jd01_09.inner;

public class ExtendedClass extends ParentClass{
    protected class SubExtended extends SubClass {
        public SubExtended() {
            System.out.println("SubExtended создан");
        }
    }
}
