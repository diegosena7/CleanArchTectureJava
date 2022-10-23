package br.com.dsena7.escola.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

/*
 * Clean Architecture tem por objetivo padronizar e organizar o código desenvolvido, favorecer a sua reusabilidade, assim como
 * independência de tecnologia.
 */
public class Aluno {
	
	private String nomeAluno;
	
	private CPF cpfAluno;
	
	private Email emailAluno;
	
	private String senha;
	
	private List<Telefone> telefones = new ArrayList<>();
	
	public void addicionaTelefone(String ddd, String numero) {
		this.telefones.add(new Telefone(numero, ddd));
	}

	public Aluno(String nome, CPF cpf, Email email) {
		this.nomeAluno = nome;
		this.cpfAluno = cpf;
		this.emailAluno = email;
	}

	public String getNome() {
		return nomeAluno;
	}

	public void setNome(String nome) {
		this.nomeAluno = nome;
	}

	public String getCpf() {
		return cpfAluno.getNumeroCPF();
	}

	public void setCpf(CPF cpf) {
		this.cpfAluno = cpf;
	}

	public String getEmail() {
		return emailAluno.getEnderecoEmail();
	}

	public void setEmail(Email email) {
		this.emailAluno = email;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	@Override
	public String toString() {
		return "Aluno [nomeAluno=" + nomeAluno + ", cpfAluno=" + cpfAluno + ", emailAluno=" + emailAluno + ", senha="
				+ senha + ", telefones=" + telefones + "]";
	}
}
