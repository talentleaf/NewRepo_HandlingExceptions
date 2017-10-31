package interviewQuestionsPractise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.testng.annotations.Test;

public class DuplicatesinArray {

	@Test
	public void seperateDuplicates()
	{
		int a[]=new int[]{1,2,2,3,4,4,5,7,7,6,7};
		int count=1;
		int key=0;
		Map<Integer,Integer> m=new TreeMap<Integer, Integer>();
		for(int i=0;i<a.length;i++)
		{
			key=a[i];
			if(m.containsKey(key))
				{
				int count1=count+1;
				m.put(key,count1);
				}
			
			else
				m.put(key, count);			
		}
		List<Integer> indivi=new ArrayList<Integer>();
		List<Integer> repe=new ArrayList<Integer>();
		Set<Integer> mapinSet=m.keySet();
		for(Integer s:mapinSet)
		if(m.get(s)==1)
		{
			indivi.add(s);
		}
		else
		{
			repe.add(s);
		}
		System.out.println("Numbers which are unique:");
		for(int each:indivi)
		{
			System.out.println(each);
		}
		
		System.out.println("Numbers which are repeated:");
		for(int each:repe)
		{
			System.out.println(each);
		}
	}
	
}
