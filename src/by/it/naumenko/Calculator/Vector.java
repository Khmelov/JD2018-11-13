package by.it.naumenko.Calculator;

import by.it.naumenko.Calculator.resourse.ResourceManager;
import by.it.naumenko.Calculator.resourse.TextTranslate;

class Vector extends Var {
    ResourceManager resVar = ResourceManager.INSTANCE;

    double[] value;

    public Vector(double[] value) throws CalcExeption {
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
    public Var mul(Var other) throws CalcExeption {
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

    public Var sub(Var other) throws CalcExeption {
        if (other instanceof Vector) {
            Vector operand2 = (Vector) other;
            if(this.value.length!=operand2.value.length)
                throw new CalcExeption(resVar.get(TextTranslate.SIZE_VECTOR));//"Не одинаковые размеры векторов");
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
    public Var add(Var other) throws CalcExeption {
        if (other instanceof Vector) {
            Vector operand2 = (Vector) other;
            if(this.value.length!=operand2.value.length)
                throw new CalcExeption(resVar.get(TextTranslate.SIZE_VECTOR));//"Не одинаковые размеры векторов");
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
    public Var div(Var other) throws CalcExeption {
        if(other instanceof Vector)
            throw new CalcExeption(resVar.get(TextTranslate.VECTOR_DIV_VECTOR));//"Невозможно разделить вектор на вектор");
        if(other instanceof Matrix)
            throw new CalcExeption(resVar.get(TextTranslate.VECTOR_DIV_MATRIX));//"Невозможно разделить вектор на матрицу");
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
            if (v%1==0)
                sb.append(del).append((int)v);
            else
                sb.append(del).append(v);
            del = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
