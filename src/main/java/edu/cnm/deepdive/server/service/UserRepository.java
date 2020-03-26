package edu.cnm.deepdive.server.service;


import edu.cnm.deepdive.server.model.entity.Agency;
import edu.cnm.deepdive.server.model.entity.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

  public interface UserRepository extends JpaRepository<User, UUID> {


    /** Iterations by id and name.**/
    Iterable<User> findAllById(UUID id);

    Iterable<User> findAllByName (String fragment);

    Iterable<User> findAllByAgency(Agency agency);

    default User findOrFail (UUID id){
      return findById(id).get();
    }

  }

