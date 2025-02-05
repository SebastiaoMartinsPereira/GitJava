package br.com.impacta.teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


import java.util.Random;

import br.com.impacta.modelos.Conta;
import br.com.impacta.modelos.ContaPoupanca;

public class TestaOrdenacao {

	public static void main(String[] args) {
		
		Random ram = new Random();
		ContaPoupanca c1;
		List<ContaPoupanca> contas = new ArrayList<ContaPoupanca>();
		
		List<ContaPoupanca> contaLinked = new LinkedList<>();
		
		
		for (int i = 1; i < 20; i++) {
			
			c1 = new ContaPoupanca(ram.nextInt(1000)* i,"Sebastiao " + i,i * 1000.0, i * 1000. * 2 );
			
			//arraylist 
			contas.add(c1);

			//Linked list
			contaLinked.add(c1);
		}
		
		Collections.sort(contas);
		
		System.out.println("Array List");
		mostrar(contas);	
		
		Collections.sort(contaLinked);
		
		System.out.println("\n\nLinked List");
		mostrar(contaLinked);
		
		Collections.shuffle(contas);
		
		System.out.println("\n\nArray list embaralhado novamente");
		mostrar(contas);
		
		Collections.shuffle(contaLinked);
		
		System.out.println("\n\nLinked list embaralhado novamente");
		mostrar(contas);
		
		System.out.println("\n\nReodernando");
		
		Collections.sort(contas);
		Collections.sort(contaLinked);
		
		
		System.out.println("\n\nRotacionando a Arry list");
		Collections.rotate(contas, contas.size()/2);
		mostrar(contas);
		
		System.out.println("\n\nRotacionando a Linked List");
		Collections.rotate(contaLinked, contaLinked.size()/2);
		mostrar(contaLinked);
		
		
		System.out.println("\n\nImprimeindo Refer�ncia as listas");
		
		System.out.println(contas);
		System.out.println(contaLinked);
		
		
	}
	
	
	public static void mostrar(List<ContaPoupanca> list){

		for (Object conta : list) {
			
			System.out.println(String.format("Numero da conta %d", ((Conta) conta).getNumero()));
		}	
	}
}

    // 4

//Apesar de ter o metodo que efetua uma compara��o na classe ContaPoupanca
//o metodo sort do Collections nescessita que a nossa classe implente o interface Comparable.



//6 basta trocarmos a l�gica do m�todo compareTo() na classe ContaPoupanca.

//@Override
//public int compareTo(ContaPoupanca conta) {
//	
//	if(this.getNumero() < conta.getNumero())
//	{
//		return -1;
//	}
//	
//	if(this.getNumero() > conta.getNumero()){
//		return 1;
//	}
//	
//	return 0;
//	
//}


//6 para embaralhar novamente devemos usar o metodo shuffle da classe Collections













