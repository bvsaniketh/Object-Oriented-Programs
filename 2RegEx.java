import java.util.regex.*;
import java.util.*;
// import java.io.*;
// import java.lang.*;

class RegEx
{
	public static void main(String args[])
{	
	//Declared String variables fname and mob
	//Declared a String array name[] to stor the first name
	String m1="Hello   <<name>> ,   We   have   your   full name  as   <<full name>>   in   our   system.   your   contact   number   is   91­xxxxxxxxxx.Please,let   us   know   in   case   of   any   clarification   Thank   you   BridgeLabz   01/01/2016.";
	String p1="";
	Pattern p=Pattern.compile(p1);
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the fullname");
	String fname=sc.nextLine();
	String []name=fname.split("\\s+");
	String mob=sc.next();

	String str2="";


	
	Matcher matcher=p.matcher(m1);
	Date d1=new Date();

	// boolean b=matcher.matches();
	// System.out.println(b);

	while(matcher.find())
	{
		str2=m1.replace("<<name>>",name[0]).replace("<<full name>>",fname).replace("91­xxxxxxxxxx",mob).replace("01/01/2016",d1.toString());
	}
	System.out.println(str2);

}
}