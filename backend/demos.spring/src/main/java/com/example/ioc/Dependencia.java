package com.example.ioc;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
public class Dependencia {

	@Value("${mi.config.name:'no se'}")
	private String nombre;
	
	public Dependencia() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return nombre;
		
	}

}
