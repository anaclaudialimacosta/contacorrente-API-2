package com.db1.contaCorrente;
import org.junit.Assert;
import org.junit.Test;

import com.db1.contaCorrente.ContaCorrente;

public class ContaCorrenteTest {
	
	@Test
	public void deveRetornarErroQuandoInformadoAgenciaInvalida() {
		String mensagem = null;
		try {
			ContaCorrente conta = new ContaCorrente (null, "012394", "Ana");
			
		}catch(RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertNotNull(mensagem);
		Assert.assertEquals("Deve ser informada uma agência válida", mensagem);
	}
	
	@Test
	public void deveRetornarErroQuandoInformadoNumeroInvalido() {
		String mensagem = null;
		try {
			ContaCorrente conta = new ContaCorrente ("12345", null, "Ana");
			
		}catch(RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertNotNull(mensagem);
		Assert.assertEquals("Deve ser informado um número válido", mensagem);
	}
	
	@Test
	public void deveRetornarErroQuandoInformadoClienteInvalido() {
		String mensagem = null;
		try {
			ContaCorrente conta = new ContaCorrente ("12345", "123456", " ");
			
		}catch(RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertNotNull(mensagem);
		Assert.assertEquals("Deve ser informado um cliente válido", mensagem);
	}
	
	@Test
	public void deveRetornarConstrutorCompleto() {
		ContaCorrente conta = new ContaCorrente ("12345", "123456", "Ana");
		Assert.assertEquals("12345", conta.getAgencia());
		Assert.assertEquals("123456", conta.getNumero());
		Assert.assertEquals("Ana", conta.getCliente());
		Assert.assertEquals(0, conta.getSaldo(), 0.0000001);
		Assert.assertTrue(conta.getHistorico().size()==0);
	}
	
	
}
