package com.tomson.microservicea.repository;

import com.tomson.microservicea.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository <Room, Long>{
    Optional<Room> findOneByIdAndPropertyId(Long id, Long propertyId);
}
