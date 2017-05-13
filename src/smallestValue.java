import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class smallestValue {

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
		Scanner sc=new Scanner(System.in);
		// TODO Auto-generated method stub
		smallestValue sm=new smallestValue();
		System.out.println("Please Enter 3 inputs");
		int a =sc.nextInt();
		int b =sc.nextInt();
		int c =sc.nextInt();
		System.out.println("Please Enter 4 inputs");
		int d =sc.nextInt();
		int e =sc.nextInt();
		int f =sc.nextInt();
		int g =sc.nextInt();
		System.out.println(sm.threeSmall(a,b,c));
		System.out.println(sm.fourSmall(d,e,f,g));
		

	}

}
