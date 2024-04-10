package com.RNE.referentiel.dto.mappers;

import org.mapstruct.Mapper;

import com.RNE.referentiel.dto.ProposalDTO;
import com.RNE.referentiel.entities.Proposal;

@Mapper(componentModel = "spring")
public interface ProposalMapper {

    ProposalDTO toDto(Proposal proposal);

    Proposal toEntity(ProposalDTO proposalDTO);
}