package com.RNE.referentiel.dto;

import com.RNE.referentiel.enums.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusDTO {
	private String code;

	private String title;

	private String description;

	private Category category;

}