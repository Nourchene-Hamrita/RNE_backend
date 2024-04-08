package com.RNE.referentiel.services.impl;

import java.util.List;

import com.RNE.referentiel.dto.StatusDTO;

public interface StatusService {

    public StatusDTO saveStatus(StatusDTO statusDTO);

    public StatusDTO getStatusByCode(String code);

    public List<StatusDTO> getAllStatuses();

    public StatusDTO updateStatus(String code, StatusDTO statusDTO);

    public void deleteStatus(String code);
}