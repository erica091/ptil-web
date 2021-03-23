package com.pactera.ptil.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pactera.ptil.web.common.JsonResult;
import com.pactera.ptil.web.dto.OwnerDto;
import com.pactera.ptil.web.service.exception.ExceptionLogService;
import com.pactera.ptil.web.service.modules.PetsService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/petsApi")
public class PetsController {

	@Autowired
	private PetsService petsService;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ExceptionLogService exceptionLogService;

	@Value("${pets.api.url}")
	private String petsApiUrl;

	@ApiOperation(value = "get the cat list interface", notes = "It's used to output a list of all the cats in alphabetical order under a heading of the gender of their owners")
	@GetMapping("/getCatsList")
	public JsonResult<Map<String, List<String>>> getCatsList() {
		try {
			OwnerDto[] body = restTemplate.getForObject(petsApiUrl, OwnerDto[].class);
			if (body != null && body.length > 0) {
				return JsonResult.ok(petsService.getCatsList(body));
			}
			return null;
		} catch (Exception e) {
			exceptionLogService.addExceptionLog(e);
			return JsonResult.fail(e.getMessage());
		}
	}

}
