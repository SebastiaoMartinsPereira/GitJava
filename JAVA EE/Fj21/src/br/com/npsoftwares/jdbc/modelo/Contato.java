package br.com.npsoftwares.jdbc.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Contato {

	private Long id;
	private String nome;
	private String email;
	private String endereco;
	private Calendar dataNascimento;
	
    /**
     * Construtor	
     */
	public Contato()
	{
		
	}
	
	/**
	 * Contrutor sem o Id.
	 * @param  Nome nome do contato
	 * @param  E-mail email do contato
	 * @param  Endereco endere�o do contato
	 * @param  DataNascimento data de nascimento.
	 */
	public Contato(String nome,String email,String endereco,Calendar dataNascimento)
	{
		this.setNome(nome);
		this.setEmail(email);
		this.setEndereco(endereco);
		this.setDataNascimento(dataNascimento);
	}
	
	/**
	 * Contrutor com defini��o de valores para todos o satributos da classe..
	 * @param id
	 * @param nome
	 * @param email
	 * @param endereco
	 * @param dataNascimento
	 */
	public Contato(Long id ,String nome,String email,String endereco,Calendar dataNascimento)
	{
		this.setId(id);
		this.setNome(nome);
		this.setEmail(email);
		this.setEndereco(endereco);
		this.setDataNascimento(dataNascimento);
	}
	
	/**
	 * Contrutor com deini��o de valores para todos os atributos (a dataNascimento pode ser passada com uma string.)
	 * @param id
	 * @param nome
	 * @param email
	 * @param endereco
	 * @param dataNascimento  Data de nascimento do tipo String.
	 * @exception  ParseException caso o formato da string n�o obede�a ao formato desejado para parseamento. (dd-MM-yyyy)
	 */
	public Contato(Long id ,String nome,String email,String endereco,String dataNascimento)
	{
		//formato da string
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		Date data = new Date();
		//defino a string como Date
		try {
			data = (Date)sdf.parse(dataNascimento);
	        Calendar cal = Calendar.getInstance(); 
	        
	        cal.setTime(data);
			this.setId(id);
			this.setNome(nome);
			this.setEmail(email);
			this.setEndereco(endereco);
			this.setDataNascimento(cal);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		

	}
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Override
	public String toString(){
		
		//Define o formato que a data de nascimento ser� exibida.
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		
		return String.format("CONTATO : \nId: %s\nNome: %s\nEmail: %s\nEndere�o: %s\nData Nascimento: %s\n",
				                        this.id,this.nome,this.email,this.endereco,sdf.format(this.dataNascimento.getTime()) );
	}
}
