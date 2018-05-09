package com.NEET.service;

import com.NEET.dao.StudentDAO;
import com.NEET.dao.StudentDAO;
import com.NEET.model.Franchise;
import com.NEET.model.Student;
import com.NEET.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl  implements StudentService{
    @Autowired
    private StudentDAO studentDAO;

    @Override
    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    @Override
    public Student getStudent(Integer studentId) {
        return studentDAO.getStudent(studentId);
    }

    @Override
    public List<User> getAllFranchises() {
        return studentDAO.getAllFranchises();
    }
}
