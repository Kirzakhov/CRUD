package com.vivek;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vivek.dao.Crud;

@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String name = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String cal = request.getParameter("crud");
		HashMap<String, String> hm = new HashMap<String, String>();
		int i = 0;
		if(cal.equals("Insert")) {
			try {
				i = Crud.insert(name, pass);
				if(i>0)
					out.println("Record updated");
				else
					out.println("Not Updated");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(cal.equals("Update")) {
			try {
				i = Crud.update(name, pass);
				if(i>0)
					out.println("Record updated");
				else
					out.println("Not Updated");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(cal.equals("Delete")) {
			try {
				i = Crud.delete(name);
				if(i>0)
					out.println("Record updated");
				else
					out.println("Not Updated");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(cal.equals("Display")){
			try {
				hm = Crud.display();
				out.println(hm);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
