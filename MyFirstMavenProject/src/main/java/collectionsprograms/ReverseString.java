package collectionsprograms;

public class ReverseString {

	public static void main(String[] args) {

		/*String s="wow ! it is fun to do this.";
		char[] ec=s.toCharArray();
		int stringLength=ec.length;
		for(int i=stringLength-1; i>=0;i--)
		{
			System.out.print(ec[i]);
		}
*/
		
		String s="wow ! it is fun to do this.";
		int stringLength=s.length();
		for(int i=stringLength-1; i>=0;i--)
		{
			System.out.print(s.charAt(i));
		}
	}

}
