package edu.cnm.deepdive.server.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.cnm.deepdive.server.model.entity.Agency;
import edu.cnm.deepdive.server.model.entity.Service;
import edu.cnm.deepdive.server.model.entity.Service.ServiceType;
import edu.cnm.deepdive.server.model.repository.AgencyRepository;
import edu.cnm.deepdive.server.model.repository.ServiceRepository;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
@Profile("preload")
public class Preloader implements CommandLineRunner {

  private final ServiceRepository serviceRepository;
  private final AgencyRepository agencyRepository;

  public Preloader(ServiceRepository serviceRepository,
      AgencyRepository agencyRepository) {
    this.serviceRepository = serviceRepository;
    this.agencyRepository = agencyRepository;
  }


  @Override
  public void run(String... args) throws Exception {
    List<Agency> agencies = new LinkedList<>();
    ClassPathResource resource = new ClassPathResource("preload/agency.json");
    try (InputStream input = resource.getInputStream()) {
      ObjectMapper mapper = new ObjectMapper();
      for (Agency agency : mapper.readValue(input, Agency[].class)){
        agencies.add(agency);
      }
      agencyRepository.saveAll(agencies);

    }
  }
}
