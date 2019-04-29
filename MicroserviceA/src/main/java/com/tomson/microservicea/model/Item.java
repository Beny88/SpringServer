package com.tomson.microservicea.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Where(clause = "deleted_on is null")
public class Item implements Typeable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String itemName;
    private String itemType;
    private Integer itemAmount;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="room_id")
    @JsonIgnore
    private Room room;

    @CreatedDate
    @Column(updatable = false)
    @JsonIgnore
    private ZonedDateTime createdOn;

    @LastModifiedDate
    @JsonIgnore
    private ZonedDateTime updatedOn;

    @JsonIgnore
    private ZonedDateTime deletedOn;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Integer getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(Integer itemAmount) {
        this.itemAmount = itemAmount;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    @JsonIgnore
    public String getType() {
        return itemType;
    }
}
