package edu.cnm.deepdive.server.controller.rest;


import edu.cnm.deepdive.server.model.entity.Service;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public class ServiceController {

  public interface ServiceRepository  UUID> {


    Iterable<Service> getAllByFoodOrderByFoodDesc(UUID id);

//  Iterable<Service> findAllByOrderId();



    Iterable<Service> findAllByFoodContainsOrderByFoodAsc (String fragment);



    default Service findOrFail (UUID id) {



      return findById(id).get();

    }



  }






}


