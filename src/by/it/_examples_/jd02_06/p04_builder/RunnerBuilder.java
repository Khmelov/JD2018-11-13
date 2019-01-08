package by.it._examples_.jd02_06.p04_builder;

/**
 * A customer ordering a product.
 */
public class RunnerBuilder {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        PizzaBuilder pizzaBuilder = Math.random() > 0.5 ? new HawaiianPizzaBuilder() : new SpicyPizzaBuilder();
        waiter.setPizzaBuilder(pizzaBuilder);
        waiter.constructPizza();

        Pizza pizza = waiter.getPizza();
        System.out.println(pizza);
    }
}
