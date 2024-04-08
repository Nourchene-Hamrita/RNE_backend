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

public class ArticleDTO {

    private String code;
    private String titleFr;
    private String titleAr;
    private Activation activation;
    private List<ProposalDTO> proposal;
   

    public static ArticleDTO convertEntityToDto(Article article) {

        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setCode(article.getCode());
        articleDTO.setTitleFr(article.getTitleFr());
        articleDTO.setTitleAr(article.getTitleAr());
        articleDTO.setActivation(article.getActivation());
        articleDTO.setProposal(
                article.getProposal().stream()
                        .map(ProposalDTO::convertEntityToDto)
                        .collect(Collectors.toList()));
        

        return articleDTO;
    }
    public static Article convertDtoToEntity(ArticleDTO articleDTO) {

        Article article = new Article();
        article.setCode(articleDTO.getCode());
        article.setTitleFr(articleDTO.getTitleFr());
        article.setTitleAr(articleDTO.getTitleAr());
        article.setActivation(articleDTO.getActivation());
        article.setProposal(
                articleDTO.getProposal().stream()
                        .map(ProposalDTO::convertDtoToEntity)
                        .collect(Collectors.toList()));
       
        return article;
    }

}