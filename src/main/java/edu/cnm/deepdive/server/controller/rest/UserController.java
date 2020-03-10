package edu.cnm.deepdive.server.controller.rest;

import edu.cnm.deepdive.server.model.entity.Agency;
import edu.cnm.deepdive.server.model.entity.User;
import edu.cnm.deepdive.server.service.UserRepository;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/** Establishing controller for User entity.  **/
@Component
@RestController
@RequestMapping("/users")
@ExposesResourceFor(User.class)
public class UserController {


  /** User Repository declared to allow controller/repository relationship.**/
  private final UserRepository userRepository;


  /**This Autowired property is injected into the application context by Spring.**/
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


//  Controller command allowing get id from User data from the database.
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public User get(@PathVariable UUID id) {
    return userRepository.findOrFail(id);
  }



  /**  Controller command allowing get name from User data from the database.
  @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable String name) {
    return (User) userRepository.getAllByName(name);
  }
  **/


  /**  Controller command allowing update of User name in the database.
  @PutMapping(value = "/{name}",
      consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public User put(@PathVariable String name, @RequestBody User updated) {
    User user = get(name);
    user.setUser(updated.getId());
    return userRepository.save(user);
  }
  **/



  /**  Controller command allowing deletion of User from the database.
  @DeleteMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {
    userRepository.findById(id).ifPresent(userRepository::delete);
  }
  **/

}

