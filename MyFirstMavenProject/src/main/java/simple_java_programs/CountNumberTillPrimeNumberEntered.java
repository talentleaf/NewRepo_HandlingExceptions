package simple_java_programs;

import java.util.Scanner;

public class CountNumberTillPrimeNumberEntered {

	public static boolean checkForPrimeNo(int a)
	{
		int x=a;
		for(int i=2; i<x/2;i++)
		{
			if(x%i==0)
			{
				return true;
			}
		}
		return false;
	}	
	public int getNumberFromUser()
	{
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		System.out.println("Entered Number is "+number);
		return number;
	}
	public static void main(String[] args) {
		CountNumberTillPrimeNumberEntered cn=new CountNumberTillPrimeNumberEntered();
		int i=0;
		boolean notprime=true;
		while(notprime==true)
		{
			int number=cn.getNumberFromUser();
			notprime=checkForPrimeNo(number);
			i++;
		}
		System.out.println("Prime number has been reached");
		System.out.println("No of times user entered number: "+i);
	}

}
