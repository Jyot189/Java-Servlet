package in.ac.adit.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ac.adit.user.User;
import in.ac.adit.userdao.UserDao;

public class isAuthentication extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html");
		try {
			PrintWriter out=response.getWriter();
			out.println(request.getParameter("email"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		User userlogin=new User();
		
		userlogin.setEmail(request.getParameter("email"));
		userlogin.setPassword(request.getParameter("password"));
		
		UserDao userdaologin=new UserDao();
		if(userdaologin.login(userlogin)) {
			try {
				response.sendRedirect("welcome.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				response.sendRedirect("login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
