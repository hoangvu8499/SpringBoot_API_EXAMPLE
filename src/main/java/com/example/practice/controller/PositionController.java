package com.example.practice.controller;

import com.example.practice.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PositionController {
    @Autowired private PositionService positionService;

//    @GetMapping("/get-person")
//    public List<Person> getAll(@RequestParam int page, @RequestParam int offset){
//        List<Person> listPerson = personService.getAll(page, offset);
//        if(listPerson.isEmpty()){
//            return new ArrayList<>();
//        }
//        return listPerson;
//    }
}
