package tn.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tn.micro.service.cloud.request.CreateAddressRequest;
import tn.micro.service.cloud.response.AddressResponse;

import java.util.List;
@FeignClient(value ="address-service")

public interface AddressFeignClient {


    @PostMapping("/api/address/create")
    public AddressResponse createStudent(@RequestBody CreateAddressRequest createStudentRequest);

    @GetMapping("/api/address/getById/{id}")
    public AddressResponse getById(@PathVariable long id);

    @GetMapping("/api/address//getAllAddress")
    public List<AddressResponse> getAll();
}
