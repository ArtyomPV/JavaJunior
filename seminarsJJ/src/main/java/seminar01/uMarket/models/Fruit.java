package seminar01.uMarket.models;

import seminar01.uMarket.interfaces.HealthyFood;

/**
 * Фрукт
 */
public class Fruit implements HealthyFood {
    @Override
    public boolean getProteins() {
        return false;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return true;
    }

    @Override
    public String getName() {
        return "Фрукт";
    }
}
