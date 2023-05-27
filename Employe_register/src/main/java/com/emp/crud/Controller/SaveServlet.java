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



public class SaveServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter out=res.getWriter();
		
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		String email=req.getParameter("email");
		String state=req.getParameter("state");
		
		Employee_DTO e1=new Employee_DTO();
		e1.setName(name);
		e1.setPassword(pwd);
		e1.setEmail(email);
		e1.setState(state);
		
		int status=EmployeeDAQ.saveEmployee(e1);
		
		if(status>0)
		{
			out.println("saved secuesfully");
			req.getRequestDispatcher("index.html").forward(req, res);
		}
		
		else
		{
			out.print("unable to save");
		}
	}

}
