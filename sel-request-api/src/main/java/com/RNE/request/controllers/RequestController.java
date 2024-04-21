package com.RNE.request.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RNE.request.dto.RequestDTO;
import com.RNE.request.services.RequestService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/request/requests")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class RequestController {

	private RequestService requestService;

	@PostMapping
	public ResponseEntity<RequestDTO> saveRequest(@RequestBody RequestDTO requestDTO) {
		return new ResponseEntity<RequestDTO>(requestService.saveRequest(requestDTO), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<RequestDTO>> getAllRequests() {
		return new ResponseEntity<List<RequestDTO>>(requestService.getAllRequests(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RequestDTO> getRequestById(@PathVariable Long id) {
		return new ResponseEntity<RequestDTO>(requestService.getRequestById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<RequestDTO> updateRequest(@PathVariable Long id, @RequestBody RequestDTO requestDTO) {
		return new ResponseEntity<RequestDTO>(requestService.updateRequest(id, requestDTO), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteRequest(@PathVariable Long id) {
		requestService.deleteRequest(id);
		return new ResponseEntity<String>("Request deleted successfully", HttpStatus.OK);
	}

}
