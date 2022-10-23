package br.com.dsena7.escola.aplicacao.aluno.matricular;

import br.com.dsena7.escola.dominio.aluno.Aluno;
import br.com.dsena7.escola.dominio.aluno.CPF;
import br.com.dsena7.escola.dominio.aluno.Email;

public class MatricularAlunoDTO {
	
	private String nomeAluno;
	private String cpfAluno;
	private String emailAluno;
	
	public MatricularAlunoDTO(String nomeAluno, String cpfAluno, String emailAluno) {
		this.nomeAluno = nomeAluno;
		this.cpfAluno = cpfAluno;
		this.emailAluno = emailAluno;
	}
	
	public Aluno criarALuno() {
		return new Aluno(nomeAluno, new CPF(cpfAluno), new Email(emailAluno));
	}
}
