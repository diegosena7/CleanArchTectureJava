package br.com.dsena7.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class EmailTest {

	@Test
	void testEmailInvalido() {
		assertThrows(IllegalArgumentException.class, () -> new Email(null));
		assertThrows(IllegalArgumentException.class, () -> new Email("invalido"));
		assertThrows(IllegalArgumentException.class, () -> new Email(""));
	}

	
	@Test
	void testEmailValido() {
		String emailTest = "diego.tjdosantos@gmail.com";
		Email email = new Email(emailTest);
		
		assertEquals(emailTest, email.getEnderecoEmail());
	}
}
