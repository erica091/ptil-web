package com.pactera.ptil.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pactera.ptil.web.common.JsonResult;
import com.pactera.ptil.web.pojo.CityEntity;
import com.pactera.ptil.web.service.exception.ExceptionLogService;
import com.pactera.ptil.web.service.modules.CityService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	private CityService cityService;
	

	@Autowired
	private ExceptionLogService exceptionLogService;



	@ApiOperation(value = "get all cities", notes = "It's used to search all cities")
	@GetMapping("/getCityList")
	public JsonResult<List<CityEntity>> getCityList(){
		List<CityEntity> cityList = null;
		try {
			cityList = cityService.getAllCity();
		} catch (Exception e) {
			 exceptionLogService.addExceptionLog(e);
			return JsonResult.fail(e.getMessage());
		}
		return JsonResult.ok(cityList);
	}

}
