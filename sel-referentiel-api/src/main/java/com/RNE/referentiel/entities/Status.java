package com.RNE.referentiel.entities;

import java.io.Serializable;
import java.util.Set;

import com.RNE.referentiel.enums.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Status implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4206123940409600831L;

	/**
	 * 
	 */
	@Id
	@Column(name = "code", nullable = false)
	private String code;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "description", nullable = false)
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "category", nullable = false)
	private Category category;

	@ManyToMany(mappedBy = "status")
	private Set<Section> sections;

}