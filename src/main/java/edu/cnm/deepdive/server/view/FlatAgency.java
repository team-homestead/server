package edu.cnm.deepdive.server.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.cnm.deepdive.server.model.entity.Enum;
import java.net.URI;
import java.util.UUID;
import org.springframework.lang.NonNull;

@JsonPropertyOrder({"id", "food", "shelter", "clothing", "supplies"})
public interface FlatAgency {



  URI getHref();

}

