package com.RNE.referentiel.dto.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RNE.referentiel.dto.VilleDTO;
import com.RNE.referentiel.dto.CodePostalDTO;
import com.RNE.referentiel.entities.Ville;
import com.RNE.referentiel.entities.CodePostal;
import com.RNE.referentiel.repositories.VilleRepository;

@Component
public class CodePostalMapperImpl implements CodePostalMapper {

	@Autowired
	private VilleRepository villeRepository;

	@Override
	public CodePostalDTO toDto(CodePostal codePostal) {

		if (codePostal == null) {
			return null;
		}

		CodePostalDTO codePostalDTO = new CodePostalDTO();
		codePostalDTO.setId(codePostal.getId());
		codePostalDTO.setCodePostal(codePostal.getCodePostal());
        codePostalDTO.setActivation(codePostal.getActivation());
        // Set the codeVille from the Ville entity
        if (codePostal.getVille() != null) {
            codePostalDTO.setCodeVille(codePostal.getVille().getCode());
        }
		/*Ville ville = codePostal.getVille();
		if (ville != null) {
			codePostalDTO.setVille(new VilleDTO(ville.getCode(), ville.getNomFr(), ville.getNomAr(), ville.getActivation(),
					ville.getGouvernorat().getCode()));
		}*/

		return codePostalDTO;
	}

	@Override
	public CodePostal toEntity(CodePostalDTO codePostalDTO) {

		 if (codePostalDTO == null) {
	            return null;
	        }

	        CodePostal codePostal = new CodePostal();
	        codePostal.setId(codePostalDTO.getId());
	        codePostal.setCodePostal(codePostalDTO.getCodePostal());
	        codePostal.setActivation(codePostalDTO.getActivation());

	        // Retrieve Ville entity using codeVille and set it to codePostal
	        if (codePostalDTO.getCodeVille() != null) {
	            Ville ville = villeRepository.findById(codePostalDTO.getCodeVille()).orElse(null);
	            codePostal.setVille(ville);
	        }

	        return codePostal;
	    }

}