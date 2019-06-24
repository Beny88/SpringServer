package com.tomson.microservicea.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Where(clause = "deleted_on is null")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @CreatedDate
    @Column(updatable = false)
    @JsonIgnore
    private ZonedDateTime createdOn;

    @LastModifiedDate
    @JsonIgnore
    private ZonedDateTime updatedOn;

    @JsonIgnore
    private ZonedDateTime deletedOn;

    @OneToMany(mappedBy = "user")
    private List<Address> addressList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Address> getAddressList() {
        return addressList;
    }


    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}


