package com.bridgelabz.kanak.cgaddressbookapp.controller;

import com.bridgelabz.kanak.cgaddressbookapp.dto.AddressDto;
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
    public List<AddressDto> getAddresses() {
       return addressRepo.findAll();

   }
   @GetMapping("/{id}")
    public AddressDto getAddressById(@PathVariable Long id) {
       return addressRepo.findById(id).orElse(null);
   }
   @PostMapping("/add")
    public AddressDto addAddress(@RequestBody AddressDto addressDto) {
       return addressRepo.save(addressDto);
   }
   @PutMapping("/update/{id}")
    public AddressDto updateAddress(@PathVariable Long id, @RequestBody AddressDto addressDto) {
      AddressDto updatedAddress = addressRepo.findById(id).orElse(null);
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
