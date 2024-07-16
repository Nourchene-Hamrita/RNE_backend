package com.RNE.demande.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customer implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	    @Column(name = "customerNumber")
	    private Integer customerNumber;

	    @Column(name = "customerName")
	    private String customerName;

	    @Column(name = "contactLastName")
	    private String contactLastName;

	    @Column(name = "contactFirstName")
	    private String contactFirstName;

	    @Column(name = "phone")
	    private String phone;

	    @Column(name = "addressLine1")
	    private String addressLine1;

	    @Column(name = "addressLine2")
	    private String addressLine2;

	    @Column(name = "city")
	    private String city;

	    @Column(name = "state")
	    private String state;

	    @Column(name = "postalCode")
	    private String postalCode;

	    @Column(name = "country")
	    private String country;

	    @Column(name = "salesRepEmployeeNumber")
	    private Integer salesRepEmployeeNumber;

	    @Column(name = "creditLimit")
	    private Long creditLimit;

}
