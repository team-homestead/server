package edu.cnm.deepdive.server.view;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.UUID;
import org.springframework.lang.NonNull;

@JsonPropertyOrder({"id", "food", "shelter", "clothing", "supplies"})
public interface FlatService {

  @NonNull
  UUID getId();

  @NonNull
  String getFood();

  @NonNull
  String getShelter();

  @NonNull
  String getClothing();

  @NonNull
  String getSupplies();

}
