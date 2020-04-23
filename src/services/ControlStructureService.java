package services;

public class ControlStructureService {

	 public static int conditionalControlStructure(String line)
	    {
	        int total = 0;  
	        total = total + ((line.length() - line.replaceAll("(?<!\\w)if(?!\\w)", "").length()) / 2);   
	        if(total > 0)  // 'if' detected
	        {            
	            //Detecting &&
	            total = total + ((line.length() - line.replaceAll("&&", "").length()) / 2);
	            //Detecting &
	            total = total + ((line.length() - line.replaceAll("(?<!&)&(?![&=])", "").length()));
	            //Detecting ||
	            total = total + ((line.length() - line.replaceAll("\\|\\|", "").length()) / 2);
	            //Detecting |
	            total = total + ((line.length() - line.replaceAll("(?<!\\|)\\|(?!\\|)", "").length()));
	        }    
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
