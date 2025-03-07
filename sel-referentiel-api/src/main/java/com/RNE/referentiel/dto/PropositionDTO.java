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
public class PropositionDTO {

    private String code;
    
    private String texteFr;
    
    private String texteAr;
  
    private Activation activation;
    
    private String articleCode;


}