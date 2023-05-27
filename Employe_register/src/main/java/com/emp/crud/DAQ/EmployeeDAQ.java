package com.emp.crud.DAQ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import com.emp.crud.DTO.Employee_DTO;

public class EmployeeDAQ 
{
	

	public static int saveEmployee(Employee_DTO e)
	{
		int status=0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/emp_reg";
			
			Connection con=DriverManager.getConnection(url, "root", "gokul");
			
			PreparedStatement ps=con.prepareStatement("insert into employee(Name,Password,Email,State) values(?,?,?,?)");
			
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getState());
			
			status=ps.executeUpdate();
			con.close();
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
		
	}
	
	public static List<Employee_DTO> viewEmployee()
	{
		ArrayList<Employee_DTO> l1=new ArrayList<Employee_DTO>();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/emp_reg";
			
			Connection con=DriverManager.getConnection(url, "root", "gokul");
			
			PreparedStatement psv= con.prepareStatement("select * from employee");
			
			ResultSet rs=psv.executeQuery();
			
			while(rs.next())
			{
				Employee_DTO e1=new Employee_DTO();
				e1.setId(rs.getInt(1));
			e1.setName(rs.getString(2));
			e1.setPassword(rs.getString(3));
			e1.setEmail(rs.getString(4));
			e1.setState(rs.getString(5));
			l1.add(e1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return l1;
	}
	
	
	public static Employee_DTO editEmployee(int id)
	{
		Employee_DTO e1=new Employee_DTO();
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/emp_reg";
			
			Connection con=DriverManager.getConnection(url, "root", "gokul");
			
			PreparedStatement ps=con.prepareStatement("select * from employee where id=?");
			
			ps.setInt(1,id);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				
				e1.setId(rs.getInt(1));
				e1.setName(rs.getString(2));
				e1.setPassword(rs.getString(3));
				e1.setEmail(rs.getString(4));
				e1.setState(rs.getString(5));
				
			}
			
				con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return e1;
	}
	
	public static int updateEmployee(Employee_DTO e)
	
	{
		int status=0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/emp_reg";
			
			Connection con=DriverManager.getConnection(url, "root", "gokul");
			
			PreparedStatement ps=con.prepareStatement("Update employee set Name=?,Password=?,Email=?,State=? where Id=?");
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getState());
			ps.setInt(5, e.getId());
			
		 status=ps.executeUpdate();
		 con.close();
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
		return status;
		
	}
	
	public static int deleteServlet(int id)
	{
		int status = 0;
		try {
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/emp_reg";
			
			Connection con=DriverManager.getConnection(url, "root", "gokul");
			
			PreparedStatement ps=con.prepareStatement("delete from employee where Id=?");
			
			ps.setInt(1, id);
			
		 status=ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return status;
	}

}
