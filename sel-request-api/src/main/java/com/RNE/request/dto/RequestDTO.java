package com.RNE.request.dto;

import java.util.Date;

import com.RNE.request.enums.StatusRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {

	private Long id;
	
	private Date deadline;
	
	private Date dateOfSent;
	
	private String typeRegister;
	
	private StatusRequest statusRequest;
	
	private Long organizationId;
	

}