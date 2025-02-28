package com.bridgelabz.kanak.cgaddressbookapp.controller;

import com.bridgelabz.kanak.cgaddressbookapp.dto.AddressDto;
import com.bridgelabz.kanak.cgaddressbookapp.entity.AddressEntity;
import com.bridgelabz.kanak.cgaddressbookapp.repository.AddressRepo;
import com.bridgelabz.kanak.cgaddressbookapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v")
public class AddressController {
    @Autowired
    private AddressService addressService;
   @GetMapping()
    public List<AddressEntity> getAddresses() {
       return addressService.getAllAddresses();

   }
   @GetMapping("/{id}")
    public AddressEntity getAddressById(@PathVariable Long id) {
       return addressService.getAddressById(id);
   }
   @PostMapping("/add")
    public AddressEntity addAddress(@RequestBody AddressDto addressDto) {

       return addressService.addAddress(addressDto);
   }
   @PutMapping("/update/{id}")
    public AddressEntity updateAddress(@PathVariable Long id, @RequestBody AddressDto addressDto) {

          return addressService.updateAddress(id,addressDto);


   }
   @DeleteMapping("/delete/{id}")
    public void deleteAddress(@PathVariable Long id) {
       addressService.deleteAddressById(id);
   }





}
