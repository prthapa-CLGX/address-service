package com.poc.addressservice.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Component
public class Address {

    @EmbeddedId
    private User user;
    private String streetNameAndNumber;
    private String city;
    private String State;

}
