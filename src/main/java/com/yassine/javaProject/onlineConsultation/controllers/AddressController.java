package com.yassine.javaProject.onlineConsultation.controllers;

import com.yassine.javaProject.onlineConsultation.models.Address;
import com.yassine.javaProject.onlineConsultation.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AddressService addressService;

    // Create One Address
    @PostMapping(value = "/addresses")
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        Address addressCreated = addressService.createAddress(address);
        return new ResponseEntity<>(addressCreated, HttpStatus.CREATED);
    }

    // Get All Addresses
    @GetMapping("/addresses")
    public ResponseEntity<List<Address>> getAllAddresss() {
        List<Address> allAddresses = addressService.allAddresses();
        return new ResponseEntity<>(allAddresses, HttpStatus.OK);
    }

    // Find One Address
    @GetMapping("/addresses/{id}")
    public ResponseEntity<Address> getOneAddress(@PathVariable Long id) {
        Address oneAddress = addressService.findAddress(id);
        return new ResponseEntity<>(oneAddress, HttpStatus.OK);
    }

    // Update One Address
    @PutMapping("/addresses/{id}")
    public ResponseEntity<Address> updateOneAddress(@PathVariable Long id, @RequestBody Address address) {
        Address existingAddress = addressService.findAddress(id);
        if (existingAddress != null) {
            existingAddress.setCity(address.getCity());
            existingAddress.setState(address.getState());
            existingAddress.setStreet(address.getStreet());

            Address updatedAddress = addressService.updateAddress(address);
            return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a consultation by ID
    @DeleteMapping("/addresses/{id}")
    public ResponseEntity<Address> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
