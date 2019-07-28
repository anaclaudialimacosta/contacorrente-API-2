package com.db1.contaCorrente;

import java.util.ArrayList;
import java.util.List;

import com.db1.contaCorrente.infra.Verificadora;


public class ContaCorrente {

	private Double saldo;
	private List<String> historico;
	private String cliente;
	private String numero;
	private String agencia;
	
	
	public ContaCorrente (String agencia,  String numero, String cliente) {
		
		Verificadora.verificaStringValida(agencia, "Deve ser informada uma agência válida");
		Verificadora.verificaStringValida(numero, "Deve ser informado um número válido");
		Verificadora.verificaStringValida(cliente, "Deve ser informado um cliente válido");

		
		if((agencia != null) && !agencia.isEmpty()) {
			if (numero != null && !numero.isEmpty()) {
				if(!cliente.isEmpty() && cliente != null) {
					this.cliente = cliente;
					this.numero = numero;
					this.agencia = agencia;
				}
			} 
		}
		
		this.saldo = 0.0;
		this.historico = new ArrayList<>();	
		
	}
	
	public void depositar (Double valor) {
		Verificadora.valorMaiorQueZero(valor, "Valor depositado deve ser maior que 0");
		
		this.saldo += valor;
		this.historico.add("Deposito: " + valor);
		
	}
	
	public void sacar (Double valor) {
		
		Verificadora.valorMaiorQueZero(valor, "Valor sacado deve ser maior que 0");
		Verificadora.valorMaiorQueZero((this.saldo - valor), "Saldo insuficiente para o saque");
		
		this.saldo -= valor;
		this.historico.add("Saque: " + valor);
		
	}
	
	
	public String getCliente() {
		return this.cliente;
	}
	public String getAgencia() {
		return this.agencia;
	}
	public String getNumero() {
		return this.numero;
	}
	public List<String> getHistorico(){
		return this.historico;
	}
	public Double getSaldo() {
		return this.saldo;
	}
	
	

	
	
}