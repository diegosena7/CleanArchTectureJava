package br.com.dsena7.escola.aplicacao.indicacao;

import br.com.dsena7.escola.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {

	void enviarPara(Aluno aluno);
}
