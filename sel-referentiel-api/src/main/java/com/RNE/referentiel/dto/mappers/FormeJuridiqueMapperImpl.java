package com.RNE.referentiel.dto.mappers;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.RNE.referentiel.dto.FormeJuridiqueDto;
import com.RNE.referentiel.entities.FormeJuridique;

@Component
public class FormeJuridiqueMapperImpl implements FormeJuridiqueMapper {
 
	private static final FormeJuridiqueMapper INSTANCE = Mappers.getMapper(FormeJuridiqueMapper.class);

	@Override
	public FormeJuridiqueDto toDto(FormeJuridique formeJuridique) {
		// TODO Auto-generated method stub
		if(formeJuridique==null) {
			return null;
		}
		FormeJuridiqueDto formeJuridiquedto=new FormeJuridiqueDto();
		formeJuridiquedto.setId(formeJuridique.getId());
		formeJuridiquedto.setNom(formeJuridique.getNom());
		formeJuridiquedto.setActivation(formeJuridique.getActivation());
		
		return formeJuridiquedto;
		
	}

	@Override
	public FormeJuridique toEntity(FormeJuridiqueDto formeJuridiqueDto) {
		// TODO Auto-generated method stub
		if(formeJuridiqueDto==null) {
			return null;
		}
		FormeJuridique formeJuridique=new FormeJuridique();
		formeJuridique.setId(formeJuridiqueDto.getId());
		formeJuridique.setNom(formeJuridiqueDto.getNom());
		formeJuridique.setActivation(formeJuridiqueDto.getActivation());
		
		return formeJuridique;
		
	}
	
	
	public static FormeJuridiqueMapper getInstance() {
		return INSTANCE;
	}
}
