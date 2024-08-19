package com.RNE.referentiel.dto.mappers;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RNE.referentiel.dto.FormeJuridiqueDto;

import com.RNE.referentiel.dto.StatutDTO;
import com.RNE.referentiel.entities.FormeJuridique;

import com.RNE.referentiel.entities.Statut;

@Component
public class StatutMapperImpl implements StatutMapper {

	private static final StatutMapper INSTANCE = Mappers.getMapper(StatutMapper.class);

	@Autowired
	private FormeJuridiqueMapper formeJuridiqueMapper;

	@Override
	public StatutDTO toDto(Statut statut) {
		if (statut == null) {
			return null;
		}

		StatutDTO statutDTO = new StatutDTO();
		statutDTO.setCode(statut.getCode());
		statutDTO.setTitre(statut.getTitre());
		statutDTO.setDescription(statut.getDescription());
		statutDTO.setCategorie(statut.getCategorie());
		statutDTO.setActivation(statut.getActivation());

		/*
		 * if (statut.getSections() != null) {
		 * statutDTO.setSections(statut.getSections().stream().map(section -> {
		 * SectionDTO sectionDTO = new SectionDTO();
		 * sectionDTO.setCode(section.getCode());
		 * sectionDTO.setTitreFr(section.getTitreFr());
		 * sectionDTO.setTitreAr(section.getTitreAr()); return sectionDTO;
		 * }).collect(Collectors.toList())); }
		 */
		FormeJuridique formeJuridique = statut.getFormeJuridique();
		if (formeJuridique != null) {
			FormeJuridiqueDto formeJuridiqueDto = formeJuridiqueMapper.toDto(formeJuridique);
			statutDTO.setFormeJuridique(formeJuridiqueDto);
		}

		return statutDTO;
	}

	@Override
	public Statut toEntity(StatutDTO statutDTO) {
		if (statutDTO == null) {
			return null;
		}

		Statut statut = new Statut();
		statut.setCode(statutDTO.getCode());
		statut.setTitre(statutDTO.getTitre());
		statut.setDescription(statutDTO.getDescription());
		statut.setCategorie(statutDTO.getCategorie());

		/*
		 * if (statutDTO.getSections() != null) {
		 * statut.setSections(statutDTO.getSections().stream().map(sectionDTO -> {
		 * Section section = new Section(); section.setCode(sectionDTO.getCode());
		 * section.setTitreFr(sectionDTO.getTitreFr());
		 * section.setTitreAr(sectionDTO.getTitreAr()); return section;
		 * }).collect(Collectors.toList())); }
		 */
		FormeJuridiqueDto formeJuridiquedto = statutDTO.getFormeJuridique();
		if (formeJuridiquedto != null) {
			FormeJuridique formeJuridique = formeJuridiqueMapper.toEntity(formeJuridiquedto);
			statut.setFormeJuridique(formeJuridique);
		}

		return statut;
	}

	public static StatutMapper getInstance() {
		return INSTANCE;
	}
}
