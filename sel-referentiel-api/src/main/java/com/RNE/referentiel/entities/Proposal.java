package com.RNE.referentiel.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Proposal implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  @Id
	   private String proposalCode;
	   private String texteFr;
	   private String texteAr;
	   @Enumerated(EnumType.STRING)
	   private Activation activation;
	   @ManyToOne
	   private Article article;
} 
