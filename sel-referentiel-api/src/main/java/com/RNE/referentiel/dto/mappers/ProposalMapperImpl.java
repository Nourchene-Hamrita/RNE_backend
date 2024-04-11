package com.RNE.referentiel.dto.mappers;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.RNE.referentiel.dto.ProposalDTO;
import com.RNE.referentiel.entities.Article;
import com.RNE.referentiel.entities.Proposal;

@Component
public class ProposalMapperImpl implements ProposalMapper {

	private static final ProposalMapper INSTANCE = Mappers.getMapper(ProposalMapper.class);

	@Override
	public ProposalDTO toDto(Proposal proposal) {
		if (proposal == null) {
			return null;
		}

		ProposalDTO proposalDTO = new ProposalDTO();
		proposalDTO.setCode(proposal.getCode());
		proposalDTO.setTextFr(proposal.getTextFr());
		proposalDTO.setTextAr(proposal.getTextAr());
		proposalDTO.setActivation(proposal.getActivation());

		// Populate articleDTO object
		Article article = proposal.getArticle();
		if (article != null) {
			proposalDTO.setArticleCode(article.getCode());
		}

		return proposalDTO;
	}

	@Override
	public Proposal toEntity(ProposalDTO proposalDTO) {
		if (proposalDTO == null) {
			return null;
		}

		Proposal proposal = new Proposal();
		proposal.setCode(proposalDTO.getCode());
		proposal.setTextFr(proposalDTO.getTextFr());
		proposal.setTextAr(proposalDTO.getTextAr());
		proposal.setActivation(proposalDTO.getActivation());

		// Populate Article object
		String codeArticle = proposalDTO.getArticleCode();
		if (codeArticle != null) {
			Article article = new Article();
			article.setCode(codeArticle);
			proposal.setArticle(article);
		}

		return proposal;
	}

	public static ProposalMapper getInstance() {
		return INSTANCE;
	}
}