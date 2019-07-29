package com.db1.contaCorrente.infra;
import org.junit.Assert;
import org.junit.Test;

import com.db1.contaCorrente.infra.Verificadora;

public class VerificadoraTest {

	//Testes da String Válida
	
	@Test
	public void deveRetornarUmaExcessaoPorqueEstaNull() {
		String mensagem = null;
		try {
			Verificadora.verificaStringValida(null, "Valor não pode ser nulo");
			
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Valor não pode ser nulo", mensagem);
	} 
	
	@Test
	public void deveRetornarUmaExcessaoPorqueEstaVazio() {
		String mensagem = null;
		try {
			Verificadora.verificaStringValida("", "A String está Vazia");
			
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("A String está Vazia", mensagem);
		
	}
	
	@Test
	public void naoDeveRetornarUmaExcessaoString() {
		String mensagem = null;
		try {
			Verificadora.verificaStringValida("1234ana", "A String não pode ser vazia e nem null");
		}catch(RuntimeException e) {
			mensagem = e.getMessage();
		}
					
		Assert.assertNull(mensagem);
		
	}
	
	//Testes de Double maior que 0
	
	@Test
	public void deveRetornarExcessaoQuandoValorDoubleNull() {
		String mensagem = null;
		try {
			Verificadora.valorMaiorQueZero(null, "Valor deve ser maior que zero");
			
		}catch(RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor deve ser maior que zero", mensagem);
	}
	
	@Test
	public void deveRetornarExcessaoQuandoValorDoubleZero() {
		String mensagem = null;
		try {
			Verificadora.valorMaiorQueZero(0.0, "Valor deve ser maior que zero");
			
		}catch(RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor deve ser maior que zero", mensagem);
	}
	
	@Test
	public void deveRetornarExcessaoQuandoValorDoubleMenorQueZero() {
		String mensagem = null;
		try {
			Verificadora.valorMaiorQueZero(-0.2, "Valor deve ser maior que zero");
			
		}catch(RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor deve ser maior que zero", mensagem);
	}

	@Test
	public void naoDeveRetornarexcessaoDouble() {
		String mensagem = null;
		try {
			Verificadora.valorMaiorQueZero(2.0, "Valor deve ser maior que 0");
		}catch(RuntimeException e) {
			mensagem = e.getMessage();
		}
					
		Assert.assertNull(mensagem);
	}
	
	//Teste Double Maior Ou Igual a 0
	
	@Test
	public void naoDeveRetornarExcessaoQuandoValorIgualAZero() {
		String mensagem = null;
		try {
			Verificadora.valorMaiorOuIgualAZero(0.0, "Valor deve ser maior ou igual a 0");
		}catch(RuntimeException e) {
			mensagem = e.getMessage();
		}
					
		Assert.assertNull(mensagem);
	}
	
	@Test
	public void naoDeveRetornarExcessaoQuandoValorMaiorQueZero() {
		String mensagem = null;
		try {
			Verificadora.valorMaiorOuIgualAZero(1.0, "Valor deve ser maior ou igual a 0");
		}catch(RuntimeException e) {
			mensagem = e.getMessage();
		}
					
		Assert.assertNull(mensagem);
	}
	
	@Test
	public void deveRetornarExcessaoQuandoValorMenorQueZero() {
		String mensagem = null;
		try {
			Verificadora.valorMaiorOuIgualAZero(-0.2, "Valor deve ser maior ou igual a zero");
			
		}catch(RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor deve ser maior ou igual a zero", mensagem);
	}

}