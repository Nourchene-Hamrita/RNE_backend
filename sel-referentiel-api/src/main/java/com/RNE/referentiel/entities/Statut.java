package com.RNE.referentiel.entities;

import java.io.Serializable;
import java.util.List;

import com.RNE.referentiel.enums.Activation;
import com.RNE.referentiel.enums.Categorie;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "statuts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Statut implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4206123940409600831L;

	/**
	 * 
	 */
	@Id
	@Column(name = "code", nullable = false)
	private String code;

	@Column(name = "titre", nullable = false)
	private String titre;

	@Column(name = "description", nullable = false)
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "categorie", nullable = false)
	private Categorie categorie;

	@OneToMany(mappedBy = "statut", cascade = CascadeType.ALL)
	private List<Section> sections;

	@ManyToOne
	private FormeJuridique formeJuridique;

	@Enumerated(EnumType.STRING)
	@Column(name = "activation")

	private Activation activation;

}