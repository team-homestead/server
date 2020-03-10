package edu.cnm.deepdive.server.service;


import edu.cnm.deepdive.server.model.entity.Service;
import edu.cnm.deepdive.server.model.entity.Service.ServiceType;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, UUID> {


  /**
   * Iterations by id and service category.
   **/
  Iterable<Service> findAllById(UUID id);

  Iterable<Service> findAllByServiceType(ServiceType serviceType);


  default Service findOrFail(UUID id) {
    return findById(id).get();
  }

}
