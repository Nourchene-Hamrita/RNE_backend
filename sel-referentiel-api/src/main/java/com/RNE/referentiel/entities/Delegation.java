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
public class Delegation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6369053955665516865L;
	/**
	* 
	*/

	@Id
	private String code;
	private String nameFr;
	private String nameAr;
	@Enumerated(EnumType.STRING)
	private Activation activation;

	@OneToMany(mappedBy = "delegation", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<City> cities;

}
