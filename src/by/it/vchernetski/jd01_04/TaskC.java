package by.it.vchernetski.jd01_04;

import java.util.Scanner;
public class TaskC {
    static int binarySearch(double[ ] array, double value){
        int i=0;
        int min=0;
        int max=array.length;
        int mid=0;
        while(min<max){
            mid=(min+max)/2;
            if(array[mid]==value){
                i=mid;
                break;
            }
            if(array[mid]<=value){min=mid;}
            else{max = mid;}
        }

        return i;
    }
    public static void mergeSort(double[] array){
        if(array.length>1){
            int left=array.length/2;
            int right=array.length-left;
            double[] part1=new double[left];
            double[] part2=new double[right];
            for (int i = 0; i <part1.length ; i++) {
                part1[i]=array[i];
            }
            for (int j = 0; j < part2.length; j++) {
                part2[j]=array[left+j];
            }
            mergeSort(part1);
            mergeSort(part2);
            merge(array,part1,part2);
        }
    }

    public static void merge(double[] res, double[] part1, double[] part2) {
        int size = part1.length + part2.length;
        int rc, c1, c2;
        rc = c1 = c2 = 0;
        while (rc < size) {
            if (c1 < part1.length && c2 < part2.length) {
                if (part1[c1] < part2[c2]) {
                    res[rc] = part1[c1];
                    rc++;
                    c1++;
                } else {
                    res[rc] = part2[c2];
                    rc++;
                    c2++;
                }
            } else {
                if(c1>=part1.length){
                    while(c2<part2.length){
                        res[rc]=part2[c2];
                        rc++;
                        c2++;
                    }
                }
                if(c2>=part2.length){
                    while (c1<part1.length){
                        res[rc]=part1[c1];
                        rc++;
                        c1++;
                    }
                }
            }
        }
    }



    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        mergeSort(array);
        InOut.printArray(array, "V", 5);
        int j=binarySearch(array,first);
        System.out.println("first element="+ j);
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == first) {
//                System.out.printf("Index of first element=%d\n", i);
//                break;
//            }
//        }
        j=binarySearch(array,last);
        System.out.println("last element="+j);
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == last) {
//                System.out.printf("Index of last element=%d", i);
//                break;
//            }
//        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        buildOneDimArray(sc.nextLine());
    }
}
