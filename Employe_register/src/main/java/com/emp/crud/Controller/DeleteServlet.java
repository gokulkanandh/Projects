package com.emp.crud.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.crud.DAQ.EmployeeDAQ;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
			String sid=request.getParameter("id");
			int id=Integer.parseInt(sid);
			
			int status=EmployeeDAQ.deleteServlet(id);
			if(status>0)
			{
				response.sendRedirect("ViewServlet");
			}
			else
			{
				PrintWriter out=response.getWriter();
				out.println("unable to delete");
			}
			
		
	}

}
