package simple_java_programs;

public class HW_AvgWindSpeed {

	public static void main(String[] args) {

String s1="Highest wind speed is 3kph";
String s2="Lowest wind speed is 1kph";

String[] split1=s1.split(" ");
String[] split2=s2.split(" ");

int length1=split1.length;
int length2=split2.length;

String lastword1=split1[length1-1];
String lastword2=split2[length2-1];

/*String subString1=lastword1.substring(0,1);
String subString2=lastword2.substring(0,1);*/

char sc1=lastword1.charAt(0);
char sc2=lastword2.charAt(0);

int value1=Character.getNumericValue(sc1);
int value2=Character.getNumericValue(sc2);

float averageWindSpeed=(value1+value2)/2;

System.out.println("Average windSpeed: "+averageWindSpeed);

	}

}
