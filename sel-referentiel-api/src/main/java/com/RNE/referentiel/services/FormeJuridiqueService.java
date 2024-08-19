package com.RNE.referentiel.services;

import java.util.List;

import com.RNE.referentiel.dto.FormeJuridiqueDto;

public interface FormeJuridiqueService {
	
		  

		 FormeJuridiqueDto saveFormeJuridique(FormeJuridiqueDto formejuridiqueDto);

		 List<FormeJuridiqueDto> getAllFormeJuridique();


		 FormeJuridiqueDto updateFormeJuridique(Long id,FormeJuridiqueDto formeJuridiqueDto);

	
}
