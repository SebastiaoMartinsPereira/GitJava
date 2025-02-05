package br.com.impacta.modelos;

import br.com.impacta.modelos.exceptions.BonificacaoIllegalException;

public class Programador extends Funcionario{

	public Programador(String nome,String departamento,double salario,Data dataEntrada,String rg){
		super(nome, departamento, salario, dataEntrada, rg);
	}
	
	
	@Override
	public void bonifica(Double value) {
		try {
			
			if(value < 0.){
			    throw new BonificacaoIllegalException("\n Valor informado para a bonifica��o deve ser positivo.\n",value);	
			   
			}else
				 super.bonifica(value);
			    			
		} catch (BonificacaoIllegalException e) {
			
			value = Math.abs(value);
			super.bonifica(value);
			System.out.printf(e.getMessage() + "\n Mas eu sou o programador e transformei meu valor em positivo \n e tamb�m multipliquei este valor � agora eu tenho %10.2f a mais em minha conta.\n\n",value*2 );
		}
	}
	
}
