package br.com.dsena7.escola.dominio.aluno;

/* Value Object -->> S�o objetos sem identidade conceitual e que d�o caracter�stica a algum outro objeto
 * Em geral, estamos interessados no que eles fazem e n�o em quem eles s�o.
 * Se a igualdade entre dois objetos de uma classe � verificada atrav�s da compara��o de todos os seus valores, se trata de um Value Object.
 */
public class Telefone {

	private static final String PATTERN_DDD = "\\d{2}";
	private static final String PATTERN_TELEFONE = "\\d{8}|\\d{9}";

	private String telefone;
	private String ddd;

	public Telefone(String telefone, String ddd) {

		if (telefone == null || ddd == null) {
			throw new IllegalArgumentException("DDD (com 2 d�gitos) e Numero sao obrigatorios!");
		}
		
		if(!telefone.matches(PATTERN_TELEFONE)) {
			throw new IllegalArgumentException("Numero invalido!");
		}
		
		if(!ddd.matches(PATTERN_DDD)) {
			throw new IllegalArgumentException("DDD invalido!");
		}
		
		this.ddd = ddd;
		this.telefone = telefone;
	}

	public String getNumero() {
		return telefone;
	}

	public void setNumero(String numero) {
		this.telefone = numero;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
}
