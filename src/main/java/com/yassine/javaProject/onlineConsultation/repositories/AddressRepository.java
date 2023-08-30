package com.yassine.javaProject.onlineConsultation.repositories;

import com.yassine.javaProject.onlineConsultation.models.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
public interface AddressRepository extends CrudRepository<Address, Long> {
    List <Address> findAll();

}