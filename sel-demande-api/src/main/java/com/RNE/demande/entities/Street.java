package com.RNE.demande.entities;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Street implements Serializable {
	
	

	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	   @Id
	   private Long id;
	   private String nameStreetFr;
	   private String nameStreetAr;
	   
	
	
	

}
