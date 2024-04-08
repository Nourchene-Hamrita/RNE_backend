package com.RNE.referentiel.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.dto.ProposalDTO;
import com.RNE.referentiel.entities.Proposal;

import com.RNE.referentiel.repositories.ProposalRepository;
import com.RNE.referentiel.services.ProposalService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProposalServiceImpl implements ProposalService {

    private ProposalRepository proposalRepository;

    // save proposal service
    @Override
    public ProposalDTO saveProposal(ProposalDTO proposalDTO) {

        Proposal proposal = convertDtoToEntity(proposalDTO);
        return convertEntityToDto(proposalRepository.save(proposal));
    }

    // get proposal by code service
    @Override
    public ProposalDTO getProposalByCode(String code) {
        Optional<Proposal> existProposal = proposalRepository.findById(code);
        return existProposal.map(this::convertEntityToDto).orElse(null);
    }

    // get all proposals services
    @Override
    public List<ProposalDTO> getAllProposals() {

        return proposalRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    // update proposal service
    @Override
    public ProposalDTO updateProposal(String code, ProposalDTO proposalDTO) {
        Proposal existProposal = proposalRepository.findById(code).orElse(null);
        if (existProposal == null) {
            return null;
        }

        existProposal.setTextFr(proposalDTO.getTextFr());
        existProposal.setTextAr(proposalDTO.getTextAr());

        return convertEntityToDto(proposalRepository.save(existProposal));
    }

    @Override
    public void deleteProposal(String proposalCode) {
        proposalRepository.deleteById(proposalCode);
    }

    public Proposal convertDtoToEntity(ProposalDTO proposalDTO) {

        Proposal proposal = new Proposal();
        proposal.setCode(proposalDTO.getCode());
        proposal.setTextFr(proposalDTO.getTextFr());
        proposal.setTextAr(proposalDTO.getTextAr());

        return proposal;
    }

    public ProposalDTO convertEntityToDto(Proposal proposal) {

        ProposalDTO proposalDTO = new ProposalDTO();
        proposalDTO.setCode(proposal.getCode());
        proposalDTO.setTextFr(proposal.getTextFr());
        proposalDTO.setTextAr(proposal.getTextAr());

        return proposalDTO;
    }

}