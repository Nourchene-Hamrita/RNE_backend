package com.RNE.referentiel.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.dto.StatusDTO;
import com.RNE.referentiel.entities.Status;

import com.RNE.referentiel.repositories.StatusRepository;
import com.RNE.referentiel.services.impl.StatusService;

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
    public StatusDTO getStatusByCode(String code) {
        Optional<Status> existStatus = statusRepository.findById(code);
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
    public StatusDTO updateStatus(String code, StatusDTO statusDTO) {
        Status existStatus = statusRepository.findById(code).orElse(null);
        if (existStatus == null) {
            return null;
        }

        existStatus.setTitle(statusDTO.getTitle());
       

        return convertEntityToDto(statusRepository.save(existStatus));
    }

    @Override
    public void deleteStatus(String code) {
        statusRepository.deleteById(code);
    }

    public Status convertDtoToEntity(StatusDTO statusDTO) {

        Status status = new Status();
        status.setCode(statusDTO.getCode());
        status.setTitle(statusDTO.getTitle());
        

        return status;
    }

    public StatusDTO convertEntityToDto(Status status) {

        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setCode(status.getCode());
        statusDTO.setTitle(status.getTitle());
    

        return statusDTO;
    }

}