package com.pactera.ptil.web.service.modules;

import java.util.List;

import com.pactera.ptil.web.dto.WeatherInfoDto;
import com.pactera.ptil.web.dto.WeatherResponseDto;
import com.pactera.ptil.web.pojo.CityEntity;

public interface WeatherService {

	WeatherInfoDto getWeatherInfo(WeatherResponseDto weatherResponseDto);

	List<CityEntity> getAllCity();

}
