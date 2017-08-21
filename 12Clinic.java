import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
class Clinic
{
	public static void main(String args[]) throws ParseException
	{
		Scanner sc =new Scanner(System.in);


		Doctor d;
		Doctor dd5;
		Patient p;
		Patient pp5;
		Appointment appo=new Appointment();
		Find f=new Find();
		ArrayList<Doctor>dd1=new ArrayList<Doctor>();
		ArrayList<Doctor>dsec=new ArrayList<Doctor>();
		ArrayList<Patient>pp1=new ArrayList<Patient>();
		HashMap<Appointment,Integer>appoint=new HashMap<Appointment,Integer>();

		// pp1.add(p);

		// Iterator itr=dd1.iterator();
		// while(itr.hasNext())
		// {
		// 	System.out.println(itr.next());
		// }
		int count=0;
		String option1="";
		int choice=0;
		do
		{
			
			System.out.println("Clinic Management");
			System.out.println("Enter the option to perform");
			System.out.println("1) Add Doctor");
			System.out.println("2) Add Patient");
			System.out.println("3) Display all Doctors");
			System.out.println("4) Display all Patients");
			System.out.println("5) Search Doctor by Name,ID,Specialization");
			System.out.println("6) Search Patient by Name,ID,Mobile Number,Age");
			System.out.println("7) Take Appointment");
			System.out.println("8) Print Appointment");
			System.out.println("9) Exit");
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:
						d=new Doctor();
						d.addDoctor();
						dd1.add(d);
						break;

				case 2:	p=new Patient();
						p.addPatient();
						pp1.add(p);
						break;

				case 3: Iterator itr =dd1.iterator();
						{
							while(itr.hasNext())
							{
								System.out.println(itr.next());
							}
						}
						break;

				case 4: 		 itr=pp1.iterator();
						{
							while(itr.hasNext())
							{
								System.out.println(itr.next());
							}
						}
						break;

				case 5: int ch1;
						String opt1;
						do
						{
							System.out.println("Search-----------");
							System.out.println("1.Search Doctor by ID");
							System.out.println("2.Search Doctor by Name");
							System.out.println("3.Search Doctor by Specialization");
							System.out.println("4.Search Doctor By Availability");
							System.out.println("5.Exit");
							ch1=sc.nextInt();

							switch(ch1)
							{
								case 1:System.out.println("Enter the Doctor's ID");
									   int chd=sc.nextInt();
									  // f=new Find();

									   dd5=f.FindbyId(dd1,chd);
									   System.out.println(dd5 +"\n");
									   break; //Check this because it is array list printing

								case 2:System.out.println("Enter the Doctor's Name");
									   String chdname=sc.next();
									   //f=new Find();
									   dd5=f.FindbyName(dd1,chdname);
									   System.out.println(dd5.toString()+"\n");
									   break;

								case 3:System.out.println("Enter the Doctor's Specialization");
									   String speci=sc.next();
									   dsec=f.FindBySpe(dd1,speci);
									   System.out.println(dsec);
									   break; 

								case 4:break;

								case 5:System.exit(0);

								default:System.out.println("Invalid choice");
										break;
							}
							System.out.println("Do you want perform any other functionlity ");
							opt1=sc.next();
						}while(!opt1.equalsIgnoreCase("no"));

				case 6:int ch2;
					   String opt2;
						do
						{
							
							System.out.println("Search-----------");
							System.out.println("1.Search Patient by ID");
							System.out.println("2.Search Patient by Name");
							System.out.println("3.Search Patient by Mobile Number");
							System.out.println("4.Search Patient by Age");
							System.out.println("5.Exit");
							ch2=sc.nextInt();

							switch(ch2)
							{
								case 1:System.out.println("Enter the Patient's ID");
									   int chp=sc.nextInt();
									   pp5=f.FindbyIdPa(pp1,chp);
									   //pp1=f.FindbyIdPa(pp1,chp);
									   System.out.println(pp5.toString()+"\n");
									   break; //Check this because it is array list printing

								case 2:System.out.println("Enter the Patient's Name");
									   String chpname=sc.next();
									   pp5=f.FindbyNamePa(pp1,chpname);
									   //pp1=f.FindbyNamePa(pp1,chpname);
									   System.out.println(pp5.toString()+"\n");
									   break;

								case 3:System.out.println("Enter the Patient's Mobile Number");
									   long mob=sc.nextLong();
									   pp5=f.FindbyMob(pp1,mob);
									   System.out.println(pp5.toString());
									   break;

								case 4:System.out.println("Enter the Patient's Age");
									   int age1=sc.nextInt();
									   pp5=f.FindbyAge(pp1,age1);
									   System.out.println(pp5.toString());
									   break;

								case 5:System.exit(0);

								default:System.out.println("Invalid choice");
										break;

								

								
							}

							System.out.println("Do you want perform any other functionlity ");
							opt2=sc.next();
						}while(!opt2.equalsIgnoreCase("no"));


				case 7: System.out.println("Enter the Doctor ID");
						int did=sc.nextInt();


						Doctor doc=f.FindbyId(dd1,did);
						if(doc!=null)
						{	

							System.out.println("Enter the Patient ID");
							int pid=sc.nextInt();
							Patient pat=f.FindbyIdPa(pp1,pid);
							System.out.println(pat);
							if(pat!=null)
							{
							System.out.println("Enter the date in the format of dd/mm/yyyy");
							String d1=sc.next();
							SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
							Date dateapp=format.parse(d1);
							//System.out.println(format.format(dateapp));
							appo.setAppointment(dateapp,doc,pat);
							}
							else
							{
								System.out.println("Invalid Patient ID");
							}
					
					    }
					    else
					    {
					    	System.out.println("Invalid Doctor ID");
					    }
						break;
						

				case 8: System.out.println("Printing all appointments");
						appo.printall();
						break;	

				case 9: System.exit(0);

				default: System.out.println("Invalid option selected");


			}


		}while(count<10);
	}
}

class Doctor
{
	int did;
	String name;
	String spec;
	String ava;
	Scanner sc =new Scanner(System.in);
	HashMap<Date,Integer>dapp =new HashMap<Date,Integer>();
	ArrayList<Integer>patient1=new ArrayList<Integer>();
	

	public String toString()
		{
			return "Doctor ID " + did +"\n"+"Doctor Name "+name+ "\n" + "Doctor Specialization "+ spec+"\n"+ "Doctor Availability " +ava +"\n" ;
		}

	void addDoctor()
	{
		System.out.println("Enter the id for the Doctor");
		did=sc.nextInt();
		

		System.out.println("Enter the name of the Doctor");
		name=sc.next();
		

		System.out.println("Enter the specialization of the Doctor");
		spec=sc.next();
		

		System.out.println("Enter the availabilty for the Doctor");
		ava=sc.next();


		// System.out.println("\n\nThe details of the Doctor are :");
		// System.out.println("ID: " + did);
		// System.out.println("Name: " + name);
		// System.out.println("Specialization: " + spec);
		// System.out.println("Availability: " +ava);
		// System.out.println();
		

	}


}

class Patient
{
	int pid;
	String name;
	long mno;
	int age;
	Scanner sc =new Scanner(System.in);
	

	public String toString()
	{
		return "Patient ID " + pid +"\n"+"Patient Name "+name+ "\n" + "Patient Mobile Number "+ mno+"\n"+ "Patient Age " +age + "\n" ;
	}

	void addPatient()
	{
		System.out.println("Enter the id for the Patient");
		pid=sc.nextInt();
		

		System.out.println("Enter the name of the Patient");
		name=sc.next();
		

		System.out.println("Enter the Mobile Number of the Patient");
		mno=sc.nextLong();
		

		System.out.println("Enter the age of the Patient");
		age=sc.nextInt();


		// System.out.println("\n\nThe details of the Patient are :");
		// System.out.println("ID: " + pid);
		// System.out.println("Name: " + name);
		// System.out.println("Mobile Number: " + mno);
		// System.out.println("Age: " +age);
		// System.out.println();
	}
}

class Appointment
{
	Integer did1;
	Date date1;
	int appcount=0;
	Integer pid1;
	HashMap<Date,Doctor>app=new HashMap<Date,Doctor>();
	//HashMap<Map,String>printmap=new HashMap<Map,String>();
	// Appointment(int did,Date date)
	// {
	// 	did1=did;
	// 	date1=date;
	// }
	SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
	void setAppointment(Date dateapp,Doctor doc,Patient pat)
	{
		
		if(doc.dapp.containsKey(dateapp))
		{
			appcount=doc.dapp.get(dateapp);
			if(appcount>=5)
			{
				System.out.println("Full for the doctor this day");

			}
			else
			{
				appcount++;
				app.put(dateapp,doc);
				doc.dapp.put(dateapp,appcount);
				doc.patient1.add(pat.pid);
				//printmap.put(app,pat.name);
				System.out.println("Appointment set with " + doc.name + " "+ doc.did + " with specialization " +doc.spec + 
					" on " +format.format(dateapp));
			}
		}
		else
		{
			app.put(dateapp,doc);
			doc.dapp.put(dateapp,1);
			doc.patient1.add(pat.pid);
			//printmap.put(app,pat.name);
			System.out.println("Appointment set with " + doc.name + " "+ doc.did + " with specialization " +doc.spec + 
					" on " +format.format(dateapp));
		}



	}
	void printall()
	{
		
		int i=0;
		Set patmap=app.entrySet();
		Iterator mapIter=patmap.iterator();
		for(Object obj:app.entrySet())
		{
			Map.Entry<Date,Doctor>entry=(Map.Entry)obj;
			Doctor d=entry.getValue();
			System.out.println("Name of the Doctor : " + d.name);
			System.out.println("\n With Patient" + d.patient1.get(i));
			System.out.println(" at " + entry.getKey());
			System.out.println("\n");
		}
		

	}
	public String toString()
	{
		return "Doctor ID " +did1 + " Date of Appointment " + date1 + "\n";
	}	
}
class Find
{
	Doctor FindbyId(ArrayList<Doctor> dd1,int chd )
	{
		Doctor temp=null;
			for(Doctor f:dd1)
			{
				temp=f;
				if(f.did==chd)
				{
					System.out.println("Found Doctor ID");
					return temp;
					
				}
				// else
				// {
				// 	System.out.println("Not found");
				// }
			}
		
		return null;
	}




	Doctor FindbyName(ArrayList<Doctor> dd1,String chdname)
	{
		Doctor temp=null;
		//ArrayList<Doctor>temp=new ArrayList<Doctor>();
		{
			for(Doctor f:dd1)
			{	
				temp=f;
				if((f.name).equals(chdname))
				{
					System.out.println("Found Doctor Name");
					return temp;//temp.add(f);
				}
				else
				{
					System.out.println("Not found");
				}
			}
		}
		return null;
	}

	ArrayList<Doctor> FindBySpe(ArrayList<Doctor>dd1,String speci)
	{
		ArrayList<Doctor>temp= new ArrayList<Doctor>();
		{
			for(Doctor f:dd1)
			{
				
				if((f.spec).equals(speci))
				{
					System.out.println("Specialization found");
					temp.add(f);
				}
			}
		}
		return temp;
	}
	Patient FindbyIdPa(ArrayList<Patient>pp1,int chp )
	{
		int flag=0;
		Patient temp = null;
		{
			for(Patient p:pp1)
			{	
				flag=0;
				temp=p;
				if(p.pid==chp)
				{
					System.out.println("Found Patient ID");
					return temp;
					
				}
				else
				{
					flag=1;
				}

			}
			if(flag==1)
			{
				System.out.println("Not Found");
			}

		}
		return null;
	}
	Patient FindbyNamePa(ArrayList<Patient>pp1,String chpname)
	{
		Patient temp = null;
		{
			for(Patient p:pp1)
			{	temp=p;
				if((p.name).equals(chpname))
				{
					System.out.println("Found Patient Name");
					break;
				}
				else
				{
					System.out.println("Not found");
				}
			}
		}
		return temp;
	}
	Patient FindbyMob(ArrayList<Patient>pp1,long mob )
	{
		Patient temp = null;
		{
			for(Patient p:pp1)
			{
				temp=p;
				if(p.mno==mob)
				{
					System.out.println("Found Mobile Number of Patient");
					break;
				}
				else
				{
					System.out.println("Not found");
				}
			}

		}
		return temp;
	}
	Patient FindbyAge(ArrayList<Patient>pp1,int age1 )
	{
		Patient temp = null;
		{
			for(Patient p:pp1)
			{
				temp=p;
				if(p.age==age1)
				{
					System.out.println("Found Patient ID");
					break;
				}
				else
				{
					System.out.println("Not found");
				}
			}

		}
		return temp;
	}


}