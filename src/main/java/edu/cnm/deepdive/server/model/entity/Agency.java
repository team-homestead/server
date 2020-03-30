
package edu.cnm.deepdive.server.model.entity;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.cnm.deepdive.server.view.FlatAgency;
import edu.cnm.deepdive.server.view.FlatService;
import edu.cnm.deepdive.server.view.FlatUser;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * Establishing entity model.
 * Class of Agency implementation of FlatAgency for Json/Spring connnectivity.
 **/
@SuppressWarnings("JpaDataSourceORMInspection")
@Component
@Entity
public class Agency implements FlatAgency {

  /**
   * Creation of interface (EntityLinks) pointing model to resources.
   */
  private static EntityLinks entityLinks;

  /**
   * Establishing entity fields.
   * Agency id is non-nullable, autogenerated and non-updatable.
   */
  @NonNull
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "agency_id", columnDefinition = "CHAR(16) FOR BIT DATA",
      nullable = false, updatable = false)
  private UUID id;

  /**
   * Establishing Agency type enum.
   */
  @Enumerated(EnumType.ORDINAL)
  private AgencyType agencyType;

  /**
   * Establishing one to many relationship between User and Agency.
   */
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "agency",
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @OrderBy("name ASC")
  @JsonSerialize(contentAs = FlatUser.class)
  private List<User> users = new LinkedList<>();

  /**
   * Establishing one to many relationship between Agency and Services.
   */
  @NonNull
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "agency",
      cascade = CascadeType.ALL)
  @JsonSerialize(contentAs = FlatService.class)
  private List<Service> services = new LinkedList<>();

  /**
   * Getters and Setters for entity fields.  All fields have getters and
   * updatable fields have setters.
   * @return agency id.
   */
  @NonNull
  public UUID getId() {
    return id;
  }

  @Override
  public AgencyType getAgencyType() {
    return agencyType;
  }

  public void setAgencyType(AgencyType agencyType) {
    this.agencyType = agencyType;
  }

  public List<User> getUsers() {
    return users;
  }

  /**
   * Getter that returns list of services.
   * @return list of services
   */
  @NonNull
  public List<Service> getServices() {
    return services;
  }

  public void  setServices(Service service) { this.services = services; }

  @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    Agency.entityLinks = entityLinks;
  }


  @Override
  public URI getHref() {
    return entityLinks.linkForItemResource(Agency.class, id).toUri();
  }

  /**
   * The PostConstruct annotation is used on a method that needs to be executed after dependency
   * injection is done to perform any initialization. This method MUST be invoked before the class
   * is put into service.
   */
  @PostConstruct
  private void init() {
    entityLinks.toString();
  }

  /**
   * Nested enum class for agency type.
   */
  public enum AgencyType {
    GOVERNMENT, OTHER, PUBLIC, RELIGIOUS;

  }
}