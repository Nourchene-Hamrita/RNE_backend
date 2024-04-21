package com.RNE.referentiel.dto.mappers;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.RNE.referentiel.dto.VilleDTO;
import com.RNE.referentiel.entities.Ville;
import com.RNE.referentiel.entities.Gouvernerat;

@Component
public class VilleMapperImpl implements VilleMapper {

	private static final VilleMapper INSTANCE = Mappers.getMapper(VilleMapper.class);

	@Override
	public VilleDTO toDto(Ville ville) {
		if (ville == null) {
			return null;
		}

		VilleDTO villeDTO = new VilleDTO();
		villeDTO.setCode(ville.getCode());
		villeDTO.setNomFr(ville.getNomFr());
		villeDTO.setNomAr(ville.getNomAr());
		villeDTO.setActivation(ville.getActivation());

		// Populate delegationDTO object
		Gouvernerat gouvernerat = ville.getGouvernerat();
		if (gouvernerat != null) {
			villeDTO.setGouverneratCode(gouvernerat.getCode());
		}

		return villeDTO;
	}

	@Override
	public Ville toEntity(VilleDTO villeDTO) {
		if (villeDTO == null) {
			return null;
		}

		Ville ville = new Ville();
		ville.setCode(villeDTO.getCode());
		ville.setNomFr(villeDTO.getNomFr());
		ville.setNomAr(villeDTO.getNomAr());
		ville.setActivation(villeDTO.getActivation());

		// Populate Delegation object
		String gouverneratCode = villeDTO.getGouverneratCode();
		if (gouverneratCode != null) {
			Gouvernerat gouvernerat = new Gouvernerat();
			gouvernerat.setCode(gouverneratCode);
			ville.setGouvernerat(gouvernerat);;
		}

		return ville;
	}

	public static VilleMapper getInstance() {
		return INSTANCE;
	}
}