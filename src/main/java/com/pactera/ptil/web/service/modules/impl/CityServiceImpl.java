package com.pactera.ptil.web.service.modules.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactera.ptil.web.mapper.CityMapper;
import com.pactera.ptil.web.pojo.CityEntity;
import com.pactera.ptil.web.service.modules.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityMapper cityMapper;
	

	@Override
	public List<CityEntity> getAllCity() {
		return cityMapper.getAllCity();
	}

}
