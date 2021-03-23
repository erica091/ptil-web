 package com.pactera.ptil.web.dto;

import java.util.List;

import lombok.Data;

@Data
public class WeatherResponseDto {
	 
	 private String name;
	 private List<WeatherDto> weather;
	 private MainDto main;
	 private WindDto wind;

}
