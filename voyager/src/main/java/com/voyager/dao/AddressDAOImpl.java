package com.voyager.dao;

import com.voyager.model.Address;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDAOImpl implements AdressDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public void addAddress(Address address) {
        System.out.println("Addaddress");
        System.out.println(address.getTourist().getId());
        sessionFactory.getCurrentSession().saveOrUpdate(address);
    }

    @SuppressWarnings("unchecked")
    public List<Address> getAllAddress() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Address.class);
        System.out.println("getAllAddress");
        System.out.println(criteria.list());
        return criteria.list();
    }

    @Override
    public void deleteAddress(Integer Id) {
        Address tour = (Address) sessionFactory.getCurrentSession().load(Address.class,Id);
        if(tour != null){
            this.sessionFactory.getCurrentSession().delete(tour);
        }
    }

    @Override
    public Address updateAddress(Address address) {
        sessionFactory.getCurrentSession().update(address);
        System.out.println("updateAddress");
        return address;
    }
    public Address getAddress(Integer Id) {
        System.out.println("getAddress");
        return (Address) sessionFactory.getCurrentSession().get(Address.class,Id);
    }
}
