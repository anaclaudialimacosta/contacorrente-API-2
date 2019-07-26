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
}
