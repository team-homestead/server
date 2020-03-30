package edu.cnm.deepdive.server.service;

import edu.cnm.deepdive.server.model.entity.Service;
import edu.cnm.deepdive.server.model.entity.Service.ServiceType;
import edu.cnm.deepdive.server.model.repository.ServiceRepository;
import java.util.LinkedList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("preload")
public class Preloader implements CommandLineRunner {

  private final ServiceRepository serviceRepository;

  public Preloader(ServiceRepository serviceRepository) {
    this.serviceRepository = serviceRepository;
  }


  @Override
  public void run(String... args) throws Exception {
    List<Service> services = new LinkedList<>();
    for (ServiceType serviceType : ServiceType.values()) {
      Service service = new Service();
      service.setServiceType(serviceType);
      services.add(service);
    }
    serviceRepository.saveAll(services);
  }
}
