package com.poc.addressservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.addressservice.model.Address;
import com.poc.addressservice.model.User;

@Repository
public interface AddressRepository extends JpaRepository<Address, User> {
    Optional<Address> findByUser(User user);
}
