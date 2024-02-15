package experiment;

public class demo {
	
	public static void demo1()
	{
		
	}
	

	public static void main(String[] args)
	
	{
		
	
//		run a command to display system properties, though we will remove this package from our framework
//		only thing is to get the associated parameter name of the details we like to get : operating system, java version, etc.
		
		System.getProperties().list(System.out);
		
//		write code to have the required details
		
		System.out.println(System.getProperty("os.version"));
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("java.version"));
		
		
	}
	
}
