package com.RNE.referentiel.entities;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Statut implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
  private String codeStatut;
  private String titreStatut;
  private String description;
  
  @Enumerated(EnumType.STRING)
  private Categorie categorie;
  @ManyToMany(mappedBy = "statuts")
  
  private Set<Section> sections;
  

  
 
  
}
