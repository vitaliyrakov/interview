package com.hw5.model.dao;

import org.hibernate.Session;

import java.util.List;

import static com.hw5.HibernateUtil.getCurrentSession;

public class DaoImpl<T>  implements Dao<T> {

    private Class<T> clazz;

    public void setClassStudent(final Class<T> classToSet) {
        clazz = classToSet;
    }

    @Override
    public void save(T entity) {
        Session currentSession = getCurrentSession();
        getCurrentSession().save(entity);
    }

    @Override
    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public T findById(int id) {
        return (T) getCurrentSession().get(clazz , id);
    }

    @Override
    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<T> findAll() {
        return (List<T>) getCurrentSession().createQuery("from " + clazz.getSimpleName()).list();
    }

    @Override
    public void deleteAll() {
        List<T> entityList = findAll();
        for (T entity : entityList) {
            delete(entity);
        }
    }
}
