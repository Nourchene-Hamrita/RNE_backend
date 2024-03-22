package com.RNE.referentiel.serviceInterface;

import java.util.List;

import com.RNE.referentiel.entities.Statut;


public interface StatutService {
   
	public Statut saveStatut(Statut status);
	
	public Statut getStatutByCode(String codeStatut);
	
	public List<Statut>getAllStatut();
	
	public Statut updateStatut(String codeStatut,Statut statut);
	
	
	public void deleteStatut(String codeStatut); 
}
