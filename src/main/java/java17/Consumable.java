package java17;

public sealed interface Consumable permits Beverage {

    public void consume();

}
