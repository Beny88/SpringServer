package com.tomson.model;

import javax.persistence.Entity;

@Entity
public class User {
	
	private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}


