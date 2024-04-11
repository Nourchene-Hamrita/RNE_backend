package com.RNE.demande.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Request implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6047593005293832737L;
	/**
	* 
	*/

	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "deadline")
	@Temporal(TemporalType.DATE)
	private Date deadline;
	
	
	@Column(name = "dateOfSent")
	@Temporal(TemporalType.DATE)
	private Date dateOfSent;
	
	@Column(name = "TypeRegister")
	private String TypeRegister;
	
	
	
	

}
