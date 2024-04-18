package com.RNE.request.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("company")

public class Company extends Organization {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1899950164116739268L;

    @Column(name = "industry")
    private String industry;

}
