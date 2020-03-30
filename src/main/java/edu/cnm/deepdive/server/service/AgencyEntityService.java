package edu.cnm.deepdive.server.service;

import edu.cnm.deepdive.server.model.entity.Agency;
import edu.cnm.deepdive.server.model.entity.Agency.AgencyType;
import edu.cnm.deepdive.server.model.entity.Service;
import edu.cnm.deepdive.server.model.entity.Service.ServiceType;
import edu.cnm.deepdive.server.model.repository.AgencyRepository;
import edu.cnm.deepdive.server.model.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AgencyEntityService {

  private final AgencyRepository agencyRepository;
  private final ServiceRepository serviceRepository;

  @Autowired
  public AgencyEntityService(AgencyRepository agencyRepository, ServiceRepository serviceRepository) {
    this.agencyRepository = agencyRepository;
    this.serviceRepository = serviceRepository;
  }

  public Agency create(Agency agency) {
    agency.setAgencyType(resolveAgencyType(agency.getAgencyType()));
    return agencyRepository.save(agency);
  }

  @SuppressWarnings("OptionalGetWithoutIsPresent")
  private AgencyType resolveAgencyType(AgencyType agencyType) {
    return agencyType;
  }
}

