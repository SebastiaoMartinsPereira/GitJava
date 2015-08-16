package br.com.npsoftwares.djbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import br.com.npsoftwares.jdbc.ConnectionFactory;
import br.com.npsoftwares.jdbc.dao.exception.DaoException;
import br.com.npsoftwares.jdbc.modelo.Contato;


public class ContatoDao {

	private Connection conn;
	
	public ContatoDao()
	{
		new ConnectionFactory();
		this.conn = ConnectionFactory.getConn();
	}
	
	public void addContato(Contato contato){
 
		 java.sql.Date dataForRecord = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		
	     StringBuilder sbQuery = new StringBuilder();
	     sbQuery.append("INSERT INTO tb0001_Contatos (");
	     sbQuery.append("nomeCONTATO,emailCONTATO,enderecoCONTATO,dataNascimentoCONTATO)");
	     sbQuery.append("values(?,?,?,?)");
	     
	     try {
			 
	    	 PreparedStatement stmt = conn.prepareStatement(sbQuery.toString());
	    	 
		     stmt.setString(1, contato.getNome());
		     stmt.setString(2,contato.getEmail());
		     stmt.setString(3,contato.getEndereco());
		     stmt.setDate(4,dataForRecord);
		     
		     stmt.execute();
		     stmt.close(); 
		     
		} catch (Exception e) {
			
			throw new DaoException("Houveram problemas durante o Indsert na base de dados.",e);
		}

	}
	
	public ArrayList<Contato> getList()
	{
		
		Calendar data = Calendar.getInstance();
		
		try {
			
		    ArrayList<Contato> contatos = new ArrayList<Contato>();
			
			PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM tb0001_Contatos WHERE idCONTATO < 10");
			ResultSet rs  = stmt.executeQuery();
			
			while(rs.next()){
				data.setTime(rs.getDate("dataNascimentoCONTATO"));
				Contato contato = new Contato(rs.getLong("idCONTATO"),rs.getString("nomeCONTATO"),rs.getString("emailCONTATO"),rs.getString("enderecoCONTATO"),data);
				contatos.add(contato);
			}
			
			rs.close();
			stmt.close();
			return contatos;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	

	/**
	* M�todo para pesquisar contatos a partir do Id no mesmo.
	* @param  id idetifica��o do contato
	* @author Sebasti�o Martins
	* @return objeto Contato com as informa��es carregadas.
	*/
	public Contato pesquisar(int id){
		
	    Calendar data = Calendar.getInstance();
		Contato contato = new Contato();
		
		try {
					
			PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM tb0001_Contatos WHERE idCONTATO = ?");
			stmt.setInt(1, id);
			ResultSet rs  = stmt.executeQuery();
                
			while (rs.next()){
				
				data.setTime(rs.getDate("dataNascimentoCONTATO"));
				
				contato = new Contato(rs.getLong("idCONTATO"),rs.getString("nomeCONTATO"),rs.getString("emailCONTATO"),rs.getString("enderecoCONTATO"),data);
			}
			
		    rs.close();
			stmt.close();

			return contato;
			
		} catch (Exception e) {                                   
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * altera��o de dados de um contato na base de dados  a partir do id do contato.
	 * @param contato  identifica��o do contato
	 */
	public void altera(Contato contato){
		
		StringBuilder sbQuery = new StringBuilder();
		sbQuery.append("UPDATE tb0001_Contatos set nomeCONTATO= ?,emailCONTATO=?,enderecoCONTATO=?,dataNascimentoCONTATO=? WHERE idCONTATO = ?");
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement(sbQuery.toString());
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5,contato.getId());
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void remove(Contato contato){
		
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM tb0001_Contatos WHERE idCONTATO  = ?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new DaoException("Error",e);
		}
	}
}