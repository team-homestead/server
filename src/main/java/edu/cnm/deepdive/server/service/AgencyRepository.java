package edu.cnm.deepdive.server.service;

import edu.cnm.deepdive.server.model.entity.Agency;
import edu.cnm.deepdive.server.model.entity.Agency.AgencyType;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyRepository extends JpaRepository<Agency, UUID> {

  /**
   * Iterations by id and agency type.
   * @return id
   */
  Iterable<Agency> getAllByOrderById();

  Iterable<Agency> getAllByIdContainsOrderById(UUID id);

  Iterable<Agency> getAllByAgencyTypeOrderByAgencyType(AgencyType agencyType);


  default Agency findOrFail(UUID id) {
    return findById(id).get();

  }

}
