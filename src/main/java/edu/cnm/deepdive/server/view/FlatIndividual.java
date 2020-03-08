package edu.cnm.deepdive.server.view;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.net.URI;
import java.util.UUID;
import org.springframework.lang.NonNull;

/** Interface for Jackson / Spring created **/
@JsonPropertyOrder({"id", "name"})
public interface FlatIndividual {

  @NonNull
  UUID getId();

  @NonNull
  String getName();

  URI getHref();

}
