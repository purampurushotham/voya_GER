package com.voyager.dao;
import com.voyager.model.Tour;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
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

    @Override
    public List<Tour> searchPackages(String pName) {
        System.out.println("searchPackages");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Tour.class);
        ProjectionList pro1 = Projections.projectionList();
        pro1.add(Projections.property("packageName"));
        pro1.add(Projections.property("id"));
        criteria.add(Restrictions.ilike("packageName",pName, MatchMode.ANYWHERE));
        criteria.setProjection(pro1);
        return (List<Tour>)criteria.list();
    }
}
