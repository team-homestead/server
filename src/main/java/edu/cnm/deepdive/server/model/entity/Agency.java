package edu.cnm.deepdive.server.model.entity;


import java.util.UUID;
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
import org.springframework.lang.NonNull;

@Entity
@Table(
    indexes = {
        @Index(columnList = "agency_id")
    }
)

public class Agency {

  //Entity Elements

  @NonNull
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "agency_id", columnDefinition = "CHAR(16) FOR BIT DATA",
      nullable = false, updatable = false)
  private UUID id;

  @Enumerated(EnumType.STRING)
  @Column
  private AgencyType agencyType;

  //Foreign Keys

  @OneToOne(fetch = FetchType.EAGER,
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
  @JoinColumn(name = "user_id")
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
    FOOD, SHELTER, CLOTHING, SUPPLIES;

  }
}
