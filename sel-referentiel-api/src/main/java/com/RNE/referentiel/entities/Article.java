package com.RNE.referentiel.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
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
	private static final long serialVersionUID = 1L;
	   @Id
	   private String codeArticle;
	   private String titreArticleFr;
	   private String titreArticleAr;
	   
	   @Enumerated(EnumType.STRING)
	   private Activation activation;
	   
	   @OneToMany(mappedBy = "article",cascade = CascadeType.ALL)
	   private List<Proposition> proposition;
	   
	   @ManyToOne
	   private Section section;
	
}
