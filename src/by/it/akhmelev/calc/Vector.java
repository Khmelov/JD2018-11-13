package by.it.akhmelev.calc;

class Vector extends Var{

    private double[] value;

    Vector(String vector){
        //
    }

    Vector(double[] value) {
        this.value=new double[value.length];
        System.arraycopy(value, 0, this.value, 0, this.value.length);
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{");

        String delimiter="";
        for (double v : value) {
            sb.append(delimiter).append(v);
            delimiter=", ";
        }
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Var add(Var other) {
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }
}
