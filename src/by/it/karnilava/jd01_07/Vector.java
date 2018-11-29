package by.it.karnilava.jd01_07;

class Vector extends AbstractVar {

    private double[] value;

    Vector(double [] value) {
        this.value = value;
    }

    Vector(Vector vector){
        this.value = vector.value;
    }

    Vector (String strVector){

        String [] strArr = strVector.replaceAll("[{}]", "").split("[,]");
        double [] res = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i]=Double.parseDouble(strArr[i]);
        }
        this.value = res;

    }

    public String toString(){
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element: value){
            sb.append(delimiter).append(element);
            delimiter=", ";
        }
        sb.append("}");
        return sb.toString();

    }
}
