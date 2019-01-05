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
public class Property implements Typeable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String houseType;

   // private String userId;
   // private Long idAddress;

    @CreatedDate
    @Column(updatable = false)
    @JsonIgnore
    private ZonedDateTime createdOn;

    @LastModifiedDate
    @JsonIgnore
    private ZonedDateTime updatedOn;

    @JsonIgnore
    private ZonedDateTime deletedOn;

    @OneToMany(mappedBy = "property")
    private List<Room> roomList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }
/*
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }
*/
    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    @Override
    public String getType() {
        return houseType;
    }
}
