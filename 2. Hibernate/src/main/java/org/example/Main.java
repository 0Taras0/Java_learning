package org.example;

import org.example.dao.CategoryDao;
import org.example.entities.CategoryEntity;
import org.example.utils.HibernateHelper;

public class Main {
    public static void main(String[] args) {

        CategoryDao dao = new CategoryDao();

        CategoryEntity category = new CategoryEntity("Електроніка");
        dao.create(category);

        System.out.println("=== Усі категорії ===");
        dao.getAll().forEach(System.out::println);

        CategoryEntity found = dao.getById(category.getId());
        System.out.println("Знайдено: " + found);

        found.setName("Оновлена електроніка");
        dao.update(found);

        dao.delete(found.getId());

        System.out.println("=== Після видалення ===");
        dao.getAll().forEach(System.out::println);

//        var session = HibernateHelper.getSession();
//        try {
//            var result = session.createSelectionQuery("from CategoryEntity", CategoryEntity.class)
//                    .getResultList();
//
//            result.forEach(System.out::println);
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        finally {
//            session.close();
//        }
    }

    private static void SimpleInsert(){
        var session = HibernateHelper.getSession();

        try {
            session.beginTransaction();

            CategoryEntity [] list = new CategoryEntity[2];
            list[0] = new CategoryEntity();
            list[0].setName("Test1");

            list[1] = new CategoryEntity();
            list[1].setName("Test2");

            //Збереження
            session.persist(list[0]);
            session.persist(list[1]);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    private static void SimpleInsertFactory(){
        var sessionFactory = HibernateHelper.getSessionFactory();
        sessionFactory.inTransaction((session) -> {
            session.persist(new CategoryEntity("Test"));
        });
        sessionFactory.close();
    }
}