package com.real_e_state.service_impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.real_e_state.entities.Property;
import com.real_e_state.exception.ResourceNotFoundException;
import com.real_e_state.payloads.PropertyDto;
import com.real_e_state.repository.PropertyRepo;
import com.real_e_state.services.PropertyService;

@Service
public class PropertySeviceImpl implements PropertyService {
	@Autowired
	private PropertyRepo propertyRepo;

	@Override
	public PropertyDto createProperty(PropertyDto propertyDto) {
		 Property property1= this.DtoToProperty(propertyDto);
		 Property savedproperty=this.propertyRepo.save(property1);
	        return this.PropertyToDto(savedproperty);
	}

	@Override
	public PropertyDto updateProperty(PropertyDto propertyDto, Integer Id) {
		Property props=this.propertyRepo.findById(Id).
				orElseThrow(()->new ResourceNotFoundException("Property","Id",Id));
		

	//	props.setId(Id);
		props.setBrokerName(propertyDto.getBrokerName());
		props.setBhk_type(propertyDto.getBhk_type());
		props.setCarpet_area(propertyDto.getCarpet_area());
		props.setFloor(propertyDto.getFloor());
		props.setLocation(propertyDto.getLocation());
		props.setPrice(propertyDto.getPrice());
		props.setProperty_type(propertyDto.getProperty_type());
		Property saveupdate = propertyRepo.save(props);
		PropertyDto propertyDto1 = this.PropertyToDto(saveupdate);

		return propertyDto1;
	}

	@Override
	public PropertyDto getPropertyById(Integer Id) {
		Property pro=this.propertyRepo.findById(Id).
				orElseThrow(()->new ResourceNotFoundException("Property","Id",Id));
		return this.PropertyToDto(pro);
	}

	@Override
	public List<PropertyDto> getAllProperty() {
		List<Property> properties = this.propertyRepo.findAll();
		List<PropertyDto> proDtos=properties.stream().map(pro-> this.PropertyToDto(pro)).collect(Collectors.toList());
		
		return proDtos;
	}

	@Override
	public void deleteProperty(Integer Id) {
		Property user=this.propertyRepo.findById(Id).
				orElseThrow(()->new ResourceNotFoundException("User","Id",Id));
			  this.propertyRepo.delete(user);
	}
	
	private Property DtoToProperty(PropertyDto propertyDto){
		Property prop=new Property();
		
		prop.setId(propertyDto.getId());
		prop.setBrokerName(propertyDto.getBrokerName());
		prop.setBhk_type(propertyDto.getBhk_type());
		prop.setCarpet_area(propertyDto.getCarpet_area());
		prop.setFloor(propertyDto.getFloor());
		prop.setLocation(propertyDto.getLocation());
		prop.setPrice(propertyDto.getPrice());
		prop.setProperty_type(propertyDto.getProperty_type());
        return prop;
    }
    private PropertyDto PropertyToDto(Property property){
    	PropertyDto propertyDto=new PropertyDto();
    	propertyDto.setId(property.getId());
    	propertyDto.setBrokerName(property.getBrokerName());
    	propertyDto.setBhk_type(property.getBhk_type());
    	propertyDto.setCarpet_area(property.getCarpet_area());
    	propertyDto.setFloor(property.getFloor());
    	propertyDto.setLocation(property.getLocation());
    	propertyDto.setPrice(property.getPrice());
    	propertyDto.setProperty_type(property.getProperty_type());
        return propertyDto;
    }

}
