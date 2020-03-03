package edu.cnm.deepdive.server.controller.rest;

import edu.cnm.deepdive.server.model.entity.User1;
import edu.cnm.deepdive.server.service.UserRepository;
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
@ExposesResourceFor(User1.class)
public class UserController {

  private final UserRepository userRepository;


  @Autowired
  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User1> post(@RequestBody User1 user1) {
    userRepository.save(user1);
    return ResponseEntity.created(user1.getHref()).body(user1);

  }
/**
 * name, phone, email get.  attach an element later.  delete (+ put or patch as an update) phone or
 * email.
 */

}

