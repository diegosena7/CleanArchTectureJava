package br.com.dsena7.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.dsena7.escola.dominio.aluno.Telefone;

class TelefoneTest {

	@Test
	void testTelefoneInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Telefone(null, ""));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("invalido", "19191919"));
		assertThrows(IllegalArgumentException.class, () -> new Telefone("", "2"));
	}

	
	@Test
	void testTelefoneValido() {
		String numTel = "947168617";
		String dddTel = "11";
		Telefone tel = new Telefone(numTel, dddTel);
		assertEquals(numTel, tel.getNumero());
		assertEquals(dddTel, tel.getDdd());
	}
}
