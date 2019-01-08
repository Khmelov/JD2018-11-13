package by.it._examples_.jd02_06.p12_bridge;

class PrgBank extends Prg {
    PrgBank(Dev developer) {
        super(developer);
    }

    @Override
    void developProgram() {
        System.out.println("Bank dev in progress...");
        developer.writeCode();
    }
}
