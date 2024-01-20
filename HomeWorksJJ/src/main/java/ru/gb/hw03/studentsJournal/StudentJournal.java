package ru.gb.hw03.studentsJournal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentJournal {
    static String pathFile = "JavaJunior\\HomeWorksJJ\\src\\main\\resources\\";
    public static final String FILE_JSON = pathFile.concat("studentMap.json");
    public static final String FILE_BIN = pathFile.concat("studentMap.bin");
    public static final String FILE_XML = pathFile.concat("studentMap.xml");

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static void addNewStudent(Scanner scanner, List<StudentMap> studentsList){
        System.out.println("Введите имя студента: ");
        String name = scanner.nextLine();
        System.out.println("Введите возраст студента: ");
        int age = scanner.nextInt();
        System.out.println("Введите средний балл: ");
        double gpo = scanner.nextDouble();
        saveToFile(FILE_JSON, studentsList);
        saveToFile(FILE_BIN, studentsList);
        saveToFile(FILE_XML, studentsList);
        System.out.println("Запись нового студента выполнена");


    }

    public static void saveToFile(String fileName, List<StudentMap> studentsList){
        try{
            if(fileName.endsWith(".json")){
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName), studentsList);
            } else if (fileName.endsWith(".bin")){
                try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
                    out.writeObject(studentsList);
                }
            }  else if (fileName.endsWith(".xml")){
                xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                xmlMapper.writeValue(new File(fileName), studentsList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<StudentMap> loadTasksFromFile(String fileName) {
        List<StudentMap> studentsList = new ArrayList<>();
        File file = new File(fileName);
        try {
            if(file.exists()) {
                if (fileName.endsWith(".json")) {
                    studentsList = objectMapper.readValue(fileName, objectMapper.getTypeFactory().constructCollectionType(List.class, StudentJournal.class));
                } else if (fileName.endsWith(".bin")){
                    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                        studentsList = (List<StudentMap>) ois.readObject();
                    }
                } else if (fileName.endsWith(".xml")){
                    studentsList = xmlMapper.readValue(fileName, xmlMapper.getTypeFactory().constructCollectionType(List.class, StudentJournal.class));
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return studentsList;
    }
}
