package com.RNE.referentiel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.entities.Delegation;
import com.RNE.referentiel.repositories.DelegationRepository;
import com.RNE.referentiel.services.impl.DelegationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DelegationServiceImpl implements DelegationService {

	private DelegationRepository delegationRepo;

	// service for creating a new Governorate
	@Override

	public Delegation saveDelegation(Delegation del) {

		return delegationRepo.save(del);

	}

	// get list of Governorate
	@Override
	public List<Delegation> getAllDelegations() {

		return delegationRepo.findAll();
	}

	@Override
	public Delegation getDelegationByCode(String code) {
		Optional<Delegation> delegation = delegationRepo.findById(code);
		return delegation.get();
	}

	@Override
	public Delegation updateDelegation(String code, Delegation del) {

		Optional<Delegation> existing = delegationRepo.findById(code);

		if (existing.isPresent()) {
			Delegation delegation = existing.get();
			delegation.setNameFr(del.getNameFr());
			delegation.setNameAr(del.getNameAr());
			delegation.setActivation(del.getActivation());
			return delegationRepo.save(del);
		} else {
			return null;
		}

	}

	@Override
	public List<Delegation> getActivatedDelegation() {

		return delegationRepo.getActivatedDelegation();
	}

	@Override
	public void deleteDelegation(String code) {
		delegationRepo.deleteById(code);
	}

}
