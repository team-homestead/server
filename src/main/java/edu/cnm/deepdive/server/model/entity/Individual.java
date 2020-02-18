package edu.cnm.deepdive.server.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

@Entity
@Table(
    indexes = {
        @Index(columnList = "individual_id")
         }
    )

public class Individual {

  //  Entity Elements
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


//  Foreign Keys

@OneToOne(fetch = FetchType.EAGER,
    cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
@JoinColumn(name = "user_id")
private User user;



  // Getters and Setters

  @NonNull
  public UUID getId() {
    return id;
  }

  public int getFun() {
    return fun;
  }

  public User getUser() {
    return user;
  }

  public void setFun(int fun) {
    this.fun = fun;
  }
}