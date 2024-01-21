package seminar03;

import java.io.Serializable;

public class UserData implements Serializable {
    //region fields

    private final String name;
    private final int age;
    transient String password;

    //endregion

    // region constructor

    public UserData(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    //endregion


    //region Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }
    //endregion
}
