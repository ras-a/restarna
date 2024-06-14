package jp.co.creambakery.config;

import org.springframework.context.annotation.Configuration;
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
		configurer.addPathPrefix("/session", HandlerTypePredicate.forBasePackage("jp.co.creambakery.controller.session"));
	}
	
	@Override
	public void addResourceHandlers(@NonNull ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
		.addResourceLocations("classpath:/static/");
	}
}
