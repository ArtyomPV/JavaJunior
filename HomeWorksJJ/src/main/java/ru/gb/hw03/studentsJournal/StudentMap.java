package ru.gb.hw03.studentsJournal;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class StudentMap implements Externalizable {
    private String name;
    private int age;
    private double gpo;

    public StudentMap(){

    }
    public StudentMap(String name, int age, double gpo) {
        this.name = name;
        this.age = age;
        this.gpo = gpo;
    }

    @Override
    public String toString() {
        return "StudentMap{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gpo=" + gpo +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
        out.writeDouble(gpo);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String)in.readObject();
        age = in.readInt();
        gpo = in.readDouble();

    }
}
