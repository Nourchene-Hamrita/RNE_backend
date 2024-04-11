package com.RNE.referentiel.dto;

import com.RNE.referentiel.enums.Activation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {

	private String code;

	private String nameFr;

	private String nameAr;

	private Activation activation;

	private String delegationCode;

}