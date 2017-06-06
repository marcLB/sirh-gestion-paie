package dev.paie.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import dev.paie.service.InitialiserDonneesService;

@Configuration
@EnableWebMvc
@ComponentScan({"dev.paie.service, dev.paie.util, dev.paie.web.controller"})
@ImportResource("classPath:jeuxDeDonnees.xml")
@Import({DataSourceMySQLConfig.class, JpaConfig.class, ServicesConfig.class, SecurityConfig.class})
public class WebAppConfig {

	@Autowired InitialiserDonneesService init;

	@Bean
	public ViewResolver viewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
    
    @PostConstruct
    public void onPostConstruc() {
        init.initialiser();
    }
    
}