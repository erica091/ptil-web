package com.pactera.ptil.web.service.modules;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pactera.ptil.web.PtilWebApplication;
import com.pactera.ptil.web.dto.MainDto;
import com.pactera.ptil.web.dto.WeatherDto;
import com.pactera.ptil.web.dto.WeatherInfoDto;
import com.pactera.ptil.web.dto.WeatherResponseDto;
import com.pactera.ptil.web.dto.WindDto;
import com.pactera.ptil.web.utils.Constants;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = PtilWebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WeatherServiceTest {

	@Autowired
	private WeatherService weatherService;
	
	WeatherResponseDto weatherResponseDto = new WeatherResponseDto();
	
	@Before
	public void init(){
		MainDto main = new MainDto();
		main.setHumidity("88");
		main.setPressure("1021");
		main.setTemp("18.86");
		weatherResponseDto.setMain(main);
		weatherResponseDto.setName("Sydney");
		List<WeatherDto> weatherList = new ArrayList<>();
		WeatherDto weatherDto = new WeatherDto();
		weatherDto.setDescription("heavy intensity rain");
		weatherDto.setIcon("10d");
		weatherDto.setId(502);
		weatherDto.setMain("Rain");
		weatherList.add(weatherDto);
		weatherResponseDto.setWeather(weatherList);
		WindDto wind = new WindDto();
		wind.setDeg("50");
		wind.setSpeed("8.23");
		weatherResponseDto.setWind(wind);
    }
	
	@Test
	public void getCatsListTest() {
		
		WeatherInfoDto weatherInfo = weatherService.getWeatherInfo(weatherResponseDto);
		WeatherInfoDto expectResult = new WeatherInfoDto();
		expectResult.setCity("Sydney");
		expectResult.setTemperature("18.86" + Constants.TEMPRATURE_UNIT);
		expectResult.setUpdatedTime(weatherInfo.getUpdatedTime());
		expectResult.setWeather("heavy intensity rain");
		expectResult.setWind("8.23" + Constants.WIND_SPEED_UNIT);
		assertEquals(expectResult, weatherInfo);  
	}


}
