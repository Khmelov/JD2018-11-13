package by.it.naumenko.jd01_15;

import java.io.*;

public class TaskB {
    //программа
    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        readClass(stringBuilder);//чтение из класса и запись в SB
        //вывод на консоль SB
        writeFile(stringBuilder);//чтение из SB и запись в File
    }
    /*Многострочный
        комментарий*/
    //запись StringBuildera в файл
    private static void writeFile(StringBuilder stringBuilder) {
        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter(Util.getPath("TaskB.txt")))) {
            printWriter.print(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**метод проверки комментария
     *
     * @param
     * @throws IOException
     */
    private static void readClass(StringBuilder stringBuilder) throws FileNotFoundException, IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Util.getPath("TaskB.java")))) {
            while (bufferedReader.ready()) {
                char firstChar = (char) bufferedReader.read();
                if (firstChar == '/') {
                    char secondChar = (char) bufferedReader.read();
                    switch (secondChar) {
                        case '/':
                            onestrComent(stringBuilder, bufferedReader);
                            break;
                        case '*':
                            multiStrComrnt(bufferedReader);
                            break;
                        default:
                            noComent(stringBuilder, firstChar, secondChar);
                            break;
                    }
                    continue;
                }
                stringBuilder.append(firstChar);
            }
        }
    }
//не комментарий
    private static void noComent(StringBuilder stringBuilder, char firstChar, char secondChar) {
        stringBuilder.append(firstChar);
        stringBuilder.append(secondChar);
    }
//многосточный комментарий и java doc
    private static void multiStrComrnt(BufferedReader bufferedReader) throws IOException {
        while (bufferedReader.ready()) {
            if (((char) bufferedReader.read()) == '*' && ((char) bufferedReader.read()) == '/') {
                break;
            }
        }
    }
//однострочный коментарий
    private static void onestrComent(StringBuilder stringBuilder, BufferedReader bufferedReader) throws IOException {
        while (bufferedReader.ready()) {
            char b = (char) bufferedReader.read();
            if (b == '\n') {
                break;
            }
        }
        stringBuilder.append("\n");
    }
/* второй многострочный соментарий
 */
}
