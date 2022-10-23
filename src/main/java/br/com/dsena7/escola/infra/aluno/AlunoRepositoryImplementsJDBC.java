package br.com.dsena7.escola.infra.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.dsena7.escola.dominio.aluno.Aluno;
import br.com.dsena7.escola.dominio.aluno.AlunoNaoEcontradoException;
import br.com.dsena7.escola.dominio.aluno.AlunoRepository;
import br.com.dsena7.escola.dominio.aluno.CPF;
import br.com.dsena7.escola.dominio.aluno.Email;
import br.com.dsena7.escola.dominio.aluno.Telefone;

public class AlunoRepositoryImplementsJDBC implements AlunoRepository {

	private final Connection connection;

	public AlunoRepositoryImplementsJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void matriularAlunos(Aluno aluno) {
		try {
			String sql = "INSERT INTO ALUNO VALUES(?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, aluno.getCpf());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getEmail());
			ps.execute();

			sql = "INSERT INTO TELEFONE VALUES(?, ?)";
			ps = connection.prepareStatement(sql);

			for (Telefone tel : aluno.getTelefones()) {
				ps.setString(1, tel.getDdd());
				ps.setString(2, tel.getNumero());
				ps.execute();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Aluno buscarPorCpf(CPF cpf) {
		try {
			String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, cpf.getNumeroCPF());

			ResultSet rs = ps.executeQuery();
			boolean encontrou = rs.next();
			if (encontrou) {
				System.out.println("Aluno encontrado");
			} else {
				throw new AlunoNaoEcontradoException(cpf);
			}

			String nome = rs.getString("nome");
			Email email = new Email(rs.getString("email"));
			Aluno alunoEncontrado = new Aluno(nome, cpf, email);

			// Busca Telefone
			Long id = rs.getLong("id");
			sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				String numero = rs.getString("numero");
				String ddd = rs.getString("ddd");
				alunoEncontrado.addicionaTelefone(ddd, numero);
			}
			return alunoEncontrado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Aluno> listarTodosOsAlunosMatriculados() {
		try {
			String sql = "SELECT id, cpf, nome, email FROM ALUNO";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Aluno> alunos = new ArrayList<>();

			while(rs.next()) {
				String nome = rs.getString("nome");
				CPF cpf = new CPF("cpf");
				Email email = new Email(rs.getString("email"));
				Aluno alunoEncontrado = new Aluno(nome, cpf, email);
				
				// Busca Telefone
				Long id = rs.getLong("id");
				sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
				PreparedStatement psTelefone = connection.prepareStatement(sql);
				psTelefone.setLong(1, id);
				ResultSet rsTelefone = psTelefone.executeQuery();
				
				while (rsTelefone.next()) {
					String numero = rs.getString("numero");
					String ddd = rs.getString("ddd");
					alunoEncontrado.addicionaTelefone(ddd, numero);
				}
				alunos.add(alunoEncontrado);
			}

			return alunos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
