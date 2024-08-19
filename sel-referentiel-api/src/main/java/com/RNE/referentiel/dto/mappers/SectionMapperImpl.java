package com.RNE.referentiel.dto.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RNE.referentiel.dto.ArticleDTO;
import com.RNE.referentiel.dto.SectionDTO;

import com.RNE.referentiel.entities.Article;
import com.RNE.referentiel.entities.Section;
import com.RNE.referentiel.entities.Statut;

@Component
public class SectionMapperImpl implements SectionMapper {

	

	    @Autowired
	    private ArticleMapper articleMapper;

	    @Override
	    public SectionDTO toDto(Section section) {
	        if (section == null) {
	            return null;
	        }

	        SectionDTO sectionDTO = new SectionDTO();
	        sectionDTO.setCode(section.getCode());
	        sectionDTO.setTitreFr(section.getTitreFr());
	        sectionDTO.setTitreAr(section.getTitreAr());
	        sectionDTO.setActivation(section.getActivation());

	        if (section.getStatut() != null) {
	            sectionDTO.setCodeStatut(section.getStatut().getCode());
	        }

	        if (section.getArticles() != null) {
	            sectionDTO.setArticles(section.getArticles().stream().map(articleMapper::toDto).collect(Collectors.toList()));
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
	        section.setTitreFr(sectionDTO.getTitreFr());
	        section.setTitreAr(sectionDTO.getTitreAr());
	        section.setActivation(sectionDTO.getActivation());

	        if (sectionDTO.getCodeStatut() != null) {
	            Statut statut = new Statut();
	            statut.setCode(sectionDTO.getCodeStatut());
	            section.setStatut(statut); // Just set the code to avoid circular dependency
	        }

	        if (sectionDTO.getArticles() != null) {
	            section.setArticles(sectionDTO.getArticles().stream().map(articleMapper::toEntity).collect(Collectors.toList()));
	        }

	        return section;
	    }
	}

