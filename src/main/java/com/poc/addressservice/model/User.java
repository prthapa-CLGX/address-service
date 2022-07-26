package com.poc.addressservice.model;


import java.io.Serializable;
import javax.persistence.Embeddable;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
@Embeddable
public class User implements Serializable {

    private int userId;
    private String name;
}
