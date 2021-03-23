package com.pactera.ptil.web.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import com.pactera.ptil.web.pojo.ExceptionLogEntity;

@Repository
public interface ExceptionLogMapper {


	@Insert("insert into exception_log(message,time) value(#{message}, #{time})")
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	void saveExceptionLog(ExceptionLogEntity exceptionLogEntity);
	
	
}
