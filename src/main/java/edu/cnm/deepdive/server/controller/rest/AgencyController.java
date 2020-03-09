package edu.cnm.deepdive.server.controller.rest;

import edu.cnm.deepdive.server.controller.exception.SearchTermTooShortException;
import edu.cnm.deepdive.server.model.entity.Agency;
import edu.cnm.deepdive.server.model.entity.Agency.AgencyType;
import edu.cnm.deepdive.server.service.AgencyRepository;
import java.util.Set;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/agencies")
@ExposesResourceFor(Agency.class)
public class AgencyController {

  private final AgencyRepository agencyRepository;

  @Autowired
  public AgencyController(AgencyRepository agencyRepository) {
    this.agencyRepository = agencyRepository;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Agency> post(@RequestBody Agency agency) {
    agencyRepository.save(agency);
    return ResponseEntity.created(agency.getHref()).body(agency);
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Agency get(@PathVariable UUID id) {
    return agencyRepository.findById(id).get();
  }

  @PutMapping(value = "/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Agency put(@PathVariable UUID id, @RequestBody Agency updated) {
    Agency agency = get(id);
    agency.setAgencyType(updated.getAgencyType());
    return agencyRepository.save(agency);
  }
}
