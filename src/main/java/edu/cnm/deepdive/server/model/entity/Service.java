package edu.cnm.deepdive.server.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.cnm.deepdive.server.view.FlatService;
import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * Establishing entity model.
 **/
@Component
@Entity
@Table
public class Service implements FlatService {


  /**
   * Creation of interface (EntityLinks) pointing model to resources.
   **/

  private static EntityLinks entityLinks;

  /** Establishing entity fields. **/

  /**
   * Service id is non-nullable, autogenerated, and non-updateable.
   **/


  @NonNull
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "service_id", columnDefinition = "CHAR(16) FOR BIT DATA",
      nullable = false, updatable = false)
  private UUID id;

  //  @Enumerated(EnumType.ORDINAL)
 // @Column
 // private ServiceType serviceType;


  @ManyToOne(fetch = FetchType.EAGER,
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinColumn(name = "agency_id")
  @JsonSerialize(contentAs = FlatService.class)
  private Agency agency;


  public static EntityLinks getEntityLinks() {
    return entityLinks;
  }

  /**
   * Spring looks for the class that matches this Autowired property and injects it automatically
   * into the application context.  @Autowired must be set for Spring to recognize it.
   **/
  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    Service.entityLinks = entityLinks;
  }

  public Agency getAgency() {
    return agency;
  }

  public void setAgency(Agency agency) {
    this.agency = agency;
  }

  // public ServiceType getServiceType() {
    // return serviceType;
 //  }

//  public void setServiceType(ServiceType serviceType) {
////    this.serviceType = serviceType;
////  }

  /**
   * Entity Setters and Getters.  Updateable fields have setters.
   **/



  @Override
  public UUID getId() {
    return null;
  }

  @Override
  public String getName() {
    return null;
  }

  public void setId(@NonNull UUID id) {
    this.id = id;
  }


  @Override
  public URI getHref() {
    return entityLinks.linkForItemResource(Service.class, id).toUri();
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

  public enum ServiceType {
    FOOD,
    SHELTER,
    CLOTHING,
    SUPPLIES;
  }

}

