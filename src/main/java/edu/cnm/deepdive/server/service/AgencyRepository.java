package edu.cnm.deepdive.server.service;

import edu.cnm.deepdive.server.model.entity.Agency;
import edu.cnm.deepdive.server.model.entity.Agency.AgencyType;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyRepository extends JpaRepository<Agency, UUID> {

  Iterable<Agency> findAllById(UUID id);

  Iterable<Agency> findAllByAgencyType(AgencyType agencyType);


  default Agency findOrFail(UUID id) {
    return findById(id).get();

  }

}
