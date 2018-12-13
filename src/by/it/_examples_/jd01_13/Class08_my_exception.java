package by.it._examples_.jd01_13;

public class Class08_my_exception {
    private double diameter;
    private double weight;

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double value) throws CoinLogicException {
        if (value <= 0) {
            throw new CoinLogicException("diameter is incorrect");
        }
        diameter = value;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double value) {
        weight = value;
    }





}


