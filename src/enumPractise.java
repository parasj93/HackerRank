import java.util.Scanner;
public class enumPractise{
	private enum station{
		LONDON("LON"),PUNE("PNQ"),MADRID("MAD");
		private String str="";
		private station(String str)
	{
		this.str=str;
	}
		public String getStation()
		{
			return str;
		}
	};
	station source;
	public String getValues(String str)
	{
		source=station.valueOf(str);
		switch(source)
		{
		case LONDON:
			return source.getStation();
		case PUNE:
			return source.getStation();
		case MADRID:
			return source.getStation();
		}
		return "";
	}
	public static void main(String [] args) {
		try{
		enumPractise em=new enumPractise();
		
		System.out.println("Please Enter SourceStation");
		Scanner sc=new Scanner(System.in);
		String inputString=sc.nextLine();
			System.out.println(em.getValues(inputString));
		
		}
		catch(ArrayIndexOutOfBoundsException e )
		{
			System.out.println(e.getMessage());
		}
	}

}
