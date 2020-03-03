package edu.cnm.deepdive.server.controller.rest;

import edu.cnm.deepdive.server.model.entity.User;
import edu.cnm.deepdive.server.service.AgencyRepository;
import edu.cnm.deepdive.server.service.IndividualRepository;
import edu.cnm.deepdive.server.service.UserRepository;
import org.apache.tomcat.util.buf.UriUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@Component
@RestController
@RequestMapping("/users")
@ExposesResourceFor(User.class)
public class UserController {

  private final UserRepository userRepository;


  @Autowired
  public UserController(UserRepository userRepository, IndividualRepository individualRepository, AgencyRepository agencyRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> post(@RequestBody User user) {
    userRepository.save(user);
    return ResponseEntity.created(user.getHref()).body(user);
  }
/**
 * name, phone, email get.  attach an element later.  delete (+ put or patch as an update) phone or
 * email.
 */




}

