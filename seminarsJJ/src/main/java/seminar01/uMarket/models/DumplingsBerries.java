package seminar01.uMarket.models;

import seminar01.uMarket.interfaces.SemiFinishedFood;

/**
 * Замороженные ягоды
 */
public class DumplingsBerries  implements SemiFinishedFood {
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
        return "Замороженные ягоды";
    }
}
