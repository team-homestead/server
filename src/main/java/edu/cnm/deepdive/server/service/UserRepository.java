package edu.cnm.deepdive.server.service;


import edu.cnm.deepdive.server.model.entity.User1;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


  public interface UserRepository extends JpaRepository<User1, UUID>

  {

    Iterable<User1> getAllByOrderByIdDesc ();

    Iterable<User1> getAllByNameContainsOrderByNameAsc (String fragment);
   // Iterable<User1> getAllByTextContainsOrderByTextAsc(String fragment);


    @Query(value = "SELECT * FROM sa.User",
        nativeQuery = true)
    default User1 findOrFail (UUID id){
      return findById(id).get();
    }
  }