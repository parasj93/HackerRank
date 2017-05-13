import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;
public class mishkiPlaying {
	
	
	byte[] buf=new byte[1024];    //Buffer of Bytes
    public int index;
    public InputStream in;
    public int total;
    public mishkiPlaying()
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
        if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)
        return true;
        return false;
    }
 
	public void getWinner(int[][] days,int[]getStoneSetValue)
	{
		int i,j;
		int []k=new int[2];
		for(i=0;i<days.length;i++)
		{
			for(j=0;j<=1;j++)
			{
				k[j]=days[i][j];
				System.out.println("value of k is: "+k[j]);
			}
			String day=getChance(k,getStoneSetValue);
			System.out.println(day);
		}
	}
	public String getChance(int[]k,int[]set)
	{
		int ctr=0;
		final int M=-1;
		final int H=-2;
		int length=k.length-1;
		for(int i=0;i<1;i++)
		{
			for(int j=k[i]-1;j<=k[i+1]-1;j++)
			{
				System.out.println("Set of j is: "+set[j]);
				ctr=chance(set[j],M,H,length,j);
				if(length==j)
				{
					if(ctr==-1)
						return "Mishki";
					if(ctr==-2)
						return "Hacker";
				}
				else
				{
				if(ctr==-1)
					ctr=chance(set[j],M,H,length,j);
				if(ctr==-2)
					ctr=chance(set[j],M,H,length,j);
				}
			}
			System.out.println(ctr);
		}
		return "";
	}
	public int chance(int c,int M,int H,int length,int j)
	{
		int A=c,B;
		while(A!=0)
		{		
		B=michkiChance(A,M,H,length,j);
		System.out.println("value of B "+B);
		if(B==-1 && j==length)
			return -1;
		else if(B==-2 && j==length) 
		{
			return -2;
			
		}
		if(A==-2)
			return -2;
		}
		return 0;
	}
	public int michkiChance(int a,int M,int H,int length,int j)
	{
		a=a/2;
		System.out.println("value of a from michki chance "+a);
		if(a>=1 && j<=length)
			return hackerChance(a,H,M,length,j);
		else if(a==0 && M==-1 && j<=length)
			return H;
		else if(a==0 && M==-1)
			return -1;
		
		return 0;
		
	}
	public int hackerChance(int a,int H,int M,int length,int j)
	{
		a=a/2;
		System.out.println("value of a from hackerChance "+a);
		if(a>=1 && j<=length)
			return michkiChance(a,M,H,length,j);
		if(a==0 && H==-2)
			return -2;
		else
			return a;
	}
	public static void main(String[] args) {
		try
		{
			int days=0,setStoneSetLength=0;
		mishkiPlaying mp=new mishkiPlaying();
		for(int i=0;i<2;i++)
		{
			if(i==0)
				setStoneSetLength=mp.scanInt();
		if(i==1)
			days=mp.scanInt();
		}
		int[] getStoneSetValue=new int[setStoneSetLength];
        for(int i=0;i<setStoneSetLength;i++)
        {
        	getStoneSetValue[i] =mp.scanInt();
        }
        /*for(int i:getStoneSetValue)
        {
        	System.out.print(i);
        }
        */int [][]daysInput=new int[days][2];
        for(int i=0;i<days;i++)
    	{
    	for(int j=0;j<2;j++)
    		{
    		daysInput[i][j]=mp.scanInt();
    		}		
    	}
        //System.out.println(days+" days and getstone "+setStoneSetLength);
        mp.getWinner(daysInput,getStoneSetValue);
		}
		catch(InputMismatchException e)
		{
			System.out.println(e.getMessage());
		}
		catch(NumberFormatException e)
		{
			System.out.println(e.getMessage());
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("exception hai bhai");
		}
		catch (IOException e) {
			System.out.println("loocha hai bhai");
		}
		

	}

}
