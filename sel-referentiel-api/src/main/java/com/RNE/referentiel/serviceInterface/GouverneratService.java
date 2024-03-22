package com.RNE.referentiel.serviceInterface;

import java.util.List;

import com.RNE.referentiel.entities.Gouvernerat;

public interface GouverneratService {
  
	public Gouvernerat saveGouvernerat(Gouvernerat gouv);
	
	public List<Gouvernerat>getAllGouvernerats();
	
	public Gouvernerat getGouverneratByCode(String codeGouv);
	
	public Gouvernerat updateGouvernerat(String codeGouv,Gouvernerat gouv);
	
	public List<Gouvernerat>getActivatedGouvernerat();
	
	public void deleteGouvernerat(String code_gouv); 
}
