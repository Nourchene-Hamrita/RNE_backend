package com.RNE.demande.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.RNE.demande.dto.RequestDTO;
import com.RNE.demande.services.RequestService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/request")
@AllArgsConstructor
@CrossOrigin("*")
public class RequestController {

	
	private RequestService requestService;
	
	
	@PostMapping
	
	public ResponseEntity<RequestDTO> saveRequest(@RequestBody RequestDTO requestDTO){
	    RequestDTO savedRequestDTO = requestService.saveRequest(requestDTO);
	    return new ResponseEntity<>(savedRequestDTO, HttpStatus.CREATED);
	}
		
	
	
	 @GetMapping("/get")
	public ResponseEntity<List<RequestDTO>> getAllRequest(){
		 return new ResponseEntity<List<RequestDTO>>(requestService.getAllRequest(), HttpStatus.OK);
	 }
}
