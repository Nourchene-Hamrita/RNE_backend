package com.RNE.referentiel.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.entities.Section;
import com.RNE.referentiel.repositories.SectionRepository;
import com.RNE.referentiel.serviceInterface.SectionService;

import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class SectionServiceImpl implements SectionService {
     
	
	private SectionRepository sectionRepo;
	
	
	//service for creating a new section
	@Override
	
	public Section saveSection(Section section) {
		
		return sectionRepo.save(section);
		 
	}

   //get list of section
	@Override
	public List<Section> getAllSections() {
		
		return sectionRepo.findAll();
	}

@Override
public Section getSectionByCode(String sectionCode) {
	Optional<Section> section =sectionRepo.findById(sectionCode);
	return section.get();
}


//update section service
	@Override
	public Section updateSection(String sectionCode, Section section) {
		
		Section existSection=sectionRepo.findById(sectionCode).orElse(null);
		existSection.setSectionTitleFr(section.getSectionTitleFr());
		existSection.setSectionTiteAr(section.getSectionTiteAr());
		existSection.setActivation(section.getActivation());
		existSection.setStatuts(section.getStatuts());
		existSection.setArticles(section.getArticles());
		
		
		return sectionRepo.save(existSection);
	}


@Override
public List<Section> getActivatedSection() {
	
	return sectionRepo.getActivatedSection();
}
@Override
public void deleteSection(String sectionCode) {
	sectionRepo.deleteById(sectionCode);
}




	

}
