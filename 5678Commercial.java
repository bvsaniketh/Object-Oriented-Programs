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

	String name1,option1,user1,choicemode="NO ";
	long qty1,badd=0,sadd=0;
	long price1;
	LinkedList l1=new LinkedList();
	Stack st1=new Stack();
	Queue qu1=new Queue();

	Scanner sc =new Scanner(System.in);
	JSONParser parser=new JSONParser();
	JSONObject jo=new JSONObject();
	HashMap<String,Stockaccount>Stockd =new HashMap<String,Stockaccount>();
	String search;
	Date date;
	//String date11;

	Stockaccount(String name1,long qty1,long price1)
	{
		this.name1=name1;
		this.qty1=qty1;
		this.price1=price1;
	}
	

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
			// st1.push(name1,qty1,price1,badd,choicemode);
			//qu1.enqueue(name1,qty1,price1);

		}
			System.out.println();
			System.out.println("Data being inserted into Linked List \n");
			l1.display();
			
			System.out.println("Data will be inserted into Stack after selecting transactions \n");
			// st1.print();
			//System.out.println("Queue Displaying ");

			//qu1.display1();


		
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
				choicemode="BUY";
				System.out.println("Before buying the data of shares------------ :");
				date=new Date();
				System.out.println(date.toString());

				printReport(name1,qty1,price1);
				long temp=buy(name1,qty1,price1);
				System.out.println("Bought shares count is----- :"+badd);
				Date date1=new Date();
				System.out.println(date1.toString());
				l1.delete(name1);
				//l1.display();
				l1.insertintoend(name1,temp,price1);
				l1.display();
				st1.push(name1,temp,price1,badd,choicemode);
				qu1.enqueue(name1,temp,date1);
				type1.put("qty",temp);
			}

			if(choice1==2)

			{	choicemode="SELL";
				System.out.println("Before selling the data of shares----------- :");
				date=new Date();
				System.out.println(date.toString());
				
				printReport(name1,qty1,price1);
            	long temp=sell(name1,qty1,price1);
            	System.out.println("Sold shares count is----- :"+sadd);
            	Date date1=new Date();
				System.out.println(date1.toString());
				l1.delete(name1);
				//l1.display();
				l1.insertintoend(name1,temp,price1);
				l1.display();
				st1.push(name1,temp,price1,sadd,choicemode);
				qu1.enqueue(name1,temp,date1);
            	type1.put("qty",temp);
				
			}
			if(choice1==3)
			{
				break;
			}
			
			// }
		}
		
		 	
		}
			System.out.println("Do you want to perform a share transaction");
		 	user1=sc.next();
	}while(!user1.equalsIgnoreCase("no"));
		//}
		System.out.println("The Linked list now contains : \n");
		l1.display();
		st1.print();
		qu1.display1();

		

		System.out.println(jo);
		System.out.println("\n");
		
			
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
		badd=q5;	
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
		sadd=q5;
		if(qty1>0)	
		{
		qty1=qty1-q5;
		//System.out.println(jo);
		//jo.put("qty",qty1);
		System.out.println("After selling the data of shares------------ :");
		printReport(name1,qty1,price1);
		return qty1;
		}
		else
		{
		System.out.println("Shares are 0 now. Cannot sell");
		return 0;
		}
		
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
			System.out.println("File insertion to JSON done successfully");
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

class Stack 
{
  Node head;
  int size;
  

  Stack()
  {
      size = 0;
      head = null;
  }

  public void pop()
  {
    if(isEmpty())
    {
      System.out.println("Empty stack");
      return ;
      }
    else
    {
      String val = head.data;
      long val1 =head.data1;
      long val2=head.data2;
      head = head.link;
      size--;
      System.out.println(val + " " +val1 +" "+ val2+ " "+ "is deleted from the stack \n");
    }
  }

  public void push(String val,long qty,long pri,long status,String choicemode)
  {
    Node temp = head;
    head = new Node();
    head.data = val;
    head.data1=qty;
    head.data2=pri;
    head.link = temp;
    System.out.println(choicemode +" "+"Operation is Selected for "+ val + " " +"and updated units of" +" "+ status+" "+" and the total count is now of " +qty +" "+"with a price of "+ pri+ " "+ "is added to the stack \n");
    size++;
  }

  public void peak()
  {
  	System.out.println("Stack maintaining transactions---------------------- \n");
    if(isEmpty())
    {
      System.out.println("Empty stack");
      return ;
    }
    else
    {
      System.out.println(head.data+" " + "is the data which is on top");
    }
  }

  public boolean isEmpty()
  {
    return (size == 0);
  }

  public int size()
  {
    return size;
  }

  public void print()
	{
   while(!isEmpty())
   {
   		System.out.println();
     	peak();
      	pop();
   }

}

}

class Node1
{
  String data;
  long data1;
  Date data2;
  Node1 link;

  Node1()
  {
    data="";
    data1=0;
    //data2=;
    link=null;
  }
  Node1(String val,long qty,Date pri,Node1 l)
  {
    data=val;
    data1=qty;
    data2=pri;
    link=l;
  }
  void SetLink(Node1 l)
  {
    link=l;
  }
  void SetData(String val,long qty,Date pri)
  {
    data=val;
    data1=qty;
    data2=pri;

  }
  Node1 GetLink()
  { 
    return link;
  }
  String GetData()
  {
    return data;
  }

}

class Queue
{

	Node1 front;
	Node1 rear;
	int size=0;
	int count=0;
	 Queue()
	 {
	 	front=null;
	 	rear=null;
	 	size=0;
	 }

	 void enqueue(String val,long qty,Date pri)
	 {
	 	Node1 n1=new Node1(val,qty,pri,null);
	 	size++;
	 	if(rear==null)
	 	{
	 		rear=n1;
	 		front=rear;
	 		System.out.println("Enqueued");
	 		return;
	 	}
	 	rear.link=n1;
	 	rear=n1;
	 	System.out.println("Enqueued");

	 }

	 void dequeue()
	 {
	 	if(front==null)
	 	{
	 		System.out.println("Empty");
	 		return ;	
	 	}
	 	if(front==rear)
	 	{	
	 		String temp;
	 		temp=front.data;
	 		front=null;
	 		rear=null;
	 		System.out.println(temp + " " + "is dequeued");
	 	}
	 	String temp1;
	 	Node1 t1;
	 	t1=front;
	 	temp1=t1.data;
	 	front=front.link;
	 	System.out.println(temp1 + " " + "is dequeued");

	 }

	 void display1()
	 {
	 	Node1 temp1=front;

	 	System.out.println("The Queue to be displayed is:---------------");
	 	while(temp1!=null)
	 	{
	 		System.out.println("Transaction " + count + ")");
	 		System.out.print(temp1.data+" "+ temp1.data1 +" "+temp1.data2 + "-> \n\n");
	 		temp1=temp1.link;
	 		count++;

		}
		System.out.println("\n\n");


	}
}
  