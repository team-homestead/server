package edu.cnm.deepdive.server.service;

import edu.cnm.deepdive.server.model.entity.Agency;
import edu.cnm.deepdive.server.model.entity.Agency.AgencyType;
import edu.cnm.deepdive.server.model.entity.Service;
import edu.cnm.deepdive.server.model.entity.Service.ServiceType;
import edu.cnm.deepdive.server.model.repository.AgencyRepository;
import edu.cnm.deepdive.server.model.repository.ServiceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class AgencyService {

  private final AgencyRepository agencyRepository;
  private final ServiceRepository serviceRepository;

  @Autowired
  public AgencyService(AgencyRepository agencyRepository, ServiceRepository serviceRepository) {
    this.agencyRepository = agencyRepository;
    this.serviceRepository = serviceRepository;
  }

  public Agency create(Agency agency) {
    return agencyRepository.save(agency);
  }

  public Iterable<Agency> readWithServiceFilter(List<Service> services) {
    return agencyRepository.findIfSubsetOfServicesExists(services);
  }
}

