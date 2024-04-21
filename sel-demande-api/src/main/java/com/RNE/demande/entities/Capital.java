package com.RNE.demande.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "capitals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Capital implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1044033486519914823L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "nb_Associes")
	private int nbAssocies;
	
	@Column(name = "capital_TDN")
	private Float capitalTDN;
	
	@Column(name = "capitalMin")
	private Float capitalMin;
	
	@Column(name = "action")
	private Float action;
	
	@Column(name = "nbr_Parts")
	private int nbrParts;
	
	@Column(name = "valeur_Parts")
	private int valeurParts;

	
	@Column(name = "Date_Cloture")
	@Temporal(TemporalType.DATE)
	private Date dateCloture;
	
	@Column(name = "Duree_Societe")
	@Temporal(TemporalType.DATE)
	private Date dureeSociete;
	
	@OneToOne(mappedBy = "capital")
	private Societe societe;
	
	


}
