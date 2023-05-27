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


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<h1>Update Employee</h1>");
		String sid=req.getParameter("id");
		int id=Integer.parseInt(sid);
	Employee_DTO e1=EmployeeDAQ.editEmployee(id);
	
	out.print("<link rel='stylesheet' type='text/css' href='style2.css'>");
	
	out.print("<form action='UpdateServlet' method='post'>");
		
		out.print("<table>");
		out.print("<tr> <td></td> <td><input type='hidden' name='Id' value='"+e1.getId()+"'></td> </tr>");
		out.print("<tr> <td>Name :</td> <td><input type='text' name='name' value='"+e1.getName()+"'></td>  </tr>");
		out.print("<tr> <td>Password :</td> <td><input type='password' name='pwd'value='"+e1.getPassword()+"'> </td>  </tr>");
		out.print("<tr> <td>Email :</td> <td><input type='email' name='email' value='"+e1.getEmail()+"'></td>  </tr>");
		out.print("<tr> <td>State :</td> <td><select name='state' value='"+e1.getState()+"'>"
				+ " <option>Kerala</option>\r\n"
				+ "<option>Tamilnadu</option>\r\n"
				+ "<option>Karnataka</option>\r\n"
				+ "<option>Andhrapradesh</option>\r\n"
				+ "<option>Telangana</option>\r\n"
				+ "<option>Maharashtra</option>\r\n"
				+ "<option>Delhi</option>\r\n"
				+ "<option>Kashmir</option>\r\n"
				+ "<option>Others</option>\r\n"
				+ "</select></td>  </tr>");
		
		out.print("</table>");
		out.print("<br>");
		
		out.print("<input id='btn' type='submit' value='Edit&Save'>");
		out.print("</form>");
		
		
	}

}
