package seminar01.uMarket.models;

import seminar01.uMarket.interfaces.Thing;

/**
 * Блокнот
 */
public class NoteBook implements Thing {

    @Override
    public String getName() {
        return "Блокнот";
    }
}
