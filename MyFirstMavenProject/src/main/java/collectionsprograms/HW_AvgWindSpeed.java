package collectionsprograms;

import org.openqa.selenium.WebDriver;

public class HW_AvgWindSpeed {

	public static void main(String[] args) {

String s1="Highest wind speed is 3kph Lowest wind speed is 6kph";
int data1=0;
int data2=0;

char[] stringtoCharacter=s1.toCharArray();
for(char each:stringtoCharacter)
{
	int value=Character.getNumericValue(each);
	if(value==6)
	{
		data1=value;
	}if(value==3)
	{
		data2=value;	
	}
}

int avg=(data1+data2)/2;
System.out.println(avg);
	}
	

}
