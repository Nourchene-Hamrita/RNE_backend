package com.RNE.referentiel.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.RNE.referentiel.enums.Activation;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sections")
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
	@Column(name = "code", nullable = false)
	private String code;

	@Column(name = "titre_fr", nullable = false)

	private String titreFr;

	@Column(name = "titre_ar", nullable = false)

	private String titreAr;

	@Enumerated(EnumType.STRING)
	@Column(name = "activation", nullable = false)

	private Activation activation;

	@ManyToOne

	private Statut statut;

	@OneToMany(mappedBy = "section", cascade = CascadeType.ALL)

	private List<Article> articles;
	
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