package com.RNE.request.dto.mappers;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.RNE.request.dto.RequestDTO;
import com.RNE.request.entities.Organization;
import com.RNE.request.entities.Request;

@Component
public class RequestMapperImpl implements RequestMapper {

	private static final RequestMapper INSTANCE = Mappers.getMapper(RequestMapper.class);

	@Override
	public RequestDTO toDto(Request request) {
		if (request == null) {
			return null;
		}
		

		RequestDTO requestDTO = new RequestDTO();
		requestDTO.setId(request.getId());
		requestDTO.setDeadline(request.getDeadline());
		requestDTO.setDateOfSent(request.getDateOfSent());
		requestDTO.setTypeRegister(request.getTypeRegister());
		requestDTO.setStatusRequest(request.getStatusRequest());

		// Populate organizationDTO object
		Organization organization = request.getOrganization();
		if (organization != null) {
			requestDTO.setOrganizationId(organization.getId());
		}

		return requestDTO;
	}

	@Override
	public Request toEntity(RequestDTO requestDTO) {
		if (requestDTO == null) {
			return null;
		}

		Request request = new Request();
		request.setId(requestDTO.getId());
		request.setDeadline(requestDTO.getDeadline());
		request.setDateOfSent(requestDTO.getDateOfSent());
		request.setTypeRegister(requestDTO.getTypeRegister());
		request.setStatusRequest(requestDTO.getStatusRequest());

		// Populate Organization object
		Long organizationId = requestDTO.getOrganizationId();
		if (organizationId != null) {
			Organization organization = new Organization();
			organization.setId(organizationId);
			request.setOrganization(organization);
		}

		return request;
	}

	public static RequestMapper getInstance() {
		return INSTANCE;
	}
}