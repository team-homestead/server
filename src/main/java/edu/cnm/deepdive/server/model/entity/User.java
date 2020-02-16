package edu.cnm.deepdive.server.model.entity;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
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
          @Index(columnList = "contact_info"),
          @Index(columnList = "name"),
          @Index(columnList = "phone_number"),
          @Index(columnList = "email"),
      }
  )
  public class User {

    @NonNull
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "user_id", columnDefinition = "CHAR(16) FOR BIT DATA",
        nullable = false, updatable = false)

    private UUID id;


    @NonNull
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date created;


    @NonNull
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date updated;


    @NonNull
    @Column(length = 4096, nullable = false, unique = true)
    private String text;


    @NonNull
    public UUID getId() {
      return id;
    }

    @NonNull
    public Date getCreated() {
      return created;
    }

    @NonNull
    public Date getUpdated() {
      return updated;
    }

    @NonNull
    public String getText() {
      return text;
    }

    public void setCreated(@NonNull Date created) {
      this.created = created;
    }

    public void setUpdated(@NonNull Date updated) {
      this.updated = updated;
    }

    public void setText(@NonNull String text) {
      this.text = text;
    }
  }

