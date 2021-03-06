package edu.cnm.deepdive.server.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.cnm.deepdive.server.view.FlatAgency;
import edu.cnm.deepdive.server.view.FlatUser;
import java.net.URI;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.stereotype.Component;

/**
 * Establishing entity model.
 **/
@Component
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(
    name = "user_profile",
    indexes = {
        @Index(columnList = "name"),
        @Index(columnList = "phoneNumber"),
        @Index(columnList = "email"),
    }
)

/** Class of User implementation of FlatUser for Json/Spring connectivity **/
public class User implements FlatUser {

  /**
   * Creation of interface (EntityLinks) pointing model to resources.
   **/
  private static EntityLinks entityLinks;

  /** Establishing entity fields. **/

  /**
   * User id is non-nullable, autogenerated, and non-updateable.
   **/
  @NonNull
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "user_id", columnDefinition = "CHAR(16) FOR BIT DATA",
      nullable = false, updatable = false)
  private UUID id;

  /**
   * User name is non-nullable, and updateable.  It is also indexable (see above).
   */
  @NonNull
  @Column(length = 1024, nullable = false, updatable = true)
  private String name;


  /**
   * User phone number is nullable, indexed (see above) and updateable.
   **/
  @Column(nullable = true, updatable = true)
  private String phoneNumber;


  /**
   * User email is nullable, updateable and indexed (see above).
   **/
  @Column(length = 1024, nullable = true, updatable = true)
  private String email;

  @Column(length = 50, nullable = false, updatable = false, unique = true)
  private String oauthKey;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "agency_id", nullable = true, updatable = true)
  @JsonSerialize(as = FlatAgency.class)
  private Agency agency;

  @Column(nullable = true, updatable = true)
  private Integer familyUnitNumber;


  /**
   * Spring looks for the class that matches this Autowired property and injects it automatically
   * into the application context.  @Autowired must be set for Spring to recognize it.
   **/
  @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    User.entityLinks = entityLinks;
  }

  /**
   * Entity Setters and Getters.  Updateable fields have setters.
   **/
  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  @Override
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getOauthKey() {
    return oauthKey;
  }

  public void setOauthKey(String oauthKey) {
    this.oauthKey = oauthKey;
  }

  public Agency getAgency() {
    return agency;
  }

  public void setAgency(Agency agency) {
    this.agency = agency;
  }

  @Override
  public Integer getFamilyUnitNumber() {
    return familyUnitNumber;
  }

  public void setFamilyUnitNumber(Integer familyUnitNumber) {
    this.familyUnitNumber = familyUnitNumber;
  }

  @Override
  public URI getHref() {
    return entityLinks.linkForItemResource(User.class, id).toUri();
  }

  /**
   * The PostConstruct annotation is used on a method that needs to be executed after dependency
   * injection is done to perform any initialization. This method MUST be invoked before the class
   * is put into service.
   **/
  @PostConstruct
  private void init() {
    entityLinks.toString();
  }

  public void setUser(UUID id) {

  }

  public void setDisplayName(String displayName) {
  }

}

