package simple_java_programs;

import java.util.Scanner;

public class Multiplicationtable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
int tableNo=sc.nextInt();
for(int i=1;i<=10;i++)
{
	int value=i*tableNo;
	System.out.println(i +" * "+tableNo+" = "+value );
}

	}

}
