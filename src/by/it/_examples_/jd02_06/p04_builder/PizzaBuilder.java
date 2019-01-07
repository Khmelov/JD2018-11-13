package by.it._examples_.jd02_06.p04_builder;

/** "Abstract Builder" */
abstract class PizzaBuilder {
    Pizza pizza;

    Pizza getPizza() { return pizza; }
    void createNewPizzaProduct() { pizza = new Pizza(); }

    public abstract void buildDough();
    public abstract void buildSauce();
    public abstract void buildTopping();
}

