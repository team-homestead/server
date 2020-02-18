package edu.cnm.deepdive.server.model.entity;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import javax.naming.Name;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
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
          @Index(columnList = "name"),
          @Index(columnList = "phone_number"),
          @Index(columnList = "email"),
      }
  )

  public class User {

    // Entity Elements

    @NonNull
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "user_id", columnDefinition = "CHAR(16) FOR BIT DATA",
        nullable = false, updatable = false)
    private UUID id;


    @NonNull
    @Column(length = 1024, name = "name", nullable = false, updatable = true)
    private String name;


    @Column(name = "phone_number", nullable = true, updatable = true)
    private long phoneNumber;


    @Column(length = 1024, name = "email", nullable = true, updatable = true)
    private String email;




    //  Getters and Setters


    @NonNull
    public UUID getId() {
      return id;
    }

    @NonNull
    public String getName() {
      return name;
    }

    public long getPhoneNumber() {
      return phoneNumber;
    }

    public String getEmail() {
      return email;
    }

    public void setName(@NonNull String name) {
      this.name = name;
    }

    public void setPhoneNumber(long phoneNumber) {
      this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
      this.email = email;
    }
  }

