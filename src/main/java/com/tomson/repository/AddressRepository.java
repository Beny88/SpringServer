package com.tomson.repository;

import com.tomson.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository  extends JpaRepository<Address, Long> {
    Optional<Address> findOneByIdAndUserId(Long id, Long userId);
}
