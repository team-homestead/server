package edu.cnm.deepdive.server.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.cnm.deepdive.server.model.entity.Enum;
import edu.cnm.deepdive.server.model.entity.User;
import java.net.URI;
import java.util.UUID;
import org.springframework.lang.NonNull;

@JsonPropertyOrder({"id", "agency_type", "user"})
public interface FlatAgency {

@NonNull
UUID getId();

User getUser();

  URI getHref();

}

