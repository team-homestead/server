package edu.cnm.deepdive.server.service;

import edu.cnm.deepdive.server.model.entity.Service;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, UUID> {

  Iterable<Service> getAllByNameContainsOrderByNameAsc(String fragment);

  Iterable<Service> findAllByOrderName();
}
