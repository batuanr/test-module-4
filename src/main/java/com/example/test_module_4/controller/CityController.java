package com.example.test_module_4.controller;

import com.example.test_module_4.model.City;
import com.example.test_module_4.service.city.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/city")
public class CityController {
    @Autowired
    ICityService cityService;


    @GetMapping("/list")
    public ResponseEntity<Page<City>> getAllCity(@PageableDefault(value = 5)Pageable pageable){
        Page<City> cities = cityService.findAll(pageable);
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<City> create(@RequestBody City city){
        cityService.save(city);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<City> edit(@PathVariable Long id, @RequestBody City city){
        Optional<City> city1 = cityService.findById(id);
        if (!city1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        city.setId(city1.get().getId());
        cityService.save(city);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/findOne/{id}")
    public ResponseEntity<City> findById(@PathVariable Long id){
        Optional<City> city1 = cityService.findById(id);
        if (!city1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(city1.get(), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<City> delete(@PathVariable Long id){
        Optional<City> city1 = cityService.findById(id);
        if (!city1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cityService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
