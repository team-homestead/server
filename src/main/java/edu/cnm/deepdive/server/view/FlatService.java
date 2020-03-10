package edu.cnm.deepdive.server.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.cnm.deepdive.server.model.entity.Agency.AgencyType;
import edu.cnm.deepdive.server.model.entity.Service.ServiceType;
import java.net.URI;
import java.util.UUID;
import org.springframework.lang.NonNull;


/** Interface for Jackson / Spring created **/
@JsonPropertyOrder({"id", "notes", "href", "serviceType"})
public interface FlatService {

  @NonNull
  UUID getId();

  @NonNull
  String getNotes();

  @NonNull
  ServiceType getServiceType();

  @NonNull
  URI getHref();

}


