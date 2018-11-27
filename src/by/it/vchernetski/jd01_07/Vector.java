package by.it.vchernetski.jd01_07;
class Vector extends Var {
    private double[] value;
    Vector(double[] value){
        this.value = new double[value.length];
        System.arraycopy(value,0,this.value,0,value.length);
    }
    Vector(Vector otherVector){
        this.value = new double[otherVector.value.length];

        System.arraycopy(otherVector.value,0,this.value,0,otherVector.value.length);
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder("{");
        String del=", ";
        for (int i = 0; i < value.length; i++) {
            sb.append(value[i]).append(del);
            if(i == value.length-2) del = "}";
        }
        return sb.toString();
    }
}
