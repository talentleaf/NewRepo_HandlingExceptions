package interviewQuestionsPractise;

import org.testng.annotations.Test;

public class PalindromeCheck {

	@Test
	public void palindromecheckforstring()
	{
		String s="hello";
		String rev="";
		for(int i=s.length()-1;i>=0;i--)
		{
			char c=s.charAt(i);
			rev=rev.concat(Character.toString(c));
		}
		
		if(s.equals(rev))
			System.out.println("string is palindrome");
		else
			System.out.println("not a palindrome");
	}
	
	@Test
	public void ispalindrome()
	{
		String s="mom";
		StringBuffer sb=new StringBuffer(s);
		sb.reverse();
		String reverse=sb.toString();
		
		if(s.equals(reverse))
			System.out.println("String is palindrome");
		else
			System.out.println("not");
	}
}
