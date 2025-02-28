package com.bridgelabz.kanak.cgaddressbookapp.repository;

import com.bridgelabz.kanak.cgaddressbookapp.dto.AddressDto;
import com.bridgelabz.kanak.cgaddressbookapp.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepo extends JpaRepository<AddressEntity, Long> {

}
