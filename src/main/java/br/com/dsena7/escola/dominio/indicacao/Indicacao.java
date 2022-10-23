package br.com.dsena7.escola.dominio.indicacao;

import java.time.LocalDateTime;

import br.com.dsena7.escola.dominio.aluno.Aluno;

public class Indicacao {
	
	private Aluno alunoIndicado;
	private Aluno alunoIndicante;
	private LocalDateTime dataIndicacao;
	
	public Indicacao(Aluno alunoIndicado, Aluno alunoIndicante) {
		this.alunoIndicado = alunoIndicado;
		this.alunoIndicante = alunoIndicante;
		this.dataIndicacao = LocalDateTime.now();
	}

	public Aluno getAlunoIndicado() {
		return alunoIndicado;
	}

	public Aluno getAlunoIndicante() {
		return alunoIndicante;
	}

	public LocalDateTime getDataIndicacao() {
		return dataIndicacao;
	}
}
