package com.RNE.referentiel.dto;


import com.RNE.referentiel.entities.Status;
import com.RNE.referentiel.enums.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusDTO {

    private String code;
    
    private String title;
    
    private String description;
    

    
    private Category category;

    public static StatusDTO convertEntityToDto(Status status) {

        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setCode(status.getCode());
        statusDTO.setTitle(status.getTitle());
        statusDTO.setDescription(status.getDescription());
       
        statusDTO.setCategory(status.getCategory());

        return statusDTO;
    }

    public static Status convertDtoToEntity(StatusDTO statusDTO) {

        Status status = new Status();
        status.setCode(statusDTO.getCode());
        status.setTitle(statusDTO.getTitle());
        status.setDescription(statusDTO.getDescription());
        status.setCategory(statusDTO.getCategory());

        return status;
    }

}