package edu.cnm.deepdive.server.model.repository;


import edu.cnm.deepdive.server.model.entity.Agency;
import edu.cnm.deepdive.server.model.entity.Service;
import edu.cnm.deepdive.server.model.entity.Service.ServiceType;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, UUID> {


  /**
   * Iterations by id and service category.
   **/
  Iterable<Service> findAllByServiceType(ServiceType type);


  default Service findOrFail(UUID id) {
    return findById(id).get();
  }

}
