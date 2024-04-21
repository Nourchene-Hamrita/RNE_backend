package com.RNE.demande.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.RNE.demande.enums.Pouvoirs;
import com.RNE.demande.enums.Qualite;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
public class Membre implements Serializable {

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
	
	@Enumerated(EnumType.STRING)
	@Column(name = "qualite")
	private  Qualite qualite;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "pouvoirs")
	private  Pouvoirs pouvoirs;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_Nomination")
	private Date dateNomination;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_Fin_Nomination")
	private Date dateFinNomination;
	
	@Column(name = "duree_Nomination")
	private Long dureeNomination;
	
	@ManyToOne
	private Societe societe;
	
   @ManyToMany

   private Set<Personne> personnes;
}
