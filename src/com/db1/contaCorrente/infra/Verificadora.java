package com.db1.contaCorrente.infra;

public class Verificadora {
	
	public static void verificaStringValida(String value, String message) {
		if(value == null || value.trim().isEmpty()) {
			throw new RuntimeException(message);
		}
	}
	
	public static void valorMaiorQueZero(Double value, String message) {
		if(value ==null || ( value<=0.0)) {
			throw new RuntimeException(message);
		}
	}
	
	public static void valorMaiorOuIgualAZero(Double value, String message) {
		if(value==null || value<0.0) {
			throw new RuntimeException(message);
		}
	}
	

	
}
