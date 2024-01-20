package ru.gb.hw03.studentsJournal;

import ru.gb.hw03.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static ru.gb.hw03.studentsJournal.StudentJournal.*;

public class MainApp {
    public static void main(String[] args) {
        StudentMap student = new StudentMap("Igorek", 27, 4.5);
        System.out.println(student);

        List<StudentMap> studentsList;
        File file = new File(FILE_JSON);

        if (file.exists() && !file.isDirectory()) {
            studentsList = loadTasksFromFile(FILE_JSON);
        } else {
            studentsList = prepareTasks();
            StudentJournal.saveToFile(FILE_JSON, studentsList);
            StudentJournal.saveToFile(FILE_BIN, studentsList);
            StudentJournal.saveToFile(FILE_XML, studentsList);
        }
    }

    private static List<StudentMap> prepareTasks() {
        List<StudentMap> studentList = new ArrayList<>();
        studentList.add(new StudentMap("Igorek", 27, 4.5));
        studentList.add(new StudentMap("Lelik", 25, 4.2));
        return studentList;
    }


}
