package com.RNE.referentiel.entities;

import java.util.List;

import com.RNE.referentiel.enums.Activation;
import com.RNE.referentiel.enums.Categorie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FormeJuridique {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@Enumerated(EnumType.STRING)
	@Column(name = "activation",nullable=false)
	private Activation activation;
	
	@Enumerated(EnumType.STRING)
	@Column(name="categorie")
	private Categorie categorie;
	@OneToMany(mappedBy = "formeJuridique")
	private List<Statut> status;

}
