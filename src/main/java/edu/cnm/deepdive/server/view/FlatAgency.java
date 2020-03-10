package edu.cnm.deepdive.server.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.cnm.deepdive.server.model.entity.Agency.AgencyType;
import edu.cnm.deepdive.server.model.entity.Service.ServiceType;
import java.net.URI;
import java.util.UUID;
import org.springframework.lang.NonNull;

@JsonPropertyOrder({"id", "agency_type", "href"})
public interface FlatAgency {

  @NonNull
  UUID getId();

  @NonNull
  AgencyType getAgencyType();


  @NonNull
  URI getHref();

}

