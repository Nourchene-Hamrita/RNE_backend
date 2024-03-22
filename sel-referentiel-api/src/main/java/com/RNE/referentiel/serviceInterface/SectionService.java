package com.RNE.referentiel.serviceInterface;

import java.util.List;

import com.RNE.referentiel.entities.Section;

public interface SectionService {
  
	public Section saveSection(Section section);
	
	public List<Section>getAllSections();
	
	public Section getSectionByCode(String codeSection);
	
	public Section updateSection(String codeSection,Section section);
	
	public List<Section>getActivatedSection();
	
	public void deleteSection(String codeSection); 
}
