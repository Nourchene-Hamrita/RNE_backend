package com.RNE.referentiel.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.dto.StatusDTO;
import com.RNE.referentiel.dto.mappers.StatusMapper;
import com.RNE.referentiel.entities.Section;
import com.RNE.referentiel.entities.Status;

import com.RNE.referentiel.repositories.SectionRepository;
import com.RNE.referentiel.repositories.StatusRepository;
import com.RNE.referentiel.services.StatusService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatusServiceImpl implements StatusService {

	private StatusRepository statusRepository;
	private StatusMapper statusMapper;
	private SectionRepository sectionRepository;

	// save status service
	@Override
	public StatusDTO saveStatus(StatusDTO statusDTO) {

		Status status = statusMapper.toEntity(statusDTO);
		if (statusDTO.getSectionCodes() != null) {
			List<Section> sections = sectionRepository.findAllById(statusDTO.getSectionCodes());
			status.setSections(sections);
		}
		return statusMapper.toDto(statusRepository.save(status));
	}

	// get status by code service
	@Override
	public StatusDTO getStatusByCode(String code) {
		Optional<Status> existStatus = statusRepository.findById(code);
		return existStatus.map(statusMapper::toDto).orElse(null);
	}

	// get all statuses services
	@Override
	public List<StatusDTO> getAllStatus() {

		return statusRepository.findAll().stream().map(statusMapper::toDto).collect(Collectors.toList());
	}

	// update status service
	@Override
	public StatusDTO updateStatus(String code, StatusDTO statusDTO) {
		Status existStatus = statusRepository.findById(code).orElse(null);
		if (existStatus == null) {
			return null;
		}

		existStatus.setTitle(statusDTO.getTitle());
		existStatus.setDescription(statusDTO.getDescription());
		existStatus.setCategory(statusDTO.getCategory());

		return statusMapper.toDto(statusRepository.save(existStatus));
	}

	@Override
	public void deleteStatus(String code) {
		statusRepository.deleteById(code);
	}

}