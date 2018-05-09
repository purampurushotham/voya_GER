package com.NEET.dao;

import com.NEET.model.Franchise;
import com.NEET.model.Student;
import com.NEET.model.User;
import com.voyager.model.Tourist;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void addStudent(Student student) {
        System.out.println("student");
        sessionFactory.getCurrentSession().saveOrUpdate(student);
    }
    public Student getStudent(Integer studentId) {
        System.out.println("student");
        return (Student) sessionFactory.getCurrentSession().get(User.class,studentId);
    }
    public List<User> getAllFranchises() {
        System.out.println("student");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class,"user");
        /*criteria.createCriteria("addressList").add(Restrictions.sqlRestriction("zipcode LIKE '%"+searchKey+"%' "));*/
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq("user.class",Franchise.class));
        return (List<User>) criteria.list();
    }
}
