package collectionsprograms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.annotations.Test;

public class GetOccuranceofEachCharacter {
	
	@Test
	public void checkforrepeatedOccurence()
	{
		String s="good";
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
		
		Set<Entry<Character,Integer>> entrySet=lhm.entrySet();
		for(Entry<Character,Integer> each:entrySet)
		{
			Character c=each.getKey();
			Integer i=each.getValue();
			
			System.out.println(c +"   -     "+i);
		}

	}

}
