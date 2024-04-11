package com.RNE.request.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6047593005293832737L;
	/**
	* 
	*/

	@Id
	private Long id;
	
	@Column(name = "delCode")
    private String delCode;
	
	@Column(name = "cityCode")
    private String cityCode;
	
	@Column(name = "postalCodeId")
    private String postalCodeId;
	
	
	
	

}
