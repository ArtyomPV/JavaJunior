package seminar04.modules;

import javax.persistence.*;
import java.util.Random;
@Entity
@Table(name = "Students")
public class StudentModule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column
    private  String name;
    @Column
    private  int age;
    private static final String[] names = new String[]{"Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Коля", "Вася", "Петя"};
    private final static Random random = new Random();

    public StudentModule(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public StudentModule(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public StudentModule(){

    }

    public static StudentModule create(){
        return new StudentModule(names[random.nextInt(names.length)], random.nextInt(20, 45) );
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    //endregion
}
