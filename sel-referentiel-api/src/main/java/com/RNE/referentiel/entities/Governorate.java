package com.RNE.referentiel.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Governorate implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	@Id
	private String govCode;
	private String govNameFr;
	private String govNamevAr;
	@Enumerated(EnumType.STRING)
	private Activation activation;

	@OneToMany(mappedBy = "governorate", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<City> cities;

}
