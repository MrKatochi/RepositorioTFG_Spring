package com.tfgdaw.spring.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;

import org.springframework.context.annotation.Configuration;

import com.tfgdaw.spring.upload.storage.StorageProperties;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@EnableConfigurationProperties(StorageProperties.class)
public class ConfiguracionAuditoria {

}

/*
 * @Configuration
 * 
 * @EnableConfigurationProperties(StorageProperties.class) public class MyConfig
 * {
 * 
 * @Bean public MessageSource messageSource() {
 * ReloadableResourceBundleMessageSource messageSource = new
 * ReloadableResourceBundleMessageSource();
 * 
 * messageSource.setBasename("classpath:errors");
 * messageSource.setDefaultEncoding("UTF-8"); return messageSource; }
 * 
 * @Bean public LocalValidatorFactoryBean getValidator() {
 * LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
 * bean.setValidationMessageSource(messageSource()); return bean; }
 * 
 * }
 */
