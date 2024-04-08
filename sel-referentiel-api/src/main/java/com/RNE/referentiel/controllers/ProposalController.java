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

import com.RNE.referentiel.dto.ProposalDTO;
import com.RNE.referentiel.services.ProposalService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/referentiel/proposals")
public class ProposalController {

    private ProposalService proposalService;

    @PostMapping
    public ResponseEntity<ProposalDTO> createProposal(@RequestBody ProposalDTO proposalDTO) {

        ProposalDTO savedProposalDTO = proposalService.saveProposal(proposalDTO);
        return new ResponseEntity<>(savedProposalDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProposalDTO>> getAllProposals() {
        return new ResponseEntity<List<ProposalDTO>>(proposalService.getAllProposals(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<ProposalDTO> getProposalByCode(@PathVariable String code) {
        return new ResponseEntity<ProposalDTO>(proposalService.getProposalByCode(code), HttpStatus.OK);

    }

    @PutMapping("/update/{code}")
    public ResponseEntity<ProposalDTO> updateProposal(@PathVariable String code,
            @RequestBody ProposalDTO proposalDTO) {
        return new ResponseEntity<ProposalDTO>(proposalService.updateProposal(code, proposalDTO),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<String> deleteProposal(@PathVariable String code) {
        proposalService.deleteProposal(code);
        return new ResponseEntity<String>("Proposal successfully deleted!", HttpStatus.OK);
    }

}