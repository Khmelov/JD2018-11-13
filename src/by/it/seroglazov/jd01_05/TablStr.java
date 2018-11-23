package by.it.seroglazov.jd01_05;

public class TablStr {
    private static char[] getSimpleCharLine(int len) {
        char sl = '\u2550'; // Simple line ═
        char[] line = new char[len];
        for (int i = 0; i < len; i++) {
            line[i] = sl;
        }
        return line;
    }

    private static String getUniversalLine(int blockAmount, int blockLength, char leftSymbol, char centerSymbol, char rightSymbol){
        char[] chLine = getSimpleCharLine(blockLength);
        StringBuilder line = new StringBuilder((blockLength + 1) * (blockAmount + 1));
        line.append(leftSymbol);
        for (int i = 0; i < blockAmount - 1; i++) {
            line.append(chLine);
            line.append(centerSymbol);
        }
        line.append(chLine);
        line.append(rightSymbol);
        line.append('\n');
        return line.toString();
    }

    static String getUpLine(int blockAmount, int blockLength) {
        return getUniversalLine(blockAmount, blockLength,
                '\u2554', // Left up ╔
                '\u2566', // Center up ╦
                '\u2557'); // Right up ╗
    }

    static String getCenterLine(int blockAmount, int blockLength) {
        return getUniversalLine(blockAmount, blockLength,
                '\u2560', // Left center ╠
                '\u256c', // Simple center ╬
                '\u2563'); // Right center ╣
    }

    static String getDownLine(int blockAmount, int blockLength) {
        return getUniversalLine(blockAmount, blockLength,
                '\u255a', // Left down ╚
                '\u2569', // Center down ╩
                '\u255d'); // Right center ╝
    }

    static String getBlankLine(int blockLength){
        StringBuilder line = new StringBuilder(blockLength);
        for (int i = 0; i < blockLength; i++) {
            line.append(' ');
        }
        return line.toString();
    }
}
