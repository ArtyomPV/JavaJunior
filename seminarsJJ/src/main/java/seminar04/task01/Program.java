package seminar04.task01;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Program {

    private final static Random random  = new Random();
    /**
     * Задача 1
     * ==================
     * <p>
     * Использую SQL, создайте таблицу students с полями id (ключ), name, age
     * Реализуйте подключение к базе данных через JDBC:
     * Напишите подключение к базе данных (например MysSQL или PostgreSQL).
     * Реализуйте вставку, чтение, и удаление данных в таблице Students
     * с использованием провайдера JDBC
     * </p>
     */
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "password";

        try {
            // Подключение к базе данных
            Connection connection = DriverManager.getConnection(url, user, password);

            // Создание базы данных
            createConnection(connection);
            System.out.println("Database created successfully");

            //использование базы данных
            useDatabase(connection);
            System.out.println("Use database successfully");

            // Создание таблицы
            createTable(connection);
            System.out.println("Create table");

            // Вставка данных

            int count = random.nextInt(5, 11);

            for (int i = 0; i < count; i++) {
                insertData(connection, Student.create());
            }
            System.out.println("Insert data successfully");


            // Чтение данных
            Collection<Student> students = readDatabase(connection);
            for (var student : students) {
                System.out.println(student);
            }
            System.out.println("Read data successfully");

            // Обновление данных
            for (var student: students){
                student.updateName();
                student.updateAge();
                updateDatabase(connection, student);
            }
            System.out.println("Update data successfully");


            // Удаление данных
//            for (var student: students){
//                deleteData(connection, student.getId());
//            }
//            System.out.println("Delete data successfully");

            // Закрытие соединения
            connection.close();
            System.out.println("Database connection close successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //region Вспомогательные методы
    private static void createConnection(Connection connection) throws SQLException{
        String createDataBaseSQL = "CREATE DATABASE IF NOT EXISTS studentsDB";
        PreparedStatement statement = connection.prepareStatement(createDataBaseSQL);
        statement.execute();
    }

    private static void useDatabase(Connection connection) throws SQLException{
        String useDatabaseSQL = "USE studentsDB";
        try(PreparedStatement statement = connection.prepareStatement(useDatabaseSQL)){
            statement.execute();
        }
    }

    private static void createTable(Connection connection) throws SQLException{
        String createTableSQL = "CREATE TABLE IF NOT EXISTS students (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), age INT)";
        try(PreparedStatement statement = connection.prepareStatement(createTableSQL)){
            statement.execute();
        }
    }

    /**
     * Доббавление данных в таблицу
     * @param connection Соединение с БД
     * @param student Студент
     * @throws SQLException Исключение при выполнении запроса
     */
    private static void insertData(Connection connection, Student student) throws SQLException{
        String inserDataSQL = "INSERT INTO students (name, age) VALUES (?, ?);";
        try(PreparedStatement statement = connection.prepareStatement(inserDataSQL)){
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.executeUpdate();
        }
    }


    private static Collection<Student> readDatabase(Connection connection) throws SQLException{
        ArrayList<Student> studentList = new ArrayList<>();
        String readDatabaseSQL = "SELECT * FROM students;";
        try(PreparedStatement statement = connection.prepareStatement(readDatabaseSQL)){
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getNString("name");
                int age = resultSet.getInt("age");
                studentList.add(new Student(id, name, age));
            }
           return studentList;
        }
    }


    /**
     * Обновление данных в тфблице students по индефикатору
     * @param connection Соединение с БД
     * @param student Студент
     * @throws SQLException Исключение при выполнении запроса
     */
    private static void updateDatabase(Connection connection, Student student)throws SQLException{
        String  updatabaseSQL = "UPDATE students SET name=?, age=? WHERE id=?;";
        try(PreparedStatement statement = connection.prepareStatement(updatabaseSQL)){
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setInt(3, student.getId());
            statement.executeUpdate();
        }
    }

    /**
     * Удаление записи из таблицы students по индефикатору
     * @param connection  Соединение с БД
     * @param id идентификатор записи
     * @throws SQLException Исключение при выполнении запроса
     */
    private static void deleteData(Connection connection, int id) throws SQLException{
        String deleteDataSQL = "DELETE FROM students WHERE id=?;";
        try(PreparedStatement statement = connection.prepareStatement(deleteDataSQL)){
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }

    //endregion
}
