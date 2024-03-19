package com.real_e_state.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.real_e_state.entities.Property;

public interface  PropertyRepo extends JpaRepository<Property, Integer> {

}
