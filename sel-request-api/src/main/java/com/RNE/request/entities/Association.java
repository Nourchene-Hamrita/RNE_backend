package com.RNE.request.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("association")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Association extends Organization {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1810222298486466170L;

	@Column(name = "subject")
    private String subject;

    @Column(name = "objective")
    private String objective;

	

}
