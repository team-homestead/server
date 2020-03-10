 package edu.cnm.deepdive.server.view;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.cnm.deepdive.server.model.entity.Agency;
import edu.cnm.deepdive.server.model.entity.User;
import java.net.URI;
import java.util.UUID;
import org.springframework.lang.NonNull;

/** Interface for Jackson / Spring created **/
@JsonPropertyOrder({"id", "name", "href"})
public interface FlatUser {

 /**
  *
  * @return
  */
 @NonNull
 UUID getId();

 /**
  *
  * @return
  */
 @NonNull
 String getName();

 /**
  *
  * @return
  */
 String getPhoneNumber();

 /**
  *
  * @return
  */
 String getEmail();

 /**
  *
  * @param email
  */
 void setEmail(String email);

 /**
  *
  * @return
  */
 Integer getFamilyUnitNumber();

 /**
  *
  * @return
  */
 @NonNull
 URI getHref();

}


