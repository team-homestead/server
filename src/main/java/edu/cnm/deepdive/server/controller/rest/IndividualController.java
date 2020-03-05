package edu.cnm.deepdive.server.controller.rest;

import edu.cnm.deepdive.server.model.entity.Individual;
import edu.cnm.deepdive.server.service.IndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



  @Component
  @RestController
  @RequestMapping("/individuals")
  @ExposesResourceFor(Individual.class)


  public class IndividualController {
    private final IndividualRepository individualRepository;


    @Autowired
    public IndividualController(IndividualRepository individualRepository) {
      this.individualRepository = individualRepository;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Individual> post(@RequestBody Individual individual) {
      individualRepository.save(individual);
      return ResponseEntity.created(individual.getHref()).body(individual);
    }
  }