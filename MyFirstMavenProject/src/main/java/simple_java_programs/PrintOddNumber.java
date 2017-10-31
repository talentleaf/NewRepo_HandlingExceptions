package simple_java_programs;

public class PrintOddNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("Print odd numbers between 50 to 100:");
for(int i=51;i<100;i++)
{
	int k=i%2;
	
			if(k==0)
	{
		System.out.print(i);
		System.out.print(", ");
	}
}
	}

}
