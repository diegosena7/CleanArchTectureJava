package br.com.dsena7.escola.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.dsena7.escola.dominio.aluno.Aluno;
import br.com.dsena7.escola.dominio.aluno.CPF;
import br.com.dsena7.escola.infra.aluno.AlunoRepositoryMemoria;

class MatricularAlunoTest {

	@Test
	void alunoDeveSerPersistido() {
		AlunoRepositoryMemoria repository = new AlunoRepositoryMemoria();
		MatricularAluno useCase = new MatricularAluno(repository);
		
		MatricularAlunoDTO  dto = new MatricularAlunoDTO("Diego", 
				"36875965463", 
				"diego.dsena7@gmail.com");
		
		useCase.matricular(dto);
		
		Aluno encontrado = repository.buscarPorCpf(new CPF("36875965463"));
		assertEquals(encontrado, "Diego");
	}

}
