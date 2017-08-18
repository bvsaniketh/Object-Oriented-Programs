import java.util.*;
import java.lang.*;
import java.io.*;

class Clinic
{
	public static void main(String args[])
	{
		Scanner sc =new Scanner(System.in);


		Doctor d;
		Doctor dd5;
		//d.addDoctor();
		Patient p;
		Find f=new Find();
		//p.addPatient();
		ArrayList<Doctor>dd1=new ArrayList<Doctor>();
		// dd1.add(d);
		ArrayList<Patient>pp1=new ArrayList<Patient>();
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
			System.out.println("5) Exit");
			System.out.println("6) Search Doctor by name,id");
			System.out.println("7) Search Patient by name,id");
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

				case 5: System.exit(0);

				case 6: int ch1;
						do
						{
							System.out.println("Search-----------");
							System.out.println("1.Search Doctor by ID");
							System.out.println("2.Search Doctor by Name");
							System.out.println("3.Search Doctor By Availability");
							System.out.println("4.Exit");
							ch1=sc.nextInt();

							switch(ch1)
							{
								case 1:System.out.println("Enter the Doctor's ID");
									   int chd=sc.nextInt();
									  // f=new Find();

									   dd5=f.FindbyId(dd1,chd);
									   System.out.println(dd5.toString());
									   break; //Check this because it is array list printing

								case 2:System.out.println("Enter the Doctor's Name");
									   String chdname=sc.next();
									   //f=new Find();
									   dd5=f.FindbyName(dd1,chdname);
									   System.out.println(dd5.toString());
									   break;

								case 3:break;

								case 4:System.exit(0);

								default:System.out.println("Invalid choice");
										break;
							}
						}while(ch1<5);

				case 7:int ch2;
						do
						{
							System.out.println("Search-----------");
							System.out.println("1.Search Patient by ID");
							System.out.println("2.Search Patient by Name");
							System.out.println("3.Search Patient By Availability");
							System.out.println("4.Exit");
							ch2=sc.nextInt();

							switch(ch2)
							{
								case 1:System.out.println("Enter the Patient's ID");
									   int chp=sc.nextInt();
									  
									   pp1=f.FindbyIdPa(pp1,chp);
									   System.out.println(pp1);
									   break; //Check this because it is array list printing

								case 2:System.out.println("Enter the Patient's Name");
									   String chpname=sc.next();
									   
									   pp1=f.FindbyNamePa(pp1,chpname);
									   System.out.println(pp1);
									   break;

								case 3:break;

								case 4:System.exit(0);

								default:System.out.println("Invalid choice");
										break;
							}
						}while(ch2<5);

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


	public String toString()
		{
			return "Doctor ID " + did +"\n"+"Doctor Name "+name+ "\n" + "Doctor Specialization "+ spec+"\n"+ "Doctor Availability " +ava ;
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


		System.out.println("\n\nThe details of the Doctor are :");
		System.out.println("ID: " + did);
		System.out.println("Name: " + name);
		System.out.println("Specialization: " + spec);
		System.out.println("Availability: " +ava);
		System.out.println();
		

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
		return "Patient ID " + pid +"\n"+"Patient Name "+name+ "\n" + "Patient Mobile Number "+ mno+"\n"+ "Patient Age " +age ;
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


		System.out.println("\n\nThe details of the Patient are :");
		System.out.println("ID: " + pid);
		System.out.println("Name: " + name);
		System.out.println("Mobile Number: " + mno);
		System.out.println("Age: " +age);
		System.out.println();
	}
}

class Find
{
	Doctor FindbyId(ArrayList<Doctor> dd1,int chd )
	{
		Doctor temp=null;
		//ArrayList<Doctor>temp=new ArrayList<Doctor>();
			for(Doctor f:dd1)
			{
				temp=f;
				if(f.did==chd)
				{
					System.out.println("hiahda");
					break;
					// temp.add(f);
				}
			}
		
		return temp;
	}


// ArrayList<Doctor> FindbyId(ArrayList<Doctor> dd1,int chd )
// 	{
// 		ArrayList<Doctor>temp=new ArrayList<Doctor>();
// 			for(Doctor f:dd1)
// 			{
// 				if(f.did==chd)
// 				{
// 					System.out.println("hiahda");
// 					temp.add(f);
// 				}
// 			}
		
// 		return temp;
// 	}


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
					System.out.println("afhuaf");
					break;//temp.add(f);
				}
			}
		}
		return temp; 
	}
	ArrayList<Patient> FindbyIdPa(ArrayList<Patient>pp1,int chp )
	{
		ArrayList<Patient> temp = new ArrayList<Patient>();
		{
			for(Patient p:pp1)
			{
				if(p.pid==chp)
				{
					temp.add(p);
				}
			}

		}
		return temp;
	}
	ArrayList<Patient> FindbyNamePa(ArrayList<Patient>pp1,String chpname)
	{
		ArrayList<Patient> temp = new ArrayList<Patient>();
		{
			for(Patient p:pp1)
			{
				if((p.name).equals(chpname))
				{
					temp.add(p);
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