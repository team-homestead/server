package edu.cnm.deepdive.server.controller.rest;

import edu.cnm.deepdive.server.model.entity.Agency;
import edu.cnm.deepdive.server.model.entity.Service;
import edu.cnm.deepdive.server.model.repository.AgencyRepository;
import edu.cnm.deepdive.server.model.repository.ServiceRepository;
import java.util.LinkedList;
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

/**
 * Establishing controller for Agency entity.
 */
@Component
@RestController
@RequestMapping("/agencies")
@ExposesResourceFor(Agency.class)
public class AgencyController {

  /**
   * Agency repository declared to allow controller/repository relationship.
   */
  private final AgencyRepository agencyRepository;
  private final ServiceRepository serviceRepository;

  /**
   * Spring looks for the class that matches this Autowired property and injects it automatically
   * into the application context. @Autowired must be set for Spring to recognize it.
   * @param agencyRepository
   * @param serviceRepository
   */
  @Autowired
  public AgencyController(AgencyRepository agencyRepository,
      ServiceRepository serviceRepository) {
    this.agencyRepository = agencyRepository;
    this.serviceRepository = serviceRepository;
  }

  /**
   * Controller command allowing posting of Agency data to database.
   * @param agency
   * @return Agency
   */
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Agency> post(@RequestBody Agency agency) {
    List<Service> services = new LinkedList<>();
    for (Service service : agency.getServices()) {
      services.add(serviceRepository.getOne(service.getId()));
    }
    agency.getServices().clear();
    agency.getServices().addAll(services);
    agencyRepository.save(agency);
    return ResponseEntity.created(agency.getHref()).body(agency);
  }

  /**
   * Controller command allowing retrieval of Agency data from database using id.
   * @param id
   * @return single Agency
   */
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Agency get(@PathVariable UUID id) {
    return agencyRepository.findById(id).get();
  }

  /**
   * Controller command allowing mapping HHTP PUT requests in Agency using id.
   * @param id
   * @param updated
   * @return Agency with id

  @PutMapping(value = "/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Agency put(@PathVariable UUID id, @RequestBody Agency updated) {
    Agency agency = get(id);
    agency.setAgencyType(updated.getAgencyType());
    return agencyRepository.save(agency);
  } **/

  /**
   * Controller command to map HTTP DELETE requests using id.
   * @param id
   */
  @DeleteMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {
    agencyRepository.findById(id).ifPresent((agency) -> {
       agencyRepository.delete(agency);
    });
  }

  @GetMapping(value = "/by-services", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Agency> searchByService(@RequestBody List<Service> services) {
    return agencyRepository.findIfSubsetOfServicesExists(services);
  }


}