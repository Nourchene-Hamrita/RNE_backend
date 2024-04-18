package com.RNE.request.entities;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeOrganization implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6047593005293832737L;
	/**
	* 
	*/

    @Id
    private Long id;

    @Column(name = "association_type")
    private String associationType;

    @Column(name = "legal_status")
    private String legalStatus;

    @OneToMany(mappedBy = "typeOrganization", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Organization> organizations;

}