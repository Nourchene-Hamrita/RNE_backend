package com.RNE.demande.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.RNE.demande.entities.Adress;
import com.RNE.demande.services.AdressService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/request/addresses")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class AdressController {

    private AdressService adressService;

    @PostMapping
    public ResponseEntity<Adress> saveAddress(@RequestBody Adress adress) {
        return new ResponseEntity<>(adressService.saveAdress(adress), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Adress>> getAllAdresses() {
        return new ResponseEntity<>(adressService.getAllAdresses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Adress> getAdressById(@PathVariable Long id) {
        return new ResponseEntity<>(adressService.getAdressById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Adress> updateAddress(@PathVariable Long id, @RequestBody Adress adress) {
        return new ResponseEntity<>(adressService.updateAdress(id, adress), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id) {
        adressService.deleteAdress(id);
        return new ResponseEntity<>("Adress deleted successfully", HttpStatus.OK);
    }
}