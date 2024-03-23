package com.RNE.referentiel.controller;


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

import com.RNE.referentiel.entities.Section;

import com.RNE.referentiel.service.SectionServiceImpl;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/referentiel/sections")
@AllArgsConstructor
public class SectionController {
  
	
	private SectionServiceImpl sectionService;
	
	
	@PostMapping
	public ResponseEntity<Section>saveSection(@RequestBody Section section){
		return new ResponseEntity<Section>(sectionService.saveSection(section),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Section>>getAllSection(){
		return new ResponseEntity<List<Section>>(sectionService.getAllSections(),HttpStatus.OK);
	}
	//get section by code
	@GetMapping("/{codeGouv}")
	public ResponseEntity<Section> getSectionByCode(@PathVariable String codeSection){
		return new ResponseEntity<Section>(sectionService.getSectionByCode(codeSection),HttpStatus.OK);
	}
	//update section
	@PutMapping("/update/{codeSection}")
	public ResponseEntity<Section> updateSection(@PathVariable String codeSection,@RequestBody Section section){
		return new ResponseEntity<Section>(sectionService.updateSection(codeSection, section),HttpStatus.OK);
	}
	
	//getActivate Section
	@GetMapping("/Activated")
	public ResponseEntity<List<Section>> getActivatedSection(){
		return new ResponseEntity<List<Section>>(sectionService.getActivatedSection(),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{codeSection}")
	public ResponseEntity<String> deleteGouvernerat(@PathVariable String codeSection){
	  sectionService.deleteSection(codeSection);
	  return new  ResponseEntity<String>("Section successfully deleted!", HttpStatus.OK);
	}
	
}
