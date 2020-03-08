package edu.cnm.deepdive.server.controller.rest;

import edu.cnm.deepdive.server.model.entity.Service;
import edu.cnm.deepdive.server.model.entity.User;
import edu.cnm.deepdive.server.service.ServiceRepository;
import edu.cnm.deepdive.server.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Establishing controller for Service entity.  **/
@Component
@RestController
@RequestMapping("/services")
@ExposesResourceFor(Service.class)
public class ServiceController {

  /** Service Repository declared to allow controller/repository relationship.**/
  private final ServiceRepository serviceRepository;

  /**
   * Spring looks for the class that matches this Autowired property and injects it automatically
   * into the application context.  @Autowired must be set for Spring to recognize it.
   **/
  @Autowired
  public ServiceController(ServiceRepository serviceRepository) {
    this.serviceRepository = serviceRepository;
  }
  /** Controller command allowing posting of Service data to database.**/
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Service> post(@RequestBody Service service) {
    serviceRepository.save(service);
    return ResponseEntity.created(service.getHref()).body(service);
  }
}



