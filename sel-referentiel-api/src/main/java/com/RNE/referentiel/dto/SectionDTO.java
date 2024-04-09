package com.RNE.referentiel.dto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.RNE.referentiel.dto.mappers.SectionMapper;
import com.RNE.referentiel.entities.Article;
import com.RNE.referentiel.entities.Section;
import com.RNE.referentiel.entities.Status;
import com.RNE.referentiel.enums.Activation;

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

	public static SectionDTO convertEntityToDto(Section section, SectionMapper sectionMapper) {
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
			sectionDTO
					.setStatus(statusEntities.stream().map(StatusDTO::convertEntityToDto).collect(Collectors.toSet()));
		}

		// Populate ArticleDTO objects
		List<Article> articleEntities = section.getArticles();
		if (articleEntities != null) {
			sectionDTO.setArticles(
					articleEntities.stream().map(ArticleDTO::convertEntityToDto).collect(Collectors.toList()));
		}

		return sectionDTO;
	}

	public static Section convertDtoToEntity(SectionDTO sectionDTO, SectionMapper sectionMapper) {
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
			section.setStatus(statusDTOs.stream().map(StatusDTO::convertDtoToEntity).collect(Collectors.toSet()));
		}

		// Populate Article objects
		List<ArticleDTO> articleDTOs = sectionDTO.getArticles();
		if (articleDTOs != null) {
			section.setArticles(articleDTOs.stream().map(ArticleDTO::convertDtoToEntity).collect(Collectors.toList()));
		}

		return section;
	}
}