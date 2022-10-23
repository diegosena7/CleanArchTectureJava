package br.com.dsena7.escola.dominio.aluno;

/*
 * Usando o padrão Builder que é um padrão de design criacional, que permite construir objetos complexos passo a passo.
 * Nos métodos retornamos a própria classe com intuíto de poder usar todos os médotos em uma única instancia da classe.
 */
public class FabricaDeAluno {

	private Aluno aluno;
	
	public FabricaDeAluno criaAlunoComNomCpfEMail(String nome, String cpf, String email) {
		this.aluno = new Aluno(nome,new CPF(cpf), new Email(email));
		return this;
	}
	
	public FabricaDeAluno criaAlunoComTelefone(String ddd, String numTel) {
		this.aluno.addicionaTelefone(ddd, numTel);
		return this;
	}
	
	public Aluno criarAluno() {
		return this.aluno;
	}
}
