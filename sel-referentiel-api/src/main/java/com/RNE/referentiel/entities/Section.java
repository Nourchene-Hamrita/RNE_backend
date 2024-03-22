package com.RNE.referentiel.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	private static final long serialVersionUID = 1L;
	   @Id
	   private String codeSection;
	   private String titreSectionFr;
	   private String titreSectionAr;
	   
	   @Enumerated(EnumType.STRING)
	   private Activation activation;
	   @ManyToMany
	  
	   private Set<Statut> statuts;
	   @OneToMany(mappedBy = "section",cascade = CascadeType.ALL)
	   private List<Article>articles;

	   
	   
	
	   
	   
	   
}
