package com.poc.addressservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.addressservice.model.Address;
import com.poc.addressservice.model.User;
import com.poc.addressservice.repository.AddressRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    Address address;

    @Override
    public Address getAddressForAUser(User user) {
        Optional<Address> addressOptional = addressRepository.findByUser(user);
        if (addressOptional.isPresent()) {
            return addressOptional.get();
        }
        log.info("Address null from repository. Returning Empty Address");
        return getEmptyAddress();
    }

    public Address getEmptyAddress() {
        User user = new User();
        user.setUserId(-1);
        user.setName("");
        address.setCity("");
        address.setUser(user);
        address.setState("");
        address.setStreetNameAndNumber("");
        return address;
    }

}