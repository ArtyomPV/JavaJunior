package seminar01.uMarket.interfaces;

public interface Food extends Thing {
    /**
     * Получить наличие протеинов в еде
     * @return наличие протеинов
     */
    boolean getProteins();

    /**
     * Получить наличие жиров в еде
     * @return наличие жиров
     */
    boolean getFats();

    /**
     * Получить наличие углеводов в еде
     * @return наличие углеводов
     */
    boolean getCarbohydrates();
}
