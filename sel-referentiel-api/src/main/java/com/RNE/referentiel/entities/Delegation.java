package com.RNE.referentiel.entities;

import java.io.Serializable;
import java.util.List;

import com.RNE.referentiel.enums.Activation;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "delegations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Delegation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6369053955665516865L;
	/**
	 * 
	 */

	@Id
	@Column(name = "code", nullable = false)
	private String code;

	@Column(name = "name_fr", nullable = false)
	private String nameFr;

	@Column(name = "name_ar", nullable = false)
	private String nameAr;

	@Enumerated(EnumType.STRING)
	@Column(name = "activation", nullable = false)
	private Activation activation;

	@OneToMany(mappedBy = "delegation", cascade = CascadeType.ALL)

	private List<City> cities;

}