package com.real_e_state.services;

import java.util.List;

import com.real_e_state.payloads.PropertyDto;


public interface PropertyService {
	
	PropertyDto createProperty(PropertyDto property);

	PropertyDto updateProperty(PropertyDto property,Integer Id);

	PropertyDto getPropertyById(Integer Id );

    List<PropertyDto> getAllProperty();

    void deleteProperty(Integer Id );

}
