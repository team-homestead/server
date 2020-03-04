package edu.cnm.deepdive.server.controller.rest;


import edu.cnm.deepdive.server.controller.exception.SearchTermTooShortException;
import edu.cnm.deepdive.server.model.entity.Service;
import edu.cnm.deepdive.server.service.ServiceRepository;
import java.util.Set;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
@ExposesResourceFor(Service.class)
public class ServiceController {

  private final ServiceRepository repository;

  @Autowired
  public ServiceController(ServiceRepository repository) {
    this.repository = repository;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Service> post(@RequestBody Service service) {
    repository.save(service);
    return ResponseEntity.created(service.getHref()).body(service);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Service> get() {
    return repository.findAllByOrderName();
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Service get(@PathVariable UUID id) {
    return repository.findById(id).get();
  }

   @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Service> search(@RequestParam("q") String fragment) {
    if (fragment.length() < 3) {
      throw new SearchTermTooShortException();
    }
    return repository.getAllByNameContainsOrderByNameAsc(fragment);
  }


}
