package com.RNE.referentiel.serviceInterface;

import java.util.List;

import com.RNE.referentiel.dto.StatusDTO;

public interface StatusService {

    public StatusDTO saveStatus(StatusDTO statusDTO);

    public StatusDTO getStatusByCode(String statusCode);

    public List<StatusDTO> getAllStatuses();

    public StatusDTO updateStatus(String statusCode, StatusDTO statusDTO);

    public void deleteStatus(String statusCode);
}