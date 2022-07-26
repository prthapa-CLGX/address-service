package com.poc.addressservice.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import com.poc.addressservice.model.Address;
import com.poc.addressservice.model.User;


@SpringBootTest
@RunWith(SpringRunner.class)
class AddressServiceImplTest {

    @Autowired
    AddressService addressService;

    @Test
    void shouldGetAddressForAUser() {
        User user = new User();
        user.setUserId(2);
        user.setName("John Barnett");
        Address address = addressService.getAddressForAUser(user);
        System.out.println();

        assertThat(address.getStreetNameAndNumber()).isEqualTo("16 Barnett st");
    }
}