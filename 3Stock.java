package JavaPrograms.ObjectOrientedPrograms;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.*;
import java.util.*;
import java.io.*;
import java.lang.*;

class Stock
{
	public static void main(String args[]) throws IOException,FileNotFoundException,ParseException
	{
		JSONParser jp =new JSONParser();
		//try{
		JSONObject jo = (JSONObject) jp.parse(new FileReader("stock.json"));
		JSONArray ja =(JSONArray)jo.get("stock");
		for(Object j1:ja)
		{
			JSONObject type1=(JSONObject) (j1);
			String name1=(String)type1.get("name");
			System.out.println(name1);	
			long weight1=(long)type1.get("qty");
			System.out.println(weight1);
			long ppkg1=(long)type1.get("price");
			System.out.println(ppkg1);
			System.out.println("The total value is " + " "+ (weight1*ppkg1));
		}
		
	}

	
}
/*class Stock
{
	public static void main(String args[])
	{
		stocksdata();
	}

	static void stocksdata()
	{
		JSONObject obj =new JSONObject();
		obj.put("Name","anibo");
		obj.put("Age","21");

		JSONArray arr =new JSONArray();
		arr.add("Company:IDE");
		arr.add("Company:Intellect");
		arr.add("Company:Oracle");
		obj.put("Company List",arr);

	System.out.println(obj);
			
		try
		{
			FileWriter fw=new FileWriter("anibo.json");
			fw.write(obj.toJSONString());
			System.out.println("File Insertion done successfully now!");
			
			fw.flush();
			fw.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		/*fw.flush();
		fw.close();*/
		
