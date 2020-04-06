package edu.cnm.deepdive.server.model.repository;

import edu.cnm.deepdive.server.model.entity.Agency;
import edu.cnm.deepdive.server.model.entity.Agency.AgencyType;
import edu.cnm.deepdive.server.model.entity.Service;
import edu.cnm.deepdive.server.model.entity.Service.ServiceType;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AgencyRepository extends JpaRepository<Agency, UUID> {

  String SERVICES_QUERY = "SELECT a\n"
      + "FROM Agency AS a\n"
      + "         JOIN a.services AS s\n"
      + "WHERE s.serviceType IN (?1)\n"
      + "GROUP BY a\n"
      + "HAVING COUNT(s) >= (SELECT COUNT(s2) FROM Service AS s2 WHERE s2.serviceType IN (?1))";

  String SERVICES_QUERY_SINGLE_SERVICE_TYPE = "SELECT a\n"
      + "FROM Agency AS a\n"
      + "         JOIN a.services AS s\n"
      + "WHERE s.serviceType = ?1\n"
      + "ORDER BY a.name";

  String SERVICES_QUERY_NAME_AND_SINGLE_SERVICE_TYPE = "SELECT a\n"
      + "FROM Agency AS a\n"
      + "         JOIN a.services AS s\n"
      + "WHERE s.serviceType = ?1\n"
      + "    AND a.name LIKE %?2%"
      + "ORDER BY a.name";

  /**
   * Iterations by id and agency type.
   * @return id
   */
  Iterable<Agency> findAllByIdContainsOrderById(UUID id);

  Iterable<Agency> findAllByNameContainsOrderByName(String fragment);

  @Query(SERVICES_QUERY_SINGLE_SERVICE_TYPE)
  Iterable<Agency> findAllByServiceTypeOrderByName(ServiceType type);

  @Query(SERVICES_QUERY_NAME_AND_SINGLE_SERVICE_TYPE)
  Iterable<Agency> findAllByNameContainsAndServiceTypeOrderByName(ServiceType type, String fragment);

  Iterable<Agency> findAllByAgencyTypeOrderByAgencyType(AgencyType agencyType);

  @Query(SERVICES_QUERY)
  Iterable<Agency> findIfSubsetOfServicesExists(List<ServiceType> serviceTypes);


  default Agency findOrFail(UUID id) {
    return findById(id).get();

  }

}
