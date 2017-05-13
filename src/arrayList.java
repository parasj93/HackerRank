import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;


public class arrayList {
	public  byte[] buf=new byte[1024];    //Buffer of Bytes
    public int index;
    public InputStream in;
    public  BufferedWriter bw;
    public int total=0;
    public arrayList()
    {
        this.in=System.in;
        this.bw=new BufferedWriter(new OutputStreamWriter(System.out));
    }
    
    public void close()throws IOException
    {
        bw.close();
    }
    public int scan()throws IOException    //Scan method used to scan buf
    {
        if(total<0)
        return 0;
        if(index>=total)
        {
            index=0;
            total=in.read(buf);
            //System.out.println("total in scan method "+total);
            if(total<=0)
            return -1;
        }
        return buf[index++];
    }
    public int scanInt()throws IOException
    {
        int integer=0;
        int n=scan();
        
        //System.out.println("n in scanInt "+n);
        while(isWhiteSpace(n))    //Removing starting whitespaces
        	n=scan();
        int neg=1;
        if(n=='-')                //If Negative Sign encounters
        {
            return -1;
        }
        while(!isWhiteSpace(n))
        {
        	
            if(n>='0'&&n<='9')
            {
                integer*=10;
                integer+=n-'0';
                n=scan();
                
            }
            else
            	throw new InputMismatchException();
            
        }
        
        return neg*integer; 
    }
    private boolean isWhiteSpace(int n)
    {
        if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)
        return true;
        return false;
    }
    
    
	public int getFrequency(ArrayList<Integer> inputArray,int [][] typeQuery,int i)
	{
		int type=0;
			if(typeQuery[i][0]==0)
			{
				type=typeQuery[i][1];
				//System.out.println("Hello in atleast");
				return atleastElement(type,inputArray);
			}
			else if(typeQuery[i][0]==1)			{
				type=typeQuery[i][1];
				//System.out.println("Hello in equal");
				return equalToElement(type,inputArray);
			}
			else
			return 0;
			
			
        //System.out.println("lelelelele");
		//return 0;
	}
	
	public int atleastElement(int element,ArrayList<Integer> inputArray)
	{
		int counter=0;
		for(int i=0;i<inputArray.size();i++)
		{
			for(int j=0;j<inputArray.size();j++)
			{
				if(inputArray.get(i)==inputArray.get(j))
						{
					        counter=counter+1;
					        if(counter>=element)
					        {
					        	return inputArray.get(i);
					        }
						}
			}
			counter=0;
		}
		System.out.println("before return");
		return 0;
	}

	public int equalToElement(int element,ArrayList<Integer>inputArray)
	{
		int counter=0;
		for(int i=0;i<inputArray.size();i++)
		{
			for(int j=0;j<inputArray.size();j++)
			{
			if(inputArray.get(i)==inputArray.get(j))
			{
			   counter=counter+1;
			   
			}
			}
			if(counter==element)
			   {
				
				   return inputArray.get(i);
			   }
			else
				counter=0;
			}
		
		return 0;
	}
    
	public static void main(String []args) throws IOException
	{
		try{
			long size=0;
			
		arrayList f=new arrayList();
				PrintStream ps=new PrintStream(System.out);
			
	
	size=f.scanInt();
	if(size<=0 || size<-1)
	{
		
		System.out.println(0);
		System.exit(1);
	}
	else
	{
		ArrayList<Integer> inputArray=new ArrayList<Integer>();
	for(int i=0;i<size;i++)
	{
		inputArray.add(f.scanInt());
		if(inputArray.contains(0))
		{
			System.out.println(0);
			System.exit(1);
		}
	}
	int query=f.scanInt();
	if(query<=0)
	{
		System.out.println(0);
		
	}
     int [][]typeQuery=new int[query][2];
	for(int i=0;i<query;i++)
	{
		    int a=f.scanInt();
		    //System.out.println("value of a "+f.scanInt());
			if(a>=0 || a<=1)
			{
			typeQuery[i][0]=a;
			}
			else
			{
				System.out.println(0);
				System.exit(1);
			}
			a=f.scanInt();
				if(a>=1)
				{
				typeQuery[i][1]=a;
				}
				else
				{
					System.out.println(0);
					System.exit(1);
				}
	}
	for(int g=0;g<typeQuery.length;g++)
	{ps.print(f.getFrequency(inputArray,typeQuery,g));
	System.out.print('\n');
	
	}f.close();
	}
	}
		catch(IOException e)
		{
			e.getMessage();
		}
		catch(InputMismatchException e)
		{
			
			e.getMessage();
		}
	
		catch(ArrayIndexOutOfBoundsException e)
		{
			e.getMessage();
		}
		catch(NumberFormatException e)
		{
			e.getMessage();
		}
		
    }
}
