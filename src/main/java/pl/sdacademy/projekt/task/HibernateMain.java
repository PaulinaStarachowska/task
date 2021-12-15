package pl.sdacademy.projekt.task;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class HibernateMain {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        EntityManager entityManger = sessionFactory.createEntityManager();

        Nauczyciel profesor = new Nauczyciel("Profesor");
        Nauczyciel profesor2 = new Nauczyciel("Profesor2");

        Student student1 = new Student("Jan", "Kowalski", 20, "xyz@wp.pl", "biologia");
        Student student2 = new Student("Ania", "Pietruszka", 21, "z@wp.pl", "matematyka");
        Student student3 = new Student("Tomek", "Tom", 20, "y@wp.pl", "biologia");
        Student student4 = new Student("Magda", "Kwiat", 19, "zy@wp.pl", "polski");

        List<Student> listStudent=new ArrayList<>();
        listStudent.add(student1);
        listStudent.add(student2);
        listStudent.add(student3);
        listStudent.add(student4);

        profesor.setStudentNauczyciela(listStudent);
        profesor2.setStudentNauczyciela(listStudent);

        entityManger.getTransaction().begin();

        entityManger.persist(student1);
        entityManger.persist(student2);
        entityManger.persist(student3);
        entityManger.persist(student4);
        entityManger.persist(profesor);
        entityManger.persist(profesor2);

        entityManger.getTransaction().commit();
        entityManger.close();
        sessionFactory.close();
    }
}
