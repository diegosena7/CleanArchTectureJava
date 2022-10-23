package br.com.dsena7.escola.aplicacao.aluno.matricular;

import br.com.dsena7.escola.dominio.aluno.Aluno;
import br.com.dsena7.escola.dominio.aluno.AlunoRepository;

public class MatricularAluno {

	private final AlunoRepository repositorio;
	
	public MatricularAluno(AlunoRepository repository) {
		this.repositorio = repository;
	}
	
	public void matricular(MatricularAlunoDTO aluno) {
		Aluno novoAluno = aluno.criarALuno();
		repositorio.matriularAlunos(novoAluno);
	}
}
