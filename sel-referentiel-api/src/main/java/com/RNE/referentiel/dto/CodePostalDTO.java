package com.RNE.referentiel.dto;

import com.RNE.referentiel.enums.Activation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CodePostalDTO {

    private Long id;

    private String codePostal;

    private VilleDTO ville;
    
    private Activation activation;

}