package com.RNE.referentiel.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.RNE.referentiel.dto.FormeJuridiqueDto;

public interface FormeJuridiqueService {
	
		  

		 FormeJuridiqueDto saveFormeJuridique(FormeJuridiqueDto formejuridiqueDto);

		 List<FormeJuridiqueDto> getAllFormeJuridique();


		 FormeJuridiqueDto updateFormeJuridique(Long id,FormeJuridiqueDto formeJuridiqueDto);

		Page<FormeJuridiqueDto> getFormeJuridiquePagination(int pageNumber, int pageSize);

	
}
