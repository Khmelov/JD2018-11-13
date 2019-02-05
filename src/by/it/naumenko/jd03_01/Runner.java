package by.it.naumenko.jd03_01;

public class Runner {
    public static void main(String[] args) {


        C_Init createDB = new C_Init();
        createDB.create();
        System.out.println("База создана");


//
// Scanner scanner = new Scanner(System.in);
//        System.out.println("Что хотите сделать с базой данных?\n+1-создать\n+2-удалить");
//        int a = scanner.nextInt();
//        switch (a) {
//            case 1:
//                C_Init createDB = new C_Init();
//                createDB.create();
//                System.out.println("База создана");
//                break;
//            case 2:
//                C_Reset resetDB = new C_Reset();
//                resetDB.reset();
//                System.out.println("База удалена");
//                break;
//            default:
//                System.out.println("Нет такого варианта");
//                break;
//        }
    }
}
