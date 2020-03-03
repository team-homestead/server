package edu.cnm.deepdive.server.model.entity;

import edu.cnm.deepdive.server.view.FlatUser;
import java.net.URI;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.hateoas.server.EntityLinks;



  @Entity
  @Table(
      indexes = {
          @Index(columnList = "name"),
          @Index(columnList = "phone_number"),
          @Index(columnList = "email"),
      }
  )

  public class User1 implements FlatUser {

    private static EntityLinks entityLinks;


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


    @Override
    public URI getHref() {
      return entityLinks.linkForItemResource(User1.class, id).toUri();
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
      User1.entityLinks = entityLinks;
    }

  }

