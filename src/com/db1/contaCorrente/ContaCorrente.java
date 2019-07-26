package com.db1.contaCorrente;

import java.util.List;

import com.db1.contaCorrente.infra.Verificadora;


public class ContaCorrente {

	private double saldo;
	private List<String> historico;
	private String cliente;
	private String numero;
	private String agencia;
	
	
	public ContaCorrente (String agencia,  String numero, String cliente) {
		
		Verificadora.VerificaStringValida(agencia, "Deve ser informada uma ag�ncia v�lida");
		Verificadora.VerificaStringValida(numero, "Deve ser informada uma n�mero v�lido");
		Verificadora.VerificaStringValida(cliente, "Deve ser informada um cliente v�lido");

		
		if((agencia != null) && !agencia.isEmpty()) {
			if (numero != null && !numero.isEmpty()) {
				if(!cliente.isEmpty() && cliente != null) {
					this.cliente = cliente;
					this.numero = numero;
					this.agencia = agencia;
				}
			} 
		}
		
	}
	
	
	
}