package com.NEET.controller;

import com.NEET.model.Franchise;
import com.NEET.model.Student;
import com.NEET.model.User;
import com.NEET.service.StudentService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String setIndex(){
        return "redirect:/home";
    }

    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public ResponseEntity<Void> home(UriComponentsBuilder ucBuilder){
        Student s = new Student();
        Franchise f = new Franchise();
        createObject(s);
        studentService.addStudent(s);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(s.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
        System.out.println("Fetching User with id " + id);
        User student = studentService.getStudent(id);
        if (student == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(student, HttpStatus.OK);
    }
    @RequestMapping(value = "/franchises", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUser() {
        List<User> student = studentService.getAllFranchises();
        if (student == null) {
            return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<User>>(student, HttpStatus.OK);
    }
    public void createObject(Student s){
        s.setQualification("test");
        s.setAadharNo("1111111");
        s.setAddressOne("test");
        s.setAddressTwo("test");
        s.setCity("test");
        s.setEmail("test");
        s.setFirstName("test");
        s.setGender("test");
        s.setLandlineNo("test");
        s.setLastName("test");
        s.setPanNo("test");
        s.setPhoneNo("test");
        s.setMiddleName("test");
        s.setState("test");
        s.setStatus("test");
        s.setZipcode(32232);
    }
}
