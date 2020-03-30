package edu.cnm.deepdive.server.controller.rest;

import edu.cnm.deepdive.server.model.entity.Agency;
import edu.cnm.deepdive.server.model.entity.Service;
import edu.cnm.deepdive.server.model.repository.ServiceRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/** Establishing controller for Service entity.  **/
@Component
@RestController
@RequestMapping("/services")
@ExposesResourceFor(Service.class)
public class ServiceController {


  /** Service Repository declared to allow controller/repository relationship.**/
  private final ServiceRepository serviceRepository;


  /**This Autowired property allows Spring to it automatically into the application context.**/
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

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Service get(@PathVariable UUID id) {
    return serviceRepository.findById(id).get();
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Service> get() {
    return serviceRepository.findAll();
  }

  @DeleteMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {
    serviceRepository.findById(id).ifPresent((service) -> {
      List<Agency> agencies = service.getAgencies();
      agencies.forEach((agency) -> agency.getServices().remove(service)); // TODO Check service.equals implementation
      serviceRepository.delete(service);
    });
  }
}



