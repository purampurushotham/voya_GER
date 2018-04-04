package com.voyager.dao;

import com.voyager.model.Tourist;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TouristDAOImpl implements TouristDAO {

@Autowired
private SessionFactory sessionFactory;

    public void addTourist(Tourist tourist) {
        System.out.println("AddTourist");
        System.out.println(tourist.getDob());
        sessionFactory.getCurrentSession().saveOrUpdate(tourist);
    }
    @SuppressWarnings("unchecked")
    public List<Tourist> getAllTourists() {
        System.out.println("getAllTourists");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Tourist.class);
        System.out.println(criteria.list());
        return criteria.list();
    }
    @Override
    public void deleteTourist(Integer Id) {
        System.out.println("getAllTourists");
        Tourist tourist = (Tourist) sessionFactory.getCurrentSession().load(Tourist.class,Id);
        if(tourist != null){
            sessionFactory.getCurrentSession().delete(tourist);
        }
    }
    @Override
    public Tourist updateTourist(Tourist tourist) {
        System.out.println("updateTourist");
        sessionFactory.getCurrentSession().update(tourist);
        return tourist;
    }
    @Override
    public Tourist getTourist(Integer Id) {
        System.out.println("getTourist");
        return  (Tourist)sessionFactory.getCurrentSession().get(Tourist.class,Id);
    }
}
