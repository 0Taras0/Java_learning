package org.example.dao;

import org.example.entities.CategoryEntity;
import org.example.utils.HibernateHelper;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryDao {

    public void create(CategoryEntity category) {
        Transaction tx = null;
        try (Session session = HibernateHelper.getSession()) {
            tx = session.beginTransaction();
            session.persist(category);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public CategoryEntity getById(int id) {
        try (Session session = HibernateHelper.getSession()) {
            return session.find(CategoryEntity.class, id);
        }
    }

    public List<CategoryEntity> getAll() {
        try (Session session = HibernateHelper.getSession()) {
            return session.createQuery("from CategoryEntity", CategoryEntity.class).list();
        }
    }

    public void update(CategoryEntity category) {
        Transaction tx = null;
        try (Session session = HibernateHelper.getSession()) {
            tx = session.beginTransaction();
            session.merge(category);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Transaction tx = null;
        try (Session session = HibernateHelper.getSession()) {
            tx = session.beginTransaction();
            CategoryEntity category = session.find(CategoryEntity.class, id);
            if (category != null) {
                session.remove(category);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
    }
}