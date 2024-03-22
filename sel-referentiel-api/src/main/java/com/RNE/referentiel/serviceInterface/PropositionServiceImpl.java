package com.RNE.referentiel.serviceInterface;

import java.util.List;


import com.RNE.referentiel.entities.Proposition;

public interface PropositionServiceImpl {

	public Proposition saveProposition(Proposition proposition);
	public Proposition propositionById(String codeProposition);
	public List<Proposition>getAllProposition();
	public Proposition  updateProposition(String codeProposition,Proposition proposition);
	public void deleteProposition(String codeProposition);
}
