package com.RNE.request.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.RNE.request.dto.RequestDTO;
import com.RNE.request.dto.mappers.RequestMapper;
import com.RNE.request.entities.Request;
import com.RNE.request.repositories.RequestRepository;
import com.RNE.request.services.RequestService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RequestServiceImpl implements RequestService {

    private RequestRepository requestRepository;
    private RequestMapper requestMapper;

    @Override
    public RequestDTO saveRequest(RequestDTO requestDTO) {
        Request request = requestMapper.toEntity(requestDTO);
        request = requestRepository.save(request);
        return requestMapper.toDto(request);
    }

    @Override
    public List<RequestDTO> getAllRequests() {
        List<Request> requests = requestRepository.findAll();
        return requests.stream().map(requestMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public RequestDTO getRequestById(Long id) {
        Request request = requestRepository.findById(id).orElse(null);
        return requestMapper.toDto(request);
    }

    @Override
    public RequestDTO updateRequest(Long id, RequestDTO requestDTO) {
        Request request = requestRepository.findById(id).orElse(null);
        request.setDeadline(requestDTO.getDeadline());
        request.setDateOfSent(requestDTO.getDateOfSent());
        request.setTypeRegister(requestDTO.getTypeRegister());
        request.setStatusRequest(requestDTO.getStatusRequest());
        request = requestRepository.save(request);
        return requestMapper.toDto(request);
    }

    @Override
    public void deleteRequest(Long id) {
        requestRepository.deleteById(id);
    }

}