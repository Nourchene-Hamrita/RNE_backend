package com.RNE.referentiel.dto.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RNE.referentiel.dto.VilleDTO;
import com.RNE.referentiel.dto.GouverneratDTO;
import com.RNE.referentiel.entities.Ville;
import com.RNE.referentiel.entities.Gouvernerat;

@Component
public class GouverneratMapperImpl implements GouverneratMapper {

	private static final GouverneratMapper INSTANCE = Mappers.getMapper(GouverneratMapper.class);
	@Autowired
	private VilleMapper villeMapper;

	@Override
	public GouverneratDTO toDto(Gouvernerat gouvernerat) {
		if (gouvernerat == null) {
			return null;
		}

		GouverneratDTO gouverneratDTO = new GouverneratDTO();
		gouverneratDTO.setCode(gouvernerat.getCode());
		gouverneratDTO.setNomFr(gouvernerat.getNomFr());
		gouverneratDTO.setNomAr(gouvernerat.getNomAr());
		gouverneratDTO.setActivation(gouvernerat.getActivation());

		// Populate CityDTO objects
		List<Ville> villeEntities = gouvernerat.getVilles();
		if (villeEntities != null) {
			
			gouverneratDTO.setVilles(villeEntities.stream().map(villeMapper::toDto).collect(Collectors.toList()));
		}

		return gouverneratDTO;
	}

	@Override
	public Gouvernerat toEntity(GouverneratDTO gouverneratDTO) {
		if (gouverneratDTO == null) {
			return null;
		}

		Gouvernerat gouvernerat = new Gouvernerat();
		gouvernerat.setCode(gouverneratDTO.getCode());
		gouvernerat.setNomFr(gouverneratDTO.getNomFr());
		gouvernerat.setNomAr(gouverneratDTO.getNomAr());
		gouvernerat.setActivation(gouverneratDTO.getActivation());

		// Populate cities objects
		List<VilleDTO> villeDTOs = gouverneratDTO.getVilles();
		if (villeDTOs != null) {

			gouvernerat.setVilles(villeDTOs.stream().map(villeMapper::toEntity).collect(Collectors.toList()));
		}

		return gouvernerat;
	}

	public static GouverneratMapper getInstance() {
		return INSTANCE;
	}
}