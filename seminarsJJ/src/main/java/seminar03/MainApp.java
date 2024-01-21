package seminar03;


import java.io.*;

public class MainApp {
    public static void main(String[] args) {
        task01();
        task02();
    }


    private static void task01(){
        UserData userData = new UserData("Igor", 37, "password1");
        try(FileOutputStream fileOutputStream = new FileOutputStream("userdata.bin")){
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(userData);
            System.out.println("Объект UserData сериализован.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void task02() {
        try(FileInputStream fileInputStream = new FileInputStream("userdata.bin")){
            ObjectInputStream in = new ObjectInputStream(fileInputStream);
           UserData userData = (UserData)in.readObject();
            System.out.println("Объект UserData сериализован.");
            System.out.println("Имя: " + userData.getName());
            System.out.println("Возраст: " + userData.getAge());
            System.out.println("Пароль (должен быть null, так как transiant): " + userData.getPassword());

        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
