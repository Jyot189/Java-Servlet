package in.ac.adit.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ac.adit.user.User;
import in.ac.adit.userdao.UserDao;

public class LoginSystemServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html");
		
		User user=new User();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setCpassword(request.getParameter("cpassword"));
		
		if(user.getPassword().equals(user.getCpassword())) {
			UserDao userdao=new UserDao();
			boolean check=userdao.signUp(user);
			if(check) {
				try {
					response.sendRedirect("login.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				try {
					response.sendRedirect("index.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else {
			try {
				response.sendRedirect("index.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
