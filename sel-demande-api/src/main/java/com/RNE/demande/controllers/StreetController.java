package com.RNE.demande.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RNE.demande.DTO.StreetDTO;
import com.RNE.demande.serviceInterface.StreetService;


import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/demande/street")
@AllArgsConstructor
public class StreetController {
	
	private StreetService streetService;
	
	
	@GetMapping
	public ResponseEntity<List<StreetDTO>> getAllStreet(){
		List<StreetDTO> streetList = streetService.getAllStreets();
          return  new ResponseEntity<>(streetList, HttpStatus.OK);
	}
	
	

}
