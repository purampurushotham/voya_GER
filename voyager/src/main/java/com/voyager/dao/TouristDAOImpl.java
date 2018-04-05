package com.voyager.dao;

import com.voyager.model.Address;
import com.voyager.model.Passport;
import com.voyager.model.Tour;
import com.voyager.model.Tourist;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public class TouristDAOImpl implements TouristDAO {

@Autowired
private SessionFactory sessionFactory;
    public void addTourist(Tourist tourist) {
        System.out.println("AddTourist");
        tourist = setAddressAssocaition(tourist);
        /*tourist = setPassportAssociation(tourist);*/
        sessionFactory.getCurrentSession().saveOrUpdate(tourist);

    }
    @SuppressWarnings("unchecked")
    public List<Tourist> getAllTourists() {
        System.out.println("getAllTourists");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Tourist.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
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
        tourist = setAddressAssocaition(tourist);
        sessionFactory.getCurrentSession().update(tourist);
        return tourist;
    }
    @Override
    public Tourist getTourist(Integer Id) {
        System.out.println("getTourist");
        return  (Tourist)sessionFactory.getCurrentSession().get(Tourist.class,Id);
    }
    public Tourist setAddressAssocaition(Tourist tourist){
        List<Address> touristAddress = tourist.getAddressList();
        Iterator<Address> addressIterator = touristAddress.listIterator();
        while(addressIterator.hasNext()){
            Address a =addressIterator.next();
            a.setTourist(tourist);
        }
        return tourist;
    }
    /*public Tourist setPassportAssociation(Tourist tourist){
        Passport passport =tourist.getPassport();
        passport
        return tourist;
    }*/
}
