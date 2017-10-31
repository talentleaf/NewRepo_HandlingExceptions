package simple_java_programs;

public class CheckforPrimeNumber {

	public boolean toCheckPrimeNumber(int number)
	{
		int no=number;
		for(int i=2;i<=no/2;i++)
		{
			if(no%i==0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckforPrimeNumber cfpn=new CheckforPrimeNumber();
		for(int i=2; i<=50;i++)
		{
			boolean flag=cfpn.toCheckPrimeNumber(i);
			if(flag==true)
				System.out.println(i);

		}
	}

}
