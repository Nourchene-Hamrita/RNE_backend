package com.RNE.referentiel.serviceInterface;

import java.util.List;

import com.RNE.referentiel.dto.ProposalDTO;

public interface ProposalService {

    public ProposalDTO saveProposal(ProposalDTO proposalDTO);

    public ProposalDTO getProposalByCode(String proposalCode);

    public List<ProposalDTO> getAllProposals();

    public ProposalDTO updateProposal(String proposalCode, ProposalDTO proposalDTO);

    public void deleteProposal(String proposalCode);

}