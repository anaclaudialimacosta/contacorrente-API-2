package com.db1.contaCorrente.infra;
import org.junit.Assert;
import org.junit.Test;

import com.db1.contaCorrente.infra.Verificadora;

public class VerificadoraTest {


	
	@Test
	public void deveRetornarUmaExcessaoPorqueEstaNull() {
		String mensagem = null;
		try {
			Verificadora.VerificaStringValida(null, "Valor n�o pode ser nulo");
			
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Valor n�o pode ser nulo", mensagem);
	} 
	
	@Test
	public void deveRetornarUmaExcessaoPorqueEstaVazio() {
		String mensagem = null;
		try {
			Verificadora.VerificaStringValida("", "A String est� Vazia");
			
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("A String est� Vazia", mensagem);
		
	}
	
	@Test
	public void naoDeveRetornarUmaExcessao() {
		String mensagem = null;
		try {
			Verificadora.VerificaStringValida("1234ana", "A String n�o pode ser vazia e nem null");
		}catch(RuntimeException e) {
			mensagem = e.getMessage();
		}
					
		Assert.assertNull(mensagem);
	}


}