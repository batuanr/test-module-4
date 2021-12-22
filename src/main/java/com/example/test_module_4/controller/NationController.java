package com.example.test_module_4.controller;

import com.example.test_module_4.model.Nation;
import com.example.test_module_4.service.nation.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/nation")
public class NationController {
    @Autowired
    INationService nationService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<Nation>> findAll(){
        return new ResponseEntity<>(nationService.findAll(), HttpStatus.OK);
    }

}
