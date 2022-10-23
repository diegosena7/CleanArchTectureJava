package br.com.dsena7.escola.dominio.aluno;

import java.util.List;

public interface AlunoRepository {

	void matriularAlunos(Aluno aluno);
	
	Aluno buscarPorCpf(CPF cpf);
	
	List<Aluno> listarTodosOsAlunosMatriculados();
}
