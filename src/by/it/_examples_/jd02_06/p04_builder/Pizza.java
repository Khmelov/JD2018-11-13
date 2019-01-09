package by.it._examples_.jd02_06.p04_builder;

/** "Product" */
class Pizza {
    private String dough="";
    private String sauce="";
    private String topping="";

    //тут сеттеры дружественные, но это обычно это public методы
    void setDough(String dough)     { this.dough = dough; }
    void setSauce(String sauce)     { this.sauce = sauce; }
    void setTopping(String topping) { this.topping = topping; }


    @Override
    public String toString() {
        return "Pizza{" +
                "dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", topping='" + topping + '\'' +
                '}';
    }
}


