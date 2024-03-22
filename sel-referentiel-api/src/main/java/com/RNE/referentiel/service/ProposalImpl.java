package com.RNE.referentiel.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.RNE.referentiel.entities.Proposal;

import com.RNE.referentiel.repositories.ProposalRepository;
import com.RNE.referentiel.serviceInterface.ProposalService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProposalImpl implements ProposalService{
	 private ProposalRepository propositionRepository;
	

	@Override
	public Proposal saveProposition(Proposal proposition) {
		// TODO Auto-generated method stub
		return propositionRepository.save(proposition);
	}

	@Override
	public Proposal propositionById(String proposalCode) {
		// TODO Auto-generated method stub
		 Proposal existProposition=propositionRepository.findById(proposalCode).orElse(null);

		return existProposition;
	}

	@Override
	public List<Proposal> getAllProposition() {
		// TODO Auto-generated method stub
		return propositionRepository.findAll();
	}

	@Override
	public Proposal updateProposition(String proposalCode, Proposal proposition) {
		// TODO Auto-generated method stub
		Proposal	existProposition=propositionRepository.findById(proposalCode).orElse(null);
		existProposition.setActivation(proposition.getActivation());
		existProposition.setArticle(proposition.getArticle());
		existProposition.setProposalCode(proposition.getProposalCode());
		existProposition.setTexteAr(proposition.getTexteAr());
		existProposition.setTexteFr(proposition.getTexteFr());
		
		return propositionRepository.save(existProposition);
	}

	@Override
	public void deleteProposition(String proposalCode) {
		// TODO Auto-generated method stub
		propositionRepository.deleteById(proposalCode);
		
	}

}
