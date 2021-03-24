package com.pactera.ptil.web.service.exception.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactera.ptil.web.mapper.ExceptionLogMapper;
import com.pactera.ptil.web.pojo.ExceptionLogEntity;
import com.pactera.ptil.web.service.exception.ExceptionLogService;


/**
 * 
* @ClassName: ExceptionLogServiceImpl  
* @author Zhi.WZ.Wang
* @date 2021/03/20 
*
 */
@Service
public class ExceptionLogServiceImpl implements ExceptionLogService {

	@Autowired
	private ExceptionLogMapper exceptionLogMapper;

    @Override
    public void addExceptionLog(Exception e) {
        ExceptionLogEntity exceptionLogEntity = new ExceptionLogEntity();
        exceptionLogEntity.setMessage(getExceptionStaclTrace(e));
        exceptionLogEntity.setTime(new Date());
        exceptionLogMapper.saveExceptionLog(exceptionLogEntity);
    }

	private String getExceptionStaclTrace(Exception e) {
        e.printStackTrace();
        return e.getLocalizedMessage();
    }
    
}
