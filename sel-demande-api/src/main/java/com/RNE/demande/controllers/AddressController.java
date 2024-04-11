package com.RNE.demande.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RNE.demande.dto.AddressDTO;
import com.RNE.demande.services.AddressService;


import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/request/address")
@AllArgsConstructor
public class AddressController {

	private AddressService addressService;
	
	@PostMapping("/address")
	
	public ResponseEntity<AddressDTO> saveAddress(@RequestBody AddressDTO addressDTO){
	    AddressDTO savedAddressDTO = addressService.saveAddress(addressDTO);
	    return new ResponseEntity<>(savedAddressDTO, HttpStatus.CREATED);
	}
	
	 @GetMapping
	public ResponseEntity<List<AddressDTO>> getAllAddress(){
		 return new ResponseEntity<List<AddressDTO>>(addressService.getAllAddress(), HttpStatus.OK);
	 }
	
	
}
