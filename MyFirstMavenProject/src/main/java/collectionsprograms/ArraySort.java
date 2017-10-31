package collectionsprograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.testng.annotations.Test;

public class ArraySort {

	/*@Test
	public void arraySort()
	{
		String[] companyName=new String[3];
		companyName[0]="TCS";
		companyName[1]="INFOSYS";
		companyName[2]="HCL";
		Arrays.sort(companyName);
		
		//System.out.println(companyName);
		
		for(int i=0;i<companyName.length;i++)
		{
			System.out.println(companyName[i]);
		}
	}*/
	
	/*@Test
	public void listSort()
	{
		List<String> companyName=new ArrayList<String>();
		companyName.add("TCS");
		companyName.add("INFOSYS");
		companyName.add("HCL");
		
		Collections.sort(companyName);
		
		for(int i=0;i<companyName.size();i++)
		{
			System.out.println(companyName.get(i));
		}
				
	}*/
	
	@Test
	public void setSort()
	{
		Set<String> companyName=new TreeSet<String>();
		companyName.add("TCS");
		companyName.add("INFOSYS");
		companyName.add("HCL");
		
		List <String> companyList=new ArrayList<String>();
		companyList.addAll(companyName);
		for(int i=0; i<companyList.size();i++)
		{
			System.out.println(companyList.get(i));
		}

		/*for(String c:companyName)
		{
			System.out.println(c);
		}*/
				
	}
}
