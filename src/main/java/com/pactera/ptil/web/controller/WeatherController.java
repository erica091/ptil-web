package com.pactera.ptil.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pactera.ptil.web.common.JsonResult;
import com.pactera.ptil.web.dto.WeatherInfoDto;
import com.pactera.ptil.web.dto.WeatherResponseDto;
import com.pactera.ptil.web.pojo.CityEntity;
import com.pactera.ptil.web.service.exception.ExceptionLogService;
import com.pactera.ptil.web.service.modules.WeatherService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/weatherApi")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ExceptionLogService exceptionLogService;
	
	@Value("${weather.api.url}")
	private String weatherApiUrl;

	@ApiOperation(value = "get current weather information interface", notes = "It's used to get the current weather of a city")
	@GetMapping("/getWeatherInfo")
	public JsonResult<WeatherInfoDto> getWeatherInfo(String city) {
		try {
			StringBuilder weatherUrl = new StringBuilder(weatherApiUrl);
			weatherUrl.append(city);
			WeatherResponseDto weatherResponseDto = restTemplate.getForObject(weatherUrl.toString(),
					WeatherResponseDto.class);
			if (weatherResponseDto != null) {
				return JsonResult.ok(weatherService.getWeatherInfo(weatherResponseDto));
			}
			return null;
		} catch (Exception e) {
			 //Store error log in the DB
			 exceptionLogService.addExceptionLog(e);
			return JsonResult.fail(e.getMessage());
		}
	}
	
	@ApiOperation(value = "get all cities", notes = "It's used to search all cities")
	@GetMapping("/getCityList")
	public JsonResult<List<CityEntity>> getCityList(){
		List<CityEntity> cityList = null;
		try {
			cityList = weatherService.getAllCity();
		} catch (Exception e) {
			 exceptionLogService.addExceptionLog(e);
			return JsonResult.fail(e.getMessage());
		}
		return JsonResult.ok(cityList);
	}

}
