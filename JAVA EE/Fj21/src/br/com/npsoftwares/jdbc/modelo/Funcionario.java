package br.com.npsoftwares.jdbc.modelo;

public class Funcionario {

	Long id;
	String nome;
	String usuario;
	String senha;
	
	public Funcionario(Long id,String nome,String usuario,String senha)
	{
		this.id = id;
		this.nome = nome;
		this.usuario=usuario;
		this.senha=senha;
		
	}
	
	public Funcionario(String nome,String usuario,String senha)
	{	
		this.nome = nome;
		this.usuario=usuario;
		this.senha=senha;
		
	}
	public Funcionario(){}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
