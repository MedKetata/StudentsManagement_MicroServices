package tn.micro.service.cloud.response;

import java.util.ArrayList;
import java.util.List;

public class AddressResponse {

private Long id;
    private String street;

    private String city;



    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
