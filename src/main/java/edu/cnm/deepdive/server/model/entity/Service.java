package edu.cnm.deepdive.server.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
          @Index(columnList = "food"),
          @Index(columnList = "shelter"),
          @Index(columnList = "clothing"),
          @Index(columnList = "supplies"),
      }
  )

  public class Service {

    //  Entity Elements

    @NonNull
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "service_id", columnDefinition = "CHAR(16) FOR BIT DATA",
        nullable = false, updatable = false)
    private UUID id;



    @NonNull
    @Column(length = 1024, nullable = true)
    private String food;

    @NonNull
    @Column(length = 1024, nullable = true)
    private String shelter;

    @NonNull
    @Column(length = 1024, nullable = true)
    private String clothing;


    @NonNull
    @Column(length = 1024, nullable = true)
    private String supplies;


//  Foreign Keys

      @ManyToOne(fetch = FetchType.EAGER,
        cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "individual_id")
    private Service serviceA;

    @ManyToOne(fetch = FetchType.EAGER,
        cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "agency_id")
    private Service serviceB;



//  Getters and Setters


    @NonNull
    public UUID getId() {
      return id;
    }

    @NonNull
    public String getFood() {
      return food;
    }

    public void setFood(@NonNull String food) {
      this.food = food;
    }

    @NonNull
    public String getShelter() {
      return shelter;
    }

    public void setShelter(@NonNull String shelter) {
      this.shelter = shelter;
    }

    @NonNull
    public String getClothing() {
      return clothing;
    }

    public void setClothing(@NonNull String clothing) {
      this.clothing = clothing;
    }

    @NonNull
    public String getSupplies() {
      return supplies;
    }

    public void setSupplies(@NonNull String supplies) {
      this.supplies = supplies;
    }

    public Service getServiceA() {
      return serviceA;
    }

    public void setServiceA(Service serviceA) {
      this.serviceA = serviceA;
    }

    public Service getServiceB() {
      return serviceB;
    }

    public void setServiceB(Service serviceB) {
      this.serviceB = serviceB;
    }
  }





