package com.RNE.demande.services;

import java.util.List;
import com.RNE.demande.entities.Adress;

public interface AdressService {

	public Adress saveAdress(Adress adress);

	public List<Adress> getAllAdresses();

	public Adress getAdressById(Long id);

	public Adress updateAdress(Long id, Adress Adress);

	public void deleteAdress(Long id);
}