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

/** Establishing controller for Individual entity.  **/
  @Component
  @RestController
  @RequestMapping("/individuals")
  @ExposesResourceFor(Individual.class)
  public class IndividualController {

    /** Individual Repository declared to allow controller/repository relationship. **/
    private final IndividualRepository individualRepository;

  /**
   * Spring looks for the class that matches this Autowired property and injects it automatically
   * into the application context.  @Autowired must be set for Spring to recognize it.
   **/
    @Autowired
    public IndividualController(IndividualRepository individualRepository) {
      this.individualRepository = individualRepository;
    }
  /** Controller command allowing posting of Individual data to database.**/
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Individual> post(@RequestBody Individual individual) {
      individualRepository.save(individual);
      return ResponseEntity.created(individual.getHref()).body(individual);
    }
  }