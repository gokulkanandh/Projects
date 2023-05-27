package com.emp.crud.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.crud.DAQ.EmployeeDAQ;
import com.emp.crud.DTO.Employee_DTO;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	

		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
		{
			
			PrintWriter out=res.getWriter();
			
			res.setContentType("text/html");
			
			out.print("<link rel='stylesheet' type='text/css' href='style2.css'>");
			
			out.print("<body>");
			out.println("<a href='index.html'>Add New Employee</a>");
			
			out.println("<h1>Employe List</h1>");
			List<Employee_DTO> l2=EmployeeDAQ.viewEmployee();
			
			out.print("<table  width='100%' >");
			
			out.print(" <tr><th>Id</th> <th>Name</th> <th>Password</th> <th>Email</th> <th>State</th> <th>Edit</th> <th>Delete</th> </tr>");
			for(Employee_DTO c:l2)
			{
				out.print("<tr><td>"+c.getId()+ "</td><td>"+c.getName()+"</td><td>"+c.getPassword()+"</td> <td>"+c.getEmail()+"</td> <td>"+c.getState()+
						"</td><td>"+"<a href='EditServlet?id=" + c.getId()+"' >Edit</a></td>"
						+"<td> "+"<a href='DeleteServlet?id=" + c.getId()+"'>Delete</a></td></tr>");
			}
		
			
			out.print("</table>");
			out.print("</body>");
	}

}
