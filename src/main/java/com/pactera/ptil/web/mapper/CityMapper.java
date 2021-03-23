package com.pactera.ptil.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.pactera.ptil.web.pojo.CityEntity;

@Repository
public interface CityMapper {


	@Select("select * from city")
	List<CityEntity> getAllCity();
	
	
}
