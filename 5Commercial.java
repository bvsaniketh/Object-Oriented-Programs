package JavaPrograms.ObjectOrientedPrograms;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.*;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
* created by: Aniketh Bondada
* Date: 17/08/2017
* Purpose: Read in Stock Names, Number of Share, Share Price. Print a Stock Report with total value of each Stock and the total value of Stock.
**/

class StockManager
{
	public static void main(String args[]) throws IOException,FileNotFoundException,ParseException
	{
		Stockaccount s1=new Stockaccount("Stock.json");


		s1.save();
		
	}

}
class Stockaccount  
{	

	String name1,option1,user1;
	long qty1;
	long price1;
	LinkedList l1=new LinkedList();
	Stockaccount(String name1,long qty1,long price1)
	{
		this.name1=name1;
		this.qty1=qty1;
		this.price1=price1;
	}
	Scanner sc =new Scanner(System.in);
	JSONParser parser=new JSONParser();
	JSONObject jo=new JSONObject();
	HashMap<String,Stockaccount>Stockd =new HashMap<String,Stockaccount>();
	String search;
	Date date;

	 Stockaccount(String f1) throws IOException,FileNotFoundException,ParseException
	{
			
		int choice1;
		String option;
		File f2=new File(f1);
		
		jo=(JSONObject)parser.parse(new FileReader(f2));
		JSONArray ja =(JSONArray)jo.get("stock");

		System.out.println("The available shares are as below :");
		System.out.println("-----------------------------------------");
		for(Object joo:ja)
		{
			//Stockaccount s1=new Stockaccount()
			JSONObject type1=(JSONObject)(joo);
			name1=(String)type1.get("name");
			qty1=(long)type1.get("qty");
			price1=(long)type1.get("price");
			Stockaccount s1=new Stockaccount(name1,qty1,price1);
			System.out.println("->" + " " +name1 + " " + qty1 + " " + price1);
			Stockd.put(name1,s1);


			l1.insertintoend(name1,qty1,price1);

		}
		System.out.println("Data being inserted into Linked List");
		l1.display();
		// l1.delete("TCS");
		// l1.display();
		// for(Map.Entry m:Stockd.entrySet())
		// {

		// 	System.out.println(m.getKey()+ " " + m.getValue());
		// }
		// System.out.println("Is the required stock available");
		// option=sc.next();
		// if(option.equalsIgnoreCase("no"))
		// {
		// 	System.out.println("Not available stock Is the required stock available");
		// 	String na = sc.next(); //add the required stock
		// 	long q=0;
		// 	long pr=150;
			
		// 	ja.add("150");
		// 	ja.add("0");
		// 	ja.add(na);
		// 	jo.put("stock",ja);
		// 	System.out.println(jo);
		// 	//ja.add(jo,"stock");
		// 	//ja.add(jo,"stock")

		// }
		//else
		//{
		 do{
		 	System.out.println("Enter the required stock name to perform operation");
		 	option1=sc.next();
			for(Object joo:ja)
			{
			 
			 JSONObject type1=(JSONObject)(joo);
			 name1=(String)type1.get("name");
			 qty1=(long)type1.get("qty");
			 price1=(long)type1.get("price");
			// if(name1.equalsIgnoreCase(option1))
			// {
			 if(option1.equalsIgnoreCase(name1))
			{ 	
			System.out.println("The name of the stock is" + " " + name1 + " " +qty1 + " "+price1);
			//if()
			System.out.println("Enter the option to 1) buy or  2) sell 3) exit");
			choice1=sc.nextInt();
			if(choice1==1)
			{
				System.out.println("Before buying the data of shares------------ :");
				date=new Date();
				System.out.println(date.toString());

				printReport(name1,qty1,price1);
				long temp=buy(name1,qty1,price1);
				Date date1=new Date();
				System.out.println(date1.toString());
				l1.delete(name1);
				l1.display();
				l1.insertintoend(name1,temp,price1);
				l1.display();
				type1.put("qty",temp);
			}

			if(choice1==2)
			{	System.out.println("Before selling the data of shares----------- :");
				date=new Date();
				String d1=date.toString();
				System.out.println(d1);
				
				
				printReport(name1,qty1,price1);
            	long temp=sell(name1,qty1,price1);
            	Date date1=new Date();
				System.out.println(date1.toString());
				l1.delete(name1);
				l1.display();
				l1.insertintoend(name1,temp,price1);
				l1.display();
            	type1.put("qty",temp);
				
			}
			if(choice1==3)
			{
				break;
			}
			
			// }
		}
		
		 	
		}
			System.out.println("Do you want to perform sharing operation");
		 	user1=sc.next();
	}while(!user1.equalsIgnoreCase("no"));
		//}
		System.out.println(jo);
		
			
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
		//System.out.println(jo);
		//jo.put("qty",qty1);
		System.out.println("After buying the data of shares------------ :");
		printReport(name1,qty1,price1);
		return qty1;
	}

	static void printReport(String name1,long qty1,long price1)
	{
		System.out.println("The name of the stock is" + " " + name1);
		System.out.println("The quantity of the stock is" + " " + qty1);
		System.out.println("The price of the stock is" + " " + price1);
		System.out.println();
		
	}

	 void save()
	{
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


}
class Node
{
  String data;
  long data1;
  long data2;
  Node link;

  Node()
  {
    data="";
    data1=0;
    data2=0;
    link=null;
  }
  Node(String val,long qty,long pri,Node l)
  {
    data=val;
    data1=qty;
    data2=pri;
    link=l;
  }
  void SetLink(Node l)
  {
    link=l;
  }
  void SetData(String val,long qty,long pri)
  {
    data=val;
    data1=qty;
    data2=pri;

  }
  Node GetLink()
  { 
    return link;
  }
  String GetData()
  {
    return data;
  }

}

class LinkedList
{
  Node start;
  Node end;
  int size;
  int count;

  LinkedList()
  {
    start=null;
    end=null;

  }
  void insertintoend(String val,long qty,long pri)
  {
    Node n1=new Node(val,qty,pri,null);
    if(start==null)
    {
      start=n1;
      end=start;
    }
    else
    {
      end.SetLink(n1);
      end=n1;
    }
    count++;
  }

  void display()
  {
    //count++;
    Node temp=start;
    System.out.print(temp.GetData() +" "+ temp.data1 +" "+temp.data2 + "-->");
    temp=start.GetLink();
    while(temp.GetLink()!=null)
    {
      System.out.print(temp.GetData() +" "+ temp.data1 +" "+temp.data2+ "-->" );
      temp=temp.GetLink();
    }
    System.out.println(temp.GetData()+" "+ temp.data1 +" "+temp.data2);
  }

 public void delete(String key)

    {
      Node temp = start, prev = null;


        if (temp != null && temp.data.equals(key))
        {
            start = temp.GetLink(); // Changed head
            return;
        }


        while (temp != null && !temp.data.equals(key))
        {
            prev = temp;
            temp = temp.GetLink();
        }


        if (temp == null)
          return;


        prev.SetLink(temp.GetLink());

	}
}
  // void sort(Node start)
  // {

  //   // Node head=start;
  //   // Node temp=head.GetLink();
  //   for(int i=0;i<count;i++)
  //   {
  //     Node head=start;
  //     Node temp=head.GetLink();
  //       for(int j=0;j<count-1;j++)
  //         {
  //           if(head.GetData()>temp.GetData())
  //           {  
  //           String temp1=head.GetData();
  //           head.data=temp.GetData();
  //           temp.data=temp1;
  //           }
  //           head=temp;
  //           temp=temp.GetLink();
  //         }
  //   }
  // }
 