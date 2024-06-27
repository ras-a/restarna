package jp.co.creambakery.config;

import java.time.*;
import java.time.format.*;
import java.util.*;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.*;
import org.springframework.format.*;
import org.springframework.format.datetime.*;
import org.springframework.lang.NonNull;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class PathConfig implements WebMvcConfigurer {
	@Override
	public void configurePathMatch(@NonNull PathMatchConfigurer configurer) {
		configurer.addPathPrefix("/item", HandlerTypePredicate.forBasePackage("jp.co.creambakery.controller.item"));
		configurer.addPathPrefix("/admin", HandlerTypePredicate.forBasePackage("jp.co.creambakery.controller.admin"));
		configurer.addPathPrefix("/user", HandlerTypePredicate.forBasePackage("jp.co.creambakery.controller.user"));
	}
	
	@Override
	public void addResourceHandlers(@NonNull ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**")
		.addResourceLocations("classpath:/static/");
	}

	@Override
	public void addFormatters(@NonNull final FormatterRegistry registry) {
		registry.addFormatter(new DateFormatter("yyyy/MM/dd"));
	}
}
