package com.RNE.request.services;

import java.util.List;

import com.RNE.request.dto.RequestDTO;


public interface RequestService {

    RequestDTO saveRequest(RequestDTO requestDTO);

    List<RequestDTO> getAllRequests();

    RequestDTO getRequestById(Long id);

    RequestDTO updateRequest(Long id, RequestDTO requestDTO);

    void deleteRequest(Long id);

}