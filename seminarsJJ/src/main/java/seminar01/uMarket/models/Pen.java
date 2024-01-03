package seminar01.uMarket.models;

import seminar01.uMarket.interfaces.Thing;

public class Pen implements Thing {
    @Override
    public String getName() {
        return "Ручка";
    }
}
