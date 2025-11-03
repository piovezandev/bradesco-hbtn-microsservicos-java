package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/messages")
public class MessageResource {
	
	private static final int TAMANHO_LIMITE = 15;

	@GetMapping("/simpleMessageWelcome")
	public String simpleMessageWelcome() {
		return "BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!";
	}
	
	@GetMapping("/login")
	public String login(@RequestParam(name = "user") String user,
			@RequestParam(name = "password") String password) {
		
		if(user.isEmpty() || password.isEmpty()) {
			return "USUÁRIO E SENHA NÃO INFORMADOS";
		}
		
		if(user.length() > TAMANHO_LIMITE  || password.length() > TAMANHO_LIMITE) {
			return "USUÁRIO E SENHA INVÁLIDOS";
		}
		
		return "LOGIN EFETUADO COM SUCESSO !!!";
	}
	
}
