package by.it.markelov.jd02_06.Calculator;

class Vector extends Var {

    double[] value;

    public Vector(double[] value) throws CalcException {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, this.value.length);
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

    Vector(Vector vector) {
        value = vector.value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Vector) {
            Vector operand2 = (Vector) other;
            if (this.value.length != operand2.value.length)
                throw new CalcException("Вектора имеют разные (несовместимые) размеры");
            double mas[] = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                mas[i] = this.value[i] + operand2.value[i];
            }
            return new Vector(mas);
        }
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double mas[] = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                mas[i] = this.value[i] + operand2.value;
            }
            return new Vector(mas);
        }
        return other.add(this);
    }

    public Var sub(Var other) throws CalcException {
        if (other instanceof Vector) {
            Vector operand2 = (Vector) other;
            if (this.value.length != operand2.value.length)
                throw new CalcException("Вектора имеют разные (несовместимые) размеры");
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
    public Var mul(Var other) throws CalcException {
        if (other instanceof Vector) {
            Vector operand2 = (Vector) other;
            double result = 0;
            for (int i = 0; i < this.value.length; i++) {
                result += this.value[i] * operand2.value[i];
            }
            return new Scalar(result);
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

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Vector)
            throw new CalcException("Деление вектора на вектор невозможно");
        if (other instanceof Matrix)
            throw new CalcException("Деление вектора на матрицу невозможно");
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double[] mas = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                mas[i] = this.value[i] / operand2.value;
            }
            return new Vector(mas);
        }
        return other.div(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double v : value) {
            sb.append(delimiter).append(v);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
