package by.it.naumenko.jd01_02.jd01_04;

/**
 * Created by user on 20.11.2018.
 */
public class TaskA {
    static void printMulTable(){
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%1d*%1d=%-3d",i,j,i*j);
            }
            System.out.println();
        }


    }

    static void buildOneDimArray(String line){

        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length-1];
        InOut.printArray(array,"V",5);
        Helper.sort(array);
        System.out.println();
        InOut.printArray(array,"V",4);
        firstIndex(array, first);
        lastIndex(array, last);

    }

    private static void lastIndex(double[] array, double last) {
        for (int i = 0; i < array.length; i++) {
            if(array[i]==last){
                System.out.printf("index of last element=%d\n",i);
                break;
            }
        }
    }

    private static void firstIndex(double[] array, double first) {
        for (int i = 0; i < array.length; i++) {
            if(array[i]==first){
                System.out.printf("index of first element=%d\n",i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        printMulTable();
        buildOneDimArray("123 99 88 77 66 5 4 3 1 0 2");
    }
}
