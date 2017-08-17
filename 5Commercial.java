package JavaPrograms.ObjectOrientedPrograms;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.*;
import java.io.*;
import java.util.*;
import java.lang.*;

class Commercial
{
	public static void main(String args[]) throws IOException,FileNotFoundException,ParseException
	{
		Stockaccount s1=new Stockaccount("Stock.json");
		
	}

}
class Stockaccount  
{
	Scanner sc =new Scanner(System.in);
	JSONParser parser=new JSONParser();
	JSONObject jo=new JSONObject();


	 Stockaccount(String f1) throws IOException,FileNotFoundException,ParseException
	{
			
		String choice1;
		File f2=new File(f1);
		
		jo=(JSONObject)parser.parse(new FileReader(f2));
		JSONArray ja =(JSONArray)jo.get("stock");

		// for(Object joo:ja)
		// {
		// 	JSONObject type1=(JSONObject)(joo);
		// 	String name1=(String)type1.get("name");
		// 	long qty1=(long)type1.get("qty");
		// 	long price1=(long)type1.get("price");
		// 	printReport(name1,qty1,price1);
		// }
		
		for(Object joo:ja)
		{
			JSONObject type1=(JSONObject)(joo);
			String name1=(String)type1.get("name");
			long qty1=(long)type1.get("qty");
			long price1=(long)type1.get("price");
			System.out.println("The name of the stock is" + " " + name1 + " " +qty1 + " "+price1);
			System.out.println("Enter the option to buy or sell");
			choice1=sc.next();
			if(choice1.equalsIgnoreCase("buy"))
			{
				System.out.println("Before buying the data of shares------------ :");
				printReport(name1,qty1,price1);
				long temp=buy(name1,qty1,price1);
				type1.put("qty",temp);
			}

			if(choice1.equalsIgnoreCase("sell"))
			{	System.out.println("Before selling the data of shares----------- :");
				printReport(name1,qty1,price1);
            	long temp=sell(name1,qty1,price1);
            	type1.put("qty",temp);
				
			}
			
			
		
		
		}
		System.out.println(jo);
		
		try
		{
			FileWriter fw=new FileWriter("Stock.json");
			fw.write(jo.toJSONString());
			System.out.println("File insertion done successfully");
			fw.flush();
			fw.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}



	static void printReport(String name1,long qty1,long price1)
	{
		System.out.println("The name of the stock is" + " " + name1);
		System.out.println("The quantity of the stock is" + " " + qty1);
		System.out.println("The price of the stock is" + " " + price1);
		System.out.println();
		
	}

	 long buy(String name1,long qty1,long price1)
	{
		Scanner sc =new Scanner(System.in);
		// System.out.println("Enter the stock name to buy");
		// String opt=sc.next();
		// if(name1.equals(opt))
		// {
		System.out.println("Okay ! Enter the number of units to buy for" + " " +name1);
		int q5=sc.nextInt();	
		qty1=qty1+q5;
		//jo.put("qty",qty1);
		System.out.println("After buying the data of shares------------ :");
		printReport(name1,qty1,price1);
		return qty1;
	}
		

	
	long sell(String name1,long qty1,long price1)
	{
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Okay ! Enter the number of units to sell for" + " " +name1);
		int q5=sc.nextInt();	
		qty1=qty1-q5;
		//jo.put("qty",qty1);
		System.out.println("After buying the data of shares------------ :");
		printReport(name1,qty1,price1);
		return qty1;
	}

}