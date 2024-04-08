package com.RNE.referentiel.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6047593005293832737L;
	/**
	* 
	*/

	@Id
	private String code;
	private String titleFr;
	private String titleAr;

	@Enumerated(EnumType.STRING)
	private Activation activation;

	@OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
	 private List<Proposal> proposal = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "section_code", referencedColumnName = "code")
	private Section section;
}
