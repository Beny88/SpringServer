package com.tomson.repository;

import com.tomson.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    Optional<Property> findFirstByHouseTypeAndId(String houseType, Long Id);
}