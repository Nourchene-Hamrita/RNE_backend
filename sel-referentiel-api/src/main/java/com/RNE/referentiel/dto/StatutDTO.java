package com.RNE.referentiel.dto;

import com.RNE.referentiel.enums.Activation;
import com.RNE.referentiel.enums.Categorie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatutDTO {
	private String code;

	private String titre;

	private String description;

	private Categorie categorie;

	// private List<SectionDTO> sections;

	private Activation activation;

	private FormeJuridiqueDto formeJuridique;

}