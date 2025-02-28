package com.bridgelabz.kanak.cgaddressbookapp.service;

import com.bridgelabz.kanak.cgaddressbookapp.dto.AddressDto;
import com.bridgelabz.kanak.cgaddressbookapp.entity.AddressEntity;
import com.bridgelabz.kanak.cgaddressbookapp.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;
    public List<AddressEntity> getAllAddresses() {
        return addressRepo.findAll();
    }
    public AddressEntity getAddressById(Long id) {
        return addressRepo.findById(id).get();
    }
    public AddressEntity addAddress(AddressDto addressDto) {
        AddressEntity addressEntity = new AddressEntity(addressDto);
        return addressRepo.save(addressEntity);
    }
    public AddressEntity updateAddress( Long id,AddressDto addressDto) {
        AddressEntity addressEntity = addressRepo.findById(id).orElse(null);
        if(addressEntity!= null){
            addressEntity.setCity(addressDto.getCity());
            addressEntity.setCountry(addressDto.getCountry());
            addressEntity.setZipcode(addressDto.getZipcode());
            return addressRepo.save(addressEntity);
        }
        return null;

    }
    public void deleteAddressById(Long id) {
        addressRepo.deleteById(id);
    }

}
