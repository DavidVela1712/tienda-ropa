package com.proyectotiendaropa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ProyectoTiendaRopaApplication implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoTiendaRopaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//String pass1 = "user";
		//System.out.println(passEncoder.encode(pass1));
	}
}
