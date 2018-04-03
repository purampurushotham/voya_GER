package com.voyager.dao;
import com.voyager.model.Tour;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TourDAOImpl implements TourDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public void addTour(Tour tour) {
        sessionFactory.getCurrentSession().saveOrUpdate(tour);
    }
    @SuppressWarnings("unchecked")
    public List<Tour> getAllTours() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Tour.class);
        System.out.println("getAllTours");
        System.out.println(criteria.list());
        return criteria.list();
    }
    @Override
    public void deleteTour(Integer Id) {
        Tour tour = (Tour) sessionFactory.getCurrentSession().load(Tour.class,Id);
        if(tour != null){
            this.sessionFactory.getCurrentSession().delete(tour);
        }

    }
    @Override
    public Tour updateTour(Tour tour) {
    sessionFactory.getCurrentSession().update(tour);
        System.out.println("updateTour");
    return tour;
    }
    public Tour getTour(Integer Id) {
        System.out.println("getTour");
        return (Tour) sessionFactory.getCurrentSession().get(Tour.class,Id);
    }


}
