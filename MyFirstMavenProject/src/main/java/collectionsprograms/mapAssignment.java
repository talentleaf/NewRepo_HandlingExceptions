package collectionsprograms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.annotations.Test;

public class mapAssignment {
	
	@Test
	public void checkforrepeatedOccurence()
	{
		String s="AMAZONA";
		int count=1;
		char[] amazonCharacters=s.toCharArray();
		Map<Character,Integer> lhm=new LinkedHashMap<Character,Integer>();
		for(int i=0;i<amazonCharacters.length;i++)
		{
			if(lhm.containsKey(amazonCharacters[i]))
			{
				int count1=count+1;
				lhm.put(amazonCharacters[i], count1);}
			else 
				lhm.put(amazonCharacters[i], count);
		}
		Set<Character> keys=lhm.keySet();		
		int value=1;
		char ch = '0';
		for(Character k:keys)
		{
			int value1=lhm.get(k);
			if(value1>value)
			{
				ch=k;
				value=value1;}
		}
		
		System.out.println(ch);	
	}

}
