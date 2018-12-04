package by.it.skarpovich.jd01_08;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    private double[][] value;
    Matrix(double[][] value){
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i],0,this.value[i], 0,value.length);
        }
    }

    Matrix(Matrix matrix){
        this.value = new double[matrix.value.length][matrix.value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(matrix.value[i],0,this.value[i], 0,value.length);
        }
    }

    @Override
    public Var add (Var other) {

        if (other instanceof Scalar) {
            System.out.println("Сложение(матрицы и скаляра):");
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {

                for (int j = 0; j < value[i].length; j++) {
                    res[i][j] = value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);

        } else if (other instanceof Matrix) {
            System.out.println("Сложение(матрицы и матрицы):");
            double[][] res=new double[value.length][value.length];
            for (int i = 0; i <this.value.length ; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    res[i][j] = value[i][j] + ((Matrix) other).value[i][j];

                }
            }
            return new Matrix(res);
        } else
            return other.add(this);
    }

    @Override
    public Var sub (Var other) {

        if (other instanceof Scalar) {
            System.out.println("Вычитание(матрицы и скаляра):");
            double[][] res = new double[value.length][value.length];
            //double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    res[i][j] = value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);

        } else if (other instanceof Matrix) {
            System.out.println("Вычитание(матрицы и матрицы):");
            double[][] res=new double[value.length][value.length];
            for (int i = 0; i <this.value.length ; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    res[i][j] = value[i][j] - ((Matrix) other).value[i][j];

                }
            }
            return new Matrix(res);
        } else
            return other.add(this);
    }

    @Override
    public Var mul (Var other) {

        if (other instanceof Scalar) {
            System.out.println("Произведение(матрицы и скаляра):");
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    res[i][j] = value[i][j] * ((Scalar) other).getValue();
                }
            }

            return new Matrix(res);
        } else if (other instanceof Vector) {
            System.out.println("Произведение(матрицы и вектора):");
            double[] res=new double[value.length];
            for (int i = 0; i <value.length ; i++) {
                for (int j = 0; j < value[i].length; j++) {
                        res[i] = res[i]+value[i][j]*((Vector) other).getValue()[j];
                    }
                }
            return new Vector(res);

        } else if (other instanceof Matrix) {
            System.out.println("Произведение(матрицы и матрицы):");
            double[][] res=new double[value.length][value.length];
            for (int i = 0; i <value.length ; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    for (int k = 0; k<value.length ; k++) {

                    res[i][j] = res[i][j]+value[i][k]*((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(res);
        } else
            return other.add(this);
    }




    Matrix(String value){
        value = value.replaceAll("[{|}]{2,}", "");
        String[] stringValue = value.split("[}][\\s]?,[\\s]?[{]");

        this.value = new double[stringValue.length][];
        for (int i = 0; i < stringValue.length; i++) {

            String[] valueStringNumber = stringValue[i].trim().split(",");
            double[] tempArr = new double[valueStringNumber.length];

            for (int j = 0; j < valueStringNumber.length; j++) {
                tempArr[j] = Double.parseDouble(valueStringNumber[j]);
                this.value[i] = tempArr;
            }
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[i].length; j++) {
                sb.append(value[i][j]);
                if (j != value[i].length - 1) sb.append(", ");
            }
            if(i<value.length-1) sb.append("}, ");
            if(i == value.length-1) sb.append("}");
        }
        sb.append("}");
        return sb.toString();
    }
}