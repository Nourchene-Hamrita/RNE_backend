package com.RNE.referentiel.serviceInterface;

import java.util.List;

import com.RNE.referentiel.entities.Ville;

public interface VilleService {
   
	public Ville saveVille(Ville ville);
	
	public Ville getVilleByCode(String codeVille);
	
	public List<Ville>getAllVille();
	
	public Ville updateVille(String codeVille,Ville ville);
	
	public List<Ville> getActivatedVille();
	
	public void deleteVille(String codeVille); 
}
