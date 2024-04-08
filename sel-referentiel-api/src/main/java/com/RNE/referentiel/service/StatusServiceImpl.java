package com.RNE.referentiel.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.dto.StatusDTO;
import com.RNE.referentiel.entities.Status;

import com.RNE.referentiel.repositories.StatusRepository;

import com.RNE.referentiel.serviceInterface.StatusService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatusServiceImpl implements StatusService {

    private StatusRepository statusRepository;

    // save status service
    @Override
    public StatusDTO saveStatus(StatusDTO statusDTO) {

        Status status = convertDtoToEntity(statusDTO);
        return convertEntityToDto(statusRepository.save(status));
    }

    // get status by code service
    @Override
    public StatusDTO getStatusByCode(String statusCode) {
        Optional<Status> existStatus = statusRepository.findById(statusCode);
        return existStatus.map(this::convertEntityToDto).orElse(null);
    }

    // get all status services
    @Override
    public List<StatusDTO> getAllStatuses() {

        return statusRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    // update status service
    @Override
    public StatusDTO updateStatus(String statusCode, StatusDTO statusDTO) {
        Status existStatus = statusRepository.findById(statusCode).orElse(null);
        if (existStatus == null) {
            return null;
        }

        existStatus.setStatusTitle(statusDTO.getStatusTitle());
       

        return convertEntityToDto(statusRepository.save(existStatus));
    }

    @Override
    public void deleteStatus(String statusCode) {
        statusRepository.deleteById(statusCode);
    }

    public Status convertDtoToEntity(StatusDTO statusDTO) {

        Status status = new Status();
        status.setStatusCode(statusDTO.getStatusCode());
        status.setStatusTitle(statusDTO.getStatusTitle());
        

        return status;
    }

    public StatusDTO convertEntityToDto(Status status) {

        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setStatusCode(status.getStatusCode());
        statusDTO.setStatusTitle(status.getStatusTitle());
    

        return statusDTO;
    }

}