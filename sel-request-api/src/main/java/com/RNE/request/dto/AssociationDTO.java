package com.RNE.request.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssociationDTO extends OrganizationDTO {

    private String subject;
    
    private String objective;
}

