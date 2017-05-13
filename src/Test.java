public class Test{
    private int a;
    private int b;
    public Test()
    {
    	this.a=10;
    	this.b=20;
    	System.out.println("value of a and b is "+a+  " "+b);
    }

    public void seta(int a)
    {
    	this.a=a;
    }
    public int geta()
    {
    	return a;
    }
    
    public void setb(int b)
    {
    	this.b=b;
    }
    public int getb()
    {
    	return b;
    }
    
    public Test getDefault()
    {
    	return new Test();
    }
    
    public Test setRequestForRome()
    {
    	Test test=getDefault();
    	test.a=300;
    	test.b=500;
    	return test;
    }
    public void getSetterAndGetter()
    {
    	System.out.println(a+" "+b);
    }
    public static void main(String []args){
    	
    	Test t=new Test();
    	t.seta(100);
    	t.setb(200);
    	t.getSetterAndGetter();
}
}