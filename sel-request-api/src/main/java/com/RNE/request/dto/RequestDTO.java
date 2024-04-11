package com.RNE.request.dto;

import java.util.Date;

import com.RNE.request.entities.Request;

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
	    requestDTO.setId(request.getId());
	    requestDTO.setDeadline(request.getDeadline());
	    requestDTO.setDateOfSent(request.getDateOfSent());
	    requestDTO.setTypeRegister(request.getTypeRegister());
	    return requestDTO;
	}

	public static Request convertDtoToEntity(RequestDTO requestDTO) {
	    Request request = new Request();
	    request.setId(requestDTO.getId());
	    request.setDeadline(requestDTO.getDeadline());
	    request.setDateOfSent(requestDTO.getDateOfSent());
	    request.setTypeRegister(requestDTO.getTypeRegister());
	    return request;
	}

}