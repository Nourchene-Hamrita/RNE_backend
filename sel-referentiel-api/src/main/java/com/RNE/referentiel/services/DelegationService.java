package com.RNE.referentiel.services;

import java.util.List;

import com.RNE.referentiel.entities.Delegation;

public interface DelegationService {

	public Delegation saveDelegation(Delegation del);

	public List<Delegation> getAllDelegations();

	public Delegation getDelegationByCode(String code);

	public Delegation updateDelegation(String code, Delegation del);

	public List<Delegation> getActivatedDelegation();

	public void deleteDelegation(String code);
}
