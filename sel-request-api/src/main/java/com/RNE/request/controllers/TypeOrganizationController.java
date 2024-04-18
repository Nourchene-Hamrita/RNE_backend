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

import com.RNE.request.dto.TypeOrganizationDTO;
import com.RNE.request.services.TypeOrganizationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/request/type-organizations")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class TypeOrganizationController {

    private TypeOrganizationService typeOrganizationService;

    @PostMapping
    public ResponseEntity<TypeOrganizationDTO> createTypeOrganization(@RequestBody TypeOrganizationDTO typeOrganizationDTO) {
        TypeOrganizationDTO createdTypeOrganization = typeOrganizationService.saveType(typeOrganizationDTO);
        return new ResponseEntity<>(createdTypeOrganization, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TypeOrganizationDTO>> getAllTypeOrganizations() {
        List<TypeOrganizationDTO> typeOrganizations = typeOrganizationService.getAllTypes();
        return new ResponseEntity<>(typeOrganizations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeOrganizationDTO> getTypeOrganizationById(@PathVariable Long id) {
        TypeOrganizationDTO typeOrganization = typeOrganizationService.getTypeById(id);
        if (typeOrganization != null) {
            return new ResponseEntity<>(typeOrganization, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeOrganizationDTO> updateTypeOrganization(@PathVariable Long id, @RequestBody TypeOrganizationDTO typeOrganizationDTO) {
        TypeOrganizationDTO updatedTypeOrganization = typeOrganizationService.updateType(id, typeOrganizationDTO);
        if (updatedTypeOrganization != null) {
            return new ResponseEntity<>(updatedTypeOrganization, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeOrganization(@PathVariable Long id) {
        typeOrganizationService.deleteType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}