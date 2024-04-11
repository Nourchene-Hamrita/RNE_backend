package com.RNE.request.services;

import java.util.List;

import com.RNE.request.dto.RequestDTO;

public interface RequestService {
	
	public RequestDTO saveRequest(RequestDTO requestDTO);
	public List<RequestDTO> getAllRequest();
	 public void deleteRequest(Long id);

}
