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

import com.RNE.referentiel.entities.Proposal;
import com.RNE.referentiel.serviceInterface.ProposalService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/referentiel/propositions")
public class ProposalController {
	
	private ProposalService propositionService;
	
	 @PostMapping
	    public ResponseEntity<Proposal> createProposition(@RequestBody Proposal proposition) {
	        
		 Proposal savedProposition = propositionService.saveProposition(proposition);
	        return new ResponseEntity<>(savedProposition, HttpStatus.CREATED);
	    }
		@GetMapping
		public ResponseEntity<List<Proposal>> getAllProposition(){
			return new ResponseEntity<List<Proposal>>(propositionService.getAllProposition(),HttpStatus.OK);
		}
		
		@GetMapping("/{proposalCode}")
		public ResponseEntity<Proposal> getCodePostalById(@PathVariable String proposalCode){
			return new ResponseEntity<Proposal>(propositionService.propositionById(proposalCode), HttpStatus.OK);
			
		}
		
		@PutMapping("/update/{proposalCode}")
		public ResponseEntity<Proposal> updateProposition(@PathVariable String proposalCode,@RequestBody Proposal proposition){
			return new ResponseEntity<Proposal>(propositionService.updateProposition(proposalCode, proposition),HttpStatus.OK);
		}
		
		@DeleteMapping("/delete/{proposalCode}")
		public ResponseEntity<String> deleteArticle(@PathVariable String proposalCode){
			propositionService.deleteProposition(proposalCode);
			return new  ResponseEntity<String>("Proposal successfully deleted!", HttpStatus.OK);
		}

}
