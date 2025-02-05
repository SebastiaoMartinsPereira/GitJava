package br.com.impacta.modelos;

import br.com.impacta.modelos.exceptions.BonificacaoIllegalException;


public class Diretor extends Funcionario {

	public Diretor(String nome,String departamento,double salario,Data dataEntrada,String rg){
		super(nome, departamento, salario, dataEntrada, rg);
	}
	
	
	@Override
	public void bonifica(Double value) {
		try {
			
			if(value < 0.){
			    throw new BonificacaoIllegalException("\nValor informado deve ser positivo\n",value);	
			   
			}else
				 super.bonifica(value);
						
		} catch (BonificacaoIllegalException e) {
			
			System.out.printf(e.getMessage() );
		}
		
	}
}
