package servelets;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Size;
import services.SizeService;




@WebServlet("/CodeComplexity")
@MultipartConfig
public class CodeComplexity extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String filePath;
	private File file ;
	public ArrayList<Size> sizedetails = new ArrayList<Size>();

	
	public void init( ){
	      // Get the file location where it would be stored.
	      filePath = getServletContext().getInitParameter("file-upload"); 
	   }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Part filePart = request.getPart("filename");
		InputStream filecontent = filePart.getInputStream();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(filecontent));
		while(reader.ready()) {
		     String line = reader.readLine();
		     line = excludeComments(line);
		     
		     if(validateCodeLine(line)) {
		     //size details
		     Size size = new Size();
		     size.setLine(line);
		     
		     size.setNkw(SizeService.keywords(line));
		     size.setNid(SizeService.identifiers(line));
		     size.setNop(SizeService.arithmeticOperators(line) + 
		    		 	 SizeService.relationalOperators(line) + 
		    		 	 SizeService.logicalOperators(line) +
		    		 	 SizeService.bitwiseOperators(line) +
		    		 	 SizeService.miscellaneousOperators(line) +
		    		 	 SizeService.assignmentOperators(line) );
		     size.setNnv(SizeService.numbers(line));
		     size.setNsl(SizeService.checkStrings(line));
		     
		     sizedetails.add(size);
		     }
		}
		     request.setAttribute("sizedetails", sizedetails );
		     request.setAttribute("filename", getFileName(filePart) );
		     RequestDispatcher rd= request.getRequestDispatcher("cs_measure_page.jsp");
		     rd.forward(request, response);
		     
		
	}
	
	public boolean validateCodeLine(String line) {
		
		line = line.trim();
        if (line.isEmpty()) {
            return false;
        }
        
     // Excluding import Statements
        if (line.contains("import")) {
            return false;
        }
        
		return true;
	}
	
	public String excludeComments(String line) {
		// Excluding comments
        if (line.contains("//")) {
            int begin = line.indexOf("//");
            if (begin == 0) {
                return "";
            }
            return line.substring(0, begin);
        }
		return line;
	}
	
	protected String getFileName(Part p){

		String GUIDwithext = Paths.get(p.getSubmittedFileName()).getFileName().toString();

		String GUID = GUIDwithext.substring(0, GUIDwithext.lastIndexOf('.'));

		return GUID;
		    }
	
	

}
