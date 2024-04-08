package com.RNE.referentiel.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.dto.ArticleDTO;
import com.RNE.referentiel.dto.SectionDTO;
import com.RNE.referentiel.dto.StatusDTO;

import com.RNE.referentiel.entities.Section;

import com.RNE.referentiel.repositories.SectionRepository;
import com.RNE.referentiel.serviceInterface.SectionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SectionServiceImpl implements SectionService {

    private SectionRepository sectionRepo;

    // service for creating a new section
    @Override
    public SectionDTO saveSection(SectionDTO sectionDTO) {

        Section section = new Section();
        section.setSectionCode(sectionDTO.getSectionCode());
        section.setSectionTitleFr(sectionDTO.getSectionTitleFr());
        section.setSectionTiteAr(sectionDTO.getSectionTiteAr());
        section.setActivation(sectionDTO.getActivation());
        section.setStatus(sectionDTO.getStatus().stream()
                .map(StatusDTO::convertDtoToEntity)
                .collect(Collectors.toSet()));
        section.setArticles(sectionDTO.getArticles().stream()
                .map(ArticleDTO::convertDtoToEntity)
                .collect(Collectors.toList()));

        section = sectionRepo.save(section);

        return SectionDTO.convertEntityToDto(section);
    }

    // get list of section
    @Override
    public List<SectionDTO> getAllSections() {

        List<Section> sections = sectionRepo.findAll();
        return sections.stream()
                .map(SectionDTO::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SectionDTO getSectionByCode(String sectionCode) {
        Optional<Section> section = sectionRepo.findById(sectionCode);
        return section.map(SectionDTO::convertEntityToDto).orElse(null);
    }

    //update section service
    @Override
    public SectionDTO updateSection(String sectionCode, SectionDTO sectionDTO) {

        Section existSection = sectionRepo.findById(sectionCode).orElse(null);
        if (existSection == null) {
            return null;
        }

        existSection.setSectionTitleFr(sectionDTO.getSectionTitleFr());
        existSection.setSectionTiteAr(sectionDTO.getSectionTiteAr());
        existSection.setActivation(sectionDTO.getActivation());
        existSection.setStatus(sectionDTO.getStatus().stream()
                .map(StatusDTO::convertDtoToEntity)
                .collect(Collectors.toSet()));
        existSection.setArticles(sectionDTO.getArticles().stream()
                .map(ArticleDTO::convertDtoToEntity)
                .collect(Collectors.toList()));

        sectionRepo.save(existSection);

        return SectionDTO.convertEntityToDto(existSection);
    }

    @Override
    public List<SectionDTO> getActivatedSection() {

        List<Section> sections = sectionRepo.getActivatedSection();
        return sections.stream()
                .map(SectionDTO::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSection(String sectionCode) {
        sectionRepo.deleteById(sectionCode);
    }

}