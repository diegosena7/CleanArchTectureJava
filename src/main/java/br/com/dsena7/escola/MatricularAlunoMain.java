package br.com.dsena7.escola;

import br.com.dsena7.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.dsena7.escola.aplicacao.aluno.matricular.MatricularAlunoDTO;
import br.com.dsena7.escola.infra.aluno.AlunoRepositoryMemoria;

public class MatricularAlunoMain {

	public static void main(String[] args) {
		
		String nome = "EuMemo";
		String cpf = "339.857.468-77";
		String email = "teste@tete.com";
		
		MatricularAluno matricularAluno = new MatricularAluno(new AlunoRepositoryMemoria());
		matricularAluno.matricular(new MatricularAlunoDTO(nome, cpf, email));
		
//		EnviarEmailIndicacao envioEmail = new EnviarEmailIndicacaoComJavaMail();
//		System.out.println("Enviando e-mail para: " + aluno.getEmail());
//		envioEmail.enviarPara(aluno);
		
	}
}
