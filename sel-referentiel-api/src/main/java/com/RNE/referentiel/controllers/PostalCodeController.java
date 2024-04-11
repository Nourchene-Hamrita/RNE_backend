package com.RNE.referentiel.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RNE.referentiel.dto.PostalCodeDTO;
import com.RNE.referentiel.services.PostalCodeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/referentiel/postalCode")
@AllArgsConstructor
public class PostalCodeController {

	private PostalCodeService codePostalService;

	@PostMapping
	public ResponseEntity<PostalCodeDTO> saveCodePostal(@RequestBody PostalCodeDTO codePostalDTO) {
		return new ResponseEntity<PostalCodeDTO>(codePostalService.savePostalCode(codePostalDTO), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<PostalCodeDTO>> getAllCodesPostal() {
		return new ResponseEntity<List<PostalCodeDTO>>(codePostalService.getAllPostalCode(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PostalCodeDTO> getCodePostalById(@PathVariable Long id) {
		return new ResponseEntity<PostalCodeDTO>(codePostalService.getPostalCodeById(id), HttpStatus.OK);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<PostalCodeDTO> updateCodePostal(@PathVariable Long id,
			@RequestBody PostalCodeDTO codePostalDTO) {
		return new ResponseEntity<PostalCodeDTO>(codePostalService.updatePostalCode(id, codePostalDTO), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCodePostal(@PathVariable Long id) {
		codePostalService.deletePostalCode(id);
		return new ResponseEntity<String>("PostalCode successfully deleted!", HttpStatus.OK);
	}
}