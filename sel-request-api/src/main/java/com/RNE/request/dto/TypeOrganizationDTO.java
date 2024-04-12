package com.RNE.request.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeOrganizationDTO {
    private Long id;
    private String associationType;
    private String legalStatus;
}