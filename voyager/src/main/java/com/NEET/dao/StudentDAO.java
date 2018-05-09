package com.NEET.dao;

import com.NEET.model.Franchise;
import com.NEET.model.Student;
import com.NEET.model.User;
import com.voyager.model.Address;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentDAO {
public void addStudent(Student student);
public Student getStudent(Integer studentId);
    public List<User> getAllFranchises();
}
