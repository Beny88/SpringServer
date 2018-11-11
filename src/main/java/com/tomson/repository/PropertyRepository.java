package com.tomson.repository;


import com.tomson.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    Property findFirstByHouseTypeAndId(String houseType, Long Id);
}