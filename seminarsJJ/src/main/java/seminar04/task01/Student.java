package seminar04.task01;

import java.util.Random;

public class Student {

    private  int id;
    private  String name;
    private  int age;
    private static final String[] names = new String[]{"Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Коля", "Вася", "Петя"};
    private final static Random random = new Random();

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student( String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Student(){

    }

    public static  Student create(){
        return new Student(names[random.nextInt(names.length)], random.nextInt(20, 45) );
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public void updateAge(){
        age = random.nextInt(20, 30);
    }
    public void updateName(){
        name = names[random.nextInt(names.length)];
    }

    //region Getters & Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //endregion
}
