package com.RNE.referentiel.dto;

import java.util.List;

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
	
	private List<String> sectionCodes;

}