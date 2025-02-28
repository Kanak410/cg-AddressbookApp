package com.bridgelabz.kanak.cgaddressbookapp.entity;

import com.bridgelabz.kanak.cgaddressbookapp.dto.AddressDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String country;
    private Long zipcode;

   public AddressEntity(AddressDto addressDto){
        this.city = addressDto.getCity();
        this.country = addressDto.getCountry();
        this.zipcode = addressDto.getZipcode();

    }

}
