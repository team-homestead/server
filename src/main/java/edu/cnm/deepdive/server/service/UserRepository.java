package edu.cnm.deepdive.server.service;


import edu.cnm.deepdive.server.model.entity.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


  public interface UserRepository extends JpaRepository<User, UUID>

  {

    Iterable<User> getAllByOrderByCreatedDesc ();

    Iterable<User> getAllByTextContainsOrderByTextAsc (String fragment);


    @Query(value = "SELECT * FROM sa.User",
        nativeQuery = true)
    default
      User findOrFail (UUID id){
      return findById(id).get();
    }
  }