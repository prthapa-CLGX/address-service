package com.poc.addressservice.service;

import com.poc.addressservice.model.Address;
import com.poc.addressservice.model.User;

public interface AddressService {

    Address getAddressForAUser(User user);
}
