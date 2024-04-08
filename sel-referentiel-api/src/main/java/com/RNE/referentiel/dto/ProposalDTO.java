package com.RNE.referentiel.dto;

import com.RNE.referentiel.entities.Activation;
import com.RNE.referentiel.entities.Proposal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProposalDTO {
	
	private String proposalCode;
    private String texteFr;
    private String texteAr;
    private Activation activation;
    private ArticleDTO article;
    
    
    public static ProposalDTO convertEntityToDto(Proposal proposal) {
    	
    	ProposalDTO proposalDTO = new ProposalDTO();
    	
    	proposalDTO.setProposalCode(proposalDTO.getProposalCode());
    	proposalDTO.setTexteAr(proposalDTO.getTexteAr());
    	proposalDTO.setActivation(proposalDTO.getActivation());
    	proposalDTO.setArticle(proposalDTO.getArticle());
    	return proposalDTO;
    	
    }

}
