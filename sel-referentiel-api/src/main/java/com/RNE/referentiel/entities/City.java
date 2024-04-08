package com.RNE.referentiel.entities;

import java.io.Serializable;
import java.util.List;

import com.RNE.referentiel.enums.Activation;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class City implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3048454537732980212L;
	/**
	* 
	*/
	
	@Id
	private String code;
	private String nameFr;
	private String nameAr;
	@Enumerated(EnumType.STRING)
	private Activation activation;

	@ManyToOne
	private Delegation delegation;
	@OneToMany(mappedBy = "city", cascade = { CascadeType.ALL })
	@JsonManagedReference
	private List<PostalCode> postalCode;

}
