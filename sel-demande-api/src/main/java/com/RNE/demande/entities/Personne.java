package com.RNE.demande.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.RNE.demande.enums.Genre;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personne implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6047593005293832737L;
	/**
	* 
	*/
	@Id
	@Column(name = "ID_Carte")
	private Long IDCarte;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_Delivrence")
	private Date date_Delivrance;

	@Column(name = "type_ID_Carte")
	private String type_ID_Carte;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_Naiss")
	private Date date_Naiss;

	@Column(name = "lieu_Naiss")
	private String lieu_Naiss;

	@Column(name = "nom_Prenom")
	private String nom_prenom;

	@Column(name = "nationalite")
	private String nationalite;

	@Enumerated(EnumType.STRING)
	@Column(name = "genre")
	private Genre genre;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Action> actions;

	@ManyToMany(mappedBy = "personnes")

	private List<MembreSpec> membreSec;

	@OneToOne
	private Adresse adresse;

}
