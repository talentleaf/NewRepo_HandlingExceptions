package simple_java_programs;

public class CountNoOfWords {

	public static void main(String[] args) {
		String s="I am the winner today";
		String[] eachword=s.split(" ");
		//eachword.length
		System.out.println("Total no of words in a given string:"+eachword.length);

	}

}
