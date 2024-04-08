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

import com.RNE.referentiel.dto.SectionDTO;
import com.RNE.referentiel.service.SectionServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/referentiel/sections")
@AllArgsConstructor
public class SectionController {

    private SectionServiceImpl sectionService;

    @PostMapping
    public ResponseEntity<SectionDTO> saveSection(@RequestBody SectionDTO sectionDTO) {
        SectionDTO savedSectionDTO = sectionService.saveSection(sectionDTO);
        return new ResponseEntity<SectionDTO>(savedSectionDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SectionDTO>> getAllSections() {
        List<SectionDTO> sectionDTOs = sectionService.getAllSections();
        return new ResponseEntity<List<SectionDTO>>(sectionDTOs, HttpStatus.OK);
    }

    // get section by code
    @GetMapping("/{codeSection}")
    public ResponseEntity<SectionDTO> getSectionByCode(@PathVariable String codeSection) {
        SectionDTO sectionDTO = sectionService.getSectionByCode(codeSection);
        return new ResponseEntity<SectionDTO>(sectionDTO, HttpStatus.OK);
    }

    // update section
    @PutMapping("/update/{codeSection}")
    public ResponseEntity<SectionDTO> updateSection(@PathVariable String codeSection, @RequestBody SectionDTO sectionDTO) {
        SectionDTO updatedSectionDTO = sectionService.updateSection(codeSection, sectionDTO);
        return new ResponseEntity<SectionDTO>(updatedSectionDTO, HttpStatus.OK);
    }

    // getActivate Section
    @GetMapping("/Activated")
    public ResponseEntity<List<SectionDTO>> getActivatedSections() {
        List<SectionDTO> sectionDTOs = sectionService.getActivatedSection();
        return new ResponseEntity<List<SectionDTO>>(sectionDTOs, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{codeSection}")
    public ResponseEntity<String> deleteSection(@PathVariable String codeSection) {
        sectionService.deleteSection(codeSection);
        return new ResponseEntity<String>("Section successfully deleted!", HttpStatus.OK);
    }

}