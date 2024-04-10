package com.RNE.referentiel.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.dto.PostalCodeDTO;
import com.RNE.referentiel.dto.mappers.CityMapper;
import com.RNE.referentiel.dto.mappers.PostalCodeMapper;
import com.RNE.referentiel.entities.PostalCode;
import com.RNE.referentiel.repositories.PostalCodeRepository;
import com.RNE.referentiel.services.PostalCodeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostalCodeImpl implements PostalCodeService {

	private PostalCodeRepository codePostalRepo;
	private PostalCodeMapper postalCodeMapper;
	private CityMapper cityMapper;

	@Override
	public PostalCodeDTO savePostalCode(PostalCodeDTO codePostalDTO) {

		return postalCodeMapper.toDto(codePostalRepo.save(postalCodeMapper.toEntity(codePostalDTO)));
	}

	@Override
	public PostalCodeDTO getPostalCodeById(Long id) {

		PostalCode existPostalCode = codePostalRepo.findById(id).orElse(null);
		return postalCodeMapper.toDto(existPostalCode);
	}

	@Override
	public List<PostalCodeDTO> getAllPostalCode() {

		return codePostalRepo.findAll().stream().map(postalCodeMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public PostalCodeDTO updatePostalCode(Long id, PostalCodeDTO codePostalDTO) {

		PostalCode existPostalCode = codePostalRepo.findById(id).orElse(null);
		if (existPostalCode == null) {
			return null;
		}

		if (codePostalDTO.getPostalCode() != null) {
			existPostalCode.setPostalCode(codePostalDTO.getPostalCode());
		}

		if (codePostalDTO.getCity() != null) {
			existPostalCode.setCity(cityMapper.toEntity(codePostalDTO.getCity()));
		}

		return postalCodeMapper.toDto(codePostalRepo.save(existPostalCode));
	}

	@Override
	public void deletePostalCode(Long id) {

		codePostalRepo.deleteById(id);

	}

}