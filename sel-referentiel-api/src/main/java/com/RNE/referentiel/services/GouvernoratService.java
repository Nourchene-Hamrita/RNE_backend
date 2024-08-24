package com.RNE.referentiel.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.RNE.referentiel.dto.GouvernoratDTO;

public interface GouvernoratService {

	public GouvernoratDTO saveGouvernorat(GouvernoratDTO gouvernoratDTO);

	public List<GouvernoratDTO> getAllGouvernorats();

	public GouvernoratDTO getGouvernoratByCode(String code);

	public GouvernoratDTO updateGouvernorat(String code, GouvernoratDTO gouvernoratDTO);

	public List<GouvernoratDTO> getActivatedGouvernorats();

	public void deleteGouvernorat(String code);

	public Page<GouvernoratDTO> getGouvernoratPagination(int pageNumber, int pageSize);
}