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
	private static final long serialVersionUID = 7731704580879660247L;
	/**
	 * 
	 */

	@Id
	private String code;
	private String textFr;
	private String textAr;
	@Enumerated(EnumType.STRING)
	private Activation activation;
	@ManyToOne
	private Article article;
}
