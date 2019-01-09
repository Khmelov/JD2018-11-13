package by.it._examples_.jd02_06.p12_bridge;

public class Runner {
    public static void main(String[] args) {
        Prg[] prgs = {
                new PrgBank(new DevJava()),
                new PrgBank(new DevCpp()),
                new PrgStock(new DevJava())
        };
        for (Prg prg : prgs) prg.developProgram();
    }
}
