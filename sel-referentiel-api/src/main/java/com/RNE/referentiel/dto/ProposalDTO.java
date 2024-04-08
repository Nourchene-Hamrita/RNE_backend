package com.RNE.referentiel.dto;

import com.RNE.referentiel.entities.Proposal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProposalDTO {

	private String code;
	private String textFr;
	private String textAr;
	private ArticleDTO article;

	public static ProposalDTO convertEntityToDto(Proposal proposal) {

		ProposalDTO proposalDTO = new ProposalDTO();
		proposalDTO.setCode(proposal.getCode());
		proposalDTO.setTextFr(proposal.getTextFr());
		proposalDTO.setTextAr(proposal.getTextAr());
		proposalDTO.setArticle(ArticleDTO.convertEntityToDto(proposal.getArticle()));

		return proposalDTO;
	}

	public static Proposal convertDtoToEntity(ProposalDTO proposalDTO) {

		Proposal proposal = new Proposal();
		proposal.setCode(proposalDTO.getCode());
		proposal.setTextFr(proposalDTO.getTextFr());
		proposal.setTextAr(proposalDTO.getTextAr());
		proposal.setArticle(ArticleDTO.convertDtoToEntity(proposalDTO.getArticle()));

		return proposal;
	}

}