package edu.cnm.deepdive.server.service;


    import edu.cnm.deepdive.server.model.entity.Individual;
    import java.util.UUID;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;


public interface IndividualRepository extends JpaRepository<Individual, UUID> {


  /** Iterations by id and fun. **/
  Iterable<Individual> getAllByIdOrderByIdDesc(UUID id);

  Iterable<Individual> getAllByFunContainsOrderByFun(Integer fragment);

  default Individual findOrFail(UUID id) {

    return findById(id).get();
  }
}
