package com.RNE.referentiel.serviceInterface;

import java.util.List;


import com.RNE.referentiel.entities.Proposal;

public interface ProposalService {

	public Proposal saveProposition(Proposal proposition);
	public Proposal propositionById(String codeProposition);
	public List<Proposal>getAllProposition();
	public Proposal  updateProposition(String codeProposition,Proposal proposition);
	public void deleteProposition(String codeProposition);
}
