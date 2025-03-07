package com.RNE.referentiel.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.RNE.referentiel.dto.VilleDTO;
import com.RNE.referentiel.dto.mappers.VilleMapper;
import com.RNE.referentiel.entities.Gouvernorat;
import com.RNE.referentiel.entities.Ville;
import com.RNE.referentiel.repositories.GouvernoratRepository;
import com.RNE.referentiel.repositories.VilleRepository;
import com.RNE.referentiel.services.VilleService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VilleServiceImpl implements VilleService {

    private VilleRepository villeRepository;
    private GouvernoratRepository gouvernoratRepository;
    private VilleMapper villeMapper;

    // save city service
    @Override
    public VilleDTO saveVille(VilleDTO villeDTO) {
        Ville ville = villeMapper.toEntity(villeDTO);
        return villeMapper.toDto(villeRepository.save(ville));
    }

    // get city by code service
    @Override
    public VilleDTO getVilleByCode(String code) {
        Optional<Ville> existCity = villeRepository.findById(code);
        return villeMapper.toDto(existCity.get());
    }

    // get all cities services
    @Override
    public List<VilleDTO> getAllVille() {
        List<Ville> villes = villeRepository.findAll();
        return villes.stream().map(villeMapper::toDto).toList();
    }

    // update city service
    @Override
    public VilleDTO updateVille(String code, VilleDTO villeDTO) {
        Ville existCity = villeRepository.findById(code).orElse(null);
        existCity.setNomFr(villeDTO.getNomFr());
        existCity.setNomAr(villeDTO.getNomAr());
        existCity.setActivation(villeDTO.getActivation());
       
     // Retrieve the Gouvernorat entity using the gouverneratCode from the DTO
        Gouvernorat gouvernorat = gouvernoratRepository.findById(villeDTO.getGouverneratCode())
                .orElseThrow(() -> new RuntimeException("Gouvernorat not found"));

        // Set the Gouvernorat in the Ville entity
        existCity.setGouvernorat(gouvernorat);

        // Save the updated Ville entity and return the DTO
        return villeMapper.toDto(villeRepository.save(existCity));
    }

    @Override
    public List<VilleDTO> getActivatedVille() {
        List<Ville> villes = villeRepository.getActivatedVilles();
        return villes.stream().map(villeMapper::toDto).toList();
    }

    @Override
    public void deleteVille(String code) {
        villeRepository.deleteById(code);
    }

	@Override
	public Page<VilleDTO> getVillePagination(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
	    Page<Ville> villePage = villeRepository.findAll(pageable);
	    
	    return  villePage.map(villeMapper::toDto);
		
	}

}