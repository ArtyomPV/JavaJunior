package seminar.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainApp {
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
        String password = "admin";


        try {
            // Подключение к базе данных
            Connection connection = DriverManager.getConnection(url, user, password);

            // Создание базы данных
            createDatabase(connection);
            System.out.println("Database creates successfully");

            // Использование базы данных
            useDatabase(connection);
            System.out.println("Use database successfully ");

            // Создание таблицы
            createTable(connection);
            System.out.println("Create table successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // region Вспомогательные методы

    private static void createDatabase(Connection connection) throws SQLException{
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS studentsDB;";
        PreparedStatement statement = connection.prepareStatement(createDatabaseSQL);
        statement.execute();
    }


    private static void useDatabase(Connection connection) throws SQLException{
        String useDatabaseSQL = "USE studentsDB";
        try(PreparedStatement statement = connection.prepareStatement(useDatabaseSQL)){
            statement.execute();
        }
    }

    private static void createTable(Connection connection) throws SQLException{
        String createTableSQL = "CREATE TABLE IF NOT EXISTS students (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), age INT);";
        try(PreparedStatement statement = connection.prepareStatement(createTableSQL)){
            statement.execute();
        }
    }
    //endregion
}

