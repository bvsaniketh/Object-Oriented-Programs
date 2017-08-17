package JavaPrograms.ObjectOrientedPrograms;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.*;
import java.io.*;
import java.util.*;

class Inventory
{
	public static void main(String args[]) throws IOException,FileNotFoundException,ParseException
	{
		//JSONObject j1=new JSONObject();
		JSONParser jp =new JSONParser();
		//try{
		JSONObject jo = (JSONObject) jp.parse(new FileReader("inventory.json"));
		JSONArray ja =(JSONArray)jo.get("type");
		for(Object j1:ja)
		{
			JSONObject type1=(JSONObject) (j1);
			String name1=(String)type1.get("name");
			System.out.println(name1);
			long weight1=(long)type1.get("weight");
			System.out.println(weight1);
			long ppkg1=(long)type1.get("ppkg");
			System.out.println(ppkg1);
			System.out.println("The total value is " + " "+ (weight1*ppkg1) );
		}
		//}																		// JSONObject js=new JSONObject();
																				// JSONObject js1 =new JSONObject();
																				// JSONObject js2=new JSONObject();
																				// JSONArray ja=new JSONArray();
																				// ja.add("KAKA");
																				// js.put("name", "RICE");
																				// js.put("weight",new Double(55.5));
																				// js.put("ppkg",new Double(655.5));

																				// js1.put("name", "Pulses");
																				// js1.put("weight",new Double(23.5));
																				// js1.put("ppkg",new Double(1000.5));

																				// js2.put("name", "Wheat");
																				// js2.put("weight",new Double(78.34));
																				// js2.put("ppkg",new Double(2005.98));

																				// System.out.println(js);
																				// System.out.println(js1);
																				// System.out.println(js2);
																				// System.out.println(ja);
	}
}		