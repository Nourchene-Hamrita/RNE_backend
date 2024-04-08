package com.RNE.referentiel.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.RNE.referentiel.enums.Activation;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Section implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -492407437337641766L;
	/**
	* 
	*/

	@Id
	private String code;

	private String titleFr;

	private String titleAr;

	@Enumerated(EnumType.STRING)
	private Activation activation;
	@ManyToMany

	private Set<Status> status;
	@OneToMany(mappedBy = "section", cascade = CascadeType.ALL)

	private List<Article> articles;

}
