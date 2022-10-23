package br.com.dsena7.escola.dominio.aluno;

public class AlunoNaoEcontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AlunoNaoEcontradoException(CPF cpf) {
		super("Aluno não encontrado com o CPF: " + cpf.getNumeroCPF());
	}

}
