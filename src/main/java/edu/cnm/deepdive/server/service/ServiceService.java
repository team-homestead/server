package edu.cnm.deepdive.server.service;

import edu.cnm.deepdive.server.model.entity.Agency;
import edu.cnm.deepdive.server.model.entity.Service;
import edu.cnm.deepdive.server.model.entity.Service.ServiceType;
import edu.cnm.deepdive.server.model.repository.AgencyRepository;
import edu.cnm.deepdive.server.model.repository.ServiceRepository;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceService {

  private final AgencyRepository agencyRepository;
  private final ServiceRepository serviceRepository;

  @Autowired
  public ServiceService(AgencyRepository agencyRepository, ServiceRepository serviceRepository) {
    this.agencyRepository = agencyRepository;
    this.serviceRepository = serviceRepository;
  }

  public Service create(Service service) {
    return serviceRepository.save(service);
  }


}
