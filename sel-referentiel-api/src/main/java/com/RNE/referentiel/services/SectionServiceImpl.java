package com.RNE.referentiel.services;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.dto.ArticleDTO;
import com.RNE.referentiel.dto.SectionDTO;
import com.RNE.referentiel.dto.StatusDTO;

import com.RNE.referentiel.entities.Section;

import com.RNE.referentiel.repositories.SectionRepository;
import com.RNE.referentiel.services.impl.SectionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SectionServiceImpl implements SectionService {

    private SectionRepository sectionRepo;

    // service for creating a new section
    @Override
    public SectionDTO saveSection(SectionDTO sectionDTO) {

        Section section = new Section();
        section.setCode(sectionDTO.getCode());
        section.setTitleAr(sectionDTO.getTitleAr());
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
    public SectionDTO getSectionByCode(String code) {
        Optional<Section> section = sectionRepo.findById(code);
        return section.map(SectionDTO::convertEntityToDto).orElse(null);
    }

    //update section service
    @Override
    public SectionDTO updateSection(String code, SectionDTO sectionDTO) {

        Section existSection = sectionRepo.findById(code).orElse(null);
        if (existSection == null) {
            return null;
        }

        existSection.setTitleFr(sectionDTO.getTitleFr());
        existSection.setTitleAr(sectionDTO.getTitleAr());
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
    public void deleteSection(String code) {
        sectionRepo.deleteById(code);
    }

}