package br.com.dsena7.escola.dominio.aluno;

public class EmailNaoEnviadoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EmailNaoEnviadoException(String email) {
		super("Erro ao enviar e-mail para: " + email);
	}

}
