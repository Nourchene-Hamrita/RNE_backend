package com.RNE.referentiel.entities;

import java.io.Serializable;
import java.util.List;

import com.RNE.referentiel.enums.Activation;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cities")
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
	@Column(name = "code", nullable = false)
	private String code;

	@Column(name = "name_fr", nullable = false)
	private String nameFr;

	@Column(name = "name_ar", nullable = false)
	private String nameAr;

	@Enumerated(EnumType.STRING)
	@Column(name = "activation", nullable = false)
	private Activation activation;

	@ManyToOne
	private Delegation delegation;

	@OneToMany(mappedBy = "city", cascade = { CascadeType.ALL })
	@JsonManagedReference
	private List<PostalCode> postalCode;

}