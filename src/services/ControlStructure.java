package services;

public class ControlStructure {

	 public static int conditionalControlStructure(String line)
	    {
	        int total = 0;  
	        total = total + ((line.length() - line.replaceAll("(?<!\\w)if(?!\\w)", "").length()) / 2);    
	        return total;
	    }
	 
	 
	 
	   public static int iterativeControlStructure(String line)
	    {
	        int total = 0;
	        
	        total = total + ((line.length() - line.replaceAll("\\bfor\\b", "").length()) / 3);
	        total = total + ((line.length() - line.replaceAll("\\bwhile\\b", "").length()) / 5);
	        total = total + ((line.length() - line.replaceAll("\\bdo\\b", "").length()) / 2);  
	         
	        return total;
	    }
	    
	   
	   public static int switchControlStructure(String line)
	    {
	        int total = 0;
	        total += (((line.length() - line.replaceAll("(?<!\\w)switch(?!\\w)", "").length()) / 6));
	        return total;
	    }
	   
	   
	   public static int caseControlStructure(String line){   
	                
	   		int total = 0;
	        total = total + ((line.length() - line.replaceAll("(?<!\\w)case(?!\\w)", "").length()) / 4);
	              
	        return total;
	    }
	    
	 
	 
}
