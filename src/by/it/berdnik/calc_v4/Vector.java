package by.it.berdnik.calc_v4;

class Vector extends Var {

    private double[] value;

    Vector(String vector) throws CalcException {
        throw new CalcException("не асилил "+vector);
    }

    Vector() {
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
    public Var add(Var other)  throws CalcException {
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        return super.div(other);
    }
}
