package com.RNE.request.dto.mappers;

import org.mapstruct.Mapper;

import org.springframework.stereotype.Component;

import com.RNE.request.dto.RequestDTO;
import com.RNE.request.entities.Request;
@Component
@Mapper
public interface RequestMapper {

 
    RequestDTO toDto(Request request);
    
    Request toEntity(RequestDTO requestDTO);

}