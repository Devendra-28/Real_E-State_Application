package com.real_e_state.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PropertyDto {
	
	private int id;

    private String brokerName;

    private String bhk_type;

    private String carpet_area;

    private String floor;

    private String location;

    private double price;

    private String property_type;
}
