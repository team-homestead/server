package edu.cnm.deepdive.server.service;


import edu.cnm.deepdive.server.model.entity.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


  public interface UserRepository extends JpaRepository<User, UUID>

  {

    Iterable<User> getAllByIdOrderByIdDesc(UUID id);

    Iterable<User> getAllByNameContainsOrderByNameAsc (String fragment);

    default User findOrFail (UUID id){
      return findById(id).get();
    }

  }

