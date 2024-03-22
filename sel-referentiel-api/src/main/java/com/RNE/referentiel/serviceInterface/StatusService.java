package com.RNE.referentiel.serviceInterface;

import java.util.List;

import com.RNE.referentiel.entities.Status;


public interface StatusService {
   
	public Status saveStatut(Status status);
	
	public Status getStatutByCode(String statusCode);
	
	public List<Status>getAllStatut();
	
	public Status updateStatut(String statusCode,Status statut);
	
	
	public void deleteStatut(String statusCode); 
}
