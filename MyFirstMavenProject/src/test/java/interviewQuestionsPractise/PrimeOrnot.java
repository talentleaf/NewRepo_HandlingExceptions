package interviewQuestionsPractise;

import java.util.Scanner;

import org.testng.annotations.Test;

public class PrimeOrnot {

	@Test
	public void checkforPrimeNo()
	{
		/*Scanner sc=new Scanner(System.in);
		String number=sc.next();*/
		//int no=Integer.valueOf(number);
		int no =11;
		boolean primecheckflag=false;
		
		for(int i=2;i<=no/2;i++)
		{
			if(no%i==0)
			{
				primecheckflag=true;
				break;
			}
		}
		if(primecheckflag==false)
		System.out.println("number is prime");
		else
			System.out.println("number is not prime");
		
	}
	
}
