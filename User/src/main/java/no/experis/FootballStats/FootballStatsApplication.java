package no.experis.FootballStats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class FootballStatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballStatsApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean corsFilterRegistration(){
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(new CORSFilter());
		registrationBean.setName("CORS Filter");
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(1);
		return  registrationBean;
	}

}

