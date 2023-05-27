package com.emp.crud.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.crud.DAQ.EmployeeDAQ;
import com.emp.crud.DTO.Employee_DTO;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String sid=request.getParameter("Id");
	    int id=Integer.parseInt(sid);
		String Name=request.getParameter("name");
		String Password=request.getParameter("pwd");
		String Email=request.getParameter("email");
		String State=request.getParameter("state");
		
		Employee_DTO e=new Employee_DTO();
		e.setId(id);
		e.setName(Name);
		e.setPassword(Password);
		e.setEmail(Email);
		e.setState(State);
		
		int status=EmployeeDAQ.updateEmployee(e);
		
		if(status>0)
		{
			response.sendRedirect("ViewServlet");
		}
		
		else
		{
			PrintWriter out= response.getWriter();
			out.println("Unable to update try again later!!!!!!!!");
		}
	}
	

}
