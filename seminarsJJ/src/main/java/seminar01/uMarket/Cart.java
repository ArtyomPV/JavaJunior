package seminar01.uMarket;

import seminar01.uMarket.interfaces.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Корзина
 *
 * @param <T> Еда
 */
public class Cart<T extends Food> {
    //region Поля
    private final ArrayList<T> foodstuffs;
    private final uMarket market;
    private final Class<T> clazz;

    /**
     * Создание нового экземпляра корзины
     *
     * @param clazz
     * @param market принадлежность к магазину
     */
    public Cart(Class<T> clazz, uMarket market) {
        this.foodstuffs = new ArrayList<>();
        this.market = market;
        this.clazz = clazz;
    }
    //endregion


    public void printFoodstuffs() {

/*
        int index = 1;
        for(var food: foodstuffs){
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                    index++,
                    food.getName(),
                    food.getProteins() ? "Да":"Нет",
                    food.getFats() ? "Да":"Нет",
                    food.getCarbohydrates() ? "Да":"Нет"
            );
        }

 */


        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food ->
                System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                        index.getAndIncrement(),
                        food.getName(),
                        food.getProteins() ? "Да" : "Нет",
                        food.getFats() ? "Да" : "Нет",
                        food.getCarbohydrates() ? "Да" : "Нет"
                )
        );
    }

    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }

    public void cartBalacing() {
        boolean proteins = false;
        boolean fats = false;
        boolean carbohydrates = false;

        for (var food : foodstuffs) {
            if (!proteins && food.getProteins()) proteins = true;
            else if (!fats && food.getFats()) fats = true;
            else if (!carbohydrates && food.getCarbohydrates()) carbohydrates = true;
            if (proteins && fats && carbohydrates) break;
        }
        if (proteins && fats && carbohydrates) {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }
        for (var thing : market.getThings(clazz)) {
            if (!proteins && thing.getProteins()) {
                proteins = true;
                foodstuffs.add(thing);
            } else if (!fats && thing.getFats()) {
                fats = true;
                foodstuffs.add(thing);
            } else if (!carbohydrates && thing.getCarbohydrates()) {
                carbohydrates = true;
                foodstuffs.add(thing);
            }
            if (proteins && fats && carbohydrates) break;

        }
        if (proteins && fats && carbohydrates) {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
        } else
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");
    }
}
