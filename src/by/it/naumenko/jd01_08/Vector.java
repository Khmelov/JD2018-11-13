package by.it.naumenko.jd01_08;

class Vector extends Var {

    double[] value;

    public Vector(double[] value) {
        //this.value = value;
        this.value=new double[value.length];
        System.arraycopy(value, 0, this.value, 0, this.value.length);
    }

//    this.value = new double[value.length];
//        for (int i = 0; i < value.length; i++) {
//        this.value[i]=value[i];
//    }

    Vector(Vector vector) {
        value = vector.value;
    }


    Vector(String strVector) {
        strVector = strVector.replaceAll("[{}]", "");
        String[] mas = strVector.split(",\\s*");
        double[] mas1 = new double[mas.length];
        for (int i = 0; i < mas.length; i++) {
            mas1[i] = Double.parseDouble(mas[i]);
        }
        value = mas1;
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Vector) {
            Vector operand2 = (Vector) other;
            double rezultat = 0;
            for (int i = 0; i < this.value.length; i++) {
                rezultat += this.value[i] * operand2.value[i];
            }
            return new Scalar(rezultat);
        }
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double mas[] = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                mas[i] += this.value[i] * operand2.value;
            }
            return new Vector(mas);
        }
        return other.mul(this);
    }

    public Var sub(Var other) {
        if (other instanceof Vector) {
            Vector operand2 = (Vector) other;
            double mas[] = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                mas[i] = this.value[i] - operand2.value[i];
            }
            return new Vector(mas);
        }
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double mas[] = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                mas[i] = this.value[i] - operand2.value;
            }
            return new Vector(mas);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Vector) {
            Vector operand2 = (Vector) other;
            double mas[] = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                mas[i] = this.value[i] + operand2.value[i];
            }
            return new Vector(mas);
        }
        if(other instanceof Scalar){
            Scalar operand2  = (Scalar)other;
            double mas[] = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                mas[i] = this.value[i] + operand2.value;
            }
            return new Vector(mas);
        }
        return other.add(this);
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Vector)
            return super.div(other);
        if (other instanceof Scalar){
            Scalar operand2 = (Scalar)other;
            double[] mas = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                mas[i]=this.value[i]/operand2.value;
            }
            return new Vector(mas);
        }
        return other.div(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String del = "";
        for (double v : value) {
            sb.append(del).append(v);
            del = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
