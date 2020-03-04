package edu.cnm.deepdive.server.service;

import edu.cnm.deepdive.server.model.entity.Agency;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyRepository extends JpaRepository<Agency, UUID> {

  Iterable<Agency> getAllByOrderByCreatedDesc();

  Iterable<Agency> getAllByOrderBy

}
