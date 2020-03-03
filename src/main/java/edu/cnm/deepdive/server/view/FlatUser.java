 package edu.cnm.deepdive.server.view;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.net.URI;
import java.util.UUID;
import org.springframework.lang.NonNull;

@JsonPropertyOrder()
 public interface FlatUser {

  @NonNull
  UUID getId();

  @NonNull
  String getName();

  long getPhoneNumber();

  @NonNull
  public String getEmail();

  URI getHref();


}


