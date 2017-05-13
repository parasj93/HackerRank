
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
   

public class Frequency {
	
    public  byte[] buf=new byte[1024];    //Buffer of Bytes
    public int index;
    public InputStream in;
    public int total;
    public Frequency()
    {
        in=System.in;
    }
    public int scan()throws IOException    //Scan method used to scan buf
    {
        if(total<0)
        throw new InputMismatchException();
        if(index>=total)
        {
            index=0;
            total=in.read(buf);
            if(total<=0)
            return -1;
        }
        return buf[index++];
    }
    public int scanInt()throws IOException
    {
        int integer=0;
        int n=scan();
        while(isWhiteSpace(n))    //Removing starting whitespaces
        n=scan();
        int neg=1;
        if(n=='-')                //If Negative Sign encounters
        {
            neg=-1;
            n=scan();
        }
        while(!isWhiteSpace(n))
        {
            if(n>='0'&&n<='9')
            {
                integer*=10;
                integer+=n-'0';
                n=scan();
            }
            else throw new InputMismatchException();
        }
        return neg*integer;
    }
    private boolean isWhiteSpace(int n)
    {
        if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1 || n>58)
        return true;
        return false;
    }
    
public void getFrequency(int []inputArray,int [][] typeQuery)
	{
		int frequency=0,element=0;
		for(int i=0;i<typeQuery.length;i++)
		{
		//	for(int j=0;j<1;j++)
		//	{
			if(typeQuery[i][0]==0)
			{
				element=typeQuery[i][1];
				frequency=atleastElement(element,inputArray);
				System.out.println(frequency);
			}
			else if(typeQuery[i][0]==1)
			{
				element=typeQuery[i][1];
				frequency=equalToElement(element,inputArray);
				System.out.println(frequency);
			}
			else
			{
				System.out.println(Integer.parseInt("0"));
				
			}
	//	   }
		}
		
	}
	
	public int atleastElement(int element,int [] inputArray)
	{
		int counter=0,returnElement=0;
		for(int i=0;i<inputArray.length;i++)
		{
			for(int j=0;j<inputArray.length;j++)
			{
				if(inputArray[i]==inputArray[j])
						{
					        counter=counter+1;
					        if(counter>=element)
					        {
					        	
					        	return inputArray[i];
					        }
						}
			}
			counter=0;
			
			
					
			
		}
		System.out.println("before return");
		return 0;
	}

	public int equalToElement(int element,int [] inputArray)
	{
		int counter=0,returnElement=0;
		for(int i=0;i<inputArray.length;i++)
		{
			for(int j=0;j<inputArray.length;j++)
			{
			if(inputArray[i]==inputArray[j])
			{
			   counter=counter+1;
			   
			}
			}
			if(counter==element)
			   {
				returnElement=inputArray[i];
				   return returnElement;
			   }
			else
				counter=0;
			}
		
		return 0;
	}
    
	public static void main(String []args) throws IOException
	{
		//try{
			int size=0;
		Frequency f=new Frequency();
	
	size=f.scanInt();
	if(size<=0)
	{
		System.out.println(0);
	}
	else
	{
	int []inputArray=new int[size];
	for(int i=0;i<size;i++)
	{
		inputArray[i]=f.scanInt();
		if(inputArray[i]==0)
		{
			System.out.println(0);
			System.exit(1);
		}
	}
/*	for(int i:inputArray)
	{
		System.out.print(i);
	}
*/	//System.out.println("\n");
		
	int query=f.scanInt();
	if(query<=0)
	{
		System.out.println(0);
		
	}
	else
	{
		//System.out.println(query);
	}
   // if(query>=1)
    ///{
	int [][]typeQuery=new int[query][2];
	for(int i=0;i<query;i++)
	{
	for(int j=0;j<2;j++)
		{
		    if(j==0)
		    {
			int a=f.scanInt();
			if(a==0 || a==1)
			{
			typeQuery[i][j]=a;
			}
			else
			{
				System.out.println(0);
				System.exit(1);
			}
		    }
		    else if(j==1)
		    {
		    	int a=f.scanInt();
				if(a>=1)
				{
				typeQuery[i][j]=a;
				}
				else
				{
					System.out.println(0);
					System.exit(1);
				}
		    	
		    }
		}
	}
	f.getFrequency(inputArray,typeQuery);
	}
}
}
	
		


