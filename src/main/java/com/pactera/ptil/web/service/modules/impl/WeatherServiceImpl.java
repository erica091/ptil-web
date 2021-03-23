package com.pactera.ptil.web.service.modules.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactera.ptil.web.dto.WeatherInfoDto;
import com.pactera.ptil.web.dto.WeatherResponseDto;
import com.pactera.ptil.web.mapper.CityMapper;
import com.pactera.ptil.web.pojo.CityEntity;
import com.pactera.ptil.web.service.modules.WeatherService;
import com.pactera.ptil.web.utils.Constants;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private CityMapper cityMapper;
	
	/**
	 * 
	* <p>Title: getWeatherInfo</p>  
	* <p>Description: Retrieve the current weather info</p>  
	* @param weatherResponseDto
	* @return  
	 */
	@Override
	public WeatherInfoDto getWeatherInfo(WeatherResponseDto weatherResponseDto) {
		WeatherInfoDto weatherInfoDto = new WeatherInfoDto();
		weatherInfoDto.setCity(weatherResponseDto.getName());
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FOMRAT, Locale.ENGLISH);
		weatherInfoDto.setUpdatedTime(sdf.format(new Date()));
		if (weatherResponseDto.getWeather() != null) {
			weatherInfoDto.setWeather(weatherResponseDto.getWeather().get(0).getDescription());
		}
		if (weatherResponseDto.getMain() != null && weatherResponseDto.getMain().getTemp() != null) {
			weatherInfoDto.setTemperature(weatherResponseDto.getMain().getTemp() + Constants.TEMPRATURE_UNIT);
		}
		if (weatherResponseDto.getWind() != null && weatherResponseDto.getWind().getSpeed() != null) {
			weatherInfoDto.setWind(weatherResponseDto.getWind().getSpeed() + Constants.WIND_SPEED_UNIT);
		}
		return weatherInfoDto;
	}

	@Override
	public List<CityEntity> getAllCity() {
		return cityMapper.getAllCity();
	}

}
