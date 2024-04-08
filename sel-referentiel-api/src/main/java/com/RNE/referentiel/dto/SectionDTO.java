package com.RNE.referentiel.dto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.RNE.referentiel.entities.Activation;
import com.RNE.referentiel.entities.Section;
import com.RNE.referentiel.entities.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SectionDTO {

    private String code;
    private String titleFr;
    private String titleAr;
    private Activation activation;
    private Set<StatusDTO> status;
    private List<ArticleDTO> articles;

    public static SectionDTO convertEntityToDto(Section section) {

        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setCode(section.getCode());
        sectionDTO.setTitleFr(section.getTitleFr());
        sectionDTO.setTitleAr(section.getTitleAr());
        sectionDTO.setActivation(section.getActivation());
        sectionDTO.setStatus(section.getStatus().stream()
                .map(StatusDTO::convertEntityToDto)
                .collect(Collectors.toSet()));
        sectionDTO.setArticles(section.getArticles().stream()
                .map(ArticleDTO::convertEntityToDto)
                .collect(Collectors.toList()));

        return sectionDTO;
    }

    public static Section convertDtoToEntity(SectionDTO sectionDTO) {

        Section section = new Section();
        section.setCode(sectionDTO.getCode());
        section.setTitleFr(sectionDTO.getTitleFr());
        section.setTitleAr(sectionDTO.getTitleAr());
        section.setActivation(sectionDTO.getActivation());
        section.setStatus(sectionDTO.getStatus().stream()
                .map(StatusDTO::convertDtoToEntity)
                .collect(Collectors.toSet()));
        section.setArticles(sectionDTO.getArticles().stream()
                .map(ArticleDTO::convertDtoToEntity)
                .collect(Collectors.toList()));

        return section;
    }
}