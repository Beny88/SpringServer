package com.tomson.repository;

import com.tomson.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository  extends JpaRepository<Address, Long> {
    Address findOneByIdAndUserId(Long id, Long userId);
}
