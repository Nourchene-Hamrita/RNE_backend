package com.RNE.referentiel.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.RNE.referentiel.dto.CodePostalDTO;

public interface CodePostalService {

	public CodePostalDTO saveCodePostal(CodePostalDTO codePostalDTO);

	public CodePostalDTO getCodePostalById(Long id);

	public List<CodePostalDTO> getAllCodePostal();

	public CodePostalDTO updateCodePostal(Long id, CodePostalDTO codePostalDTO);

	public void deleteCodePostal(Long id);

	public Page<CodePostalDTO> getPostalPagination(int pageNumber, int pageSize);
}