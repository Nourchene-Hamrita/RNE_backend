package com.RNE.referentiel.dto.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RNE.referentiel.dto.ArticleDTO;
import com.RNE.referentiel.dto.ProposalDTO;
import com.RNE.referentiel.entities.Article;
import com.RNE.referentiel.entities.Proposal;
import com.RNE.referentiel.entities.Section;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class ArticleMapperImpl implements ArticleMapper {

	private static final ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);
	@Autowired
	private ProposalMapper proposalMapper;
	
	public ArticleMapperImpl(ProposalMapper proposalMapper) {
        this.proposalMapper = proposalMapper;
    }

	@Override
	public ArticleDTO toDto(Article article) {
		if (article == null) {
			return null;
		}

		ArticleDTO articleDTO = new ArticleDTO();
		articleDTO.setCode(article.getCode());
		articleDTO.setTitleFr(article.getTitleFr());
		articleDTO.setTitleAr(article.getTitleAr());
		articleDTO.setActivation(article.getActivation());

		// Populate SectionDTO object
		Section section = article.getSection();
		if (section != null) {
			articleDTO.setCodeSection(section.getCode());
		}

		// Populate ProposalDTO objects
		List<Proposal> proposals = article.getProposal();
		if (proposals != null) {
			articleDTO.setProposal(proposals.stream().map(proposalMapper::toDto).collect(Collectors.toList()));
		}

		return articleDTO;
	}

	@Override
	public Article toEntity(ArticleDTO articleDTO) {
		if (articleDTO == null) {
			return null;
		}

		Article article = new Article();
		article.setCode(articleDTO.getCode());
		article.setTitleFr(articleDTO.getTitleFr());
		article.setTitleAr(articleDTO.getTitleAr());
		article.setActivation(articleDTO.getActivation());

		// Populate Section object
		String codeSection = articleDTO.getCodeSection();
		if (codeSection != null) {
			Section section = new Section();
			section.setCode(codeSection);
			article.setSection(section);
		}

		// Populate Proposal objects
		List<ProposalDTO> proposalDTOs = articleDTO.getProposal();
		if (proposalDTOs != null) {
			article.setProposal(proposalDTOs.stream().map(proposalMapper::toEntity).collect(Collectors.toList()));

		}

		return article;
	}

	public static ArticleMapper getInstance() {
		return INSTANCE;
	}
}