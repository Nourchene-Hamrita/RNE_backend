package com.RNE.referentiel.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.RNE.referentiel.enums.Activation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Getter
@Table(name = "propositions")
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Proposition implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 7731704580879660247L;
    /**
     * 
     */

    @Id
	@Column(name = "code", nullable = false)
    private String code;

    @Column(name = "texte_fr",nullable = false)
    private String texteFr;

    @Column(name = "texte_ar",nullable = false)
    private String texteAr;

    @Enumerated(EnumType.STRING)
    @Column(name = "activation")
    private Activation activation;

    @ManyToOne
    private Article article;
    
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