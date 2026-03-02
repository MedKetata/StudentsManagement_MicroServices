package tn.micro.service.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.micro.service.cloud.entity.Address;
import tn.micro.service.cloud.repository.AddressRepository;
import tn.micro.service.cloud.request.CreateAddressRequest;
import tn.micro.service.cloud.response.AddressResponse;

import java.util.List;


@Service
public class AddressService implements IAddressService {

    @Autowired
    AddressRepository addressRepository;


    @Override
    public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {
        Address address = new Address();
        address.setCity(createAddressRequest.getCity());
        address.setStreet(createAddressRequest.getStreet());
        addressRepository.save(address);
        return  new AddressResponse(address);
    }

    @Override
    public AddressResponse getById(long id) {
        return new AddressResponse(addressRepository.findById(id).get());
    }

    @Override
    public List<AddressResponse> getAllAddress() {
        return AddressResponse.toArrayList(addressRepository.findAll());
    }

    @Override
    public void deleteById(long id) {
        addressRepository.deleteById(id);
    }
    @Override
    public AddressResponse updateAddress(long id, Address addressRequest) {

        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + id));

        if (addressRequest.getStreet() != null) {
            address.setStreet(addressRequest.getStreet());
        }

        if (addressRequest.getCity() != null) {
            address.setCity(addressRequest.getCity());
        }

        address = addressRepository.save(address);

        return new AddressResponse(address);
    }
}
