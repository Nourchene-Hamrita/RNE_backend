package com.RNE.referentiel.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Ville implements Serializable {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	   @Id
	   private String codeVille;
	   private String nomVilleFr;
	   private String nomVilleAr;
	   @Enumerated(EnumType.STRING)
	   private Activation activation;
	   
	   @ManyToOne
	   private Gouvernerat gouvernerat;
	   @OneToMany(mappedBy = "ville",cascade = {CascadeType.ALL})
	   @JsonManagedReference
	   private List<CodePostal> codePostal;
	   
	   
	
	   
	   
	
	   
	   
}
