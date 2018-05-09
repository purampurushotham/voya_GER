package com.NEET.service;

import com.NEET.model.Franchise;
import com.NEET.model.Student;
import com.NEET.model.User;

import java.util.List;

public interface StudentService {
    public void addStudent(Student student);
    public Student getStudent(Integer studentId);
    public List<User> getAllFranchises();
}
