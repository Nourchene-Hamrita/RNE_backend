package com.RNE.referentiel.serviceInterface;

import java.util.List;

import com.RNE.referentiel.dto.SectionDTO;

public interface SectionService {

    public SectionDTO saveSection(SectionDTO sectionDTO);

    public List<SectionDTO> getAllSections();

    public SectionDTO getSectionByCode(String sectionCode);

    public SectionDTO updateSection(String sectionCode, SectionDTO sectionDTO);

    public List<SectionDTO> getActivatedSection();

    public void deleteSection(String sectionCode);
}
