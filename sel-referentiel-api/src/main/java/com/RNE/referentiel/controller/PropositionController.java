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

import com.RNE.referentiel.entities.Proposition;
import com.RNE.referentiel.serviceInterface.PropositionServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/referentiel/propositions")
public class PropositionController {
	
	private PropositionServiceImpl propositionService;
	
	 @PostMapping
	    public ResponseEntity<Proposition> createProposition(@RequestBody Proposition proposition) {
	        
		 Proposition savedProposition = propositionService.saveProposition(proposition);
	        return new ResponseEntity<>(savedProposition, HttpStatus.CREATED);
	    }
		@GetMapping
		public ResponseEntity<List<Proposition>> getAllProposition(){
			return new ResponseEntity<List<Proposition>>(propositionService.getAllProposition(),HttpStatus.OK);
		}
		
		@GetMapping("{codeProposition}")
		public ResponseEntity<Proposition> getCodePostalById(@PathVariable String codeProposition){
			return new ResponseEntity<Proposition>(propositionService.propositionById(codeProposition), HttpStatus.OK);
			
		}
		
		@PutMapping("update/{codeProposition}")
		public ResponseEntity<Proposition> updateProposition(@PathVariable String codeProposition,@RequestBody Proposition proposition){
			return new ResponseEntity<Proposition>(propositionService.updateProposition(codeProposition, proposition),HttpStatus.OK);
		}
		
		@DeleteMapping("delete/{codeProposition}")
		public ResponseEntity<String> deleteArticle(@PathVariable String codeProposition){
			propositionService.deleteProposition(codeProposition);
			return new  ResponseEntity<String>("Proposition successfully deleted!", HttpStatus.OK);
		}

}
