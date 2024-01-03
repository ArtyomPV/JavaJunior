package seminar01.uMarket.models;

import seminar01.uMarket.interfaces.Snack;

/**
 * Шоколадный батончик
 */
public class ChocolateBar implements Snack {
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
        return "Шоколадный батончик";
    }
}
