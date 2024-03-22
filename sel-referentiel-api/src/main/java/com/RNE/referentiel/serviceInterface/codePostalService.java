package com.RNE.referentiel.serviceInterface;

import java.util.List;

import com.RNE.referentiel.entities.CodePostal;

public interface codePostalService {
  
	public CodePostal saveCodePostal(CodePostal codePostal);
	
	public CodePostal getCodePostalById(Long id);
	
	public List<CodePostal>getAllCodesPostal();
	
	public CodePostal updateCodePostal(Long id,CodePostal codePostal);
	
	public void deleteCodePostal(Long id);
}
