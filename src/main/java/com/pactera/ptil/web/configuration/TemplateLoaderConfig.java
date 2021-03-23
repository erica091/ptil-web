/**
 * Copyright (C), 2018-2019,
 * FileName: TamplateLoader
 * Author:   Jian.Yang
 * Date:     2019/12/17 17:40
 * Description: 模板加载路径设置
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pactera.ptil.web.configuration;

import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.pactera.ptil.web.utils.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
* @ClassName: TemplateLoaderConfig  
* @Description: Template loading path setting
* @author Zhi.WZ.Wang
* @date 2021/03/19 
*
 */
@Configuration
public class TemplateLoaderConfig implements WebMvcConfigurer {
	
	private final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private final String SUFFIX = ".ftl";
	private final String TEMPLATE_PATH = "classpath:/templates";
	
	
    @Bean
    public ViewResolver viewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setCache(true);
        resolver.setPrefix("");
        resolver.setSuffix(SUFFIX);
        resolver.setContentType(CONTENT_TYPE);
        return resolver;
    }

    @Bean
    public FreeMarkerConfigurer freemarkerConfig() {
        String[] templatePath={TEMPLATE_PATH};
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPaths(templatePath);
        configurer.setDefaultEncoding(Constants.UTF);
        return configurer;
    }

}
