package com.RNE.demande.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RNE.demande.entities.Adress;
import com.RNE.demande.repositories.AdressRepository;
import com.RNE.demande.services.AdressService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class AdressServiceImpl implements AdressService {

	private AdressRepository adressRepository;

	@Override
	public Adress saveAdress(Adress adress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Adress> getAllAdresses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Adress getAdressById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Adress updateAdress(Long id, Adress Adress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAdress(Long id) {
		// TODO Auto-generated method stub
		
	}
	
}