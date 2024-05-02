package com.RNE.demande.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IdentifiantUnique {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String identifiantUnique;
  
  @OneToOne(mappedBy = "identifiantUnique")
  private MembreSpec membreSpecs;
}
