package tn.micro.service.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.micro.service.cloud.entity.Address;
import tn.micro.service.cloud.request.CreateAddressRequest;
import tn.micro.service.cloud.response.AddressResponse;
import tn.micro.service.cloud.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/create")
    public AddressResponse createStudent(@RequestBody CreateAddressRequest createStudentRequest) {
        return addressService.createAddress(createStudentRequest);
    }

    @GetMapping("/getById/{id}")
    public AddressResponse getById(@PathVariable long id) {
        return addressService.getById(id);
    }

    @GetMapping("/getAllAddress")
    public List<AddressResponse> getAll() {
        return addressService.getAllAddress();
    }

    @DeleteMapping ("/{id}")
    public void deleteById(@PathVariable long id) {
         addressService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public AddressResponse updateAddress(
            @PathVariable long id,
            @RequestBody Address addressRequest) {

        return addressService.updateAddress(id, addressRequest);
    }
}
