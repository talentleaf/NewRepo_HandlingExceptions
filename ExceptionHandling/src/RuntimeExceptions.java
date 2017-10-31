import java.util.Scanner;

public class RuntimeExceptions {


		public static void main(String agrs[]) {
	        Scanner sc=new Scanner(System.in);
	        System.out.println("Enter size");
	        int n=sc.nextInt();
	        //int h=n;
	        for(int i=1;i<=n;i++)//for rows
	        {
	            for(int j=1;j<=n-i;j++)//for spaces
	            {
	                System.out.print(" ");
	            }
	                for(int k=1;k<=i;k++)//for stars
	                {
	                    System.out.print("* ");
	                    //Thread.sleep(100);
	                    
	                }
	                System.out.println();
	            
	        }

	       /* for (int i = 0; i < 5; i++) {
	            for (int j = 0; j <= i; j++) {
	                
	                    System.out.print("  $");
	                
	            }
	            System.out.println();
	        }
	    }
		 for(int i=0;i<5;i++) 
		 { 
	         for(int j=0;j<5-i;j++) 
	         {
	             System.out.print(" ");
	         }
	        for(int k=0;k<=i;k++) 
	        {
	            System.out.print("$ ");
	        }
	        System.out.println();  
	    }
		}*/
		}
	
}

