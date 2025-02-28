package com.bridgelabz.kanak.cgaddressbookapp.controller;

import com.bridgelabz.kanak.cgaddressbookapp.dto.AddressDto;
import com.bridgelabz.kanak.cgaddressbookapp.entity.AddressEntity;
import com.bridgelabz.kanak.cgaddressbookapp.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v")
public class AddressController {
    @Autowired
    private AddressRepo addressRepo;
   @GetMapping()
    public List<AddressEntity> getAddresses() {
       return addressRepo.findAll();

   }
   @GetMapping("/{id}")
    public AddressEntity getAddressById(@PathVariable Long id) {
       return addressRepo.findById(id).get();
   }
   @PostMapping("/add")
    public AddressEntity addAddress(@RequestBody AddressDto addressDto) {
       AddressEntity addressEntity = new AddressEntity(addressDto);
       return addressRepo.save(addressEntity);
   }
   @PutMapping("/update/{id}")
    public AddressEntity updateAddress(@PathVariable Long id, @RequestBody AddressDto addressDto) {
      AddressEntity updatedAddress = addressRepo.findById(id).orElse(null);
      if(updatedAddress != null) {
          updatedAddress.setCity(addressDto.getCity());
          updatedAddress.setCountry(addressDto.getCountry());
          updatedAddress.setZipcode(addressDto.getZipcode());
          return addressRepo.save(updatedAddress);
      }
      return null;

   }
   @DeleteMapping("/delete/{id}")
    public void deleteAddress(@PathVariable Long id) {
       addressRepo.deleteById(id);
   }





}
