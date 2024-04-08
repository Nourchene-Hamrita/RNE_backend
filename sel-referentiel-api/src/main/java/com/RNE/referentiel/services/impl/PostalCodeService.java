package com.RNE.referentiel.services.impl;

import java.util.List;

import com.RNE.referentiel.entities.PostalCode;

public interface PostalCodeService {

	public PostalCode savePostalCode(PostalCode codePostal);

	public PostalCode getPostalCodeById(Long id);

	public List<PostalCode> getAllPostalCode();

	public PostalCode updatePostalCode(Long id, PostalCode codePostal);

	public void deletePostalCode(Long id);
}
