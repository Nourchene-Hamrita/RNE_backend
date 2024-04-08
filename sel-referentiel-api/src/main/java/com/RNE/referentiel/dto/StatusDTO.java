package com.RNE.referentiel.dto;

import java.util.Set;
import java.util.stream.Collectors;

import com.RNE.referentiel.entities.Category;
import com.RNE.referentiel.entities.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusDTO {

    private String statusCode;
    private String statusTitle;
    private String description;
    private Category category;

    public static StatusDTO convertEntityToDto(Status status) {

        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setStatusCode(status.getStatusCode());
        statusDTO.setStatusTitle(status.getStatusTitle());
        statusDTO.setDescription(status.getDescription());
        statusDTO.setCategory(status.getCategory());

        return statusDTO;
    }

    public static Status convertDtoToEntity(StatusDTO statusDTO) {

        Status status = new Status();
        status.setStatusCode(statusDTO.getStatusCode());
        status.setStatusTitle(statusDTO.getStatusTitle());
        status.setDescription(statusDTO.getDescription());
        status.setCategory(statusDTO.getCategory());

        return status;
    }

}