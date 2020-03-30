package edu.cnm.deepdive.server.service;

import edu.cnm.deepdive.server.model.entity.Agency;
import edu.cnm.deepdive.server.model.entity.Service;
import edu.cnm.deepdive.server.model.entity.Service.ServiceType;
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

  public Iterable<Service> readAll(boolean includeNull, boolean includeEmpty) {
    Iterable<Service> raw = includeEmpty
        ? serviceRepository.findAllByServiceType()
        : serviceRepository.findAllById();
    if (includeNull) {
      List<Service> services = new LinkedList<>();
      for (Service service : raw) {
        services.add(service);
      }
      return services;
    } else {
      return raw;
    }
  }

  public void delete(ServiceType serviceType) {
    serviceRepository.findAllByServiceType();
  }

}
