package com.RNE.referentiel.services;

import java.util.List;

import com.RNE.referentiel.dto.GouverneratDTO;

public interface GouverneratService {

	public GouverneratDTO saveGouvernerat(GouverneratDTO gouverneratDTO);

	public List<GouverneratDTO> getAllGouvernerats();

	public GouverneratDTO getGouverneratByCode(String code);

	public GouverneratDTO updateGouvernerat(String code, GouverneratDTO gouverneratDTO);

	public List<GouverneratDTO> getActivatedGouvernerats();

	public void deleteGouvernerat(String code);
}