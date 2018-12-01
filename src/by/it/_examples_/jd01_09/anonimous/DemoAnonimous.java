package by.it._examples_.jd01_09.anonimous;

public class DemoAnonimous {
    static class People {
        private String name;
        People(String name) {this.name=name;}
        public  String toString()   {return name;}
    }
    public static void main(String[ ] args) {
        People mother=new People("Вероника");
        People father=new People("Алексей");
        People son=new People("Сергей");
        People ano=new People("Некто"){
                        public String toString() {
                           return "неизвестно кто такой";
                        }
        };
        System.out.println("Это " + mother);
        System.out.println("Это " + father);
        System.out.println("Это " + son);
        System.out.println("Это " + ano);
    }
}
