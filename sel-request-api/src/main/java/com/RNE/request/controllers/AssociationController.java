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

import com.RNE.request.dto.AssociationDTO;
import com.RNE.request.services.AssociationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/request/associations")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class AssociationController {

    private AssociationService associationService;

    @PostMapping
    public ResponseEntity<AssociationDTO> createAssociation(@RequestBody AssociationDTO associationDTO) {
        AssociationDTO createdAssociation = associationService.saveAssociation(associationDTO);
        return new ResponseEntity<>(createdAssociation, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AssociationDTO>> getAllAssociations() {
        List<AssociationDTO> associations = associationService.getAllAssociations();
        return new ResponseEntity<>(associations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssociationDTO> getAssociationById(@PathVariable Long id) {
        AssociationDTO association = associationService.getAssociationById(id);
        if (association != null) {
            return new ResponseEntity<>(association, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<AssociationDTO> updateAssociation(@PathVariable Long id, @RequestBody AssociationDTO associationDTO) {
        AssociationDTO updatedAssociation = associationService.updateAssociation(id, associationDTO);
        if (updatedAssociation != null) {
            return new ResponseEntity<>(updatedAssociation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssociation(@PathVariable Long id) {
        associationService.deleteAssociation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}