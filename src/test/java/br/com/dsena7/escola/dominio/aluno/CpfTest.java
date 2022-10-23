package br.com.dsena7.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CpfTest {

	@Test
	void testCPFInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new CPF(null));
		assertThrows(IllegalArgumentException.class, () -> new CPF(""));
//		assertThrows(IllegalArgumentException.class, () -> new CPF("00000011114243252353"));
	}

	
	@Test
	void testCPFValido() {
		String numCPF = "34985679655";
		CPF cpf = new CPF(numCPF);
		assertEquals(numCPF, cpf.getNumeroCPF());
	}
}
