package com.RNE.demande.services;

import java.util.List;
import com.RNE.demande.entities.Adress;

public interface AdressService {
	
    Adress saveAdress(Adress adress);
    
    List<Adress> getAllAdresses();
    
    Adress getAdressById(Long id);
    
    Adress updateAdress(Long id, Adress Adress);
    
    void deleteAdress(Long id);
}