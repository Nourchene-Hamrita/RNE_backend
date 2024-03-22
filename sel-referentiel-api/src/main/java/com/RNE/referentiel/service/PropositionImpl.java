package com.RNE.referentiel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.entities.Article;
import com.RNE.referentiel.entities.Proposition;
import com.RNE.referentiel.repositories.ArticleRepository;
import com.RNE.referentiel.repositories.PropositionRepository;
import com.RNE.referentiel.serviceInterface.PropositionServiceImpl;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PropositionImpl implements PropositionServiceImpl{
	 private PropositionRepository propositionRepository;
	

	@Override
	public Proposition saveProposition(Proposition proposition) {
		// TODO Auto-generated method stub
		return propositionRepository.save(proposition);
	}

	@Override
	public Proposition propositionById(String codeProposition) {
		// TODO Auto-generated method stub
		 Proposition existProposition=propositionRepository.findById(codeProposition).orElse(null);

		return existProposition;
	}

	@Override
	public List<Proposition> getAllProposition() {
		// TODO Auto-generated method stub
		return propositionRepository.findAll();
	}

	@Override
	public Proposition updateProposition(String codeProposition, Proposition proposition) {
		// TODO Auto-generated method stub
		Proposition	existProposition=propositionRepository.findById(codeProposition).orElse(null);
		existProposition.setActivation(proposition.getActivation());
		existProposition.setArticle(proposition.getArticle());
		existProposition.setCodeProposition(proposition.getCodeProposition());
		existProposition.setTexteAr(proposition.getTexteAr());
		existProposition.setTexteFr(proposition.getTexteFr());
		
		return propositionRepository.save(existProposition);
	}

	@Override
	public void deleteProposition(String codeProposition) {
		// TODO Auto-generated method stub
		propositionRepository.deleteById(codeProposition);
		
	}

}
