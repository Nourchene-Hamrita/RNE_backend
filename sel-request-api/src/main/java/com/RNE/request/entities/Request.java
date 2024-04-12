package com.RNE.request.entities;

import java.io.Serializable;
import java.util.Date;
import com.RNE.request.enums.StatusRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "requests")
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "deadline")
	@Temporal(TemporalType.DATE)
	private Date deadline;

	@Column(name = "date_of_sent")
	@Temporal(TemporalType.DATE)
	private Date dateOfSent;

	@Column(name = "type_register")
	private String typeRegister;

	@Enumerated(EnumType.STRING)
	@Column(name = "status_request", nullable = false)
	private StatusRequest statusRequest;

	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organization;

}
