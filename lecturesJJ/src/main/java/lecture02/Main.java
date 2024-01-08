package lecture02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> car = Class.forName("lecture02.Car");
        Constructor<?>[] constructors = car.getConstructors();
        System.out.println(constructors);

        Object gaz = constructors[0].newInstance("ГАЗ");
        System.out.println(gaz);

        Field[] fields = gaz.getClass().getFields();
        int temp = fields[fields.length-1].getInt(gaz);
        fields[fields.length-1].setInt(gaz, temp*2);
        System.out.println("GAZ +++++++++++++++++++++++++++");
        System.out.println(gaz);
        System.out.println("Get methods ==========================");
        Method[] methods = gaz.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
        }

        Method[] methods1 = gaz.getClass().getDeclaredMethods();
        System.out.println("Get declorated methods ===============");
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
        }
    }
}
