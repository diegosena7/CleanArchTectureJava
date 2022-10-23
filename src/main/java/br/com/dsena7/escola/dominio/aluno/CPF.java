package br.com.dsena7.escola.dominio.aluno;

/* Value Object -->> São objetos sem identidade conceitual e que dão característica a algum outro objeto
 * Em geral, estamos interessados no que eles fazem e não em quem eles são.
 * Se a igualdade entre dois objetos de uma classe é verificada através da comparação de todos os seus valores, se trata de um Value Object.
 */
public class CPF {
	
	private String numeroCPF;
	
	private static final String CPF_PATTERN = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}";

	@Override
	public String toString() {
		return "CPF [numeroCPF=" + numeroCPF + "]";
	}

	public CPF(String cpf) {
		
		if (cpf == null || !cpf.matches(CPF_PATTERN)) {
			throw new IllegalArgumentException("CPF inválido");
		}
		this.setNumeroCPF(cpf);
	}

	public String getNumeroCPF() {
		return numeroCPF;
	}

	public void setNumeroCPF(String cpf) {
		this.numeroCPF = cpf;
	}
	
	
}
