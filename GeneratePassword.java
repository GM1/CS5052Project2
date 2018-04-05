import java.util.*;

public class GeneratePassword
{
	/*public static void main(String[] args)
	{
		
		generate();
		
	}*/

	public static String generate()
	{
		
		String password ="";
		
		int seed = (int) (Math.random()*3) + 1;
		int random = 0;
		
		String alphabetAndSymbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*&^%$£";
		
		String[] array = new String[12];
		
		switch (seed)
		{
			case 1:
				for (int i = 0; i < 12; i++)
					{	if ((i%2==0))
						{
							random = (int) (Math.random()*59);
							array[i] = alphabetAndSymbols.substring(random,random+1);
							//System.out.println(array[i]);
						}
						else 
						{
							random = (int) (Math.random()*10);
							array[i] = Integer.toString(random);
							//System.out.println(array[i]);
						}
					}
				System.out.println("Password generator 1= " + stringBuilder(array));
				password = stringBuilder(array);
				break;
				
			case 2:
				for (int i = 0; i < 12; i++)		
					{	
						if ((i%3==0))
						{
							random = (int) (Math.random()*53);
							array[i] = alphabetAndSymbols.substring(random,random+1);	
							//System.out.println(array[i]);
						}
						else 
						{
							random = (int) (Math.random()*10);
							array[i] = Integer.toString(random);
							//System.out.println(array[i]);
						}
					}
				System.out.println("Password generator 2= " + stringBuilder(array));
				password = stringBuilder(array);
				break;
			
			case 3:
				for (int i = 0; i < 12; i++)
					{	
						if ((i%4==0))
						{
							random = (int) (Math.random()*6)+53;
							array[i] = alphabetAndSymbols.substring(random,random+1);	
							//System.out.println(array[i]);
							
						}
						else if ((i%3==0))
						{	
							random = (int) (Math.random()*10);
							array[i] = Integer.toString(random);
							//System.out.println(array[i]);
						}
						else 
						{
							random = (int) (Math.random()*53);
							array[i] = alphabetAndSymbols.substring(random,random+1);	
							//System.out.println(array[i]);
						}
					}
					System.out.println("Password generator 3= " + stringBuilder(array));
					password = stringBuilder(array);
					break;
			default:
				break;
		}
		
		return password;
		
	}
	
	public static String stringBuilder(String[] array)
	{
		String string = "";
		
		for (int i =0; i < array.length; i++)
		{
			
			string += array[i];
			
		}
		
		return string;
		
		
	}

}