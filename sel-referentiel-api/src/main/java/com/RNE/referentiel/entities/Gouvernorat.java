package com.RNE.referentiel.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.RNE.referentiel.enums.Activation;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Table(name = "gouvernorats")
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Gouvernorat implements Serializable {

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

	@Column(name = "nom_fr", nullable = false)
	private String nomFr;

	@Column(name = "nom_ar", nullable = false)
	private String nomAr;

	@Enumerated(EnumType.STRING)
	@Column(name = "activation", nullable = false)
	private Activation activation;

	@OneToMany(mappedBy = "gouvernorat", cascade = {CascadeType.REMOVE})
	private List<Ville> villes;
	
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;

	@PrePersist
	protected void onCreate() {
		LocalDateTime now = LocalDateTime.now();
		createdAt = now;
		updatedAt = now;
	}

	@PreUpdate
	protected void onUpdate() {
		updatedAt = LocalDateTime.now();
	}

}