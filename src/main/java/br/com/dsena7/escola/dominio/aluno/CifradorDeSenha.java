package br.com.dsena7.escola.dominio.aluno;

public interface CifradorDeSenha {

	String cifrarSenha(String senha);
	
	Boolean validarSenhas(String senhaCIfrada, String senha);
}
