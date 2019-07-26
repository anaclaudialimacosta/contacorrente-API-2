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
		
		Verificadora.VerificaStringValida(agencia, "Deve ser informada uma agência válida");
		Verificadora.VerificaStringValida(numero, "Deve ser informada uma número válido");
		Verificadora.VerificaStringValida(cliente, "Deve ser informada um cliente válido");

		
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