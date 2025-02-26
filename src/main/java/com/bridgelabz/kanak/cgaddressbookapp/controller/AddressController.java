package com.bridgelabz.kanak.cgaddressbookapp.controller;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v")
public class AddressController {
    @GetMapping()
    public String getAddresses() {
        return "List of addresses";
    }
    @GetMapping("{id}")
    public String getAddress(@PathVariable Long id) {
        return "Address with id " + id;
    }
    @PostMapping("/add/{id}")
   public String addAddress(@PathVariable Long id) {
        return "Successfully added the address of id" + id;
    }
    @PutMapping("update/{id}")
    public String updateAddress(@PathVariable Long id) {
        return "Successfully updated the address of id" + id;
    }
    @DeleteMapping("/delete/{id}")
    public String deleteAddress(@PathVariable Long id) {
        return "Sucessfully deleted the address"+id;
    }



}
