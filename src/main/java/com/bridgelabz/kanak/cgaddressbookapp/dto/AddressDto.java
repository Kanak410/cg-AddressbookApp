package com.bridgelabz.kanak.cgaddressbookapp.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data


@NoArgsConstructor
public class AddressDto {
     private String city;
     private String country;
     private Long zipcode;

     private Long id;
     public AddressDto(String city, String country, Long zipcode) {
          this.city = city;
          this.country = country;
          this.zipcode = zipcode;

     }




}
