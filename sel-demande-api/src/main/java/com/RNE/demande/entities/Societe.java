package com.RNE.demande.entities;
import java.io.Serializable;
import java.util.Set;

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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "company")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Societe implements Serializable  {

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
	@Column(name = "formeJuridique")
	private String formeJuridique;
	
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
	private String OrigineFondCommercial;
	
	
	@OneToMany(mappedBy = "societes", cascade = CascadeType.ALL)
	private Set<Activite> activities;
	
	@OneToOne
	private Capital capital;
	
	@OneToMany(mappedBy = "societes", cascade = CascadeType.ALL)
	private Set<Demande> demandes;
	
	@OneToMany(mappedBy = "societes", cascade = CascadeType.ALL)
	private Set<MembreSpec> membreSpecs;
	
	@OneToMany(mappedBy = "societes", cascade = CascadeType.ALL)
	private Set<Action> actions;
	
	
	@OneToMany(mappedBy = "societes", cascade = CascadeType.ALL)
	private Set<Adress> addresses;
}
