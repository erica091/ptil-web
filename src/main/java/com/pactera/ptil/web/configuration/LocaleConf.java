/********************************************************************
 *
 * Copyright (c) 2020 -  EY
 *
 ********************************************************************/
 
 
package com.pactera.ptil.web.configuration;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.pactera.ptil.web.utils.Constants;

@Configuration
public class LocaleConf implements WebMvcConfigurer {
	private final String MESSAGES_DIR = "classpath:/static/i18n/messages";
	private final String LANG = "lang";

	private String getLoaderPaths() {
		return MESSAGES_DIR;
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource commands = new ReloadableResourceBundleMessageSource();
		commands.setBasenames(getLoaderPaths(), MESSAGES_DIR);
		commands.setCacheSeconds(60);
		commands.setDefaultEncoding(Constants.UTF);

		return commands;
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		return slr;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName(LANG);
		return lci;
	}


}
