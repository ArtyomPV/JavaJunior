package seminar04.task02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import seminar04.modules.StudentModule;


public class Program {
    /**
     * Задача 2
     * ==============
     * <p>
     *     Настройте Hibernate, связав его с с вашей базой данных.
     *     Создайте класс Student в Java, аннотируя его как сущность Hibernate.
     *     Используя Hibernate, реализуйте вставку, чтение, обновление и
     *     удаление данных в таблице students
     *     Обратите внимание на использование сессий и транзакций в Hibernate
     * </p>
     */

    public static void main(String[] args) {
        // Создание фабрики сессий
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(StudentModule.class)
                .buildSessionFactory();

        // Создание сессии
//        Session session = sessionFactory.getCurrentSession();
//        try{
//    }
//        finally {
//            sessionFactory.close();
//        }
        try(Session session = sessionFactory.getCurrentSession()){

            // Начало транзакции
            session.beginTransaction();

            // Создаем студента
            StudentModule student = StudentModule.create();

            // Сохраняем объект в базе данных
            session.save(student);
            System.out.println("Object student sava successfully");

            // Чтение объекта из базы данных
            StudentModule retrievedStudent = session.get(StudentModule.class, student.getId());
            System.out.println("Object student retrieved successfully");
            System.out.println("Retrieved student object " + retrievedStudent);

            // Обновление объекта
            retrievedStudent.updateName();
            retrievedStudent.updateAge();
            session.update(retrievedStudent);
            System.out.println("Object student update successfully");

            // Удаление объекта
//            session.delete(retrievedStudent);
//            System.out.println("Object student update successfully");

            // Коммит транзакции
            session.getTransaction().commit();
            System.out.println("Transaction commit successfully");

        }
        }
}
