package edu.cnm.deepdive.server.controller.rest;


import edu.cnm.deepdive.server.model.entity.Service.ServiceType;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-types")
public class ServiceTypeController {

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  Iterable<String> get() {
    return Arrays.stream(ServiceType.values())
        .map(ServiceType::toString)
        .sorted()
        .collect(Collectors.toList());
  }
}
