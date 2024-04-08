package com.RNE.referentiel.services.impl;

import java.util.List;

import com.RNE.referentiel.dto.ProposalDTO;

public interface ProposalService {

    public ProposalDTO saveProposal(ProposalDTO proposalDTO);

    public ProposalDTO getProposalByCode(String code);

    public List<ProposalDTO> getAllProposals();

    public ProposalDTO updateProposal(String code, ProposalDTO proposalDTO);

    public void deleteProposal(String code);

}