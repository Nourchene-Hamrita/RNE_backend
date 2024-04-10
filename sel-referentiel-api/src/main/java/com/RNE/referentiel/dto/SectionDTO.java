package com.RNE.referentiel.dto;

import java.util.List;
import java.util.Set;

import com.RNE.referentiel.enums.Activation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SectionDTO {

    private String code;

    private String titleFr;

    private String titleAr;

    private Activation activation;

    private Set<StatusDTO> status;

    private List<ArticleDTO> articles;
}