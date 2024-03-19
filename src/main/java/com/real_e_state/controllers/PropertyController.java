package com.real_e_state.controllers;

import com.real_e_state.payloads.ApiResponse;
import com.real_e_state.payloads.PropertyDto;
import com.real_e_state.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/property")
public class PropertyController {
	@Autowired
	private PropertyService propertyservice;

	// POST-Create Property

	@PostMapping("/")
	public ResponseEntity<PropertyDto> createProperty(@RequestBody PropertyDto propertyDto) {
		PropertyDto createPropertyDto = this.propertyservice.createProperty(propertyDto);
		return new ResponseEntity<>(createPropertyDto, HttpStatus.CREATED);
	}

	// PUT-update Property

	@PutMapping("/{Id}")
	public ResponseEntity<PropertyDto> updateProperty(@RequestBody PropertyDto propertyDto,
			@PathVariable("Id") Integer Id) {
		PropertyDto updateProperty = this.propertyservice.updateProperty(propertyDto, Id);
		return ResponseEntity.ok(updateProperty);
	}

	// DELETE-delete Property
	@DeleteMapping("/{Id}")
	public ResponseEntity<ApiResponse> DeleteUser(@PathVariable("Id") Integer Id) {
		this.propertyservice.deleteProperty(Id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Property Deleted Successfully",true), HttpStatus.OK);
	}

	// GET-List OF Property
	@GetMapping("/")
	public ResponseEntity<List<PropertyDto>> getAllUsers() {
		return ResponseEntity.ok(this.propertyservice.getAllProperty());

	}

	// Get- Property By Id
	@GetMapping("/{Id}")
	public ResponseEntity<PropertyDto> getSingleUsers(@PathVariable Integer Id) {
		return ResponseEntity.ok(this.propertyservice.getPropertyById(Id));
	}

}
