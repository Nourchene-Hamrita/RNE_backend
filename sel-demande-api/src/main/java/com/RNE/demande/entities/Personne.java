package com.RNE.demande.entities;

import java.io.Serializable;
import java.util.Date;
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
    private Date dateDelivrence;
	
	@Column(name = "type_ID_Carte")
    private String typeIDCarte;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dateNaiss")
    private Date dateNaiss;
	
	@Column(name = "lieu_Naiss")
    private String lieuNaiss;
	
	@Column(name = "nom_Prenom")
    private String nomPrenom;
	
	@Column(name = "nationalité")
    private String nationalité;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "genre")
    private  Genre genre;
	
	@ManyToMany( cascade = CascadeType.ALL)
	private Set<Action> actions;
	
	@ManyToMany(mappedBy = "personnes",cascade = CascadeType.ALL)
	private Set<Membre> membres;

	
	@OneToOne
	private Adresse adresse;
	
}
