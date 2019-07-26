package com.db1.contaCorrente.infra;

public class Verificadora {
	
	public static void VerificaStringValida(String value, String message) {
		if(value == null || value.trim().isEmpty()) {
			throw new RuntimeException(message);
		}
	}
}
