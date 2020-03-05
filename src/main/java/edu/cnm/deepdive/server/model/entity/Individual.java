package edu.cnm.deepdive.server.model.entity;

import edu.cnm.deepdive.server.view.FlatIndividual;
import java.net.URI;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
        @Index(columnList = "individual_id")
         }
    )

public class Individual implements FlatIndividual {
  
  private static EntityLinks entityLinks;


  @NonNull
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "individual_id", columnDefinition = "CHAR(16) FOR BIT DATA",
      nullable = false, updatable = false)
  private UUID id;


  @NonNull
  @Column(name = "family_unit_number", nullable = false)
  private int fun;


  @OneToOne(fetch = FetchType.EAGER,
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinColumn(name = "user_id")
  private User user;



  // Getters and Setters
  @NonNull
  public UUID getId() {
    return id;
  }

  public void setId(@NonNull UUID id) {
    this.id = id;
  }

  public User getUser() {

    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }




  @Override
  public URI getHref() {
    return entityLinks.linkForItemResource(Individual.class, id).toUri();
  }

  public static EntityLinks getEntityLinks() {
    return entityLinks;
  }

  @PostConstruct
  private void init() {
    entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) { Individual.entityLinks = entityLinks;
  }

}
