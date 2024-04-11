package com.RNE.demande.services;

import java.util.List;
import com.RNE.demande.dto.RequestDTO;

public interface RequestService {
	
	public RequestDTO saveRequest(RequestDTO requestDTO);
	public List<RequestDTO> getAllRequest();

}
