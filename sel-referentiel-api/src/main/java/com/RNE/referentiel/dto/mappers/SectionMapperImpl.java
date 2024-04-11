package com.RNE.referentiel.dto.mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RNE.referentiel.dto.ArticleDTO;
import com.RNE.referentiel.dto.SectionDTO;
import com.RNE.referentiel.dto.StatusDTO;
import com.RNE.referentiel.entities.Article;
import com.RNE.referentiel.entities.Section;
import com.RNE.referentiel.entities.Status;

@Component
public class SectionMapperImpl implements SectionMapper {

    private static final SectionMapper INSTANCE = Mappers.getMapper(SectionMapper.class);
    @Autowired
    private StatusMapper statusMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public SectionDTO toDto(Section section) {
        if (section == null) {
            return null;
        }

        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setCode(section.getCode());
        sectionDTO.setTitleFr(section.getTitleFr());
        sectionDTO.setTitleAr(section.getTitleAr());
        sectionDTO.setActivation(section.getActivation());

        // Populate StatusDTO objects
        Set<Status> statusEntities = section.getStatus();
        if (statusEntities != null) {
            sectionDTO.setStatus(statusEntities.stream()
                .map(statusMapper::toDto)
                .collect(Collectors.toSet()));
        }

        // Populate ArticleDTO objects
        List<Article> articleEntities = section.getArticles();
        if (articleEntities != null) {
            sectionDTO.setArticles(articleEntities.stream()
                .map(articleMapper::toDto)
                .collect(Collectors.toList()));
        }

        return sectionDTO;
    }

    @Override
    public Section toEntity(SectionDTO sectionDTO) {
        if (sectionDTO == null) {
            return null;
        }

        Section section = new Section();
        section.setCode(sectionDTO.getCode());
        section.setTitleFr(sectionDTO.getTitleFr());
        section.setTitleAr(sectionDTO.getTitleAr());
        section.setActivation(sectionDTO.getActivation());

        // Populate Status objects
        Set<StatusDTO> statusDTOs = sectionDTO.getStatus();
        if (statusDTOs != null) {
            section.setStatus(statusDTOs.stream()
                .map(statusMapper::toEntity)
                .collect(Collectors.toSet()));
        }

        // Populate Article objects
        List<ArticleDTO> articleDTOs = sectionDTO.getArticles();
        if (articleDTOs != null) {
            section.setArticles(articleDTOs.stream()
                .map(articleMapper::toEntity)
                .collect(Collectors.toList()));
        }

        return section;
    }

    public static SectionMapper getInstance() {
        return INSTANCE;
    }
}