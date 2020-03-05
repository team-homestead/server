package edu.cnm.deepdive.server.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.net.URI;
import java.util.UUID;
import org.springframework.lang.NonNull;


@JsonPropertyOrder({"id"})
public interface FlatIndividual {

  @NonNull
  UUID getId();

  URI getHref();

}
