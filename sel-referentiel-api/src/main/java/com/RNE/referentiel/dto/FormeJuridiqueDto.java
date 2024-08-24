package com.RNE.referentiel.dto;

import java.util.List;

import com.RNE.referentiel.enums.Activation;
import com.RNE.referentiel.enums.Categorie;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormeJuridiqueDto {
    
	private Long id;
	private String nom;
    private Activation activation;
	//private List<StatutDTO>status;
    private Categorie categorie;
}
