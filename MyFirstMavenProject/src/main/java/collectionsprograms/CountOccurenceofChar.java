package collectionsprograms;

public class CountOccurenceofChar {

	public static void main(String[] args) {

String s="I am smart learner";
int count=0;

int stringlength=s.length();
for(int i=0;i<stringlength;i++)
{
	char ec=s.charAt(i);
	if(ec=='e')
	{
	count++;
	}
}
System.out.println(count);
	}

}
