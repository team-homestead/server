package edu.cnm.deepdive.server.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.cnm.deepdive.server.model.entity.Agency.AgencyType;
import java.net.URI;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;


@Component
@Entity
@Table(
    indexes = {

        @Index(columnList = "food"),

        @Index(columnList = "shelter"),

        @Index(columnList = "clothing"),

        @Index(columnList = "supplies"),

    }
)

public class Service {


  private static EntityLinks entityLinks;

  //  Entity Elements


  @NonNull
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "service_id", columnDefinition = "CHAR(16) FOR BIT DATA",
      nullable = false, updatable = false)
  private UUID id;


  @Enumerated(EnumType.STRING)
  @Column
  private ServiceType serviceType;


  @NonNull
  @ManyToOne(fetch = FetchType.LAZY, mapp = "service",
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @OrderBy("text ASC")
  @JsonSerialize(contentAs = FlatService.class)
  private Set<Service> quotes = new LinkedHashSet<>();


  public enum ServiceType {
    FOOD, CLOTHING, SHELTER, SUPPLIES;



   @Override
    public URI getHref() {
      return entityLinks.linkForItemResource(Service.class, id).toUri();
    }

    public static EntityLinks getEntityLinks() {
      return entityLinks;
    }

    @PostConstruct
    private void init() {
      entityLinks.toString();
    }

    @Autowired
    private void setEntityLinks(EntityLinks entityLinks) {
      Service.entityLinks = entityLinks;
    }
  }
}

