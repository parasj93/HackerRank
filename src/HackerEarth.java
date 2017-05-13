import java.util.InputMismatchException;
import java.util.Arrays;
import java.util.Scanner;
public class HackerEarth {
	int counterH,counterA,counterC,counterK,counterE,counterR,counterT;
	int threeValue,fourValue;
	public int counthackerearth(String str)
	{
		try
		{
		int len=str.length();
		int smallestEven=0;
		int smallestOdd=0;
		for(int i=0;i<len;i++)
		{
			if(Character.isLowerCase(str.charAt(i)))
			{
				
			if(str.charAt(i)=='h')
				counterH++;
			else if(str.charAt(i)=='a')
			    counterA++;
			else if(str.charAt(i)=='c')
			    counterC++;
			else if(str.charAt(i)=='k')
			    counterK++;
			else if(str.charAt(i)=='e')
			    counterE++;
			else if(str.charAt(i)=='r')
			    counterR++;
			else if(str.charAt(i)=='t')
			    counterT++;
		}
			}
		
		//---------------------------------------------------------
//		if(counterC>=1 && counterK>=1 && counterT>=1)
//		{
//			int []oddNumbers=new int[]{counterC,counterK,counterT};
//		    /*smallestOdd=oddNumbers[0];
//		    for(int i=1; i< oddNumbers.length; i++)
//	        {
//	                if (oddNumbers[i] < smallestOdd)
//	                        smallestOdd = oddNumbers[i];
//	          */
//			Arrays.sort(oddNumbers);
//			for(int i=0;i<oddNumbers.length;i++)
//			{
//				System.out.println("Sorted Lis is: "+oddNumbers[i]+" at "+oddNumbers.);
//			}
//			
//			
//	        }
//		
//		//--------------------------------------------------------
		
		if(counterH>=2 && counterA>=2 && counterE>=2 && counterR>=2)
		{
			fourValue =fourSmall(counterH,counterA ,counterE,counterR);
		}

			
//		    smallestEven=evenNumbers[0];
//		    for(int i=1; i< evenNumbers.length; i++)
//	        {
//	                if (evenNumbers[i] < smallestEven)
//	                        smallestEven = evenNumbers[i];
//	               
//	        }
		//    System.out.println("smallestEven value is "+smallestEven);
		else
		{	
			return 0;	
		}
		
		if(counterC>=1 && counterK>=1 && counterT>=1)
		{
			threeValue=threeSmall(counterC,counterK,counterT);
		
//		    smallestOdd=oddNumbers[0];
//		    for(int i=1; i< oddNumbers.length; i++)
//	        {
//	                if (oddNumbers[i] < smallestOdd)
//	                        smallestOdd = oddNumbers[i];
//	               
//	        }
		  //  System.out.println(smallestOdd);
		}
		else
		{
			return 0;
		}
		
		for(int i=threeValue;i>=1;i--)
		{
			if(fourValue>=threeValue*2)
				return threeValue;
			else
			{
				threeValue=threeValue-1;
				if(threeValue==0)
					return 0;
			}
				

				
		}
		//System.out.println("Values is: "+smallestEven+smallestOdd);
		
//		if((smallestEven/2)==smallestOdd)
//		{
//			return smallestOdd;
//		}
//		else if(smallestOdd<smallestEven)
//		{
//			return smallestOdd;
//		}
//		else if(smallestEven==0)
//		{
//			return 0;
//		}
//		
//	System.out.println("H is "+counterH + "A is " + counterA + "c is " +counterC + "K is " +counterK + 
//				"E is " +counterE + "R is " +counterR
//				+ "T is " +counterT);
		
	}
		
		catch(ArithmeticException e)
		{
			return 0;
		}
		catch(IllegalArgumentException e)
		{
			return 0;
		}
		return 0;
	}
        public int fourSmall(int d,int e ,int f,int g)
    {
	int []four=new int [4];
	four[0]=d;
	four[1]=e;
	four[2]=f;
	four[3]=g;
	Arrays.sort(four);
	for (int number : four) {
		   return number;
	}
	return 0;
    }
        public int threeSmall(int a,int b,int c)
    	{
    		int []three=new int [3];
    		three[0]=a;
    		three[1]=b;
    		three[2]=c;
    		
    		Arrays.sort(three);
    		for (int number : three) {
    			   return number;
    		}
    		return 0;			
    	}
        
	public static void main(String[] args) {
		
		try{
			Scanner sc=new Scanner(System.in);
		
	
	System.out.println("Please Enter the length of the string");
	
	int len=sc.nextInt();
	
	if(len<=0)
	{
		System.out.println(Integer.parseInt("0"));
	}
	else
	{
		System.out.println("Please Enter the string");
		String aString =sc.next();
	int maxLength = (aString.length() < len)?aString.length():len;
	aString = aString.substring(0, maxLength);
	//System.out.println("aString lengthis: "+maxLength+aString);
	HackerEarth he=new HackerEarth();
	
	System.out.println(he.counthackerearth(aString));
	}
		}
	catch(IllegalArgumentException e)
	{
		System.out.println(Integer.parseInt("0"));
	}
	catch(InputMismatchException e)
	{
		System.out.println(Integer.parseInt("0"));
	}
	}
	

}
