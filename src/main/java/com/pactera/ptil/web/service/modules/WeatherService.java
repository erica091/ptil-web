package com.pactera.ptil.web.service.modules;

import com.pactera.ptil.web.dto.WeatherInfoDto;
import com.pactera.ptil.web.dto.WeatherResponseDto;

public interface WeatherService {

	WeatherInfoDto getWeatherInfo(WeatherResponseDto weatherResponseDto);


}
