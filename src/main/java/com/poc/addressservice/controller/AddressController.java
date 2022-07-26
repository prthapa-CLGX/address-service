package com.poc.addressservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.addressservice.model.Address;
import com.poc.addressservice.model.User;
import com.poc.addressservice.service.AddressService;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/address")
    public Address getAddressOfAUser(@RequestBody User user) {
        return addressService.getAddressForAUser(user);
    }

}
