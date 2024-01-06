package lecture01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args) {
//        task01();

        List<User> list = Arrays.asList(new User("Павел", 25), new User("Коля", 28), new User("Дима", 22));
        list.stream()
                .map(user -> new User(user.name, user.age-5))
                .filter(user-> user.age<22)
                .forEach(System.out::println);
    }
public static void task01(){
    //        PlainInterface plainInterface = new PlainInterface() {
//            @Override
//            public String action(int x, int y) {
//                return String.valueOf(x + y);
//            }
//        };
//     использование лямбда выражения
    PlainInterface plainInterface = (x, y) -> String.valueOf(x + y);
    System.out.println(plainInterface.action(5,3));

    PlainInterface plainInterface1 = (x, y) -> String.valueOf(Integer.compare(x,y));
    System.out.println(plainInterface1.action(1, 5));

    PlainInterfaceInt plainInterface2  = Integer::compare;
    System.out.println(
            plainInterface2.action(4, 3)
    );

    PlainInterfaceInt plainInterface3 = Integer::sum;
    System.out.println(plainInterface3.action(5,4));

    List<String> list = Arrays.asList("Привет", "мир", "!", "я", "родился");
    List<String> newList = list.stream()
            .filter(str -> str.length()>4) //фильтр является конвеерным методом
            .collect(Collectors.toList());
    for (String s : list) {
        System.out.println(s);
    }

    /**
     * используется поток для филтрации и выводит в консоль
     */
    list.stream()
            .filter(str -> str.length()>4) //фильтр является конвеерным методом
            .forEach(System.out::println);

    list.stream()
            .filter(str->str.length()>4)
            .filter(str->str.contains("о"))
            .forEach(System.out::println);

    /**
     * в stream переобразуем число в его квадрат
     */
    Arrays.asList(1, 2, 3, 4, 5).stream()
            .map(number->number*number)
            .forEach(System.out::println);

    /**
     * в методе map можно выполнять с числом и другие действия
     */
    Stream.of (1, 2, 3, 4, 5)
            .map(number->"число: " + number + " квадрат числа:" + number*number)
            .forEach(System.out::println);

    Stream.of (1, 10, 8, 5, 7, 5)
            .sorted()
//                .distinct()
            .forEach(System.out::println);

}

}
