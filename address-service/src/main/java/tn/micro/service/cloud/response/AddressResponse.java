package tn.micro.service.cloud.response;

import tn.micro.service.cloud.entity.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressResponse {

    private Long id;

    private String street;

    private String city;

    public AddressResponse(Address address) {
        this.id = address.getId();
        this.street = address.getStreet();
        this.city = address.getCity();
    }

    public static List<AddressResponse> toArrayList(List<Address> all) {
        List<AddressResponse> list = new ArrayList<>();
        for (Address address : all) {
            list.add(new AddressResponse(address));
        }
        return list;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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


}
