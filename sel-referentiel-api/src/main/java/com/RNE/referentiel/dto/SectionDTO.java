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

    private String sectionCode;
    private String sectionTitleFr;
    private String sectionTiteAr;
    private Activation activation;
    private Set<StatusDTO> status;
    private List<ArticleDTO> articles;

    public static SectionDTO convertEntityToDto(Section section) {

        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setSectionCode(section.getSectionCode());
        sectionDTO.setSectionTitleFr(section.getSectionTitleFr());
        sectionDTO.setSectionTiteAr(section.getSectionTiteAr());
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
        section.setSectionCode(sectionDTO.getSectionCode());
        section.setSectionTitleFr(sectionDTO.getSectionTitleFr());
        section.setSectionTiteAr(sectionDTO.getSectionTiteAr());
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