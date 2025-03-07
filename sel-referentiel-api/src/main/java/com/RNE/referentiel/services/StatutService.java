package com.RNE.referentiel.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.RNE.referentiel.dto.StatutDTO;

public interface StatutService {

    public StatutDTO saveStatut(StatutDTO statutDTO);

    public StatutDTO getStatutByCode(String code);

    public List<StatutDTO> getAllStatuts();

    public StatutDTO updateStatut(String code, StatutDTO statutDTO);

    public void deleteStatut(String code);

	public Page<StatutDTO> getStatutPagination(int pageNumber, int pageSize);
}