package edu.cnm.deepdive.server.controller.rest;

import edu.cnm.deepdive.server.model.entity.Agency;
import edu.cnm.deepdive.server.service.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
