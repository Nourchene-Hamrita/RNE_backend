package com.RNE.demande.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.RNE.demande.enums.FormeJuridique;
import com.RNE.demande.enums.OrigineFondCommercial;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Societe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6047593005293832737L;
	/**
	* 
	*/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DénominationSocialeFr")
	private String DénominationSocialeFr;

	@Column(name = "DénominationSocialeAr")
	private String DénominationSocialeAr;

	@Column(name = "Email")
	private String Email;

	@Enumerated(EnumType.STRING)
	@Column(name = "FormeJuridique")
	private FormeJuridique formeJuridique;

	@Column(name = "N° de réservation")
	private String NumRéservation;

	@Column(name = "CNomCommercial")
	private Boolean CNomCommercial;

	@Column(name = "CEnseigne")
	private Boolean CEnseigne;

	@Column(name = "NbEmployés")
	private int NbEmployes;

	@Enumerated(EnumType.STRING)
	@Column(name = "OrigineFondCommercial")
	private OrigineFondCommercial origineFondCommercial;

	@OneToMany(mappedBy = "societe", cascade = CascadeType.ALL)
	private Set<Activite> activities;

	@OneToOne
	private Capital capital;

	@OneToMany(mappedBy = "societe", cascade = CascadeType.ALL)
	private Set<Demande> demandes;

	@OneToMany(mappedBy = "societe", cascade = CascadeType.ALL)
	private Set<Action> actions;

	@OneToMany(mappedBy = "societe", cascade = CascadeType.ALL)
	private List<MembreSpec> membreSpec;

	@OneToMany(mappedBy = "societe", cascade = CascadeType.ALL)
	private Set<Adresse> adresses;
}
