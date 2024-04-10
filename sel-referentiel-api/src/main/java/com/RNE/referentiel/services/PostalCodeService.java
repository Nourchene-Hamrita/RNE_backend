package com.RNE.referentiel.services;

import java.util.List;

import com.RNE.referentiel.dto.PostalCodeDTO;

public interface PostalCodeService {

	public PostalCodeDTO savePostalCode(PostalCodeDTO codePostalDTO);

	public PostalCodeDTO getPostalCodeById(Long id);

	public List<PostalCodeDTO> getAllPostalCode();

	public PostalCodeDTO updatePostalCode(Long id, PostalCodeDTO codePostalDTO);

	public void deletePostalCode(Long id);
}