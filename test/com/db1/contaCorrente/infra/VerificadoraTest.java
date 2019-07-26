package com.db1.contaCorrente.infra;
import org.junit.Assert;
import org.junit.Test;

import com.db1.contaCorrente.infra.Verificadora;

public class VerificadoraTest {


	
	@Test
	public void deveRetornarUmaExcessaoPorqueEstaNull() {
		String mensagem = null;
		try {
			Verificadora.VerificaStringValida(null, "Valor não pode ser nulo");
			
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		
		Assert.assertEquals("Valor não pode ser nulo", mensagem);
	} 
	
	@Test
	public void deveRetornarUmaExcessaoPorqueEstaVazio() {
		String mensagem = null;
		try {
			Verificadora.VerificaStringValida("", "A String está Vazia");
			
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("A String está Vazia", mensagem);
		
	}
	
	@Test
	public void naoDeveRetornarUmaExcessao() {
		String mensagem = null;
		try {
			Verificadora.VerificaStringValida("1234ana", "A String não pode ser vazia e nem null");
		}catch(RuntimeException e) {
			mensagem = e.getMessage();
		}
					
		Assert.assertNull(mensagem);
	}


}