package com.RNE.demande.dto;

import java.util.Date;

import com.RNE.demande.entities.Request;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RequestDTO {
	
    private Long id;
	
	private Date deadline;
	
	private Date dateOfSent;
	
	private String TypeRegister;

	public static RequestDTO convertEntityToDto(Request request) {
		
		RequestDTO requestDTO = new RequestDTO();
		
		requestDTO.setId(requestDTO.getId());
		requestDTO.setDeadline(requestDTO.getDeadline());
		requestDTO.setDateOfSent(requestDTO.getDateOfSent());
		requestDTO.setTypeRegister(requestDTO.getTypeRegister());
		
		return requestDTO;
		
		
	}
	
public static Request convertDtoToEntity(RequestDTO requestDTO) {
		
		Request request = new Request();
		
		request.setId(request.getId());
		request.setDeadline(request.getDeadline());
		request.setDateOfSent(request.getDateOfSent());
		request.setTypeRegister(request.getTypeRegister());
		
		return request;
}
}