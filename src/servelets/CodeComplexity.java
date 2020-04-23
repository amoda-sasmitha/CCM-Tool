package servelets;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/CodeComplexity")
@MultipartConfig
public class CodeComplexity extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String filePath;
	private File file ;
	private ArrayList<String> lines = new ArrayList<String>();
	
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
		     lines.add(line);
		}
		
		
		
		
		
	}
	
	

}
