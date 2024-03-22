package com.RNE.referentiel.serviceInterface;

import java.util.List;

import com.RNE.referentiel.entities.Governorate;

public interface GovernorateService {
  
	public Governorate saveGovernorate(Governorate gouv);
	
	public List<Governorate>getAllGovernorates();
	
	public Governorate getGovernorateByCode(String codeGouv);
	
	public Governorate updateGovernorate(String codeGouv,Governorate gouv);
	
	public List<Governorate>getActivatedGovernorate();
	
	public void deleteGovernorate(String code_gouv); 
}
