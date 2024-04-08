package com.RNE.referentiel.dto;

import java.util.List;

import com.RNE.referentiel.entities.Activation;
import com.RNE.referentiel.entities.Article;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDTO {

	
	  private String articleCode;
	   private String articleTitleFr;
	   private String articleTitleAr;
	   private Activation activation;
	   private List<ProposalDTO> proposals;
	   private SectionDTO section;
	   
	   
	   
		 public static ArticleDTO convertEntityToDto(Article article) {
			 
			 ArticleDTO articleDTO= new ArticleDTO();
			 articleDTO.setArticleCode(articleDTO.getArticleCode());
			 articleDTO.setArticleTitleAr(articleDTO.getArticleTitleAr());
			 articleDTO.setArticleTitleFr(articleDTO.getArticleTitleFr());
			 articleDTO.setActivation(articleDTO.getActivation());
			 articleDTO.setProposals(articleDTO.getProposals());
			 articleDTO.setSection(articleDTO.getSection());
			 return articleDTO;
		 }
	   
}
