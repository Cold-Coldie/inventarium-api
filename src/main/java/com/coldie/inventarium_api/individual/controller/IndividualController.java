package com.coldie.inventarium_api.individual.controller;

import com.coldie.inventarium_api.individual.model.Individual;
import com.coldie.inventarium_api.individual.repository.IndividualRepository;
import com.coldie.inventarium_api.user.enums.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/individual")
public class IndividualController {

    @Autowired
    private IndividualRepository individualRepository;

    @GetMapping("")
    public  ResponseEntity<List<Individual>> getAllIndividuals() {
        return new ResponseEntity<List<Individual>>(individualRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Individual> createIndividual() {
        Individual individual = new Individual();

        individual.setEmail("erioluwa1@gmail.com");
        individual.setPassword("erioluwa@gmail");
        individual.setRole(RoleType.INDIVIDUAL);
        individual.setCurrency("USD");
        individual.setCountry("USA");
        individual.setAddress("2 Washington");
        individual.setFirstName("Erioluwa");
        individual.setLastName("Ogedengbe");

        return new ResponseEntity<Individual>(individualRepository.save(individual), HttpStatus.CREATED);
    }
}
