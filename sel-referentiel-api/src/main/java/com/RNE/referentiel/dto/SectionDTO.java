package com.RNE.referentiel.dto;

import java.util.List;


import com.RNE.referentiel.enums.Activation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SectionDTO {

    private String code;

    private String titreFr;

    private String titreAr;

    private Activation activation;

    private String codeStatut;

    //private List<ArticleDTO> articles;
}