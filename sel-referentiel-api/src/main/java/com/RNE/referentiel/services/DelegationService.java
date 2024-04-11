package com.RNE.referentiel.services;

import java.util.List;

import com.RNE.referentiel.dto.DelegationDTO;

public interface DelegationService {

	public DelegationDTO saveDelegation(DelegationDTO delegationDTO);

	public List<DelegationDTO> getAllDelegations();

	public DelegationDTO getDelegationByCode(String code);

	public DelegationDTO updateDelegation(String code, DelegationDTO delegationDTO);

	public List<DelegationDTO> getActivatedDelegations();

	public void deleteDelegation(String code);
}