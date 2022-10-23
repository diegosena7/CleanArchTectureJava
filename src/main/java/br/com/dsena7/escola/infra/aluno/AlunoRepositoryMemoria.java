package br.com.dsena7.escola.infra.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.dsena7.escola.dominio.aluno.Aluno;
import br.com.dsena7.escola.dominio.aluno.AlunoNaoEcontradoException;
import br.com.dsena7.escola.dominio.aluno.AlunoRepository;
import br.com.dsena7.escola.dominio.aluno.CPF;

public class AlunoRepositoryMemoria implements AlunoRepository{
	
	List<Aluno> listaAlunos = new ArrayList<Aluno>();

	@Override
	public void matriularAlunos(Aluno aluno) {
		this.listaAlunos.add(aluno);
	}

	@Override
	public Aluno buscarPorCpf(CPF cpf) {
		return this.listaAlunos.stream()
				.filter(aluno -> aluno.getCpf().equals(cpf.getNumeroCPF()))
				.findFirst()
				.orElseThrow(() -> new AlunoNaoEcontradoException(cpf));
	}

	@Override
	public List<Aluno> listarTodosOsAlunosMatriculados() {
		return this.listaAlunos;
	}

}
