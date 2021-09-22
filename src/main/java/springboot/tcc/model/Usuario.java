package springboot.tcc.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull(message = "Nome não pode ser nulo")
	@NotEmpty(message="Nome não pode ser vazio")
	private String nome;
	
	@NotNull(message = "Sobrenome não pode ser nulo")
	@NotEmpty(message="Sobrenome não pode ser vazio")
	private String sobrenome;
	
	@NotNull(message = "Data de nascimento não pode ser nulo")
	private Date dataNascimento;
	
	@NotNull(message = "O usuário não pode ser nulo")
	@NotEmpty(message="O usuário não pode ser vazio")
	@Size(min= 5, max = 25, message = "O usuário deve conter no mínimo 5 e no máximo 25 caracteres")
	private String utilizador;
	
	@NotNull(message = "E-mail não pode ser nulo")
	@NotEmpty(message="E-mail não pode ser vazio")
	@Email(message = "Digite um email válido")
	private String email;
	
	@NotNull(message = "Senha não pode ser nulo")
	@NotEmpty(message="Senha não pode ser vazia")
	private String senha;
	
	private String tipo = "comum";
	
	private String situacao = "ativo";

	public String getUtilizador() {
		return utilizador;
	}

	public void setUtilizador(String utilizador) {
		this.utilizador = utilizador;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
}
