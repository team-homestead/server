 package edu.cnm.deepdive.server.view;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.net.URI;
import java.util.UUID;
import org.springframework.lang.NonNull;

/** Interface for Jackson / Spring created **/
@JsonPropertyOrder({"id", "name", "href"})
 public interface FlatUser {

  @NonNull
  UUID getId();

  @NonNull
  String getName();

  URI getHref();

}


