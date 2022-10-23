package br.com.dsena7.escola.infra.aluno;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.dsena7.escola.dominio.aluno.CifradorDeSenha;

public class CifraSenhasComMD5 implements CifradorDeSenha {

	public String cifrarSenha(String senha) {

		String md5 = null;

		try {

			MessageDigest digest = MessageDigest.getInstance("MD5");

			digest.update(senha.getBytes(), 0, senha.length());

			md5 = new BigInteger(1, digest.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Erro ao gerar senha cifrada...");
		}
		return md5.toString();
	}

	@Override
	public Boolean validarSenhas(String senhaCifrada, String senha) {
		return senhaCifrada.equals(cifrarSenha(senha));
	}
}
