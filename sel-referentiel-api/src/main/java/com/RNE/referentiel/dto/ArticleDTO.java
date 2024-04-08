package com.RNE.referentiel.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.RNE.referentiel.entities.Activation;
import com.RNE.referentiel.entities.Article;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties("section")
public class ArticleDTO {

    private String articleCode;
    private String articleTitleFr;
    private String articleTitleAr;
    private Activation activation;
    private List<ProposalDTO> proposal;
    private SectionDTO section;

    public static ArticleDTO convertEntityToDto(Article article) {

        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setArticleCode(article.getArticleCode());
        articleDTO.setArticleTitleFr(article.getArticleTitleFr());
        articleDTO.setArticleTitleAr(article.getArticleTitleAr());
        articleDTO.setActivation(article.getActivation());
        articleDTO.setProposal(
                article.getProposal().stream()
                        .map(ProposalDTO::convertEntityToDto)
                        .collect(Collectors.toList()));
        articleDTO.setSection(SectionDTO.convertEntityToDto(article.getSection()));

        return articleDTO;
    }
    public static Article convertDtoToEntity(ArticleDTO articleDTO) {

        Article article = new Article();
        article.setArticleCode(articleDTO.getArticleCode());
        article.setArticleTitleFr(articleDTO.getArticleTitleFr());
        article.setArticleTitleAr(articleDTO.getArticleTitleAr());
        article.setActivation(articleDTO.getActivation());
        article.setProposal(
                articleDTO.getProposal().stream()
                        .map(ProposalDTO::convertDtoToEntity)
                        .collect(Collectors.toList()));
        article.setSection(SectionDTO.convertDtoToEntity(articleDTO.getSection()));

        return article;
    }

}