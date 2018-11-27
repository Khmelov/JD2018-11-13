package by.it.naumenko.jd01_02.jd01_06;

public class SortStr {
    public static void main(String[] args) {

        System.out.println("Please Enter your String");
        String str="Повседневнаяzz? практика показывает. Что постоянный1< количественный рост9 и сфера";
        String arrString[] = str.split("\\s");
        arrString = sortArray(arrString);
        System.out.println("Sort String ");
        for(String s:arrString){
            System.out.println(s);
        }
    }

    private static String[] sortArray(String[] arrString) {
        int length = arrString.length;
        String s;
        for (int i = 0; i < length ; i++) {
            s= new String();

            for(int j = 0; j < length; j++ ){
                if(arrString[i].length()< arrString[j].length()){
                    s = arrString[i];
                    arrString[i] = arrString[j];
                    arrString[j] = s;
                }
            }
        }
        return arrString;
    }
}
