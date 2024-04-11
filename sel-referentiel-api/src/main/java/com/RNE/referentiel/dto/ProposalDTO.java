package com.RNE.referentiel.dto;


import com.RNE.referentiel.enums.Activation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProposalDTO {

    private String code;
    
    private String textFr;
    
    private String textAr;
  
    private Activation activation;
    
    private String articleCode;


}