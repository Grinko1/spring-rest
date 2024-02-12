package com.example.demo.controllers;

import com.example.demo.models.Person;
import com.example.demo.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {
    private PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }
    @GetMapping
    public List<Person> getAll(){
        return peopleService.findAll();
    }
    @GetMapping("/{id}")
    public Person getById(@PathVariable("id") int id){
        return peopleService.findOne(id);
    }
}
