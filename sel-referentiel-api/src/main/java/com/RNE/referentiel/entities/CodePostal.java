package com.RNE.referentiel.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.RNE.referentiel.enums.Activation;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "codePostal")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CodePostal implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6932573829664333233L;
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "code_postal", nullable = false)
	private String codePostal;

	@ManyToOne
	@JsonBackReference
	private Ville ville;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "activation", nullable = false)
	private Activation activation;
	
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