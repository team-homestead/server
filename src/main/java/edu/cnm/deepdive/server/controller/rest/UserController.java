package edu.cnm.deepdive.server.controller.rest;

import edu.cnm.deepdive.server.model.entity.User;
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

/** Establishing controller for User entity.  **/
@Component
@RestController
@RequestMapping("/users")
@ExposesResourceFor(User.class)
public class UserController {

  /** User Repository declared to allow controller/repository relationship.**/
  private final UserRepository userRepository;

  /**
   * Spring looks for the class that matches this Autowired property and injects it automatically
   * into the application context.  @Autowired must be set for Spring to recognize it.
   **/
  @Autowired
  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  /** Controller command allowing posting of User data to database.**/
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> post(@RequestBody User user) {
    userRepository.save(user);
    return ResponseEntity.created(user.getHref()).body(user);
  }
}

