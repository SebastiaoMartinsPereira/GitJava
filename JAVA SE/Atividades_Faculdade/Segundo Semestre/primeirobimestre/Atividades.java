package primeirobimestre;

import java.math.BigInteger;
import com.impacta.segundobimentre.MetodosVetores;
import java.util.Arrays;
import java.util.Random;

public class Atividades {

	private int[] data;
	private  static final Random generator = new Random();

	public static void main(String[] args)
	{
		
		dividirNmsArray();
		
//		for(int counter = 0 ; counter <= 40;counter++)
//		{
//			System.out.printf("Fibonacci of %d is: %d\n",counter,fibonacci(BigInteger.valueOf(counter)));
//		}
	}


	///Fibonecci Calculator

	private static BigInteger TWO = BigInteger.valueOf(2);

	public static BigInteger fibonacci(BigInteger number)
	{
		if(number.equals(BigInteger.ZERO) || number.equals(BigInteger.ONE))
		{
			return number;	
		}else
		{
			return fibonacci(number.subtract(BigInteger.ONE)).add(fibonacci(number.subtract((TWO ))));
		}

	}


	public void preencheArray(int size)
	{
		data = new int[size];
		for(int i = 0 ; i< size ; i++)
		{
			data[i] = 10 + generator.nextInt(90);

			Arrays.sort(data);

		}
	}

	public int binarySearch(int searchElement)
	{
		int low = 0;
		int high = data.length-1;
		int middle = (low-high+1)/2;
		int location = -1;

		do
		{
			System.out.print(remainingElements(low,high));
			
			for(int i = 0 ;i < middle;i++)
			{
				System.out.print(" ");
				System.out.println(" * ");

				if(searchElement == data[middle])
				{
					location = middle;
				}
				else if(searchElement < data[middle])
				{
					high = middle-1;
				}
				else
				{
					low = middle +1;
				}

				middle = (low + high + 1)/2;

			}

				
		}while((low <= high ) && (location == -1));

		return location;
	}
	
	public String remainingElements(int low , int high)
	{
		StringBuilder temporary = new StringBuilder();
		for(int i = 0 ;i< low ;i++)
		{
			temporary.append("    ");
		}
		
		for (int i = low; i <= high; i ++)
		{
			temporary.append(data[i]+" ");
		}
		
		temporary.append("\n");
		
		return temporary.toString();
		
	}
	
	
	
	
	
	
	
	public static void dividirNmsArray()
	{
		//numeros informados pelo usu�rio
		double[] v ={50,10,5,2};
		
		double div=v[0];
		
		for(int i = 1;i<v.length;i++){
			div=div/v[i];
		} 
		
		System.out.println(div);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String toString()
	{
		return remainingElements(0, data.length-1);
	}
}








