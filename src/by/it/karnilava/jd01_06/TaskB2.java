package by.it.karnilava.jd01_06;

public class TaskB2 {
    public static void main(String[ ] args){
        StringBuilder sb = new StringBuilder(Poem.text);
        String [] mas = Poem.text.replaceAll("\\.\\.\\.", " ").split("[!?.]");
      //  String [] mas = Poem.text.split("[.!?]+");
        for (int i = 0; i < mas.length; i++) {
            mas [i] = mas[i].replaceAll("\\p{Punct}+", " ");
            mas [i] = mas[i].replaceAll("\n", " ");
            mas[i]=mas[i].trim();
            mas [i] = mas[i].replaceAll("[ ]+", " ");
        }
        sort(mas);

        for (int i = 0; i < mas.length; i++) {
            System.out.println(mas[i]);

        }

    }
    private static void sort(String []mas){
        boolean swap;
        int last = mas.length-1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if(mas[i].length()>mas[i+1].length()){
                    String  buffer = mas [i];
                    mas[i] = mas[i+1];
                    mas[i+1] = buffer;
                    swap = true;
                }

            }
            last--;

        }
        while (swap);


    }
}


