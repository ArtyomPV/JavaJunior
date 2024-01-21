package seminar03.to_do_app;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static seminar03.to_do_app.ToDoListApp.*;

public class MainApp {
    public static void main(String[] args) {
        List<ToDoV2> tasks;
        File f = new File(FILE_JSON);
        if(f.exists() && !f.isDirectory()){
            tasks = loadTasksFromFile(FILE_JSON);
        } else {
            tasks = prepareTasks();
            ToDoListApp.saveTaskToFile(FILE_JSON, tasks);
            ToDoListApp.saveTaskToFile(FILE_BIN, tasks);
            ToDoListApp.saveTaskToFile(FILE_XML, tasks);
        }

        displayTasks(tasks);

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Выберите действие: ");
            System.out.println("1. Добавить новую задачу.");
            System.out.println("2. Отметить задачу как выполненую");
            System.out.println("3. выйти");

            String choice = sc.nextLine();
            switch (choice){
                case "1":
                    ToDoListApp.addNewTask(sc, tasks);
                    break;
                case "2":
                    ToDoListApp.markTaskAsDone(sc, tasks);
                    break;
                case "3":
                    ToDoListApp.saveTaskToFile(FILE_JSON, tasks);
                    ToDoListApp.saveTaskToFile(FILE_BIN, tasks);
                    ToDoListApp.saveTaskToFile(FILE_XML, tasks);
                    System.out.println("Список задач сохранен.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Некорректный ввод. Попробуйте снова.");
                    break;
            }
            displayTasks(tasks);
        }


    }

    static List<ToDoV2> prepareTasks(){
        ArrayList<ToDoV2> list = new ArrayList<>();
        list.add(new ToDoV2("Сходить в магазин за покупками"));
        list.add(new ToDoV2("Погулять с собакой"));
        list.add(new ToDoV2("Заменить лампочку"));
        return list;
    }
}

