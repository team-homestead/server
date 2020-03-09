
package edu.cnm.deepdive.server.model.entity;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.cnm.deepdive.server.view.FlatAgency;
import java.net.URI;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(
    indexes = {
        @Index(columnList = "agency_id")
    }
)

public class Agency implements FlatAgency {

  private static EntityLinks entityLinks;

  //Entity Elements

  @NonNull
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "agency_id", columnDefinition = "CHAR(16) FOR BIT DATA",
      nullable = false, updatable = false)
  private UUID id;

  @Enumerated(EnumType.ORDINAL)
  @Column
  private AgencyType agencyType;

  //Foreign Keys

  @OneToOne(fetch = FetchType.EAGER,
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinColumn(name = "user_id")
  @JsonSerialize(contentAs = FlatAgency.class)
  private User user;

// Getters and Setters


  @NonNull
  public UUID getId() {
    return id;
  }

  public AgencyType getAgencyType() {
    return agencyType;
  }

  public User getUser() {
    return user;
  }

  public void setAgencyType(AgencyType agencyType) {
    this.agencyType = agencyType;
  }


  public enum AgencyType {
    GOVERNMENT, OTHER, PUBLIC, RELIGIOUS;

  }


  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {
    Agency.entityLinks = entityLinks;
  }


  @Override
  public URI getHref() {
    return entityLinks.linkForItemResource(Agency.class, id).toUri();
  }

  public static EntityLinks getEntityLinks() {
    return entityLinks;
  }


  @PostConstruct
  private void init() { entityLinks.toString(); }

}