package br.com.dsena7.escola.dominio.aluno;


/* Value Object -->> São objetos sem identidade conceitual e que dão característica a algum outro objeto
 * Em geral, estamos interessados no que eles fazem e não em quem eles são.
 * Se a igualdade entre dois objetos de uma classe é verificada através da comparação de todos os seus valores, se trata de um Value Object.
 */
public class Email {
	
	private String enderecoEmail;

	private static final String EMAIL_PATTERN =  "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public Email(String enderecoEmail) {
		if(enderecoEmail == null || !enderecoEmail.matches(EMAIL_PATTERN)) {
			throw new IllegalArgumentException("Email inválido");
		}
		this.setEnderecoEmail(enderecoEmail);
	}


	public String getEnderecoEmail() {
		return enderecoEmail;
	}

	public void setEnderecoEmail(String enderecoEmail) {
		this.enderecoEmail = enderecoEmail;
	}


	@Override
	public String toString() {
		return "Email [enderecoEmail=" + enderecoEmail + "]";
	}
}
