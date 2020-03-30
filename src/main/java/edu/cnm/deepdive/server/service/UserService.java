package edu.cnm.deepdive.server.service;


import edu.cnm.deepdive.server.model.entity.User;
import edu.cnm.deepdive.server.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;


  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }


  public User getOrCreate(String oauthKey, String displayName) {
    return userRepository.findByOauthKey(oauthKey)
        .orElseGet(() -> {
          User user = new User();
          user.setOauthKey(oauthKey);
          user.setDisplayName(displayName);
          return userRepository.save(user);
        });
  }
}