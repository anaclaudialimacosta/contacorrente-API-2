package com.db1.contaCorrente;
import org.junit.Assert;
import org.junit.Test;

import com.db1.contaCorrente.ContaCorrente;

public class ContaCorrenteTest {
	
	//Testes do Construtor 
	
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
	
	//Testes Depositar
	
	@Test
	public void deveRetornarExcecaoQuandoValorDepositadoInvalido() {
		ContaCorrente conta = new ContaCorrente ("12345", "123456", "Ana");
		String mensagem = null;
		try {
			conta.depositar(-0.1);
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor depositado deve ser maior que 0", mensagem);
		Assert.assertTrue(conta.getHistorico().isEmpty());
		Assert.assertEquals(0.0, conta.getSaldo(), 0.0001);
		
	}
	
	@Test
	public void deveRetornarExcecaoQuandoValorDepositadoNull() {
		ContaCorrente conta = new ContaCorrente ("12345", "123456", "Ana");
		String mensagem = null;
		try {
			conta.depositar(null);
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor depositado deve ser maior que 0", mensagem);
		Assert.assertTrue(conta.getHistorico().isEmpty());
		Assert.assertEquals(0.0, conta.getSaldo(), 0.0001);
		
	}
	
	@Test
	public void deveDepositarValor() {
		ContaCorrente conta = new ContaCorrente ("12345", "123456", "Ana");
		conta.depositar(100.0);
		Assert. assertEquals("Deposito: 100.0", conta.getHistorico().get(0));
		Assert.assertEquals(100.0,conta.getSaldo(), 0.0001);		
		
	}
	
	//Testes Sacar
	
	@Test
	public void deveRetornarExcecaoQuandoValorSacadoNegativo() {
		ContaCorrente conta = new ContaCorrente ("12345", "123456", "Ana");
		conta.depositar(2.0); //Para retornar a excessão correta
		
		String mensagem = null;
		try {
			conta.sacar(-0.1);
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor sacado deve ser maior que 0", mensagem);
		Assert.assertTrue(conta.getHistorico().size() == 1);  //Por conta do deposito realizado acima
		Assert.assertEquals(2.0, conta.getSaldo(), 0.0001);
		
	}
	
	@Test
	public void deveRetornarExcecaoQuandoValorSacadoNulo() {
		ContaCorrente conta = new ContaCorrente ("12345", "123456", "Ana");
		String mensagem = null;
		try {
			conta.sacar(null);
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor sacado deve ser maior que 0", mensagem);
		Assert.assertTrue(conta.getHistorico().isEmpty());
		Assert.assertEquals(0.0, conta.getSaldo(), 0.0001);
		
	}
	
	@Test
	public void deveRetornarExcecaoQuandoValorSacadoZero() {
		ContaCorrente conta = new ContaCorrente ("12345", "123456", "Ana");
		String mensagem = null;
		try {
			conta.sacar(0.0);
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor sacado deve ser maior que 0", mensagem);
		Assert.assertTrue(conta.getHistorico().isEmpty());
		Assert.assertEquals(0.0, conta.getSaldo(), 0.0001);
		
	}
	
	@Test
	public void deveRetornarExcecaoQuandoValorComSaldoInsuficiente() {
		ContaCorrente conta = new ContaCorrente ("12345", "123456", "Ana");
		String mensagem = null;
		try {
			conta.sacar(2.0);
		} catch (RuntimeException e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals( "Saldo insuficiente para o saque", mensagem);
		Assert.assertTrue(conta.getHistorico().isEmpty());
		Assert.assertEquals(0.0, conta.getSaldo(), 0.0001);
	}
	
	@Test
	public void deveSacarValor() {
		ContaCorrente conta = new ContaCorrente ("12345", "123456", "Ana");
		conta.depositar(20.0);
		conta.sacar(2.0);
		
		Assert.assertTrue(conta.getHistorico().size() == 2);  //Por conta do deposito realizado acima
		Assert.assertEquals(18.0, conta.getSaldo(), 0.0001);
		Assert. assertEquals("Deposito: 20.0", conta.getHistorico().get(0));
		Assert. assertEquals("Saque: 2.0", conta.getHistorico().get(1));
		
	}
	
}
