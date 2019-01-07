package by.it._examples_.jd02_06.p12_bridge;

abstract class Prg {
    protected Dev developer;

    Prg(Dev developer) {
        this.developer = developer;
    }

    abstract void developProgram();
}
