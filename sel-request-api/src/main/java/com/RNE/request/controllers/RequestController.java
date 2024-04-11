package com.RNE.request.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RNE.request.dto.RequestDTO;
import com.RNE.request.services.RequestService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/request")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
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
	 @DeleteMapping("delete/{id}")
	 public ResponseEntity<String> deleteRequest(@PathVariable Long id) {
			requestService.deleteRequest(id);
			return new ResponseEntity<String>("Request successfully deleted!", HttpStatus.OK);
		}
}
