package br.com.dsena7.escola.dominio.aluno;

/*
 * Usando o padr�o Builder que � um padr�o de design criacional, que permite construir objetos complexos passo a passo.
 * Nos m�todos retornamos a pr�pria classe com intu�to de poder usar todos os m�dotos em uma �nica instancia da classe.
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
