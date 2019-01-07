package by.it.naumenko.Calculator;

import by.it.naumenko.Calculator.resourse.ResourceManager;
import by.it.naumenko.Calculator.resourse.TextTranslate;

class Scalar extends Var {
    static ResourceManager resVar = ResourceManager.INSTANCE;
    double value;
    int iValue;

    public Scalar(int iValue) {
        this.iValue = iValue;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String str){
        this.value = Double.parseDouble(str);
    }

    Scalar(Scalar scalar){
        this.value = scalar.value;
    }

    @Override
    public String toString() {
        if (value%1==0)
            return Integer.toString((int) value);
        return Double.toString(value);

    }

    @Override
    public Var add(Var other) throws CalcExeption {
        if (other instanceof Scalar){
            Scalar operand2=(Scalar) other;
            double rezultat=this.value+operand2.value;
            return new Scalar(rezultat);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        if(other instanceof Scalar){
            Scalar operand2= (Scalar) other;
            double rezultat = this.value-operand2.value;
            return new Scalar(rezultat);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) throws CalcExeption {
        if(other instanceof Scalar){
            Scalar operand2 = (Scalar)other;
            double rezultat = this.value*operand2.value;
            return new Scalar(rezultat);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other)  throws CalcExeption {
        if (other instanceof Scalar){
            Scalar operand2=(Scalar)other;
            if (operand2.value==0)
                throw new CalcExeption(resVar.get(TextTranslate.DIVISION_BY_ZERO));//"Деление на ноль");
            double rezultat = this.value/operand2.value;
            return new Scalar(rezultat);

        }
        throw new CalcExeption(resVar.get(TextTranslate.NUMBER_DIV_VECTOR_OR_MATRIX));//"Невозможно разделить число на вектор или матрицу");
    }
}
