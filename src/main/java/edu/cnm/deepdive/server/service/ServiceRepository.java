package edu.cnm.deepdive.server.service;


import edu.cnm.deepdive.server.model.entity.Service;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, UUID> {


  /** Iterations by id and service category.**/
  Iterable<Service> getAllByIdOrderByIdDesc(UUID id);

  Iterable<Service> findAllByFoodContainsOrderByFoodAsc (String fragment);

  Iterable<Service> findAllByClothingContainsOrderByClothingAsc (String fragment);

  Iterable<Service> findAllByShelterContainsOrderByShelterAsc (String fragment);

  Iterable<Service> findAllBySuppliesContainsOrderBySuppliesAsc (String fragment);

  default Service findOrFail (UUID id) {
    return findById(id).get();
  }
}
